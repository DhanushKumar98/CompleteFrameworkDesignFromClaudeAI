package com.Listeners;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.config.DriverManager;
import com.utility.ScreenshotUtils;

public class TestListener implements ITestListener{

	

	@Override
	public void onTestStart(ITestResult result) {
		System.out.printf("[START] %s%n",
				result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.printf("[PASS] %s%n,",result.getMethod().getMethodName());
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		System.out.printf("[FAIL] %s%n",name);
		
		//Capture screenshot and attach to allure
		
		ScreenshotUtils.capture(DriverManager.getDriver(),name);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.printf("[SKIP] %s reason: %s%n",result.getMethod().getMethodName(),
				result.getThrowable() !=null ? result.getThrowable().getMessage() : "n/a");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	
	
	
	
	
	
	
	
	
	

}
