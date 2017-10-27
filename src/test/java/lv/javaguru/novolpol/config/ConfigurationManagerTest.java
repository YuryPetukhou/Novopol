package lv.javaguru.novolpol.config;

import static org.junit.Assert.*;

import org.junit.Test;

import lv.javaguru.novopol.config.ConfigurationManager;

public class ConfigurationManagerTest {

	@Test
	public void test() {
		ConfigurationManager manager = ConfigurationManager.getInstance();
		String driver = manager.getProperty("server.driver");
		assertNotNull(driver);
	}

}
