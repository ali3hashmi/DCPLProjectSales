/**
 * 
 */
package com.dcpl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;

/**
 * @author USER
 *
 */
public class SearchCustomerPage extends Action{

	public SearchCustomerPage() {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//a[normalize-space()='Search Customer']")
	private WebElement searchCustomer;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[2]/div[2]/div[1]/ul[1]/li[2]/a[1]")
	private WebElement addNewCustomer;
	
	@FindBy(xpath = "//input[@placeholder='Customer ID']")
	private WebElement customerID;
	
	@FindBy(xpath = "//input[@placeholder='Customer Name']")
	private WebElement customerName;
	
	@FindBy(xpath = "//input[@placeholder='Contact Number']")
	private WebElement customerContactNumber;
	
	@FindBy(xpath = "//input[@placeholder='Loyalty Card']")
	private WebElement customerLoyaltyCard;
	
	@FindBy(xpath = "//button[@ng-click='showCustomerList()']")
	private WebElement searchCustomerBtn;
	
	@FindBy(xpath = "//button[@id='single-button']")
	private WebElement actionBtn;
	
	@FindBy(partialLinkText = "Create Ord")// = "//a[normalize-space()='Create Order']")
	private WebElement createCustomerOrder;
	
	@FindBy(xpath = "//tr[@class='ng-scope']//td[1]")
	private WebElement searchDetailGrid;

	public void clickOnSearchCustomer() {
		
	}
	
	public void getSearchCustomerPageText() {
		
		
	}
	public AddNewCustomerPage clickOnAddNewCustomer(AddNewCustomerPage addNewCustomerPage) {

		//super.fluentWait(getDriver(), addNewCustomer, 10);
		super.findElement(getDriver(), addNewCustomer);
		//super.JSClick(getDriver(), addNewCustomer);
		super.click(getDriver(), addNewCustomer);
		return new AddNewCustomerPage();
	}
	
	public void searchCustomerDetail(String customerID,String customerName,
			String customerContactNumber,
			String customerLoyaltyCard) {
		
		super.type(this.customerID, customerID);
		super.type(this.customerName, customerName);
		super.type(this.customerContactNumber, customerContactNumber);
		super.type(this.customerLoyaltyCard, customerLoyaltyCard);
		
	}
	
	public void clickOnSeach() {
		
		super.click(getDriver(), searchCustomerBtn);
	}
	
	public void clickOnAction() {
		
		super.click(getDriver(), actionBtn);
		//super.fluentWait(getDriver(), createCustomerOrder, 10);
	}
	
	public OrderHeaderPage clickOnCustomerOrder(OrderHeaderPage orderHeaderPage) {
		
		//super.click(getDriver(), createCustomerOrder);
		//super.scrollByVisibilityOfElement(getDriver(), createCustomerOrder);
		super.click(getDriver(), createCustomerOrder);
		super.pageLoadTimeOut(getDriver(), 10);
		return new OrderHeaderPage();
		
	}
	
	public boolean verifySearchDetailGrid() {
		
		return super.isDisplayed(getDriver(), searchDetailGrid);
	}
}
