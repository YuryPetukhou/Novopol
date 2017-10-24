package lv.javaguru.novopol.logic.dal;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

import lv.javaguru.novopol.config.ConfigurationManager;

public class DBConnectionPool {
	public static final String DRIVER = "server.driver";
	public static final String URL = "server.url";
	public static final String LOGIN = "server.login.public";
	public static final String PASSWORD = "server.password";
	public static final String POOL_SIZE = "server.pool_size";
	public static final String INITIAL_CONNECTIONS = "server.initial_connections";
	public static final String MAX_CONNECTIONS = "server.max_connections";
	public static final String WAIT_IF_BUSY = "server.wait_if_busy";
	
	
	private String driverName;
	//
	private String url;
	// 
	private String username;
	// 
	private String password;
	// 
	private int poolSize;
	
	// 
	private static BlockingQueue<Connection> connectionQueue;
	// 
	private static BlockingQueue<Connection> givenAwayConQueue;
	private static DBConnectionPool instance;

	// 
	private DBConnectionPool() throws ClassNotFoundException, SQLException {
		ConfigurationManager manager = ConfigurationManager.getInstance();
		this.driverName = manager.getProperty(DRIVER);
		this.url = manager.getProperty(URL);
		this.username = manager.getProperty(LOGIN);;
		this.password = manager.getProperty(PASSWORD);
		try {
			this.poolSize = Integer.parseInt(manager.getProperty(POOL_SIZE));
		} catch (NumberFormatException e) {
			poolSize = 10;
		}
		initPoolData();
	}

	private static Object lock=new Object();

