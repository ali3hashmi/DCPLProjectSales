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
import com.dcpl.pageobjects.OrderConfirmationPage;
import com.dcpl.pageobjects.ReceiptVoucherPage;
import com.dcpl.pageobjects.SalesHomePage;
import com.dcpl.utility.Log;

public class OrderConfirmationPageTest extends BaseClass{


	private LoginPage loginPage;
	private SalesHomePage salesHomePage;
	private OrderConfirmationPage orderConfirmationPage;
	private ReceiptVoucherPage receiptVoucherPage;
	
	

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {

		super.LaunchApp(browser);
	}


	@Test(priority = 0,groups= {"Sanity","Regression"},dataProvider = "OrderConfirmationPageData",dataProviderClass = SalesDataProvider.class,
			description = "Verifying order confirmation by passing from and to date")
	public void verifyOrderConfirmationByOrderDate(HashMap<String, String> hashMapValue) throws Throwable {

		

		loginPage =new LoginPage();
		salesHomePage =new SalesHomePage();
		orderConfirmationPage =new OrderConfirmationPage();
		receiptVoucherPage =new ReceiptVoucherPage();

		Log.startTestCase("Order Confirmation Page Test");
		salesHomePage=loginPage.salesLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), salesHomePage);
		orderConfirmationPage=salesHomePage.confirmCustomerOrder(orderConfirmationPage);


		orderConfirmationPage.chooseFromToDate(hashMapValue.get("frommonth"), 
				hashMapValue.get("fromyear"),
				hashMapValue.get("fromday"),
				hashMapValue.get("tomonth"),
				hashMapValue.get("toyear"),
				hashMapValue.get("today"));
				
		orderConfirmationPage.clickOnSearchBtn();
		orderConfirmationPage.confirmTheOrder();

		String actualOrderConfirmationTitle = orderConfirmationPage.getOrderConfirmationTitle();
		String expectedOrderConfirmationTitle ="Order Confirm Cashier - Sales";
		Assert.assertEquals(actualOrderConfirmationTitle, expectedOrderConfirmationTitle);
		Log.info("Test case passed");
		Log.endTestCase("Order Confirmation Page Test");



	}
	
	@Test(priority = 1,groups= {"Sanity","Regression"},dataProvider = "OrderConfirmationPageData",dataProviderClass = SalesDataProvider.class,
			description = "Verifying order confirmation by passing order number")
	public void verifyOrderConfirmationByOrderNo(HashMap<String, String> hashMapValue) throws  Throwable{
		
		loginPage =new LoginPage();
		salesHomePage =new SalesHomePage();
		orderConfirmationPage =new OrderConfirmationPage();

		Log.startTestCase("Order Confirmation Page Test");
		salesHomePage=loginPage.salesLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), salesHomePage);
		orderConfirmationPage=salesHomePage.confirmCustomerOrder(orderConfirmationPage);
		
		//String docNumber = receiptVoucherPage.getDocNumber();
		orderConfirmationPage.setOrderNo(hashMapValue.get("orderno"));
		orderConfirmationPage.clickOnSearchBtn();
		orderConfirmationPage.confirmTheOrder();
		
		String actualOrderConfirmationTitle = orderConfirmationPage.getOrderConfirmationTitle();
		String expectedOrderConfirmationTitle ="Order Confirm Cashier - Sales";
		Assert.assertEquals(actualOrderConfirmationTitle, expectedOrderConfirmationTitle);
		Log.info("Test case passed");
		Log.endTestCase("Order Confirmation Page Test");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {

		Thread.sleep(5000);
		getDriver().quit();
	}

}
