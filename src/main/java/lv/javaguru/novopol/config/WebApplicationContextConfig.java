package lv.javaguru.novopol.config;

import java.io.PrintWriter;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableWebMvc
//@EnableTransactionManagement
@ComponentScan(basePackages = { "lv.javaguru.novopol" })
//@PropertySource("classpath:database.properties")
public class WebApplicationContextConfig extends WebMvcConfigurerAdapter {
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}
//
//	@Bean
//	public static DataSource dataSource(@Value("${server.url}") String url, @Value("${server.driver}") String driver,
//			@Value("${server.login.admin}") String login, @Value("${server.password}") String pass) {
//		Properties props = new Properties();
//		props.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
//		props.setProperty("dataSource.user", "test");
//		props.setProperty("dataSource.password", "test");
//		props.setProperty("dataSource.databaseName", "mydb");
//		props.put("dataSource.logWriter", new PrintWriter(System.out));
//
//		HikariConfig config = new HikariConfig(props);
//		HikariDataSource ds = new HikariDataSource(config);
//		return ds;
//	}
//
//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		return null;
//	}
//
//	@Bean
//	public Properties hibernateProperties(@Value("${hibernate.dialect}") String dialect,
//			@Value("${hibernate.show_sql}") boolean showSql, @Value("${hibernate.format_sql}") boolean formatSql,
//			@Value("${hibernate.hbm2ddl.auto}") String hbm2ddl) {
//
//		Properties properties = new Properties();
//		properties.put("hibernate.dialect", dialect);
//		properties.put("hibernate.show_sql", showSql);
//		properties.put("hibernate.format_sql", formatSql);
//		properties.put("hibernate.hbm2ddl.auto", hbm2ddl);
//
//		return properties;
//	}
//
//	@Bean
//	public SessionFactory sessionFactory(DataSource dataSource,
//			@Value("${hibernate.packagesToScan}") String packagesToScan,
//			@Qualifier("hibernateProperties") Properties properties) throws Exception {
//
//		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//		sessionFactoryBean.setDataSource(dataSource);
//		sessionFactoryBean.setPackagesToScan(packagesToScan);
//		sessionFactoryBean.setHibernateProperties(properties);
//		sessionFactoryBean.afterPropertiesSet();
//		return sessionFactoryBean.getObject();
//	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
