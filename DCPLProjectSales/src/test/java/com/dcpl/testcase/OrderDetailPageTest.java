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
import com.dcpl.pageobjects.CreditAndAdvancePage;
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
public class OrderDetailPageTest extends BaseClass{

	private LoginPage loginPage;
	private SalesHomePage salesHomePage;
	private SearchCustomerPage searchCustomerPage;
	private OrderHeaderPage orderHeaderPage;
	private OrderDetailPage orderDetailPage;
	private CreditAndAdvancePage creditAndAdvancePage;
	
	
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {
		
		super.LaunchApp(browser);
	}
	
	@Test(priority = 1,groups = {"Sanity","Regression"},dataProvider = "orderDetailPageData",dataProviderClass = SalesDataProvider.class,
			description = "Testing customer order creation for order kind NO")
	public void createCustomerOrderWithOrderKindNOTest(HashMap<String, String> hashMapValue) throws Throwable {
		
		loginPage =new LoginPage();
		salesHomePage=new SalesHomePage();
		searchCustomerPage=new SearchCustomerPage();
		//addNewCustomerPage =new AddNewCustomerPage();
		orderHeaderPage =new OrderHeaderPage();
		orderDetailPage =new OrderDetailPage();
		creditAndAdvancePage = new CreditAndAdvancePage();
		
		Log.startTestCase("Customer order creation for order kind NO");
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
		orderDetailPage.setCustomerOrderDetails(hashMapValue.get("orderKind"),
				hashMapValue.get("segmentType"),
				hashMapValue.get("jewelType"),
				hashMapValue.get("Pieces"));
		orderDetailPage.chooseVendorCode(hashMapValue.get("vendorCode"));
		orderDetailPage.chooseArticleCode(hashMapValue.get("mainCategory"),
				hashMapValue.get("subCategory"));
		orderDetailPage.chooseDueDate(hashMapValue.get("dueDateMonth"),
				hashMapValue.get("dueDateYear"),
				hashMapValue.get("dueDateDay"));
		orderDetailPage.selectSalesExecutive(hashMapValue.get("salesExecutiveID"));
		orderDetailPage.chooseMetalProperties(hashMapValue.get("metalColor"),
				hashMapValue.get("skinPurity"),
				hashMapValue.get("metalWeightType"),
				hashMapValue.get("fromWeightRange"),
				hashMapValue.get("toWeightRange"),
				hashMapValue.get("expectedWeightRange"));
		orderDetailPage.chooseAttributeDetailsForLength(hashMapValue.get("lengthSearch"));
		orderDetailPage.chooseAttributeDetailsForHookType(hashMapValue.get("hookTypeSearch"));
		orderDetailPage.chooseAttributeDetailsForPolishType(hashMapValue.get("polishTypeSearch"));
		orderDetailPage.chooseAttributeDetailsForSettingType(hashMapValue.get("settingTypeSearch"));
		creditAndAdvancePage=orderDetailPage.clickOnNextBtn(creditAndAdvancePage);
		String actCreditAndAdvanceText = creditAndAdvancePage.verifyCreditAndAdvanceText();
		String expCreditAndAdvanceText ="Credit & Advance";
		Assert.assertEquals(actCreditAndAdvanceText, expCreditAndAdvanceText);
		Log.info("Test Case Passes");
		Log.endTestCase("Customer order creation for order kind NO");
		
		
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {
		
		Thread.sleep(5000);
		getDriver().quit();
	}
}
