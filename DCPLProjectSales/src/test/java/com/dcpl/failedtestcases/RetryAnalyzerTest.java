package com.dcpl.failedtestcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerTest implements IRetryAnalyzer{

	private int count=0;
	private int maxCount=2;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(count<maxCount) {
			
			System.out.println("Retrying " + result.getName() + " again and count is " + (count + 1));
			
			count++;
			return true; 
		}
		return false;
	}

	
}
