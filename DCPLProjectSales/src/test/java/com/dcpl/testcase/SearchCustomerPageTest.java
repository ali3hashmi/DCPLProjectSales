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
import com.dcpl.pageobjects.AddNewCustomerPage;
import com.dcpl.pageobjects.LoginPage;
import com.dcpl.pageobjects.SalesHomePage;
import com.dcpl.pageobjects.SearchCustomerPage;
import com.dcpl.utility.Log;

/**
 * @author USER
 *
 */
public class SearchCustomerPageTest extends BaseClass{

	private LoginPage loginPage;
	private SalesHomePage salesHomePage;
	private SearchCustomerPage searchCustomerPage;
	//private AddNewCustomerPage addNewCustomerPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {

		super.LaunchApp(browser);
	}


	@Test(priority = 0,groups = "Regression",dataProvider = "searchCustomerDetailsData",dataProviderClass = SalesDataProvider.class,
			description = "Testing search customer details")
	public void searchCustomerTest(HashMap<String, String> hashMapValue) throws Throwable {

		loginPage =new LoginPage();
		salesHomePage=new SalesHomePage();
		searchCustomerPage =new SearchCustomerPage();
		//addNewCustomerPage=new AddNewCustomerPage();

		Log.startTestCase("Search Customer Test Case");
		salesHomePage=loginPage.salesLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), salesHomePage);
		searchCustomerPage=salesHomePage.createNewCustomer(searchCustomerPage);
		searchCustomerPage.searchCustomerDetail(hashMapValue.get("customerID"),
				hashMapValue.get("customerName"),
				hashMapValue.get("customerContactNumber"),
				hashMapValue.get("customerLoyaltyCard"));
		searchCustomerPage.clickOnSeach();
		boolean res =searchCustomerPage.verifySearchDetailGrid();
		Assert.assertTrue(res);
		Log.info("Search customer test case passed");
		Log.endTestCase("Search Customer Test Case");


	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {

		Thread.sleep(5000);
		getDriver().quit();
	}

}
