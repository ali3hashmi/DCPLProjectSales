/**
 * 
 */
package com.dcpl.pageobjects;

import java.time.Duration;
import java.util.ArrayList;
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
public class OrderDetailPage extends Action {

	public OrderDetailPage() {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//h2[normalize-space()='Order Details']")
	private WebElement orderDetailText;

	@FindBy(xpath = "//select[@name='orderKind-1']")
	private WebElement orderKind;

	@FindBy(xpath = "//select[@name='segmentType-1']")
	private WebElement segmentType;

	@FindBy(xpath = "//select[@name='jewelType-1']")
	private WebElement jewelType;

	@FindBy(xpath = "//input[@name='pieces-1']")
	private WebElement pieces;

	@FindBy(xpath = "//input[@name='vendor-1']")
	private WebElement vendorCode;

	@FindBy(xpath = "//button[@ng-click='orderCtrl.findVendor(lineItem)']")
	private WebElement vendorCodeFindBtn;

	@FindBy(xpath = "//input[@placeholder='Vendor Code']")
	private WebElement passVendorCode;

	@FindBy(xpath = "//button[normalize-space()='Go!']")
	private WebElement vendorCodeGoBtn;

	@FindBy(name = "vendorCode")
	///html[1]/body[1]/div[7]/div[1]/div[1]/form[1]/div[2]/table[1]/tbody[tr]/tr[td]
	private WebElement vendorCodeOption;

	@FindBy(xpath = "//button[normalize-space()='Select']")
	private WebElement vendorCodeSelectBtn;

	@FindBy(xpath = "//button[@class='btn btn-warning']")
	private WebElement vendorCodeCancelBtn;

	@FindBy(xpath = "//input[@name='articleCode-1']")
	private WebElement articleCode;

	@FindBy(xpath = "//button[@ng-click='orderCtrl.findArticle(lineItem)']")
	private WebElement findArticleCodeBtn;

	@FindBy(xpath = "//select[@name='mainCategory']")
	private WebElement mainCategory;

	@FindBy(xpath = "//select[@name='subCategory']")
	private WebElement subCategory;

	@FindBy(xpath = "//input[@name='articleCode']")
	private WebElement articleCodeOption;

	@FindBy(xpath = "//button[normalize-space()='OK']")
	private WebElement articleCodeOkBtn;

	@FindBy(name = "orderItemDueDate-1")
	private WebElement clickOnDueDate;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement dueDateMonth;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement dueDateYear;

	@FindBy(xpath = "//select[@name='salesExecutive-1']")
	private WebElement salesExecutiveID;

	@FindBy(xpath = "//select[@name='metalColor-1']")
	private WebElement metalColor;

	@FindBy(xpath = "//select[@name='orderItemSkinPurity-1']")
	private WebElement skinPurity;

	@FindBy(xpath = "//select[@name='metalWeightType-1']")
	private WebElement metalWeightType;

	@FindBy(xpath = "//input[@placeholder='From']")
	private WebElement fromWeightRange;

	@FindBy(xpath = "//input[@placeholder='To']")
	private WebElement toWeightRange;

	@FindBy(xpath = "//input[@name='expectedFromWeight-1']")
	private WebElement expectedWeightRange;

	@FindBy(xpath = "//a[normalize-space()='Attribute Details']")
	private WebElement attributeDetails;

	@FindBy(xpath = "(//span[contains(text(),'-- Select Option --')])[1]")
	private WebElement clickOnLength;

	@FindBy(xpath = "(//input[@type='text'])[10]")
	private WebElement lengthSearch;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/aside[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/uib-accordion[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[7]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/a[1]/span[1]")
	//"(//span[contains(text(),'-- Select Option --')])[2]")
	private WebElement clickOnHookType;

	@FindBy(xpath = "(//input[@type='text'])[11]")
	private WebElement hookTypeSearch;

	@FindBy(xpath = "//span[normalize-space()='Yellow Polish']")
	private WebElement clickOnPolishType;

	@FindBy(xpath = "(//input[@type='text'])[12]")
	private WebElement polishTypeSearch;
	
	@FindBy(xpath = "//span[normalize-space()='None']")
	private WebElement clickOnSettingType;
	
	@FindBy(xpath = "(//input[@type='text'])[13]")
	private WebElement settingTypeSearch;
	
	@FindBy(xpath = "//button[normalize-space()='Next']")
	private WebElement nextBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Prev']")
	private WebElement prevBtn;



	public String verifyOrderDetailText() {

		String odtext=orderDetailText.getText();
		return odtext;
	}

	public void setCustomerOrderDetails(String orderKind,
			String segmentType,
			String jewelType,
			String pieces
			) {



		super.fluentWait(getDriver(), this.orderKind, 10);
		super.selectByVisibleText(orderKind, this.orderKind);
		super.selectByVisibleText(segmentType, this.segmentType);
		super.selectByVisibleText(jewelType, this.jewelType);
		super.type(this.pieces, pieces);
		//super.type(this.vendorCode, vendorCode);



	}

	public OrderDetailPage chooseVendorCode(String passVendorCode) {

		super.scrollDown(getDriver(), this.vendorCode);
		super.click(getDriver(),this.vendorCodeFindBtn);
		super.type(this.passVendorCode, passVendorCode);
		//super.explicitWait(getDriver(), this.vendorCodeGoBtn, Duration.ofSeconds(10));
		super.click(getDriver(), this.vendorCodeGoBtn);
		super.fluentWait(getDriver(), this.vendorCodeOption, 10);
		super.click(getDriver(), this.vendorCodeOption);
		super.click(getDriver(), this.vendorCodeSelectBtn);
		super.fluentWait(getDriver(), articleCode, 10);
		/*	if(super.isDisplayed(getDriver(), this.vendorCodeOption)){

			super.click(getDriver(), this.vendorCodeOption);
			super.click(getDriver(), this.vendorCodeSelectBtn);
			Log.info("Vendor Code is selected");
		}else {

			super.click(getDriver(), this.vendorCodeCancelBtn);
			super.Alert(getDriver());
			Log.info("Vendor code is not selected");

		}*/

		/*List<WebElement> vendorCodeList =getDriver().findElements(By.name("vendorCode"));
				//findElements(By.xpath("/html[1]/body[1]/div[7]/div[1]/div[1]/form[1]/div[2]/table[1]/tbody[1]/tr[td]"));
		System.out.println("Number of Vendor codes are = " + vendorCodeList.size());

		String expectedVendorCode=vendorCode;
		for(int i=0;i<vendorCodeList.size();i++) {

			//String[] expVendorCode =
			System.out.println("Vendor codes are : " + vendorCodeList.get(i).getAttribute("value"));

		}*/
		return new OrderDetailPage();
	}

	public OrderDetailPage chooseArticleCode(String mainCatIndex,String SubCatindex) {

		//super.scrollDown(getDriver(), this.findArticleCodeBtn);
		//super.scrollByVisibilityOfElement(getDriver(), this.articleCode);
		super.click(getDriver(), this.findArticleCodeBtn);
		//super.selectByVisibleText(mainCategory, this.mainCategory);
		Integer mainCategoryIndex =Integer.parseInt(mainCatIndex);
		super.selectByIndex(this.mainCategory, mainCategoryIndex);
		Integer subCategoryIndex = Integer.parseInt(SubCatindex);
		super.selectByIndex(this.subCategory, subCategoryIndex);
		super.click(getDriver(), this.articleCodeOption);
		super.click(getDriver(), articleCodeOkBtn);

		return new OrderDetailPage();

	}

	public void chooseDueDate(String dueDateMonth,String dueDateYear,String dueDateDay) {

		super.fluentWait(getDriver(), this.clickOnDueDate, 10);
		super.click(getDriver(), this.clickOnDueDate);
		super.selectByVisibleText(dueDateMonth, this.dueDateMonth);
		super.selectByVisibleText(dueDateYear, this.dueDateYear);

		List<WebElement> dueDate = getDriver().findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for(WebElement ele:dueDate) {

			String date=ele.getText();
			if(date.equals(dueDateDay)) {

				ele.click();
				break;
			}
		}
	}

	public void selectSalesExecutive(String index) {

		Integer salesExIndex =Integer.parseInt(index);
		super.selectByIndex(this.salesExecutiveID, salesExIndex);

	}


	public void chooseMetalProperties(String metalColor,
			String skinPurity,
			String metalWeightType,
			String fromWeightRange,
			String toWeightRange,
			String expectedWeightRange) {

		Integer metalColorIndex =Integer.parseInt(metalColor);
		super.selectByIndex(this.metalColor, metalColorIndex);
		Integer skinPurityIndex =Integer.parseInt(skinPurity);
		super.selectByIndex(this.skinPurity, skinPurityIndex);
		super.fluentWait(getDriver(), this.metalWeightType, 10);

		/*List<WebElement> metalWeightTypes =getDriver().findElements(By.name("metalWeightType-1"));

		int weightTypeSize = metalWeightTypes.size();
		System.out.println("Metal Weight Types Size =" + weightTypeSize);

		for(WebElement ele:metalWeightTypes) {

			String types = ele.getText();
			System.out.println("Metal wieght types are " + types);

		}*/

		//ArrayList<String> metalWeightTypes =new ArrayList<>();
		//metalWeightTypes.add("Range");
		//metalWeightTypes.add("Absolute");
		String metalType1 ="Range";
		String metalType2 ="Absolute";



		if(metalWeightType.equalsIgnoreCase(metalType1)){

			super.selectByVisibleText(metalWeightType, this.metalWeightType);
			super.type(this.fromWeightRange, fromWeightRange);
			super.type(this.toWeightRange, toWeightRange);

		}
		if(metalWeightType.equalsIgnoreCase(metalType2)) {

			super.selectByVisibleText(metalWeightType, this.metalWeightType);
			super.type(this.expectedWeightRange, expectedWeightRange);
		}
	}

	public void chooseAttributeDetailsForLength(String lengthSearch) {

		int count=0;
		super.scrollByVisibilityOfElement(getDriver(), this.attributeDetails);
		super.click(getDriver(), clickOnLength);
		super.type(this.lengthSearch, lengthSearch);


		List<WebElement> lengthLList = getDriver().findElements(By.xpath("//a[@class='ng-binding']"));

		//System.out.println("Size = " + lengthLList.size());
		for(WebElement ele:lengthLList) {

			String length=ele.getText();
			//System.out.println(length);
			if(length.equalsIgnoreCase(lengthSearch)) {

				super.explicitWait(getDriver(), clickOnLength, Duration.ofSeconds(10));
				ele.click();
				count++;
				break;
			}
		}
		if(count !=0) {

			Log.info(lengthSearch + " length has been selected from the dropdown");
		}else {

			Log.info("Option you want to select is not available in the dropdown");
		}

	//	super.fluentWait(getDriver(), this.clickOnHookType, 10);
	}

	public void chooseAttributeDetailsForHookType(String hookTypeSearch) {

		int count=0;
		super.scrollByVisibilityOfElement(getDriver(), this.attributeDetails);
		//super.fluentWait(getDriver(), this.clickOnHookType, 10);
		super.click(getDriver(), clickOnHookType);
		super.type(this.hookTypeSearch, hookTypeSearch);

		List<WebElement> hookTypeList =getDriver().findElements(By.xpath("//a[@class='ng-binding']"));

		for(WebElement ele: hookTypeList) {

			String hookType = ele.getText();
			if(hookType.equalsIgnoreCase(hookTypeSearch)) {

				super.explicitWait(getDriver(), clickOnHookType, Duration.ofSeconds(10));
				ele.click();
				count++;
				break;
			}
		}
		if(count !=0) {

			Log.info(hookTypeSearch + " hook type has been selected");
		}else {

			Log.info("The hook type option is not available in the dropdown");
		}
		
		

	}

	public void chooseAttributeDetailsForPolishType(String polishTypeSearch) {

		int count=0;
		//super.fluentWait(getDriver(), this.clickOnPolishType, 10);
		super.click(getDriver(), clickOnPolishType);
		super.type(this.polishTypeSearch, polishTypeSearch);

		List<WebElement> polishTypeList =getDriver().findElements(By.xpath("//a[@class='ng-binding']"));

		for(WebElement ele: polishTypeList) {

			String polishType = ele.getText();
			if(polishType.equalsIgnoreCase(polishTypeSearch)) {

				super.explicitWait(getDriver(), clickOnPolishType, Duration.ofSeconds(10));
				ele.click();
				count++;
				break;
			}
		}
		if(count !=0) {

			Log.info(polishTypeSearch + " hook type has been selected");
		}else {

			Log.info("The polish type option is not available in the dropdown");
		}

	}
	public void chooseAttributeDetailsForSettingType(String settingTypeSearch) {
		
		int count=0;
		//super.fluentWait(getDriver(), this.clickOnSettingType, 10);
		super.click(getDriver(), clickOnSettingType);
		super.type(this.settingTypeSearch, settingTypeSearch);
		
		List<WebElement> settingTypeList =getDriver().findElements(By.xpath("//a[@class='ng-binding']"));

		for(WebElement ele: settingTypeList) {

			String settingType = ele.getText();
			if(settingType.equalsIgnoreCase(settingTypeSearch)) {

				super.explicitWait(getDriver(), clickOnSettingType, Duration.ofSeconds(10));
				ele.click();
				count++;
				break;
			}
		}
		if(count !=0) {

			Log.info(settingTypeSearch + " setting type has been selected");
		}else {

			Log.info("The setting type option is not available in the dropdown");
		}
	}

	public CreditAndAdvancePage clickOnNextBtn(CreditAndAdvancePage creditAndAdvancePage) {
		
		super.click(getDriver(), nextBtn);
		return new CreditAndAdvancePage();
	}
	
	public OrderHeaderPage clickOnPrevBtn(OrderHeaderPage orderHeaderPage) {
		
		super.click(getDriver(), prevBtn);
		return new OrderHeaderPage();
	}
}
