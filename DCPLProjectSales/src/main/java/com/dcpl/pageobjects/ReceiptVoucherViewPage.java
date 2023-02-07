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
public class ReceiptVoucherViewPage extends Action {

	public ReceiptVoucherViewPage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//button[normalize-space()='Print']")
	private WebElement printBtn;
	
	@FindBy(xpath = "//a[normalize-space()='View Order']")
	private WebElement viewOrderBtn;
	
	public String getReceiptVoucherViewTitle() {
		
		String actTitle = getDriver().getTitle();
		System.out.println(actTitle);
		return actTitle;
	}
	
	public ViewOrderPage clickOnViewOrderBtn(ViewOrderPage viewOrderPage) {
		
		super.scrollByVisibilityOfElement(getDriver(), viewOrderBtn);
		super.click(getDriver(), viewOrderBtn);
		return new ViewOrderPage();
		
	}
	public void clickOnPrintBtn() {
		
		super.scrollByVisibilityOfElement(getDriver(), printBtn);
		super.click(getDriver(), printBtn);
		
	}
}
