package com.dcpl.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;
import com.dcpl.utility.Log;

public class StoreHeadConfirmationPage extends Action{

	public StoreHeadConfirmationPage() {
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

	@FindBy(xpath = "//button[@class='btn btn-primary voffset']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[@type='reset']")
	private WebElement clearBtn;

	@FindBy(xpath = "//td//input[@type='checkbox']")
	private WebElement checkOrderNo;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement orderConfirmSaveBtn;

	@FindBy(xpath = "//p[@class='ng-binding']")
	private WebElement toastMessage;

	public void chooseFromToDate(String fromMonth,
			String fromYear,
			String fromDay,
			String toMonth,
			String toYear,
			String toDay) {

		//fromdate
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


		//todate
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

		super.fluentWait(getDriver(), searchBtn, 10);
		
	}

	public void clickOnSearchBtn() {

		super.click(getDriver(), searchBtn);
	}

	public void confirmTheOrder() {

		super.click(getDriver(), checkOrderNo);
		super.click(getDriver(), orderConfirmSaveBtn);	
	}

	public String getToastMessageText() {

		String actStoreHeadConfirmationSuccessMessage = toastMessage.getText();
		//System.out.println(actStoreHeadConfirmationSuccessMessage);
		return actStoreHeadConfirmationSuccessMessage;
	}
}
