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
import com.dcpl.pageobjects.OrderDetailPage;
import com.dcpl.pageobjects.OrderHeaderPage;
import com.dcpl.pageobjects.SalesHomePage;
import com.dcpl.pageobjects.SearchCustomerPage;
import com.dcpl.utility.Log;

/**
 * @author USER
 *
 */
public class OrderHeaderPageTest extends BaseClass{

	private LoginPage loginPage;
	private SalesHomePage salesHomePage;
	private SearchCustomerPage searchCustomerPage;
	private AddNewCustomerPage addNewCustomerPage;
	private OrderHeaderPage orderHeaderPage;
	private OrderDetailPage orderDetailPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {
		
		super.LaunchApp(browser);
	}
	
	@Test(priority = 1,groups = {"Sanity","Regression"},dataProvider = "orderHeaderPageData",dataProviderClass = SalesDataProvider.class,
			description = "Testing order header page for customer order")
	public void createOrderHeaderPageTest(HashMap<String, String> hashMapValue) throws Throwable {
		
		loginPage =new LoginPage();
		salesHomePage=new SalesHomePage();
		searchCustomerPage=new SearchCustomerPage();
		addNewCustomerPage =new AddNewCustomerPage();
		orderHeaderPage =new OrderHeaderPage();
		orderDetailPage =new OrderDetailPage();
		
		Log.startTestCase("Order Header Page Test");
		salesHomePage=loginPage.salesLogin(hashMapValue.get("hrms_id"),
				hashMapValue.get("password"), salesHomePage);
		searchCustomerPage=salesHomePage.createNewCustomer(searchCustomerPage);
		searchCustomerPage.searchCustomerDetail(hashMapValue.get("customerID"),
				hashMapValue.get("customerName"),
				hashMapValue.get("customerContactNumber"),
				hashMapValue.get("customerLoyaltyCard"));
		searchCustomerPage.clickOnSeach();
		searchCustomerPage.clickOnAction();
		orderHeaderPage=searchCustomerPage.clickOnCustomerOrder(orderHeaderPage);
		orderHeaderPage.setOrderHeaderDetails(hashMapValue.get("occasion"),
				hashMapValue.get("occasionmonth"),
				hashMapValue.get("occasionyear"), 
				hashMapValue.get("occasiondate"),
				hashMapValue.get("occasionRemarks"), 
				hashMapValue.get("intimation"), 
				hashMapValue.get("intimationMode"), 
				hashMapValue.get("printNameInBill"), 
				hashMapValue.get("deliveryAddress"));
		orderDetailPage=orderHeaderPage.clickOnNext(orderDetailPage);
		String actOrderDetailText = orderDetailPage.verifyOrderDetailText();
		String expOrderDetailText="Order Details";
		Assert.assertEquals(actOrderDetailText, expOrderDetailText);
		Log.info("Test case passed");
		Log.endTestCase("Order Header Page Test");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {
		
		Thread.sleep(5000);
		getDriver().quit();
	}
}
