/**
 * 
 */
package com.dcpl.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;
import com.dcpl.utility.Log;

/**
 * @author USER
 *
 */
public class ReceiptVoucherPage extends Action {

	public ReceiptVoucherPage() {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//select[@name='docTypes']")
	private WebElement docType;

	@FindBy(xpath = "//input[@name='docNo']")
	private WebElement docNumber;

	@FindBy(xpath = "//input[@name='amount']")
	private WebElement advAmount;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/a[1]/span[1]")
	private WebElement paymentModesBtn;

	@FindBy(xpath = "//body//div[@class='ng-scope']//div[@class='row']//div[@class='row']//div[1]//ul[1]//li[1]//label[1]")
	private WebElement cash;

	@FindBy(xpath = "//label[normalize-space()='Cheque / DD']")
	private WebElement chequeDD;

	@FindBy(xpath = "//button[@class='btn btn-primary pull-right']")
	private WebElement addChequeDDBtn;

	@FindBy(xpath = "//input[@name='customerName']")
	private WebElement accHolderName;

	@FindBy(xpath = "//input[@name='accountNumber']")
	private WebElement accNumber; // length 17

	@FindBy(xpath = "//input[@name='instrumentNo']")
	private WebElement chequeNumber; //length 6

	@FindBy(xpath = "//input[@id='instrumentDate']")
	private WebElement chequeDate;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement chequeMonth;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement chequeYear;

	@FindBy(xpath = "/html[1]/body[1]/div[5]/table[1]/tbody[1]/tr[td]/td")
	private WebElement chequeDay;

	@FindBy(xpath = "//option[@class='ng-binding ng-scope']")
	private WebElement bankName;

	@FindBy(name = "branchName")
	private WebElement branchName;

	@FindBy(xpath = "//input[@type='number']")
	private WebElement chequeAmount;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement chequeAddBtn;

	@FindBy(xpath = "//label[normalize-space()='Card']")
	private WebElement card;

	@FindBy(xpath = "//button[@class='btn btn-primary pull-right']")
	private WebElement addCardBtn;

	@FindBy(xpath = "//input[@name='creditCardFlag']")
	private WebElement type;

	@FindBy(xpath = "//input[@name='cardNumber']")
	private WebElement cardNumber;

	@FindBy(xpath = "//select[@name='cardTypeDetails']")
	private WebElement cardType;

	@FindBy(xpath = "//input[@name='customerName']")
	private WebElement nameOnCard;

	@FindBy(xpath = "//select[@name='month']")
	private WebElement cardExpiryMonth;

	@FindBy(xpath = "//select[@name='year']")
	private WebElement cardExpiryYear;

	@FindBy(xpath = "//select[@name='bankCode']")
	private WebElement cardBankName;

	@FindBy(xpath = "//select[@name='cardBank']")
	private WebElement cardBank;

	@FindBy(xpath = "//input[@name='authId']")
	private WebElement authID;

	@FindBy(xpath = "//input[@type='number']")
	private WebElement cardAmount;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement addBtn;

	@FindBy(xpath = "//button[@class='btn btn-warning']")
	private WebElement cancelBtn;

	@FindBy(xpath = "//label[normalize-space()='Adjust Form']")
	private WebElement adjustForm;

	@FindBy(xpath = "//i[@class='fa fa-plus']")
	private WebElement addAdjustForm;

	@FindBy(xpath = "//input[@value='1']")
	private WebElement paymentVoucherAdjustType;

	//not a dynamic path, need to change xpath according to the input values
	@FindBy(xpath = "//option[@label='6']")
	private WebElement paymentVoucherNumber;

	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-empty ng-invalid ng-invalid-required ng-touched']")
	private WebElement paymentVoucherAmount;

	@FindBy(xpath = "//input[@value='0']")
	private WebElement purchaseBillAdjustType;

	@FindBy(xpath = "//select[@name='currencyDetails']")
	private WebElement purchaseBillNumber;

	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-empty ng-invalid ng-invalid-required ng-touched']")
	private WebElement purchaseBillAmount;

	@FindBy(xpath = "//input[@value='2']")
	private WebElement salesReturnAdjustType;

	@FindBy(xpath = "//select[@name='salesReturnNo']")
	private WebElement salesReturnNumber;

	@FindBy(xpath = "//input[@class='form-control ng-touched ng-dirty ng-not-empty ng-valid-parse ng-valid ng-valid-required']")
	private WebElement salesReturnAmount;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement clickOnAddBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/div[1]/div[2]/ul[1]/li[1]/label[1]")
	private WebElement forexCash;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/div[1]/div[2]/ul[1]/li[2]/label[1]")
	private WebElement forexCheque;

	@FindBy(xpath = "//label[normalize-space()='Gift Voucher Redeem']")
	private WebElement giftVoucherRedeem;

	@FindBy(xpath = "//input[@name='gvNo']")
	private WebElement giftVoucherNumber;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement addGiftVoucher;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[2]/uib-accordion[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[3]")
	private WebElement totalGiftVoucherAmount;

	@FindBy(xpath = "//label[normalize-space()='Mobile Payments']")
	private WebElement mobilePayments;

	@FindBy(xpath = "//input[@name='cashAmount']")
	private WebElement payModeCash;

	@FindBy(xpath = "//button[@class='btn btn-primary ng-scope']")
	private WebElement submitBtn;



	public String receiptPageTitle() {


		String actTitle = getDriver().getTitle();
		//System.out.println(actTitle);
		return actTitle;
	}

	//for customer order
	public String getDocType() {

		super.fluentWait(getDriver(), docType, 10);
		String doctype = docType.getAttribute("value");
		//System.out.println(doctype);

		super.explicitWait(getDriver(), docNumber, Duration.ofSeconds(10));
		return doctype;

	}

	//for customer order
	public String getDocNumber() {

		super.fluentWait(getDriver(), docNumber, 10);
		String docnumber = docNumber.getText();
		//System.out.println(docnumber);
		super.explicitWait(getDriver(), advAmount, Duration.ofSeconds(15));
		return docnumber;
	}

	public String passAdvanceAmount(String advAmount) {

		//convert from double to string
		//String advAmt =String.valueOf(advAmount); 
		//double advAmnt = Double.parseDouble(advAmount);

		super.type(this.advAmount, advAmount);
		return advAmount;

	}

	public String getPaymentModes(String payModesOption) {


		//super.click(getDriver(), paymentModesBtn);

		int count=0;

		List<WebElement> paymentModes = getDriver().findElements(By.xpath("//label[@class='cursor']"));
		for(WebElement ele : paymentModes) {

			String payModes = ele.getText();
			//System.out.println(payModes);
			if(payModes.equalsIgnoreCase(payModesOption)) {


				ele.click();
				count ++;
				break;

			}

		}
		if(count !=0) {

			Log.info(payModesOption + " Option is choosen");
		}else {

			Log.info(payModesOption + "Option is not choosen") ;
		}

		return payModesOption;
	}

	public String passPayModeCash(String payModeCash) {

		//String cashAmt = String.valueOf(payModeCash);
		super.fluentWait(getDriver(), this.payModeCash, 5);
		super.type(this.payModeCash, payModeCash);
		return payModeCash;

	}
	
	public void paymentModeChequeDD(
			String MultipleMode,
			String ChequeDDType,
			String accHolderName,
			String accNumber,
			String chequeNumber,
			String chequeMonth,
			String chequeYear,
			String chequeDay,
			String bankName,
			String branchName,
			String chequeAmount) {

		String[] multipleModes = {"Yes","No"}; 
		if(MultipleMode.equals(multipleModes[0])) {

			super.click(getDriver(), paymentModesBtn);
			super.click(getDriver(), chequeDD);
			super.click(getDriver(), addChequeDDBtn);
		}

		if(MultipleMode.equals(multipleModes[1])) {

			super.click(getDriver(), paymentModesBtn);
			super.click(getDriver(), cash);
			super.click(getDriver(), paymentModesBtn);
			super.click(getDriver(), chequeDD);
			super.click(getDriver(), addChequeDDBtn);
		}

		List<WebElement> chequeDDType =getDriver().findElements(By.xpath("//input[@ng-model='record.chequeFlag']"));

		int count =0;
		for(WebElement ele : chequeDDType) {

			String chequeddtype = ele.getText();
			//System.out.println(chequeddtype);

			if(chequeddtype.equalsIgnoreCase(ChequeDDType)) {

				ele.click();
				count++;
				break;
			}
		}

		super.type(this.accHolderName, accHolderName);

		//long accNumberLength =17;
		//if(accNumber.length() == accNumberLength || accNumber.length() <= accNumberLength ) {

		super.type(this.accNumber, accNumber);
		//}else {

		//	System.out.println("Account number is more than the actual length");
		//	}

		//int chequeNumberLength=6;

		//if(chequeNumber.length() <= chequeNumberLength || chequeNumber.length() == chequeNumberLength) {

		super.type(this.chequeNumber, chequeNumber);
		//}else {

		//	System.out.println("Cheque number is more than the actual length");
		//}

		super.click(getDriver(), chequeDate);
		super.selectByVisibleText(chequeMonth, this.chequeMonth);
		super.selectByVisibleText(chequeYear, this.chequeYear);

		List<WebElement> chequeDayList = getDriver().findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

		int chequeCount=0;

		for(WebElement ele : chequeDayList) {

			String Day = ele.getText();

			if(Day.equals(chequeDay)) {

				ele.click();
				chequeCount++;
				break;
			}
		}if(chequeCount !=0) {

			Log.info("Cheque day " + chequeDay + " has been selected");
		}else {

			Log.info("The cheque day you want to select is not in the list");
		}

		List<WebElement> bankList = getDriver().findElements(By.xpath("//option[@class='ng-binding ng-scope']"));

		int bankCount=0;

		for(WebElement ele : bankList) {

			String bankNames = ele.getText();

			if(bankNames.equals(bankName)) {

				ele.click();
				bankCount++;
				break;
			}
		}if (bankCount !=0) {

			Log.info("Bank name " + bankName + " has been selected from the list");
		}else {

			Log.info("The bank name you want to select is not available in the list");
		}
		//int bankNameValue =Integer.parseInt(bankName);
		//super.fluentWait(getDriver(), this.bankName, 10);
		//super.selectByValue(this.bankName, bankName);
		super.type(this.branchName,branchName);
		super.type(this.chequeAmount, chequeAmount);
		super.click(getDriver(), chequeAddBtn);


	}

	public void paymentModeCard(String type,
			String cardNumber,
			String cardType,
			String nameOnCard,
			String cardExpiryMonth,
			String cardExpiryYear,
			String cardBankName,
			String cardBank,
			String authID,
			String cardAMount) {

		super.click(getDriver(), paymentModesBtn);
		super.click(getDriver(), cash);
		super.click(getDriver(), paymentModesBtn);
		super.click(getDriver(), card);
		super.click(getDriver(), addCardBtn);
		List<WebElement> typeList = getDriver().findElements(By.xpath("/html[1]/body[1]/div[7]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/label[input]"));

		for(WebElement ele:typeList) {

			String debitCreditList = ele.getText();

			//System.out.println(debitCreditList);

			if(debitCreditList.equalsIgnoreCase(type)) {

				ele.click();
				break;
			}
		}

		super.type(this.cardNumber, cardNumber);
		super.selectByVisibleText(cardType,this.cardType);
		super.type(this.nameOnCard, nameOnCard);

		//String cardExpiryMonthValue = String.valueOf(cardExpiryMonth);
		super.selectByValue(this.cardExpiryMonth, cardExpiryMonth);
		super.selectByValue(this.cardExpiryYear, cardExpiryYear);
		super.selectByVisibleText(cardBankName, this.cardBankName);
		super.selectByVisibleText(cardBank, this.cardBank);
		super.type(this.authID, authID);
		super.type(this.cardAmount, cardAMount);
		super.click(getDriver(), addBtn);

	}

	public void paymentModeAdjustForm(String adjustType,
			String adjustmentNumber,
			String adjustmentAmount) {

		super.click(getDriver(), paymentModesBtn);
		super.click(getDriver(), cash);
		super.click(getDriver(), paymentModesBtn);
		super.click(getDriver(), adjustForm);
		super.click(getDriver(), this.addAdjustForm);

		/*List<WebElement> adjustTypeList =getDriver().findElements(By.xpath("/html[1]/body[1]/div[7]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/label[input]"));

		for(WebElement ele : adjustTypeList) {

			String adjustTypes = ele.getText();
			System.out.println(adjustTypes);
		}*/
		String[] adustTypes = {"Sales Return","Purchase Bill","Payment Voucher"};

		if(adjustType.equalsIgnoreCase(adustTypes[0])) {

			int salesReturnNo=0;
			super.click(getDriver(), salesReturnAdjustType);
			super.fluentWait(getDriver(), salesReturnNumber, 15);
			super.selectByValue(salesReturnNumber, adjustmentNumber);

			List<WebElement> salesRetunNoList = getDriver().findElements(By.xpath("//select[@name='salesReturnNo']"));

			for(WebElement ele : salesRetunNoList) {

				String salesRetNumber = ele.getText();
				if(adjustmentNumber.equals(salesRetNumber)) {

					ele.click();
					salesReturnNo++;
					break;
				}
			}if(salesReturnNo !=0) {

				Log.info("The sales return number you passed is valid");
			}else {

				Log.info("Invalid sales return number");
			}

			super.type(salesReturnAmount, adjustmentAmount);
			super.click(getDriver(), clickOnAddBtn);

		}

		if(adjustType.equalsIgnoreCase(adustTypes[1])) {

			super.click(getDriver(), purchaseBillAdjustType);
			super.selectByValue(purchaseBillNumber, adjustmentNumber);
			super.type(purchaseBillAmount, adjustmentAmount);
			super.click(getDriver(), clickOnAddBtn);


		}

		if(adjustType.equalsIgnoreCase(adustTypes[2])) {

			super.click(getDriver(), paymentVoucherAdjustType);
			super.selectByValue(paymentVoucherNumber, adjustmentNumber);
			super.type(paymentVoucherAmount, adjustmentAmount);
			super.click(getDriver(), clickOnAddBtn);

		}

	}

	public void paymentModeForexCash() {

		super.click(getDriver(), paymentModesBtn);
		super.click(getDriver(), cash);
		super.click(getDriver(), paymentModesBtn);
		super.click(getDriver(), forexCash);
	}
	public void paymentModeForexCheque() {

		super.click(getDriver(), paymentModesBtn);
		super.click(getDriver(), cash);
		super.click(getDriver(), paymentModesBtn);
		super.click(getDriver(), forexCheque);
	}
	public void paymentModeGiftVoucherRedeem(String noOfGiftVouchers,
			String firstGiftVoucherNumber,
			String secondGiftVoucherNumber) {

		super.click(getDriver(), paymentModesBtn);
		super.click(getDriver(), cash);
		super.click(getDriver(), paymentModesBtn);
		super.click(getDriver(), giftVoucherRedeem);

		String numberOfgiftVouchers = noOfGiftVouchers;

		int noOfGiftVoucher = Integer.parseInt(numberOfgiftVouchers);
		System.out.println(noOfGiftVoucher);

		//super.type(this.giftVoucherNumber,giftVoucherNumber);
		//super.click(getDriver(), addGiftVoucher);

		if(noOfGiftVoucher == 1) {

			super.type(giftVoucherNumber, firstGiftVoucherNumber);
			super.click(getDriver(), addGiftVoucher);



		}

		if(noOfGiftVoucher == 2) {

			super.type(giftVoucherNumber, firstGiftVoucherNumber);
			super.click(getDriver(), addGiftVoucher);
			super.type(giftVoucherNumber, secondGiftVoucherNumber);
			super.click(getDriver(), addGiftVoucher);

		}

		/*String giftvoucherTotal = totalGiftVoucherAmount.getText();
		System.out.println(giftvoucherTotal);
		String giftVoucherTotal = giftvoucherTotal.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(giftVoucherTotal);
		double totalGiftVoucherAmount = Double.parseDouble(giftVoucherTotal);
		System.out.println(totalGiftVoucherAmount);*/
	}
	public void paymentModeMobile() {

		super.click(getDriver(), paymentModesBtn);
		super.click(getDriver(), cash);
		super.click(getDriver(), paymentModesBtn);
		super.click(getDriver(), mobilePayments);
	}
	public ReceiptVoucherViewPage clickOnSubmitBtn(ReceiptVoucherViewPage receiptVoucherViewPage) {

		super.click(getDriver(), submitBtn);
		return new ReceiptVoucherViewPage();
	}
}
