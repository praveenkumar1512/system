package com.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.excel.utility.XLS_Reader;
import com.execution.ExecutionTest;
import com.log4j.Log4jtest;
import com.pages.TripPage;

public class TripTest extends BaseTest {
	static TripPage tp;

	private String sheetName = prop.getProperty("trip");
	XLS_Reader reader = new XLS_Reader("./Resources/RedBusTestData.xlsx");

	@Test(priority = 1)
	public void BusTickets() throws Exception {
		tp = new TripPage(driver);
		Log4jtest.logger_function("Execution of Bus Tickets Search test start..");

		String testcase = "BusTickets";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);
		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		tp.Source(testData.get("Source"));
		tp.Destination(testData.get("Destination"));
		tp.Calander();
		Thread.sleep(500);
		tp.SelectDate(testData.get("MonthYear"), testData.get("Day"));
		Thread.sleep(500);
		tp.SearchBuses();
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Execution of Bus Tickets Search test Completed.!");

	}

	@Test(priority = 2)
	public void Filters() throws Exception {
		String testcase = "Filters";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		tp = new TripPage(driver);
		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		tp.Source(testData.get("Source"));
		tp.Destination(testData.get("Destination"));
		tp.Calander();
		Thread.sleep(500);
		tp.SelectDate(testData.get("MonthYear"), testData.get("Day"));
		Thread.sleep(500);
		tp.SearchBuses();
		tp.Filter();
		Thread.sleep(500);
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, testData.get("Expected Title"));

	}

	@Test(priority = 3)
	public void Modify_TripDetail() throws Exception {
		String testcase = "Modify_TripDetail";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		tp = new TripPage(driver);
		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		tp.Source(testData.get("Source"));
		tp.Destination(testData.get("Destination"));
		tp.Calander();
		Thread.sleep(500);
		tp.SelectDate(testData.get("MonthYear"), testData.get("Day"));
		Thread.sleep(500);
		tp.SearchBuses();
		Thread.sleep(500);
		tp.Modify("New Delhi", "Kanpur");
		Thread.sleep(500);
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, testData.get("Expected Title"));

	}

	@Test(priority = 4)
	public void Bus_Departure_Time() throws Exception {
		String testcase = "Bus_Departure_Time";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);
		tp = new TripPage(driver);
		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		tp.Source(testData.get("Source"));
		tp.Destination(testData.get("Destination"));
		tp.Calander();
		Thread.sleep(500);
		tp.SelectDate(testData.get("MonthYear"), testData.get("Day"));
		Thread.sleep(500);
		tp.SearchBuses();
		Thread.sleep(500);
		tp.BusDeparture();
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, testData.get("Expected Title"));

	}

	@Test(priority = 5)
	public void Bus_Types() throws Exception {
		String testcase = "Bus_Types";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		tp = new TripPage(driver);
		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		tp.Source(testData.get("Source"));
		tp.Destination(testData.get("Destination"));
		tp.Calander();
		Thread.sleep(500);
		tp.SelectDate(testData.get("MonthYear"), testData.get("Day"));
		Thread.sleep(500);
		tp.SearchBuses();
		Thread.sleep(500);
		tp.BusType();
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, testData.get("Expected Title"));

	}

	@Test(priority = 6)
	public void Bus_Arrival_Time() throws Exception {
		String testcase = "Bus_Arrival_Time";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		tp = new TripPage(driver);
		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		tp.Source(testData.get("Source"));
		Thread.sleep(300);
		tp.Destination(testData.get("Destination"));
		tp.Calander();
		Thread.sleep(500);
		tp.SelectDate(testData.get("MonthYear"), testData.get("Day"));
		tp.SearchBuses();
		Thread.sleep(500);
		tp.BusArrival();
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, testData.get("Expected Title"));

	}

}