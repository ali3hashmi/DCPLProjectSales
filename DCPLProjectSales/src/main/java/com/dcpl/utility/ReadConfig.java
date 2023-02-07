/**
 * 
 */
package com.dcpl.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author USER
 *
 */
public class ReadConfig {

	//create object for properties class
	public static Properties prop;
	
	public ReadConfig() throws FileNotFoundException,IOException {
		// TODO Auto-generated constructor stub
		
		prop =new Properties();	
		FileInputStream in =new FileInputStream(System.getProperty("user.dir")+ "/Configuration/config.properties");
		prop.load(in);
		
		
	}
	
	public static String getEnvironment() {
		
		String environment=prop.getProperty("environment");
		return environment;
	}
	
	public static String getBrowser() {
		
		String broswer= prop.getProperty("browser");
		return broswer;
	}
	
	public static String getSalesURL() {
		
		String salesURL =prop.getProperty("salesURL");
		return salesURL;
	}
	
	public static String getOrderExecutionURL() {
		
		String orderExecutionURL = prop.getProperty("orderExecutionURL");
		return orderExecutionURL;
	}
	
	public static String getSalesUsername() {
		
		String salesUsername = prop.getProperty("salesusername");
		return salesUsername;
	}
	
	public static String getSalesPassword() {
		
		String salesPassword =prop.getProperty("salespassword");
		return salesPassword;
	}
	
	public static String getOrderExecutionUsername() {
		
		String orderExecutionUsername =prop.getProperty("orderexecutionusername");
		return orderExecutionUsername;
	}
	
	public static String getOrderExecutionPassword() {
		
		String orderExecutionPassword =prop.getProperty("orderexecutionpassword");
		return orderExecutionPassword;
	}
	
	public static String getChromeDriverPath() {
		
		String chromeDriverPath =prop.getProperty("chromepath");
		return chromeDriverPath;
	}
	
	public static int getImplicitWait() {
		
		String impWait =prop.getProperty("implicitWait");
		int implicitWait = Integer.parseInt(impWait);
		return implicitWait;
	}
	
	public static int getPageLoadTimeOut() {
		
		String pageloadtimeout =prop.getProperty("pageLoadTimeOut");
		int pageLoadTimeOut = Integer.parseInt(pageloadtimeout);
		return pageLoadTimeOut;
	}
}
