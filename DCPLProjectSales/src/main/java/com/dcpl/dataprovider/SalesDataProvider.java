/**
 * 
 */
package com.dcpl.dataprovider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.dcpl.utility.NewExcelLibrary;

/**
 * @author USER
 *
 */
public class SalesDataProvider {

	NewExcelLibrary obj =new NewExcelLibrary();

	//Class -> LoginPageTest,AddNewCustomerPageTest,SalesHomePageTest,SalesLogoutPageTest
	//TestCase -> SalesLoginTest,verifyHomeCreateDocumentMenu,verifyOrdersMenu,salesLogoutTest

	@DataProvider(name="salesLoginCredentials")
	public Object[][] getSalesLoginCredentails() {

		//Total row count
		int rows =obj.getRowCount("SalesLogin");

		//Total column count
		int column =obj.getColumnCount("SalesLogin");

		int actRows=rows-1;

		//Created an object of array to store data

		Object[][] data =new Object[actRows][column];

		for(int i=0;i<actRows;i++) { // i representing row data

			for(int j=0;j< column;j++) { // j representing column data

				data[i][j]=obj.getCellData("SalesLogin",j, i+2);
			}
		}
		return data;
	}

	/*//sampe test for hashmap
	@DataProvider(name = "salestesttwo")
	public Object[][] getsales() {

		//total row count
		int rows=obj.getRowCount("SalesLogin2");

		//total column
		int column =obj.getColumnCount("SalesLogin2");

		int actRows=rows-1;

		//Created an object of array to store data
		Object[][] data =new Object[actRows][1];

		for(int i=0;i<actRows;i++) {

			Map<String, String> hashMap=new HashMap<>();
			for(int j=0;j<column;j++) {

				hashMap.put(obj.getCellData("SalesLogin2", j, 1),
						obj.getCellData("SalesLogin2", j, i+2));
			}
			data[i][0]=hashMap;
		}
		return data;
	}*/

	//class -AddNewCustomerPageTest.java
	//Test cases -addNewCustomerDetails
	@DataProvider(name = "addNewCustomerDetailsData")
	public Object[][] getAddNewCustomerDetails() {

		//total row count
		int rows=obj.getRowCount("AddNewCustomerDetails");

		//total column
		int column =obj.getColumnCount("AddNewCustomerDetails");

		int actRows=rows-1;

		//Created an object of array to store data
		Object[][] data =new Object[actRows][1];

		for(int i=0;i<actRows;i++) {

			Map<String, String> hashMap=new HashMap<>();
			for(int j=0;j<column;j++) {

				hashMap.put(obj.getCellData("AddNewCustomerDetails", j, 1),
						obj.getCellData("AddNewCustomerDetails", j, i+2));
			}
			data[i][0]=hashMap;
		}
		return data;
	}

	//class -SearchCustomerPageTest
	//Test cases -searchCustomerTest
	@DataProvider(name = "searchCustomerDetailsData")
	public Object[][] getSearchCustomerDetails() {

		//total row count
		int rows=obj.getRowCount("SearchCustomerDetails");

		//total column
		int column =obj.getColumnCount("SearchCustomerDetails");

		int actRows=rows-1;

		//Created an object of array to store data
		Object[][] data =new Object[actRows][1];

		for(int i=0;i<actRows;i++) {

			Map<String, String> hashMap=new HashMap<>();
			for(int j=0;j<column;j++) {

				hashMap.put(obj.getCellData("SearchCustomerDetails", j, 1),
						obj.getCellData("SearchCustomerDetails", j, i+2));
			}
			data[i][0]=hashMap;
		}
		return data;
	}

	//class -OrderHeaderPageTest.java
	//Test cases -createOrderHeaderPageTest
	@DataProvider(name = "orderHeaderPageData")
	public Object[][] getOrderHeaderDetails() {

		//total row count
		int rows=obj.getRowCount("OrderHeaderPage");

		//total column
		int column =obj.getColumnCount("OrderHeaderPage");

		int actRows=rows-1;

		//Created an object of array to store data
		Object[][] data =new Object[actRows][1];

		for(int i=0;i<actRows;i++) {

			Map<String, String> hashMap=new HashMap<>();
			for(int j=0;j<column;j++) {

				hashMap.put(obj.getCellData("OrderHeaderPage", j, 1),
						obj.getCellData("OrderHeaderPage", j, i+2));
			}
			data[i][0]=hashMap;
		}
		return data;
	}

