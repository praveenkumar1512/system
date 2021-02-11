package com.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.excel.utility.XLS_Reader;
import com.execution.ExecutionTest;
import com.log4j.Log4jtest;
import com.pages.RedBus_Partners_Page;

public class RedBus_Partners_Test extends BaseTest {
static RedBus_Partners_Page part;
private String sheetName = prop.getProperty("partner");
XLS_Reader reader = new XLS_Reader("./Resources/RedBusTestData.xlsx");

	@Test(priority = 1)
	public void RedBusGoibio_Partner() {
		Log4jtest.logger_function("RedBusGoibio_Partner test execution starting...");
		String testcase = "RedBusGoibio_Partner";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Click on Goibibo ");
		part = new RedBus_Partners_Page(driver);
		Log4jtest.logger_function("click on Goibibo");
		part.GoibiboPartner();
		Log4jtest.logger_function("Goibibo Page is Open now ");
		Log4jtest.logger_function("Get the title of Goibibo page ");
		String title = driver.getTitle();
		Log4jtest.logger_function("RedBusGoibio_Partner Page title is : "+title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("RedBusGoibio_Partner test execution Completed..!");
		
	}
	@Test(priority = 2)
	public void RedBus_MakemyTrip_Partner() {
		Log4jtest.logger_function("RedBus_MakemyTrip_Partner test execution starting...");
		String testcase = "RedBus_MakemyTrip_Partner";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("RedBus_MakemyTrip_Partner");
		part = new RedBus_Partners_Page(driver);
		Log4jtest.logger_function("click on Make my trip");
		part.MakeMyTripPartner();
		Log4jtest.logger_function("Make my trip Page is Open now ");
		Log4jtest.logger_function("Get the title of make my trip page ");
		String title = driver.getTitle();
		Log4jtest.logger_function("RedBus_MakemyTrip_Partner Page title is : "+title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("RedBus_MakemyTrip_Partner test execution Completed..!");
		
	}
	
}
