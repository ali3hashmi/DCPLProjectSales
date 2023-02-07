package com.dcpl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;

public class CashierReceiptPage extends Action{
	
	public CashierReceiptPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "(//b[contains(text(),'More Info')])[4]")
    private WebElement receiptsMoreInfo;
	
	@FindBy(xpath = "//p[@class='ng-binding']")
	private WebElement toastMessage;
	
	@FindBy(xpath = "//th[normalize-space()='Doc. No.']")
	private WebElement docNoFilter;
	
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[1]/div[3]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[9]/input[1]")
	private WebElement selectReceiptCheckBox;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement confirmBtn;
	
	
	public void clickOnReceiptMoreInfo() {
		
		super.click(getDriver(), receiptsMoreInfo);
		
	}

	public void confirmReceipt() {
		
		//super.fluentWait(getDriver(), docNoFilter, 10);
		super.click(getDriver(), docNoFilter);
		super.click(getDriver(), selectReceiptCheckBox);
		super.click(getDriver(), confirmBtn);
	}
	
	public String getToastMessageText() {
		
		String actReceiptSuccessMessage = toastMessage.getText();
		//System.out.println(actReceiptSuccessMessage);
		return actReceiptSuccessMessage;
	}
}
