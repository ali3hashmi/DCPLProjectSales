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
import com.dcpl.pageobjects.ReceiptVoucherViewPage;
import com.dcpl.pageobjects.SalesHomePage;
import com.dcpl.pageobjects.SearchCustomerPage;
import com.dcpl.pageobjects.ViewOrderPage;
import com.dcpl.utility.Log;

/**
 * @author USER
 *
 */
public class ReceiptVoucherPageTest extends BaseClass{

	private LoginPage loginPage;
	private SalesHomePage salesHomePage;
	private SearchCustomerPage searchCustomerPage;
	private OrderHeaderPage orderHeaderPage;
	private OrderDetailPage orderDetailPage;
	private CreditAndAdvancePage creditAndAdvancePage;
	private ConfirmOrderPage confirmOrderPage;
	private ReceiptVoucherPage receiptVoucherPage;
	private ReceiptVoucherViewPage receiptVoucherViewPage;
	private ViewOrderPage viewOrderPage;


	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUP(String browser) throws Throwable {

		super.LaunchApp(browser);
	}


	@Test(priority = 0,groups = {"Sanity","Regression"},dataProvider = "orderDetailPageData",dataProviderClass = SalesDataProvider.class,
			description = "Verifying receipt voucher page and its different payment modes")
	public void verifyingReceiptVocuherPage(HashMap<String, String> hashMapValue) throws Throwable {

		loginPage =new LoginPage();
		salesHomePage=new SalesHomePage();
		searchCustomerPage=new SearchCustomerPage();
		//addNewCustomerPage =new AddNewCustomerPage();
		orderHeaderPage =new OrderHeaderPage();
		orderDetailPage =new OrderDetailPage();
		creditAndAdvancePage = new CreditAndAdvancePage();
		confirmOrderPage = new ConfirmOrderPage();
		receiptVoucherPage = new ReceiptVoucherPage();
		receiptVoucherViewPage = new ReceiptVoucherViewPage();


		Log.startTestCase("Receipt voucher page test");
		salesHomePage=loginPage.salesLogin(hashMapValue.get("saleshrms_id"),
				hashMapValue.get("salespassword"), salesHomePage);
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
		receiptVoucherPage=confirmOrderPage.clickOnSaveAndProceed(receiptVoucherPage);
		String doctype=receiptVoucherPage.getDocType();
		System.out.println("Doc Type is " + doctype);
		String docnumber = receiptVoucherPage.getDocNumber();
		System.out.println("Doc Number is " + docnumber);
		String advAmt = receiptVoucherPage.passAdvanceAmount(hashMapValue.get("payAdvAmount"));
		final double advanceAmount = Double.parseDouble(advAmt);



		String multipleModeOrNot = hashMapValue.get("MultipleMode");
		String payMOption1= hashMapValue.get("payModesOption1");
		String payMOption2 =hashMapValue.get("payModesOption2");

		//receiptVoucherPage.getPaymentModes(hashMapValue.get("payModesOption"));


		//Array created  to store all payment modes 
		String[] payModes = {"Cash","ChequeDD","Card","AdjustForm","ForexCash","ForexCheque","GiftVoucherRedeem","MobilePayments"};
		final double advanceMaxByCash =200000;
		//boolean singleMode =false;
		//boolean multipleMode =false;

		//System.out.println(payMOption);
		if(multipleModeOrNot.equalsIgnoreCase("No")) {


			if(payMOption1.equalsIgnoreCase(payModes[0])) {

				String cashAmt=receiptVoucherPage.passPayModeCash(hashMapValue.get("CashAmount"));
				final double cashAMount = Double.parseDouble(cashAmt);

				
				if(advanceAmount == cashAMount  && advanceAmount <= advanceMaxByCash) {

					Thread.sleep(1000);
					receiptVoucherViewPage=receiptVoucherPage.clickOnSubmitBtn(receiptVoucherViewPage);
					Log.info("Advance amount and cash amount are equal and less than or equal to  " + advanceMaxByCash + " amount , so customer order created successfully");
				}else {

					Log.info("Advance amount and cash amount are not equal / advance amount is more than ," + advanceMaxByCash + "amount , so cannot be processed");

				}
			}else if (payMOption1.equalsIgnoreCase(payModes[1])) {

				receiptVoucherPage.paymentModeChequeDD(
						hashMapValue.get("MultipleMode"),
						hashMapValue.get("chequeDDType"),
						hashMapValue.get("accHolderName"),
						hashMapValue.get("accNumber"),
						hashMapValue.get("chequeNumber"),
						hashMapValue.get("chequeMonth"),
						hashMapValue.get("chequeYear"),
						hashMapValue.get("chequeDay"),
						hashMapValue.get("bankName"),
						hashMapValue.get("branchName"),
						hashMapValue.get("chequeAmount"));

				String chequeAmount = hashMapValue.get("chequeAmount");
				double chequeDDAmount = Double.parseDouble(chequeAmount);
				if(advanceAmount == chequeDDAmount) {

					Thread.sleep(1000);
					receiptVoucherViewPage=receiptVoucherPage.clickOnSubmitBtn(receiptVoucherViewPage);
					Log.info("Advance amount and cheque/DD amount are equal, so the customer order has been created successfully");
					
				}else {

					Log.info("Advance amount and cheque/DD amount are not equal, so customer cannot proceed further");
				}



			}else if (payMOption1.equalsIgnoreCase(payModes[2])) {

				receiptVoucherPage.paymentModeCard(hashMapValue.get("type"),
						hashMapValue.get("cardNumber"),
						hashMapValue.get("cardType"),
						hashMapValue.get("nameOnCard"),
						hashMapValue.get("cardExpiryMonth"),
						hashMapValue.get("cardExpiryYear"),
						hashMapValue.get("cardBankName"),
						hashMapValue.get("cardBank"),
						hashMapValue.get("authID"),
						hashMapValue.get("cardAmount"));
				
				String cardamount = hashMapValue.get("cardAmount");
				double cardAmount = Double.parseDouble(cardamount);
				//System.out.println(cardAmount);
				if(advanceAmount == cardAmount) {
					
					Thread.sleep(500);
					receiptVoucherViewPage=receiptVoucherPage.clickOnSubmitBtn(receiptVoucherViewPage);
					Log.info("Advance amount and card amount are equal, so the customer order has been created successfully");
				}else {

					Log.info("Advance amount and card amount are not equal, so customer cannot proceed further");
				}

			}else if (payMOption1.equalsIgnoreCase(payModes[3])) {

				receiptVoucherPage.paymentModeAdjustForm(hashMapValue.get("adjustType"),
						hashMapValue.get("adjustmentNumber"),
						hashMapValue.get("adjustmentAmount"));
				String adjustAmount=hashMapValue.get("adjustmentAmount");
				double adjAmount = Double.parseDouble(adjustAmount);
				if (advanceAmount == adjAmount) {
					
					Thread.sleep(500);
					receiptVoucherViewPage=receiptVoucherPage.clickOnSubmitBtn(receiptVoucherViewPage);
					Log.info("Advance amount and adjust amount are equal, so the customer order has been created successfully");
				}else {
					
					Log.info("Advance amount and adjust amount are not equal, so customer cannot proceed further");
				}
				
				
			}else if (payMOption1.equalsIgnoreCase(payModes[4])) {

				receiptVoucherPage.paymentModeForexCash();

			}else if (payMOption1.equalsIgnoreCase(payModes[5])) {

				receiptVoucherPage.paymentModeForexCheque();

			}else if (payMOption1.equalsIgnoreCase(payModes[6])) {
				
				

				receiptVoucherPage.paymentModeGiftVoucherRedeem(
					    hashMapValue.get("noOfGiftVouchers"),
						hashMapValue.get("firstGiftVoucherNumber"),
						hashMapValue.get("secondGiftVoucherNumber"));
				Thread.sleep(500);
				receiptVoucherViewPage=receiptVoucherPage.clickOnSubmitBtn(receiptVoucherViewPage);
				
				

			}else if (payMOption1.equalsIgnoreCase(payModes[7])) {

				receiptVoucherPage.paymentModeMobile();

			}


		}
		
		if(multipleModeOrNot.equalsIgnoreCase("Yes")) {
			
			if(payMOption1.equalsIgnoreCase(payModes[0]) && payMOption2.equalsIgnoreCase(payModes[1])) {
				
				String cashAmt=receiptVoucherPage.passPayModeCash(hashMapValue.get("CashAmount"));
				final double cashAMount = Double.parseDouble(cashAmt);
				
				receiptVoucherPage.paymentModeChequeDD(
						hashMapValue.get("MultipleMode"),
						hashMapValue.get("chequeDDType"),
						hashMapValue.get("accHolderName"),
						hashMapValue.get("accNumber"),
						hashMapValue.get("chequeNumber"),
						hashMapValue.get("chequeMonth"),
						hashMapValue.get("chequeYear"),
						hashMapValue.get("chequeDay"),
						hashMapValue.get("bankName"),
						hashMapValue.get("branchName"),
						hashMapValue.get("chequeAmount"));

				String chequeAmount = hashMapValue.get("chequeAmount");
				double chequeDDAmount = Double.parseDouble(chequeAmount);
				double totalCashAndChequeDDAmount = cashAMount + chequeDDAmount;
				
				if(advanceAmount == totalCashAndChequeDDAmount) {

					Thread.sleep(1000);
					receiptVoucherViewPage=receiptVoucherPage.clickOnSubmitBtn(receiptVoucherViewPage);
					Log.info("Total of cash and cheque amount are equal to advance amount  " + advanceAmount + " amount , so customer order created successfully");
				}else {

					Log.info("Total of cash and cheque amount are not equal to advance amount ," + advanceAmount + "amount , so cannot be processed");

				}
				
			}
		}


		//String actRecVoucherViewTitle= receiptVoucherViewPage.getReceiptVoucherViewTitle();
		//String expRecVoucherViewTitle ="Receipt Voucher - Sales";

		//Assert.assertEquals(actRecVoucherViewTitle, expRecVoucherViewTitle);
		viewOrderPage=receiptVoucherViewPage.clickOnViewOrderBtn(viewOrderPage);
		String actViewOrderPageTitle = viewOrderPage.getViewOrderPageTitle();
		String expViewOrderPageTitle ="Customer Order View - Sales";
		Assert.assertEquals(actViewOrderPageTitle, expViewOrderPageTitle);

		Log.info("Test case passed");
		Log.endTestCase("Receipt voucher page test");

	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeWebApplication() throws InterruptedException {

		Thread.sleep(5000);
		getDriver().quit();
	}
}
