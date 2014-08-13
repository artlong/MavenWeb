package tw.com.artlong.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 取得系統參數檔
 */
public class PropertyUtils {

	private final static Log log = LogFactory.getLog(PropertyUtils.class);

	private static PropertiesConfiguration properties = null;

	public PropertyUtils(String propertiesLocation){
		try {
			properties = new PropertiesConfiguration();
			properties.setListDelimiter('\\');
			properties.load(propertiesLocation);
			FileChangedReloadingStrategy strategy = new FileChangedReloadingStrategy();
			strategy.setRefreshDelay(10000);
			properties.setReloadingStrategy(strategy);
		} catch (ConfigurationException e) {
			log.error("load properties occur configurationException : ", e);
		}
	}
	
	public static String getEnvironmentMode(){
		return properties.getString("system.environment.mode");
	}
}
