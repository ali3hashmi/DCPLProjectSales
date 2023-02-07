package com.dcpl.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dcpl.base.BaseClass;
import com.dcpl.dataprovider.SalesDataProvider;
import com.dcpl.pageobjects.CashierReceiptPage;
import com.dcpl.pageobjects.LoginPage;
import com.dcpl.pageobjects.SalesHomePage;
import com.dcpl.utility.Log;

public class CashierReceiptPageTest extends BaseClass{

	private LoginPage loginPage;
	private SalesHomePage salesHomePage;
	private CashierReceiptPage cashierReceiptPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {

		super.LaunchApp(browser);
	}

	@Test(priority = 0,groups = {"Sanity","Regression"},dataProvider = "receiptsConfirmationPageData",dataProviderClass = SalesDataProvider.class,
			description = "Verifying receipt confirmation by logging into cashier login page")
	public void verifyReceiptsConfirmationByCashier(HashMap<String, String> hashmapValue) throws Throwable {
		
		loginPage =new LoginPage();
		salesHomePage =new SalesHomePage();
		cashierReceiptPage = new CashierReceiptPage();
		
		Log.startTestCase("Receipts Confirmation Page Test");
		salesHomePage=loginPage.salesLogin(hashmapValue.get("cashierhrms_id"),
				hashmapValue.get("cashierpassword"), salesHomePage);
		
		cashierReceiptPage=salesHomePage.confirmCustomerReceipts(cashierReceiptPage);
		cashierReceiptPage.clickOnReceiptMoreInfo();
		cashierReceiptPage.confirmReceipt();
		String actualReceiptToastMessage=cashierReceiptPage.getToastMessageText();
		String expectedReceiptToastMessage ="1 are confirmed SuccessFully";
		
		Assert.assertEquals(actualReceiptToastMessage, expectedReceiptToastMessage);
		Log.info("Test Case Passed");
		Log.endTestCase("Receipts Confirmation Page Test");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {

		Thread.sleep(5000);
		getDriver().quit();
	}
}
