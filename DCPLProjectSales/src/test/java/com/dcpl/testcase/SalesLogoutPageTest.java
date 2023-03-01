/**
 * 
 */
package com.dcpl.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;
import com.dcpl.dataprovider.SalesDataProvider;
import com.dcpl.pageobjects.LoginPage;
import com.dcpl.pageobjects.SalesHomePage;
import com.dcpl.utility.Log;
import com.dcpl.testcase.SalesLoginPageTest;

/**
 * @author USER
 *
 */
public class SalesLogoutPageTest extends BaseClass {

	Action action = new Action();

	private LoginPage loginPage; //=new LoginPage();
	private SalesHomePage saleHomePage; //=new SalesHomePage();
	private SalesLoginPageTest salesLoginPTest;

	//private OrderExecutionHomePage oeHomePage;


	//@Parameters({"browser","environment"}) //in case multiple parameters
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {

		super.LaunchApp(browser);
	}


	@Test(groups = {"Smoke","Sanity","Regression"},dataProvider = "salesLoginCredentials",dataProviderClass = SalesDataProvider.class,
			priority = 0,description = "Performing user logout for sales portal")
	public void salesLogoutTest(String hrmsid,String password) throws Throwable {

		loginPage =new LoginPage();
		saleHomePage=new SalesHomePage();
		salesLoginPTest=new SalesLoginPageTest();
		Log.startTestCase("Sales Logout Test");
		//salesLoginPTest.salesLoginTest(hrmsid, password);
		saleHomePage=loginPage.salesLogin(hrmsid,password,saleHomePage);
		loginPage=saleHomePage.salesLogout(loginPage);
		String actualLoginPageTitle=loginPage.getTitle(getDriver());
		String expectedLoginPageTitle="Login";
		Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle);
		Log.info("Sales Logout Success");
		Log.endTestCase("Sales Logout Test");	

		/*if(loginPage.getTitle(getDriver()).equalsIgnoreCase("Login")) {

			Assert.assertTrue(true);
			Log.info("Sales Logout Success");

		}else {

			Assert.assertTrue(false);
			Log.info("Sales Logout Unsuccessfull");
		}*/
	}


	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {

		getDriver().quit();
	}

}
