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
import com.dcpl.pageobjects.ConfirmOrderPage;
import com.dcpl.pageobjects.CreditAndAdvancePage;
import com.dcpl.pageobjects.LoginPage;
import com.dcpl.pageobjects.OrderDetailPage;
import com.dcpl.pageobjects.OrderHeaderPage;
import com.dcpl.pageobjects.ReceiptVoucherPage;
import com.dcpl.pageobjects.SalesHomePage;
import com.dcpl.pageobjects.SearchCustomerPage;
import com.dcpl.utility.Log;

/**
 * @author USER
 *
 */
public class CreditAndAdvancePageTest extends BaseClass{
	
	private LoginPage loginPage;
	private SalesHomePage salesHomePage;
	private SearchCustomerPage searchCustomerPage;
	private OrderHeaderPage orderHeaderPage;
	private OrderDetailPage orderDetailPage;
	private CreditAndAdvancePage creditAndAdvancePage;
	private ConfirmOrderPage confirmOrderPage;
	private ReceiptVoucherPage receiptVoucherPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {
		
		super.LaunchApp(browser);
	}
	
	@Test(priority = 0,groups = {"Sanity","Regression"},dataProvider = "orderDetailPageData",dataProviderClass = SalesDataProvider.class,
			description = "Verifying credit and advance page")
	public void verifyCreditAdvacnceTest(HashMap<String, String> hashMapValue) throws Throwable {
		
		loginPage =new LoginPage();
		salesHomePage=new SalesHomePage();
		searchCustomerPage=new SearchCustomerPage();
		//addNewCustomerPage =new AddNewCustomerPage();
		orderHeaderPage =new OrderHeaderPage();
		orderDetailPage =new OrderDetailPage();
		creditAndAdvancePage = new CreditAndAdvancePage();
		confirmOrderPage = new ConfirmOrderPage();
		receiptVoucherPage = new ReceiptVoucherPage();
		
		Log.startTestCase("Credit & advance page test");
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
		creditAndAdvancePage.payAdvance(hashMapValue.get("payAdvOption"));
		confirmOrderPage=creditAndAdvancePage.clickOnNextBtn(confirmOrderPage);
		//String actConfirmPageText =confirmOrderPage.verifyOrderConfirmPageText();
		//String expConfirmPageText ="Order Confirm";
		//Assert.assertEquals(actConfirmPageText, expConfirmPageText);
		receiptVoucherPage=confirmOrderPage.clickOnSaveAndProceed(receiptVoucherPage);
		
		String actReceiptVoucherTitle = receiptVoucherPage.receiptPageTitle();
		String expReceiptVoucherTitle ="Create Order - Sales";
		Assert.assertEquals(actReceiptVoucherTitle, expReceiptVoucherTitle);
		Log.info("Test case passed");
		Log.endTestCase("Credit & advance page test");
		
		
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {
		
		Thread.sleep(5000);
		getDriver().quit();
	}

}
