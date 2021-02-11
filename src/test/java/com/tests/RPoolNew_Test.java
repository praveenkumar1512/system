package com.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.excel.utility.XLS_Reader;
import com.execution.ExecutionTest;
import com.log4j.Log4jtest;
import com.pages.Bus_Hire_Pages;
import com.pages.ManageBookingPage;
import com.pages.RPool_Page;

public class RPoolNew_Test extends BaseTest {

	static RPool_Page pool;
	private String sheetName = prop.getProperty("rPool");
	XLS_Reader reader = new XLS_Reader("./Resources/RedBusTestData.xlsx");

	@Test(priority = 1)
	public void RPool_New() throws InterruptedException {

		pool = new RPool_Page(driver);
		Log4jtest.logger_function("Execution of RPool_New test start..");

		String testcase = "RPool_New";
		Log4jtest.logger_function("Find_Ride test- Read test data from excel sheet");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Work operation on rpool");
		pool.rpool();

		String title = driver.getTitle();
		Log4jtest.logger_function("RPool New page title :" + title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Execution of RPool_New test Completed.!");

	}

	@Test(priority = 2)
	public void Find_Ride() throws InterruptedException {

		pool = new RPool_Page(driver);
		Log4jtest.logger_function("Execution of Find_Ride test start..");

		String testcase = "Find_Ride";
		Log4jtest.logger_function("Find_Ride test- Read test data from excel sheet");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Work operation on rpool for Find Ride");
		pool.Find_CarRide();

		String title = driver.getTitle();
		Log4jtest.logger_function("Offer Ride page title :" + title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Execution of Find_Ride test completed.!");

	}

	@Test(priority = 3)
	public void Offer_Ride() throws InterruptedException {

		pool = new RPool_Page(driver);
		Log4jtest.logger_function("Execution of Offer_Ride test start..");

		String testcase = "Offer_Ride";
		Log4jtest.logger_function("Offer_Ride test- Read test data from excel sheet");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Work operation on rpool for Offer Ride");
		pool.Offer_CarRide();

		String title = driver.getTitle();
		Log4jtest.logger_function("Offer Ride page title :" + title);
		Assert.assertEquals(title, "rPool - India’s new Carpool & Bikepool mobile app");
		Log4jtest.logger_function("Execution of Offer_Ride test Completed.!");

	}

}
