package com.dcpl.testcase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
		
		double total_pages=orderConfirmationPage.verifyNumberOfPages();
		
		double expectedTotalPages = total_pages;
		
		Assert.assertEquals(total_pages, expectedTotalPages);
		
		
		int act_rows = orderConfirmationPage.verifyTotalNoOfRows();
     	System.out.println(act_rows);
    	int expected_rows = act_rows;
	
    	Assert.assertEquals(act_rows, expected_rows);
		List<String> act_order_no =new ArrayList<>();
		
		act_order_no=orderConfirmationPage.readAllRows();
		System.out.println(act_order_no);
		
		List<String> exp_order_no =new ArrayList<>();
		exp_order_no.addAll(act_order_no);
		
		Assert.assertEquals(act_order_no, exp_order_no);
		

		String act_success_msg=orderConfirmationPage.confirmTheOrder();
		
		String exp_success_msg =act_success_msg;
		
		Assert.assertEquals(act_success_msg, exp_success_msg);
		
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
	
	@Test(priority = 2,groups= {"Sanity","Regression"},dataProvider = "OrderConfirmationPageData",dataProviderClass = SalesDataProvider.class,
			description = "Verifying order confirmation by passing order number")
	public void verifyOrderConfirmationPageSearchGridHeaders(HashMap<String, String> hashMapValue) throws  Throwable{
		
		loginPage =new LoginPage();
		salesHomePage =new SalesHomePage();
		orderConfirmationPage =new OrderConfirmationPage();

		Log.startTestCase("Order Confirmation Page Test");
		salesHomePage=loginPage.salesLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), salesHomePage);
		orderConfirmationPage=salesHomePage.confirmCustomerOrder(orderConfirmationPage);
		
		//String docNumber = receiptVoucherPage.getDocNumber();
		//orderConfirmationPage.setOrderNo(hashMapValue.get("orderno"));
		orderConfirmationPage.clickOnSearchBtn();
		//orderConfirmationPage.confirmTheOrder();
		List<String> orderConfirmationSearchGridHeaders =new ArrayList<>();
		orderConfirmationSearchGridHeaders=orderConfirmationPage.verifyOrderConfirmationSearchGridHeaders();
		System.out.println(orderConfirmationSearchGridHeaders);
		List<String> expectedHeadersList = new ArrayList<>();
		
		//expectedHeadersList.add("");
		expectedHeadersList.add("Order No");
		expectedHeadersList.add("Order Date");
		expectedHeadersList.add("Customer Name");
		expectedHeadersList.add("Gold");
		expectedHeadersList.add("Platinum");
		expectedHeadersList.add("Silver");
		expectedHeadersList.add("Advance Amount");
		expectedHeadersList.add("Action");
		
		Collections.sort(orderConfirmationSearchGridHeaders);
		Collections.sort(expectedHeadersList);
		
		
		Assert.assertEquals(orderConfirmationSearchGridHeaders, expectedHeadersList);
		Log.info("Test case passed");
		Log.endTestCase("Order Confirmation Page Test");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {

		Thread.sleep(5000);
		getDriver().quit();
	}

}