	public static DBConnectionPool getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new DBConnectionPool();
				}
			}
		}
		return instance;
	}

	// Инициализация пула
	private void initPoolData() throws ClassNotFoundException, SQLException {
		// Установка локали по умолчанию
		Locale.setDefault(Locale.ENGLISH);
		
			// Регистрация драйвера
			Class.forName(driverName);
			// Создание экзмепляров очередей соединений
			givenAwayConQueue = new ArrayBlockingQueue<Connection>(poolSize);
			connectionQueue = new ArrayBlockingQueue<Connection>(poolSize);
			// Наполенение очереди свободных соединений
			for (int i = 0; i < poolSize; i++) {
				Connection connection = DriverManager.getConnection(url,
						username, password);
				
				PooledConnection pooledConnection = new PooledConnection(
						connection);
				connectionQueue.add(pooledConnection);
			}
		 

	}
	
	// Освобождение ресурсов пула
	public void dispose() throws SQLException {
		clearConnectionQueue();
	}

	private void clearConnectionQueue() throws SQLException {
		closeConnectionQueue(givenAwayConQueue);
		closeConnectionQueue(connectionQueue);

	}

	private void closeConnectionQueue(BlockingQueue<Connection> queue)
			throws SQLException {
		Connection connection;
		while ((connection = queue.poll()) != null) {
			if (!connection.getAutoCommit()) {
				connection.commit();
			}
			((PooledConnection) connection).reallyClose();
		}
	}
	
	// Получение соединения
	public Connection getConnection() throws InterruptedException {
		Connection connection = null;
		
			// Получение соединения из очереди свободных соединений
			connection = connectionQueue.take();
			// Добавление соединения в очередь занятых соединений
			givenAwayConQueue.add(connection);
		
		return connection;

	}
	
	// Закрытие соединения (вместе с запросом и ответом)
	public void closeConnection(Connection connection, Statement statement,
			ResultSet resultSet) throws SQLException {
		
			connection.close();
			statement.close();
			resultSet.close();
		
	}

	// Закрытие соединения (вместе с запросом)
	public void closeConnection(Connection connection, Statement statement) throws SQLException {
		
			connection.close();
			statement.close();
		}

	

	// Класс соединения в пуле на основе стандартного БД-соединения 
	// Переопределен только конструктор и метод закрытия соединения
	// Добавлен метод "реального закрытия" соединения
	private class PooledConnection implements Connection {

		private Connection connection;

		public PooledConnection(Connection connection) throws SQLException {
			this.connection = connection;
			this.connection.setAutoCommit(true);
		}
		
		// "Реальное закрытие" соединения (вызывается при очистке пула)
		public void reallyClose() throws SQLException {
			connection.close();
		}

		public boolean isWrapperFor(Class<?> iface) throws SQLException {
			return connection.isWrapperFor(iface);
		}

		public <T> T unwrap(Class<T> iface) throws SQLException {

			return connection.unwrap(iface);
		}

		public void abort(Executor executor) throws SQLException {
			connection.abort(executor);

		}

		public void clearWarnings() throws SQLException {
			connection.clearWarnings();
		}
		// Закрытие соединения
		public void close() throws SQLException {
			 // Проверка, не закрыто ли соединение
			if (connection.isClosed()) {
				throw new SQLException("Attempting to close closed connection");
			}
			 // Снятие режима только для чтения
			if (connection.isReadOnly()) {
				connection.setReadOnly(false);
			}
			 // Попытка удаления соединения из очереди занятых соединений
			 // В случае неудачи - выброс исключения
			if (!givenAwayConQueue.remove(this)) {
				throw new SQLException(
						"Deleting connection from the givens away pool");
			}
			 // Попытка возвращения соединения в очередь свободных соединений
			 // В случае неудачи - выброс исключения
			if (!connectionQueue.offer(this)) {
				throw new SQLException(
						"Error allocating connection in the pool.");
			}
		}

		public void commit() throws SQLException {
			connection.commit();

		}

		public Array createArrayOf(String typeName, Object[] elements)
				throws SQLException {
			return connection.createArrayOf(typeName, elements);
		}

		public Blob createBlob() throws SQLException {
			return connection.createBlob();
		}

		public Clob createClob() throws SQLException {
			return connection.createClob();
		}

		public NClob createNClob() throws SQLException {
			return connection.createNClob();
		}

		public SQLXML createSQLXML() throws SQLException {
			return connection.createSQLXML();
		}

		public Statement createStatement() throws SQLException {
			return connection.createStatement();
		}

		public Statement createStatement(int resultSetType,
				int resultSetConcurrency) throws SQLException {
			return connection.createStatement(resultSetType,
					resultSetConcurrency);
		}

		public Statement createStatement(int resultSetType,
				int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			return connection.createStatement(resultSetType,
					resultSetConcurrency, resultSetHoldability);
		}

		public Struct createStruct(String typeName, Object[] attributes)
				throws SQLException {
			return connection.createStruct(typeName, attributes);
		}

		public boolean getAutoCommit() throws SQLException {
			return connection.getAutoCommit();
		}

		public String getCatalog() throws SQLException {
			return connection.getCatalog();
		}

		public Properties getClientInfo() throws SQLException {
			return connection.getClientInfo();
		}

		public String getClientInfo(String name) throws SQLException {
			return connection.getClientInfo(name);
		}

		public int getHoldability() throws SQLException {
			return connection.getHoldability();
		}

		public DatabaseMetaData getMetaData() throws SQLException {
			return connection.getMetaData();
		}

		public int getNetworkTimeout() throws SQLException {
			return connection.getNetworkTimeout();
		}

		public String getSchema() throws SQLException {
			return connection.getSchema();
		}

		public int getTransactionIsolation() throws SQLException {
			return connection.getTransactionIsolation();
		}

		public Map<String, Class<?>> getTypeMap() throws SQLException {
			return connection.getTypeMap();
		}

		public SQLWarning getWarnings() throws SQLException {
			return connection.getWarnings();
		}

		public boolean isClosed() throws SQLException {
			return connection.isClosed();
		}

		public boolean isReadOnly() throws SQLException {
			return connection.isReadOnly();
		}

		public boolean isValid(int timeout) throws SQLException {
			return connection.isValid(timeout);
		}

		public String nativeSQL(String sql) throws SQLException {
			return connection.nativeSQL(sql);
		}

		public CallableStatement prepareCall(String sql) throws SQLException {
			return connection.prepareCall(sql);
		}

		public CallableStatement prepareCall(String sql, int resultSetType,
				int resultSetConcurrency) throws SQLException {
			return connection.prepareCall(sql, resultSetType,
					resultSetConcurrency);
		}

		public CallableStatement prepareCall(String sql, int resultSetType,
				int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			return connection.prepareCall(sql, resultSetType,
					resultSetConcurrency, resultSetHoldability);
		}

		public PreparedStatement prepareStatement(String sql)
				throws SQLException {
			return connection.prepareStatement(sql);
		}

		public PreparedStatement prepareStatement(String sql,
				int autoGeneratedKeys) throws SQLException {
			return connection.prepareStatement(sql, autoGeneratedKeys);
		}

		public PreparedStatement prepareStatement(String sql,
				int[] columnIndexes) throws SQLException {

			return connection.prepareStatement(sql, columnIndexes);
		}

		public PreparedStatement prepareStatement(String sql,
				String[] columnNames) throws SQLException {

			return connection.prepareStatement(sql, columnNames);
		}

		public PreparedStatement prepareStatement(String sql,
				int resultSetType, int resultSetConcurrency)
				throws SQLException {

			return connection.prepareStatement(sql, resultSetType,
					resultSetConcurrency);
		}

		public PreparedStatement prepareStatement(String sql,
				int resultSetType, int resultSetConcurrency,
				int resultSetHoldability) throws SQLException {

			return connection.prepareStatement(sql, resultSetType,
					resultSetConcurrency, resultSetHoldability);
		}

		public void releaseSavepoint(Savepoint savepoint) throws SQLException {
			connection.releaseSavepoint(savepoint);

		}

		public void rollback() throws SQLException {
			connection.rollback();

		}

		public void rollback(Savepoint savepoint) throws SQLException {
			connection.rollback(savepoint);

		}

		public void setAutoCommit(boolean autoCommit) throws SQLException {
			connection.setAutoCommit(autoCommit);

		}

		public void setCatalog(String catalog) throws SQLException {
			connection.setCatalog(catalog);

		}

		public void setClientInfo(Properties properties)
				throws SQLClientInfoException {
			connection.setClientInfo(properties);

		}

		public void setClientInfo(String name, String value)
				throws SQLClientInfoException {
			connection.setClientInfo(name, value);

		}

		public void setHoldability(int holdability) throws SQLException {
			connection.setHoldability(holdability);

		}

		public void setNetworkTimeout(Executor executor, int milliseconds)
				throws SQLException {
			connection.setNetworkTimeout(executor, milliseconds);

		}

		public void setReadOnly(boolean readOnly) throws SQLException {
			connection.setReadOnly(readOnly);

		}

		public Savepoint setSavepoint() throws SQLException {
			return connection.setSavepoint();
		}

		public Savepoint setSavepoint(String name) throws SQLException {
			return connection.setSavepoint(name);
		}

		public void setSchema(String schema) throws SQLException {
			connection.setSchema(schema);

		}

		public void setTransactionIsolation(int level) throws SQLException {
			connection.setTransactionIsolation(level);

		}

		public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
			connection.setTypeMap(map);

		}
	}
	
}
