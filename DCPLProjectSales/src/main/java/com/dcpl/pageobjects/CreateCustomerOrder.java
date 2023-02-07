package com.dcpl.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;

public class CreateCustomerOrder extends Action{

	public CreateCustomerOrder() {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(getDriver(), this);
	}
}
