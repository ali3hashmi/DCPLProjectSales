package com.dcpl.base;

import java.io.FileInputStream;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.dcpl.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {

	public static Properties prop; 
	//public static WebDriver driver;
	//Action action=new Action();
	
	//Declare ThreadLocal - for parellel testing
	public static ThreadLocal<RemoteWebDriver> driver= new ThreadLocal<>();

/*
	//initialize or configure log4j.xml
	@BeforeSuite
	public void beforeSuite() {
		
		DOMConfigurator.configure("log4j.xml");
		
	}
	
	*/
	
	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
	public void readConfig() throws Throwable {

		//Configure ExtentManager.setExtent() in @BeforeSuite method in BaseClass
		ExtentManager.setExtent();
		
		//initialize or configure log4j.xml
		DOMConfigurator.configure("log4j.xml");
		
		prop = new Properties(); 
		//System.out.println("super constructor is invoked");
		FileInputStream in =new FileInputStream(System.getProperty("user.dir") + "/Configuration/config.properties");
		prop.load(in);
		System.out.println("Driver : " + driver);

	}

	public static WebDriver getDriver() {
		
		// Get Driver from threadLocalmap
		return driver.get();
	}
	
	//@BeforeClass
	//@Parameters("browser")
	@SuppressWarnings("deprecation")
	public static void LaunchApp(String browserName) {

		//String browserName = prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();	
			//System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			//driver = new ChromeDriver();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
			
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
			
		}
		else if(browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			//driver = new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
		}

		//Action.implicitWait(driver, 10);
		//Action.pageLoadTimeOut(driver, 20);
		
		//Maximize the screen
		getDriver().manage().window().maximize();
		//Delete all the cookies
		getDriver().manage().deleteAllCookies();
		//Implicit TimeOuts
		getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
		
		getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
		//Launching the URL
		getDriver().get(prop.getProperty("salesURL"));
		

	}
	
	@AfterSuite(groups = {"Smoke","Sanity","Regression"})
	public  void afterSuite() {
		
		ExtentManager.endReport();
	}

	





}
