package com.dcpl.failedtestcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.AfterTest;

public class FailedTestRunner {
	
	@AfterTest
	public void runFailedTestCases() {
		
		TestNG obj = new TestNG();
		
		List<String> list = new ArrayList<String>();
		
		list.add("C:\\Users\\USER\\eclipse-workspace\\DCPLProject\\test-output\\Suite\\testng-failed.xml");
		obj.setTestSuites(list);
		obj.run();
	}

}
