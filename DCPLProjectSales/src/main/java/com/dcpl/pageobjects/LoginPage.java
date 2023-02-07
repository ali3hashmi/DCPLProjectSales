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
public class LoginPage extends Action {


	public LoginPage() {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//input[@id='uname']")
	private WebElement hrmsID;

	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginBtn;

	public  SalesHomePage salesLogin(String hrmsID,String password,SalesHomePage salesHomePage) throws Throwable {

		super.scrollByVisibilityOfElement(getDriver(), this.hrmsID);
		super.findElement(getDriver(), this.hrmsID);
		//Integer.parseInt(hrmsID);
		super.type(this.hrmsID, hrmsID);
		super.findElement(getDriver(), this.password);
		super.type(this.password, password);
		super.click(getDriver(), loginBtn);
		Thread.sleep(5000);
		return new SalesHomePage();

	}

	public  OrderExecutionHomePage OrderExecutionLogin(String hrmsID,String password,OrderExecutionHomePage OEHomePage) throws InterruptedException {

		super.scrollByVisibilityOfElement(getDriver(), this.hrmsID);
		super.findElement(getDriver(), this.hrmsID);
		super.type(this.hrmsID, hrmsID);
		super.findElement(getDriver(), this.password);
		super.type(this.password, password);
		super.click(getDriver(), loginBtn);
		Thread.sleep(5000);
		return new OrderExecutionHomePage();

	}




}
