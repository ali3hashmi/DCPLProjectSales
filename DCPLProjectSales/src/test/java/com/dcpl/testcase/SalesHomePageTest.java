/**
 * 
 */
package com.dcpl.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dcpl.base.BaseClass;
import com.dcpl.dataprovider.SalesDataProvider;
import com.dcpl.pageobjects.LoginPage;
import com.dcpl.pageobjects.OrderConfirmationPage;
import com.dcpl.pageobjects.SalesHomePage;
import com.dcpl.utility.Log;

/**
 * @author USER
 *
 */
public class SalesHomePageTest extends BaseClass {
	
	private LoginPage loginPage;
	private SalesHomePage salesHomePage;
	private OrderConfirmationPage orderConfirmationPage;
	
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {
		
		super.LaunchApp(browser);
	}
	
	@Test(priority = 0,groups = {"Smoke"},dataProvider = "salesLoginCredentials",dataProviderClass = SalesDataProvider.class)
	public void verifyHomeCreateDocumentMenu(String hrmsid,String password) throws Throwable {
		
		loginPage=new LoginPage();
		salesHomePage=new SalesHomePage();
		Log.startTestCase("Home/Create Document Menu Test");
		salesHomePage=loginPage.salesLogin(hrmsid, password, salesHomePage);
		boolean res=salesHomePage.homeCreateDocumentMenuVerifcation();
		Assert.assertTrue(res);
		
		
	}
	
	@Test(priority = 1,groups = {"Smoke"},dataProvider = "salesLoginCredentials",dataProviderClass = SalesDataProvider.class)
	public void verifyOrdersMenu(String hrmsid,String password) throws Throwable {
		
		loginPage=new LoginPage();
		salesHomePage=new SalesHomePage();
		orderConfirmationPage = new OrderConfirmationPage();
		Log.startTestCase("Orders Menu Test");
		salesHomePage=loginPage.salesLogin(hrmsid, password, salesHomePage);
		boolean res=salesHomePage.ordersMenuVerification();
		Assert.assertTrue(res);
		
	}

	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {
		
		getDriver().quit();
	}
	

}
