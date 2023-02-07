/**
 * 
 */
package com.dcpl.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dcpl.base.BaseClass;
import com.dcpl.dataprovider.SalesDataProvider;
import com.dcpl.pageobjects.LoginPage;
import com.dcpl.pageobjects.OrderExecutionHomePage;
import com.dcpl.pageobjects.SalesHomePage;
import com.dcpl.utility.Log;
import com.dcpl.actiondriver.Action;
/**
 * @author USER
 *
 */
public class SalesLoginPageTest extends BaseClass{

	Action action = new Action();
	
	private LoginPage loginPage; //=new LoginPage();
	private SalesHomePage saleHomePage; //=new SalesHomePage();
	
	//private OrderExecutionHomePage oeHomePage;
	
	
	//@Parameters({"browser","environment"}) //in case multiple parameters
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {
		
		super.LaunchApp(browser);
	}

	
	@Test(groups = {"Smoke","Sanity"},dataProvider = "salesLoginCredentials",dataProviderClass = SalesDataProvider.class,
		description = "Performing user login for sales portal")
	public void salesLoginTest(HashMap<String,String> hashMapValue) throws Throwable {
		
		loginPage =new LoginPage();
		saleHomePage=new SalesHomePage();
		Log.startTestCase("Sales Login Test");
		Log.info("User going to perform sale login test");
		Log.info("Enter HRMSID and Password");
		//int hrms =Integer.parseInt(hrmsid);
		saleHomePage=loginPage.salesLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"),saleHomePage);
		//String actualSaleHomePageTitle= action.getTitle(getDriver());
		//String expectedSaleHomePageTitle ="Sales - Dashboard - Sales";
		//Assert.assertEquals(actualSaleHomePageTitle, expectedSaleHomePageTitle);
		String actualSalesHomePageText = saleHomePage.getSalesHomeText();
		//System.out.println(actualSalesHomePageText);
		String expectedSalesHomePageText =" Sales - Home";
		Assert.assertEquals(actualSalesHomePageText, expectedSalesHomePageText);
		Log.info("Sales Login Success");
		Log.endTestCase("Sales Login Test");
		
		
		
		
	}
	
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {
		
		getDriver().quit();
	}
	
	
}
