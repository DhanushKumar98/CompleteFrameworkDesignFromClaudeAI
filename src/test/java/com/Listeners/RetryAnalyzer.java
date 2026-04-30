package com.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	
	private int attempt = 0;
	
	//Keep at 1 - enough to catch transient issues,
	//low enough not to hide real failures
	
	private static final int MAX_RETRY = 1;


	@Override
	public boolean retry(ITestResult result) {
		if(!result.isSuccess() && attempt < MAX_RETRY) {
			attempt++;
			System.out.printf("[RETEY] %s -attempt %d of %d%n",
					result.getMethod().getMethodName(),
					attempt,MAX_RETRY);
			return true;
		}
		return false;	
	}
	
 
	// Wire it globally in testng.xml <listeners>, OR
	// per-test: @Test(retryAnalyzer = RetryAnalyzer.call) 
	
	
	
	
	
	

}
