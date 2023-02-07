/**
 * 
 */
package com.dcpl.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;

/**
 * @author USER
 *
 */
public class OrderHeaderPage extends Action{




	public OrderHeaderPage() {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//h2[normalize-space()='Order Header']")
	private WebElement orderHeaderPageText;

	@FindBy(name = "occasion")
	private WebElement occasion;

	@FindBy(xpath = "//input[@id='occasionDate']")
	private WebElement occasionDate;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement occasionMonth;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement occasionYear;

	
	
	@FindBy(xpath = "//textarea[@name='occasionRemarks']")
	private WebElement occasionRemarks;

	@FindBy(xpath = "//select[@name='intimationReqd']")
	private WebElement intimation;

	@FindBy(xpath = "//select[@name='intimationMode']")
	private WebElement intimationMode;

	@FindBy(xpath = "//select[@name='printNameInBill']")
	private WebElement printNameInBill;

	@FindBy(xpath = "//select[@name='deliveryAddress']")
	private WebElement deliveryAddress;

	@FindBy(xpath = "//button[normalize-space()='Next']")
	private WebElement nextBtn;

	public String verifyOrderHeaderPageText() {

		String ohpText=orderHeaderPageText.getText();
		return ohpText;
	}

	public void setOrderHeaderDetails(String occasion,
			String occasionMonth,
			String occasionYear,
			String occasionDate,
			String occasionRemarks,
			String intimation,
			String intimationMode,
			String printNameInBill,
			String deliveryAddress) {

		super.selectByValue(this.occasion, occasion);
		super.fluentWait(getDriver(), this.occasionDate, 5);
		super.click(getDriver(), this.occasionDate);
		super.selectByVisibleText(occasionMonth,this.occasionMonth);
		super.selectByVisibleText(occasionYear,this.occasionYear);
		//super.selectByVisibleText(occasionDate, this.occasionDate);
		List<WebElement> occasionday = getDriver().findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for(WebElement ele:occasionday) {
			
			String date = ele.getText();
			if(date.equals(occasionDate)) {
				
				ele.click();
				break;
			}
			
		}
		super.type(this.occasionRemarks, occasionRemarks);
		super.selectByVisibleText(intimation, this.intimation);
		super.selectByVisibleText(intimationMode, this.intimationMode);
		super.selectByVisibleText(printNameInBill, this.printNameInBill);
		super.selectByVisibleText(deliveryAddress, this.deliveryAddress);

		
	}
	
	public OrderDetailPage clickOnNext(OrderDetailPage orderDetailPage) {
		
		super.scrollByVisibilityOfElement(getDriver(), nextBtn);
		super.click(getDriver(), nextBtn);
		return new OrderDetailPage();
	}

}



