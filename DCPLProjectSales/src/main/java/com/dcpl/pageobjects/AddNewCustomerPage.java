/**
 * 
 */
package com.dcpl.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;

/**
 * @author USER
 *
 */
public class AddNewCustomerPage extends Action{
	
	public AddNewCustomerPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(xpath = "//h4[normalize-space()='Add New Customer']")
	private WebElement addNewCustText;
	
	@FindBy(xpath = "//select[@name='customerType']")
	private WebElement customerType;
	
	@FindBy(xpath = "//select[@name='customerTitles']")
	private WebElement customerTitles;
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	private WebElement customerFirstName;
	
	@FindBy(xpath = "//input[@placeholder='Middle Name']")
	private WebElement customerMiddleName;
	
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	private WebElement customerLastName;
	
	@FindBy(xpath = "//select[@name='gender']")
	private WebElement customerGender;
	
	@FindBy(xpath = "//input[@placeholder='Address 1']")
	private WebElement customerAddress1;
	
	@FindBy(xpath = "//input[@placeholder='Address 2']")
	private WebElement customerAddress2;
	
	@FindBy(xpath = "//input[@placeholder='Address 2']")
	private WebElement customerAddress3;
	
	@FindBy(xpath = "//input[@placeholder='PAN Number']")
	private WebElement customerPanNumber;
	
	@FindBy(xpath = "//input[@placeholder='Mobile 1']")
	private WebElement customerMobile1;
	
	@FindBy(xpath = "//input[@placeholder='Mobile 2']")
	private WebElement customerMobile2;
	
	@FindBy(xpath = "//input[@placeholder='Land Line No (Home)']")
	private WebElement customerLandLineHome;
	
	@FindBy(xpath = "//input[@placeholder='Land Line (Office)']")
	private WebElement customerLandLineOffice;

	@FindBy(xpath = "//select[@name='country']")
	private WebElement customerCountry;
	
	@FindBy(xpath = "//select[@name='state']")
	private WebElement customerState;
	
	@FindBy(xpath = "//select[@name='city']")
	private WebElement customerCity;
	
	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement customerEmail;
	
	@FindBy(xpath = "//input[@id='zipcode']")
	private WebElement customerPinCode;
	
	@FindBy(xpath = "//input[@placeholder='GSTIN No']")
	private WebElement customerGSTNo;
	
	@FindBy(xpath = "//input[@placeholder='Aadhar Card No']")
	private WebElement customerAdharNo;
	
	@FindBy(xpath = "//button[normalize-space()='Add Customer']")
	private WebElement addCustomerBtn;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/h2[1]")
	private WebElement validateAddNewCustomer;
	
	public void setAddNewCustomerDetails(String customerType,String customerTitles,
			String customerFirstName,
			String customerMiddleName,
			String customerLastName,
			String customerGender,
			String customerAddress1,
			String customerAddress2,
			String customerAddress3,
			String customerPanNumber,
			String customerMobile1,
			String customerMobile2,
			String customerLandLineHome,
			String customerLandLineOffice,
			String customerCountry,
			String customerState,
			String customerCity,
			String customerEmail,
			String customerPinCode,
			String customerGSTNo,
			String customerAdharNo) throws InterruptedException {
		
		super.selectByVisibleText(customerType,this.customerType);
		super.selectByValue(this.customerTitles,customerTitles);
		super.type(this.customerFirstName, customerFirstName);
		super.type(this.customerMiddleName, customerMiddleName);
		super.type(this.customerLastName, customerLastName);
		super.selectByValue(this.customerGender, customerGender);
		super.type(this.customerAddress1, customerAddress1);
		super.type(this.customerAddress2, customerAddress2);
		super.type(this.customerAddress3, customerAddress3);
		super.type(this.customerPanNumber, customerPanNumber);
		super.type(this.customerMobile1, customerMobile1);
		super.type(this.customerMobile2, customerMobile2);
		super.type(this.customerLandLineHome, customerLandLineHome);
		super.type(this.customerLandLineOffice, customerLandLineOffice);
		super.selectByVisibleText(customerCountry, this.customerCountry);
		super.selectByVisibleText(customerState, this.customerState);
		super.selectByVisibleText(customerCity, this.customerCity);
		super.screenShot(getDriver(), customerEmail);
		super.type(this.customerEmail,customerEmail);
		super.type(this.customerPinCode, customerPinCode);	
		super.type(this.customerGSTNo, customerGSTNo);	
		super.type(this.customerAdharNo, customerAdharNo);
		super.fluentWait(getDriver(), addCustomerBtn, 10);
		

	}
	
	public SearchCustomerPage clickOnAddNewCustomer(SearchCustomerPage searchCustomerPage) {
		
		//super.explicitWait(getDriver(), addCustomerBtn,Duration.ofSeconds(10));
		//super.fluentWait(getDriver(), addCustomerBtn, 10);
		super.scrollByVisibilityOfElement(getDriver(), addCustomerBtn);
		super.click(getDriver(), addCustomerBtn);
		return new SearchCustomerPage();
	}
	
	public boolean validateAddNewCustomer() {
		
		return super.isDisplayed(getDriver(), validateAddNewCustomer);
		
	}
	
	
	
	
	
	
	public String getAddNewCustText() {
		
		String addNewCustomerText=addNewCustText.getText();
		return addNewCustomerText;
	}
	
	
	

}
