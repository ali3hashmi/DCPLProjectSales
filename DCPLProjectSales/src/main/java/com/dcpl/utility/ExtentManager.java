/**
 * 
 */
package com.dcpl.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @author USER
 *
 */
public class ExtentManager {

	public static ExtentHtmlReporter htmlReporter;
	//public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static void setExtent() throws Throwable {

		//htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+BaseClass.getCurrentTime()+".html");
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"DCPLProjectReport.html");
		//sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		htmlReporter.config().setDocumentTitle("Automation Test Report For DCPL Project");
		//Name of the report
		htmlReporter.config().setReportName("DCPL Project Test Automation Report");
		//Dark Theme
		//sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "DCPLProject");
		extent.setSystemInfo("Tester", "ALI HASHMI");
		extent.setSystemInfo("OS", "Windows 11 Home Single Language");
		extent.setSystemInfo("Browser", "chrome");

	}

	public static void endReport() {

		//close the report
		extent.flush();
	}

}
