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

public class OrderConfirmationPage extends Action {

	public OrderConfirmationPage() {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(getDriver(), this);
	}


	@FindBy(xpath = "//input[@name='fromDate']")
	private WebElement fromDate;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement fromMonth;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement fromYear;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement toMonth;

	@FindBy(xpath = "//input[@id='toDate']")
	private WebElement toDate;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement toYear;

	@FindBy(xpath = "//input[@ng-model='fieldFilters.orderNo']")
	private WebElement orderNo;

	@FindBy(xpath = "//option[@ng-repeat='item in payload.salesExecutive']")
	private WebElement selectSalesExecutive;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/aside[1]/div[1]/form[1]/div[2]/button[1]")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[@type='reset']")
	private WebElement clearBtn;
	
	@FindBy(xpath = "//td//input[@type='checkbox']")
	private WebElement checkOrderNo;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement orderConfirmSaveBtn;


	public void chooseFromToDate(String fromMonth,
			String fromYear,
			String fromDay,
			String toMonth,
			String toYear,
			String toDay,
			String orderNo) {
		super.fluentWait(getDriver(), this.fromDate, 10);
		super.click(getDriver(), this.fromDate);
		super.selectByVisibleText(fromMonth, this.fromMonth);
		super.selectByVisibleText(fromYear,this.fromYear);

		List<WebElement>  fromDayList =getDriver().findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

		int fromDayCount=0;
		for(WebElement ele:fromDayList) {

			String fromDays = ele.getText();

			if(fromDays.equals(fromDay)) {

				ele.click();
				fromDayCount++;
				break;


			}
		}
		if(fromDayCount !=0) {

			Log.info(fromDay + "has been selected");
		}else {

			Log.info("The day you want select is not available in the list");
		}


		super.fluentWait(getDriver(), toDate, 10);
		super.click(getDriver(), toDate);
		super.selectByVisibleText(toMonth, this.toMonth);
		super.selectByVisibleText(toYear, this.toYear);

		List<WebElement>  toDayList =getDriver().findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

		int toDayCount=0;
		for(WebElement ele:toDayList) {

			String toDays = ele.getText();

			if(toDays.equals(toDay)) {

				ele.click();
				toDayCount++;
				break;


			}
		}
		if(toDayCount !=0) {

			Log.info(toDay + "has been selected");
		}else {

			Log.info("The day you want select is not available in the list");
		}
		
		


/*		List<WebElement> orderList = getDriver().findElements(By.xpath("//td[@class='text-center ng-binding']"));

		for(WebElement orderEle : orderList) {

			String gridOrderList = orderEle.getText();
			
			System.out.println(gridOrderList);
			
			if(gridOrderList.contains(orderNo)) {
				
				checkOrderNo.click();
				break;
			}
			*/
		
			super.fluentWait(getDriver(), searchBtn, 10);
	}
	
	public void clickOnSearchBtn() {
		
		super.click(getDriver(), searchBtn);
	}
	
	public void confirmTheOrder() {
		
		super.click(getDriver(), checkOrderNo);
		super.click(getDriver(), orderConfirmSaveBtn);	
	}
	public String getOrderConfirmationTitle() {
		
		String actTitle = getDriver().getTitle();
		return actTitle;
	}
}
