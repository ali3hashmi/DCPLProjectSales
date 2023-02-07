/**
 * 
 */
package com.dcpl.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.dcpl.actiondriver.Action;
import com.dcpl.base.BaseClass;

/**
 * @author USER
 *
 */
public class ViewOrderPage extends Action{

	public ViewOrderPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(getDriver(), driver);
	}
	
	
	public String getViewOrderPageTitle() {
		
		String actTitle = getDriver().getTitle();
		//System.out.println(actTitle);
		return actTitle;
		
	}
	
}
