package lv.javaguru.novopol.config;

import java.util.ResourceBundle;

public class ConfigurationManager {
	private volatile static ConfigurationManager instance;
    private volatile static ResourceBundle bundle;
    
    public static final String BUNDLE_NAME = "config";
     
    private ConfigurationManager() {
    }
    
    public static ConfigurationManager getInstance() {
        if(instance == null) {
        	synchronized (ConfigurationManager.class){
        		if(instance == null) {
        			instance = new ConfigurationManager();
                    bundle = ResourceBundle.getBundle(BUNDLE_NAME);
        		}
        	}
        }
        return instance;
    }
    
    public String getProperty(String key) {
        return bundle.getString(key);
      }

}
