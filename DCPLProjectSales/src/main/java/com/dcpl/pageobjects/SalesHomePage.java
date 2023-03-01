/**
 * 
 */
package com.dcpl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;

/**
 * @author USER
 *
 */
public class SalesHomePage extends Action{

	
	public SalesHomePage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//h1[1]")
	private WebElement salesHomeText;
	
	@FindBy(xpath = "//i[@class='fa fa-angle-down']")
	private WebElement salesLogoutNavigation;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement salesLogout;
	
	@FindBy(xpath = "//a[normalize-space()='Home / Create Document']")
	private WebElement HomeCreateDocumentMenu;
	
	@FindBy(xpath = "//li[@class='dropdown open']//ul[@class='dropdown-menu']//li//a[contains(text(),'Search')]")
	private WebElement searchCustomerSubMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Orders']")
	private WebElement ordersMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Order Confirmation']")
	private WebElement orderConfirmationSubMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Function']")
	private WebElement functionMainMenu;
	
	@FindBy(xpath="//li[@class='dropdown open']//a[@role='button'][normalize-space()='Cashier']")
	private WebElement cashierSubMenu;
	
	@FindBy(xpath = "//li[@class='dropdown dropdown-submenu open']//li[1]//a[1]")
	private WebElement cashierReceipts;
	
	@FindBy(xpath = "//li[@class='dropdown dropdown-submenu open']//li[3]//a[1]")
	private WebElement orderConfirmation;
	
	
	public String getSalesHomeText() {
		
		String salesPageHomeText = salesHomeText.getText();
		return salesPageHomeText;
	}
	
	public LoginPage salesLogout(LoginPage loginPgae) throws InterruptedException {
		
		super.click(getDriver(), salesLogoutNavigation);
		super.fluentWait(getDriver(), salesLogout, 5);
		super.click(getDriver(), salesLogout);
		Thread.sleep(3000);
		super.Alert(getDriver());
		return new LoginPage();
	}
	
	public boolean homeCreateDocumentMenuVerifcation() {
		
		return super.isDisplayed(getDriver(), HomeCreateDocumentMenu);
		//return result;
	}
	public SearchCustomerPage createNewCustomer(SearchCustomerPage searchCustomerPage) {
		
		super.click(getDriver(), HomeCreateDocumentMenu);
		//super.fluentWait(getDriver(), searchCustomer, 3);
		super.click(getDriver(), searchCustomerSubMenu);
		return new SearchCustomerPage();
		
	
	}
	
	public boolean ordersMenuVerification() {
		
		
		
		return super.isDisplayed(getDriver(), ordersMenu);
		
	}
	
	public OrderConfirmationPage confirmCustomerOrder(OrderConfirmationPage orderConfirmationPage) {
		
		super.click(getDriver(), ordersMenu);
		super.click(getDriver(), orderConfirmationSubMenu);
		return new OrderConfirmationPage();
	}
	
	public CashierReceiptPage confirmCustomerReceipts(CashierReceiptPage cashierReceiptPage) {
		
		super.click(getDriver(), functionMainMenu);
		super.click(getDriver(), cashierSubMenu);
		super.click(getDriver(), cashierReceipts);
		return new CashierReceiptPage();
		
	}
	
	public StoreHeadConfirmationPage storeHeadConfirmation(StoreHeadConfirmationPage storeHeadConfirmationPage) {
		
		super.click(getDriver(), functionMainMenu);
		super.click(getDriver(), cashierSubMenu);
		super.click(getDriver(), orderConfirmation);	
		return new StoreHeadConfirmationPage();
	}
	
	
}
