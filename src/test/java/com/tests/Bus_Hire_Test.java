package com.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.excel.utility.XLS_Reader;
import com.execution.ExecutionTest;
import com.log4j.Log4jtest;
import com.pages.Bus_Hire_Pages;

public class Bus_Hire_Test extends BaseTest {

	static Bus_Hire_Pages hire;
	private String sheetName = prop.getProperty("bushire");
	XLS_Reader reader = new XLS_Reader("./Resources/RedBusTestData.xlsx");

	@Test(priority = 1)
	public void Bus_Offers() {
		Log4jtest.logger_function("Bus_Offers method execution starting...");
		String testcase = "Bus_Offers";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		hire = new Bus_Hire_Pages(driver);
		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("CLick on the Offer Button");
		hire.Offer();
		Log4jtest.logger_function("Get the title for Offer Page");
		String title = driver.getTitle();
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Bus_Offers method execution Completed...");

	}

	@Test(priority = 2)
	public void Cancellation() throws InterruptedException {
		Log4jtest.logger_function("Cancellation test method execution starting...");

		String testcase = "Cancellation";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		hire = new Bus_Hire_Pages(driver);
		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("CLick on the manage Button and then cancellation");
		hire.Manage();
		hire.RedBusCancelation(testData.get("Ticket ID"), testData.get("Phone"));
		String title = driver.getTitle();
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Cancellation test method execution completed...");

	}

}
