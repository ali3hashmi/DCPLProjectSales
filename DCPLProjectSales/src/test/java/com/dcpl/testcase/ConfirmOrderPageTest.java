/**
 * 
 */
package com.dcpl.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.dcpl.base.BaseClass;

/**
 * @author USER
 *
 */
public class ConfirmOrderPageTest extends BaseClass{
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {
		
		super.LaunchApp(browser);
	}
	
	
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {
		
		Thread.sleep(5000);
		getDriver().quit();
	}

}
