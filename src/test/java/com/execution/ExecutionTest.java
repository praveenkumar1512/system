package com.execution;

import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.tests.BaseTest;

public class ExecutionTest extends BaseTest {

	//--------------Method To check Execution Required-------------
	
	public static void tocheckExecutionRequired(String executionRequired, String TestName) {
		if (executionRequired.toLowerCase().equals("no")) {
			extentTest = extent.startTest(TestName);
			extentTest.log(LogStatus.WARNING, "Execution required is " + executionRequired);
			throw new SkipException("Skipping this test ");
		}
	}
}
