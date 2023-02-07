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
import com.dcpl.pageobjects.SalesHomePage;
import com.dcpl.pageobjects.StoreHeadConfirmationPage;
import com.dcpl.utility.Log;
import com.dcpl.failedtestcases.RetryAnalyzerTest;

public class StoreHeadConfirmationPageTest extends BaseClass {

	private LoginPage loginPage;
	private SalesHomePage salesHomePage;
	private StoreHeadConfirmationPage storeHeadConfirmationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {

		super.LaunchApp(browser);
	}
	
	@Test(priority = 0,groups = {"Sanity","Regression"},dataProvider = "storeHeadConfirmationPageData",dataProviderClass = SalesDataProvider.class,
			description = "Verifying store head order confirmation by logging into store head login page")
	
	public void verifyingOrderConfirmationByStoreHead(HashMap<String, String> hashMapValue) throws Throwable {
		
		loginPage =new LoginPage();
		salesHomePage =new SalesHomePage();
		storeHeadConfirmationPage =new StoreHeadConfirmationPage();
		
		Log.startTestCase("Store head Confirmation Page Test");
		salesHomePage=loginPage.salesLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), salesHomePage);
		storeHeadConfirmationPage=salesHomePage.storeHeadConfirmation(storeHeadConfirmationPage);
		
		storeHeadConfirmationPage.chooseFromToDate(hashMapValue.get("frommonth"), 
				hashMapValue.get("fromyear"),
				hashMapValue.get("fromday"),
				hashMapValue.get("tomonth"),
				hashMapValue.get("toyear"),
				hashMapValue.get("today"));
		
		storeHeadConfirmationPage.clickOnSearchBtn();
		storeHeadConfirmationPage.confirmTheOrder();
		
		String actStoreHeadConfirmationSuccessMessage=storeHeadConfirmationPage.getToastMessageText();
		String expStoreHeadConfirmationSuccessMessage ="1 are successfully confirmed";
		
		Assert.assertEquals(actStoreHeadConfirmationSuccessMessage, expStoreHeadConfirmationSuccessMessage);
		Log.info("Test case passed");
		Log.endTestCase("Store head Confirmation Page Test");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {

		Thread.sleep(5000);
		getDriver().quit();
	}
}
