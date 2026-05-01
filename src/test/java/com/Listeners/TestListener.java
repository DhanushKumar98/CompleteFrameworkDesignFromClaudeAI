package com.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.config.DriverManager;
import com.utility.ScreenshotUtils;

public class TestListener implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		System.out.printf("[START] %s%n", result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.printf("[PASS] %s%n,", result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		System.out.printf("[FAIL] %s%n", name);

		// Capture screenshot and attach to allure

		ScreenshotUtils.capture(DriverManager.getDriver(), name);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.printf("[SKIP] %s reason: %s%n", result.getMethod().getMethodName(),
				result.getThrowable() != null ? result.getThrowable().getMessage() : "n/a");
	}
}