	//class -OrderDetailPageTest.java
	//Test cases -createCustomerOrderWithOrderKindNO
	@DataProvider(name = "orderDetailPageData")
	public Object[][] getOrderDetails() {

		//total row count
		int rows=obj.getRowCount("OrderDetailPage");

		//total column
		int column =obj.getColumnCount("OrderDetailPage");

		int actRows=rows-1;

		//Created an object of array to store data
		Object[][] data =new Object[actRows][1];

		for(int i=0;i<actRows;i++) {

			Map<String, String> hashMap=new HashMap<>();
			for(int j=0;j<column;j++) {

				hashMap.put(obj.getCellData("OrderDetailPage", j, 1),
						obj.getCellData("OrderDetailPage", j, i+2));
			}
			data[i][0]=hashMap;
		}
		return data;
	}

	//class - OrderConfirmationPageTest.java
	//Test case - verifyOrderConfirmationByCashier
	@DataProvider(name ="OrderConfirmationPageData")
	public Object[][] getOrderConfirmationDetail() {

		//total row count

		int rows = obj.getRowCount("OrderConfirmationPage");

		//total column count

		int column = obj.getColumnCount("OrderConfirmationPage");

		int actRows = rows -1;

		//Created an object of array to store data
		Object[][] data = new Object[actRows][1];

		for(int i =0;i<actRows;i++) {

			Map<String, String> hashMap = new HashMap<>();
			for(int j=0;j<column;j++) {

				hashMap.put(obj.getCellData("OrderConfirmationPage", j, 1),
						obj.getCellData("OrderConfirmationPage", j, i+2));

			}
			data[i][0]=hashMap;
		}

		return data;


	}

	//class - CashierReceiptPageTest.java
	//Test case - verifyReceiptsConfirmationByCashier
	@DataProvider(name ="receiptsConfirmationPageData")
	public Object[][] getReceiptsConfirmationDetail() {

		//total row count

		int rows = obj.getRowCount("CashierReceipts");

		//total column count

		int column = obj.getColumnCount("CashierReceipts");

		int actRows = rows -1;

		//Created an object of array to store data
		Object[][] data = new Object[actRows][1];

		for(int i =0;i<actRows;i++) {

			Map<String, String> hashMap = new HashMap<>();
			for(int j=0;j<column;j++) {

				hashMap.put(obj.getCellData("CashierReceipts", j, 1),
						obj.getCellData("CashierReceipts", j, i+2));

			}
			data[i][0]=hashMap;
		}

		return data;


	}

	//class - StoreHeadConfirmationPageTest.java
	//Test case - verifyingOrderConfirmationByStoreHead
	@DataProvider(name ="storeHeadConfirmationPageData")
	public Object[][] getStoreHeadConfirmationDetail() {

		//total row count

		int rows = obj.getRowCount("StoreHeadConfirmationPage");

		//total column count

		int column = obj.getColumnCount("StoreHeadConfirmationPage");

		int actRows = rows -1;

		//Created an object of array to store data
		Object[][] data = new Object[actRows][1];

		for(int i =0;i<actRows;i++) {

			Map<String, String> hashMap = new HashMap<>();
			for(int j=0;j<column;j++) {

				hashMap.put(obj.getCellData("StoreHeadConfirmationPage", j, 1),
						obj.getCellData("StoreHeadConfirmationPage", j, i+2));

			}
			data[i][0]=hashMap;
		}

		return data;


	}

	//class - CreateCustomerOrderTest.java
	//Test case - verifyCustomerOrderOrderKindNo
	@DataProvider(name ="createCustomerOrderPageData")
	public Object[][] getCreateCustomerOrderDetail() {

		//total row count

		int rows = obj.getRowCount("CreateCustomerOrderNo");

		//total column count

		int column = obj.getColumnCount("CreateCustomerOrderNo");

		int actRows = rows -1;

		//Created an object of array to store data
		Object[][] data = new Object[actRows][1];

		for(int i =0;i<actRows;i++) {

			Map<String, String> hashMap = new HashMap<>();
			for(int j=0;j<column;j++) {

				hashMap.put(obj.getCellData("CreateCustomerOrderNo", j, 1),
						obj.getCellData("CreateCustomerOrderNo", j, i+2));

			}
			data[i][0]=hashMap;
		}

		return data;


	}

}