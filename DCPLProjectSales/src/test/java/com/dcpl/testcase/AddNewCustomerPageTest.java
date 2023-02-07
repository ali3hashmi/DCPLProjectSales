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
public class AddNewCustomerPageTest extends BaseClass {

	
	private LoginPage loginPage;
	private SalesHomePage salesHomePage;
	private SearchCustomerPage searchCustomerPage;
	private AddNewCustomerPage addNewCustomerPage;
	
	
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {
		
		super.LaunchApp(browser);
	}
	
	@Test(priority = 0,groups = "Sanity",dataProvider = "salesLoginCredentials",dataProviderClass = SalesDataProvider.class,
			description ="Verifying the add new customer page" )
	public void verifyAddNewCustomerPageTest(String hrmsid,String password) throws Throwable {
		
		loginPage =new LoginPage();
		salesHomePage=new SalesHomePage();
		searchCustomerPage=new SearchCustomerPage();
		addNewCustomerPage =new AddNewCustomerPage();
	
		
		
		Log.startTestCase("AddNewCustomerPageTest");
		salesHomePage=loginPage.salesLogin(hrmsid, password, salesHomePage);
		
		searchCustomerPage=salesHomePage.createNewCustomer(searchCustomerPage);
		//String actualSearchCustomerPageTitle=searchCustomerPage.getTitle(getDriver());
		//System.out.println(actualSearchCustomerPageTitle);
		//String expectedSearchCustomerPageTitle ="Customer Search Details - Sales";
		//Assert.assertEquals(actualSearchCustomerPageTitle, expectedSearchCustomerPageTitle);
		//Thread.sleep(3000);
		addNewCustomerPage=searchCustomerPage.clickOnAddNewCustomer(addNewCustomerPage);
		String actualAddNewCustText=addNewCustomerPage.getAddNewCustText();
		String expectedAddNewCustText="Add New Customer";
		Assert.assertEquals(actualAddNewCustText, expectedAddNewCustText);
		Log.info("verifyAddNewCustomerPageTest Test case passed");
		Log.endTestCase("AddNewCustomerPageTest");
		
		
		
	}
	
	@Test(priority = 1,groups = "Regression",dataProvider = "addNewCustomerDetailsData",dataProviderClass = SalesDataProvider.class,
			description = "Creating new customers and validating its success")
	public void createCustomerDetailsTest(HashMap<String, String> hashMapValue) throws Throwable {
		
		loginPage =new LoginPage();
		salesHomePage =new SalesHomePage();
		searchCustomerPage=new SearchCustomerPage();
		addNewCustomerPage=new AddNewCustomerPage();
		
		Log.startTestCase("AddNewCustomerDetailTest");
		salesHomePage=loginPage.salesLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), salesHomePage);
		searchCustomerPage=salesHomePage.createNewCustomer(searchCustomerPage);
		addNewCustomerPage=searchCustomerPage.clickOnAddNewCustomer(addNewCustomerPage);
		addNewCustomerPage.setAddNewCustomerDetails(hashMapValue.get("customerType"),
				hashMapValue.get("customerTitles"),
				hashMapValue.get("customerFirstName"), 
				hashMapValue.get("customerMiddleName"),
				hashMapValue.get("customerLastName"), 
				hashMapValue.get("customerGender"),
				hashMapValue.get("customerAddress1"),
				hashMapValue.get("customerAddress2"), 
				hashMapValue.get("customerAddress3"),
				hashMapValue.get("customerPanNumber"),
				hashMapValue.get("customerMobile1"),
				hashMapValue.get("customerMobile2"),
				hashMapValue.get("customerLandLineHome"),
				hashMapValue.get("customerLandLineOffice"),
				hashMapValue.get("customerCountry"),
				hashMapValue.get("customerState"),
				hashMapValue.get("customerCity"),
				hashMapValue.get("customerEmail"),
				hashMapValue.get("customerPinCode"),
				hashMapValue.get("customerGSTNo"), 
				hashMapValue.get("customerAdharNo"));
		
		searchCustomerPage=addNewCustomerPage.clickOnAddNewCustomer(searchCustomerPage);
		boolean res=addNewCustomerPage.validateAddNewCustomer();
		Assert.assertTrue(res);
	    Log.info("AddNewCustomerDetails TestCase Passed");
	    Log.endTestCase("AddNewCustomerDetailTest");
		
	}
	
	
	
	
	
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {
		
		Thread.sleep(5000);
		getDriver().quit();
	}
}
