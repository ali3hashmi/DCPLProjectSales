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
import com.dcpl.utility.Log;

/**
 * @author USER
 *
 */
public class CreditAndAdvancePage extends Action {
	
	

	/**
	 * 
	 */
	public CreditAndAdvancePage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
		
	}

	
	@FindBy(xpath = "//h2[normalize-space()='Credit & Advance']")
	private WebElement creditAndAdvanceText;
	
	@FindBy(xpath = "//button[normalize-space()='Next']")
	private WebElement nextBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Prev']")
	private WebElement prevBtn;
	
	public String verifyCreditAndAdvanceText() {
		
		String actText = creditAndAdvanceText.getText();
		return actText;
	}
	
	public void payAdvance(String payAdvOption) {
		
		int count=0;
		List<WebElement> payAdvanceOption = getDriver().findElements
				(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/aside[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/label[input]"));
		
		for(WebElement ele : payAdvanceOption) {
			
			String advOption = ele.getText();
			//System.out.println(advOption);
			if(advOption.equalsIgnoreCase(payAdvOption)) {
				
				ele.click();
				count++;
				break;
				
			}
		}
		if(count !=0) {
			
			Log.info(payAdvOption + " Option is choosen");
		}else {
			
			Log.info(payAdvOption + " Option is not choosen");
		}
	}
	
	public ConfirmOrderPage clickOnNextBtn(ConfirmOrderPage confirmOrderPage) {
		
		super.scrollByVisibilityOfElement(getDriver(), nextBtn);
		super.click(getDriver(), nextBtn);
		return new ConfirmOrderPage();
	}
	
	public OrderDetailPage clickOnPrevBtn(OrderDetailPage orderDetailPage) {
		
		super.scrollByVisibilityOfElement(getDriver(), prevBtn);
		super.click(getDriver(), prevBtn);
		//super.fluentWait(getDriver(), creditAndAdvanceText, 0);
		return new OrderDetailPage();
	}
}
