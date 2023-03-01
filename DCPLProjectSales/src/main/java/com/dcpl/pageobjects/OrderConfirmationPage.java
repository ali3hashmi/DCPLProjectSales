package com.dcpl.pageobjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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

	@FindBy(xpath = "//input[@name='selectAll']")
	private WebElement selectCheckBox;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement orderConfirmSaveBtn;
	
	@FindBy(xpath ="//p[@class='ng-binding']")
	private WebElement successMsg;


	public void chooseFromToDate(String fromMonth,
			String fromYear,
			String fromDay,
			String toMonth,
			String toYear,
			String toDay) {
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


		super.fluentWait(getDriver(), searchBtn, 10);
	}

	public void setOrderNo(String orderNo) {

		super.type(this.orderNo, orderNo);
	}

	public void clickOnSearchBtn() {

		super.click(getDriver(), searchBtn);
	}

	public String confirmTheOrder() {


		super.click(getDriver(), selectCheckBox);
		super.click(getDriver(), orderConfirmSaveBtn);
		
		String orderConfirmationSuccMsg=successMsg.getText();

		return orderConfirmationSuccMsg;
	}
	
	public String getOrderConfirmationTitle() {

		String actTitle = getDriver().getTitle();
		return actTitle;
	}

	public List<String> verifyOrderConfirmationSearchGridHeaders() {

		List<String> column_headers =new ArrayList<String>();
		//find no of columns
		int columnSize= getDriver().findElements(By.xpath("//table[@class='table table-striped table-hover table-search table-bgcolor']//thead//tr[2]//th")).size();
		System.out.println("Column Size =" + columnSize);

		//read each headers

		for(int h=2;h<=columnSize;h++) {

			String headers =getDriver().findElement(By.xpath("//table[@class='table table-striped table-hover table-search table-bgcolor']//thead//tr[2]//th["+h+"]")).getText();


			column_headers = Arrays.asList(headers);
			System.out.println(column_headers);




		}
		return column_headers;
	}

	public double verifyNumberOfPages() {

		//find total no of pages
		double total_pages=0;
		int total_page=0;

		String total_entries=getDriver().findElement(By.xpath("//span[@class='black-color ng-binding']")).getText();
		double total_no_rows =Double.parseDouble(total_entries);
		System.out.println(total_no_rows);

		if(total_no_rows > 20) {

			total_pages=(total_no_rows/20);
			//System.out.println(total_pages);
			String text = String.valueOf(total_pages);
			System.out.println(text);
			text=text.substring(text.indexOf(".")+1);

			int p = Integer.parseInt(text);
			//System.out.println(p);

			if(p > 0) {

				total_page = (int) total_pages +1;

				System.out.println("Total no of pages = " + total_page);
			}

		}
		if(total_no_rows < 20) {

			total_page =1;
		}


		return total_page;

	}

	public int verifyTotalNoOfRows()  {

		//Find how many rows exist in each page
		String total_entries=getDriver().findElement(By.xpath("//span[@class='black-color ng-binding']")).getText();
		int total_no_rows =Integer.parseInt(total_entries);

		int rows=0;
		int r=0;
		double total_pages=0;
		int total_page=0;

		if(total_no_rows > 20) {

			for(int p=1;p<=2;p++) {

				WebElement active_page=getDriver().findElement(By.xpath("//ul[@class='pagination ng-scope']//li//a[text()='"+p+"']"));
				System.out.println("Active Page : " + active_page.getText());
				//active_page.click();

				rows = getDriver().findElements(By.xpath("//table[@class='table table-striped table-hover table-search table-bgcolor']//tbody//tr")).size();
				System.out.println("Total no of rows : " + rows);

				r =r+rows;
				System.out.println("total rows = " + r);
				String page_no =Integer.toString(p+1);
				WebElement page= getDriver().findElement(By.xpath("//ul[@class='pagination ng-scope']//li//a[text()='"+page_no+"']"));
				super.moveToElement(getDriver(), active_page);

				super.click(getDriver(), page);

				super.fluentWait(getDriver(), page, 50);



			}
			return r;
		}
		if(total_no_rows < 20) {

			rows = getDriver().findElements(By.xpath("//table[@class='table table-striped table-hover table-search table-bgcolor']//tbody//tr")).size();

			System.out.println("Total no of rows : " + rows);


		}

		return rows;


	}
	public List<String> readAllRows() {

		String total_entries=getDriver().findElement(By.xpath("//span[@class='black-color ng-binding']")).getText();
		int total_no_rows =Integer.parseInt(total_entries);
		//find no of rows
		int rows =0;

		List<String> order_no=new ArrayList<>();

		if(total_no_rows < 20) {

			rows = getDriver().findElements(By.xpath("//table[@class='table table-striped table-hover table-search table-bgcolor']//tbody//tr")).size();
			System.out.println("Total no of rows : " + rows);

			for(int r=1;r<=rows;r++) {

				String order=getDriver().findElement(By.xpath("//table[@class='table table-striped table-hover table-search table-bgcolor']//tbody//tr["+r+"]//td[2]"))
						.getText();
				order_no.add(order);

				String order_date=getDriver()
						.findElement(By.xpath("//table[@class='table table-striped table-hover table-search table-bgcolor']//tbody//tr[\"+r+\"]//td[3]"))
						.getText();

				String customer_name=getDriver().findElement(By.xpath("//table[@class='table table-striped table-hover table-search table-bgcolor']//tbody//tr[\"+r+\"]//td[4]"))
						.getText();

				String gold=getDriver()
						.findElement(By.xpath("//table[@class='table table-striped table-hover table-search table-bgcolor']//tbody//tr[\"+r+\"]//td[5]"))
						.getText();

				String platinum=getDriver().findElement(By.xpath("//table[@class='table table-striped table-hover table-search table-bgcolor']//tbody//tr[\"+r+\"]//td[6]"))
						.getText();

				String silver=getDriver().findElement(By.xpath("//table[@class='table table-striped table-hover table-search table-bgcolor']//tbody//tr[\"+r+\"]//td[7]"))
						.getText();

				String advance_amount=getDriver().findElement(By.xpath("//table[@class='table table-striped table-hover table-search table-bgcolor']//tbody//tr[\"+r+\"]//td[8]"))
						.getText();
				String adv_amount =advance_amount.replaceAll("[^a-zA-Z0-9]", "");

				System.out.println(order + " " + order_date + " " + customer_name  + " " + gold + " " + platinum + " " + silver + " " + adv_amount);
			}
		}

		return order_no;
	}

}
