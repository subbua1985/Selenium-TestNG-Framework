package com.mylotto.qa.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
int counter=0;
int retryLimit=1;  //re-try is now set to 1 which means any failed scenarios will be tried again

	public boolean retry(ITestResult result) {
		if(counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}
}
