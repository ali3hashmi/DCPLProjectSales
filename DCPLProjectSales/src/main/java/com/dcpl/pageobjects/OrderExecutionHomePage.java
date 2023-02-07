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
public class OrderExecutionHomePage extends Action {
	
	
	public OrderExecutionHomePage() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Home - Order Execution']")
	private WebElement homePageText;
	
	public String getHomePageText() {
		
		String oeHomePageText =homePageText.getText();
		return oeHomePageText;
	}
	

}
