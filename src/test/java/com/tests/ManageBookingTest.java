package com.tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.excel.utility.XLS_Reader;
import com.execution.ExecutionTest;
import com.log4j.Log4jtest;
import com.pages.ManageBookingPage;

public class ManageBookingTest extends BaseTest {

	public ManageBookingPage manage;
	private String sheetName = prop.getProperty("ManageBooking");
	XLS_Reader reader = new XLS_Reader("./Resources/RedBusTestData.xlsx");

	@Test(priority = 1)
	public void Cancel_Ticket() throws InterruptedException, IOException {

		manage = new ManageBookingPage(driver);

		Log4jtest.logger_function("Execution of Cancel ticket test start..");

		String testcase = "Cancel_Ticket";
		Log4jtest.logger_function("cancel ticket test- Read test data from excel sheet");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("cancel ticket test- clik on manage booking");
		manage.ManageBooking();

		Log4jtest.logger_function("cancel ticket test- get ticket number and email id from excel sheet");
		manage.CancelTiket(testData.get("Ticket Number"), testData.get("E mail"));
		Thread.sleep(2000);

		String title = driver.getTitle();
		Log4jtest.logger_function("Get title of Cancel Ticket page is :" + title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Execution of Cancel ticket test Completed.!");

	}

	@Test(priority = 2)
	public void Reschedule_Ticket() throws InterruptedException {

		manage = new ManageBookingPage(driver);

		Log4jtest.logger_function("Execution of Reshedule Ticket test start...");
		String testcase = "Reschedule_Ticket";
		Log4jtest.logger_function("Reshedule Ticket test- Read test data from excel sheet");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Reschedule_Ticket - clik on manage booking");
		manage.ManageBooking();

		Log4jtest.logger_function("Reschedule_Ticket- get ticket number and email id from excel sheet");
		manage.RescheduleBooking(testData.get("Ticket Number"), testData.get("E mail"));
		Thread.sleep(2000);

		String title = driver.getTitle();
		Log4jtest.logger_function("Get title of Reschedule Ticket page is :" + title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Execution of Reschedule Ticket test Completed.!");

	}

	@Test(priority = 3)
	public void Show_My_Ticket() throws InterruptedException {

		manage = new ManageBookingPage(driver);

		Log4jtest.logger_function("Execution of Show My Ticket test start...");
		String testcase = "Show_My_Ticket";
		Log4jtest.logger_function("Show My Ticket test- Read test data from excel sheet");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Show My Ticket test - clik on manage booking");
		manage.ManageBooking();

		Log4jtest.logger_function("Show_My_Ticket test- get ticket number and email id from excel sheet");
		manage.My_Ticket(testData.get("Ticket Number"), testData.get("E mail"));
		Thread.sleep(2000);

		String title = driver.getTitle();
		Log4jtest.logger_function("Get title of Show My Ticket page is :" + title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Execution of Show My Ticket test Completed.!");

	}

	@Test(priority = 4)
	public void Email_SmS() throws InterruptedException {

		manage = new ManageBookingPage(driver);

		Log4jtest.logger_function("Execution of Email/SmS test start...");

		String testcase = "Email_SmS";
		Log4jtest.logger_function("Email/SmS test- Read test data from excel sheet");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Email/SmS test - clik on manage booking");
		manage.ManageBooking();

		Log4jtest.logger_function("Email/SmS test- get ticket number and email id from excel sheet");
		manage.SMS(testData.get("Ticket Number"), testData.get("E mail"));
		Thread.sleep(2000);
		String title = driver.getTitle();
		Log4jtest.logger_function("Get title of Email/SmS page is :" + title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Execution of Email/SmS test Completed.!");

	}
}
