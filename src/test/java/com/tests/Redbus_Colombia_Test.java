package com.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.excel.utility.XLS_Reader;
import com.execution.ExecutionTest;
import com.log4j.Log4jtest;
import com.pages.Redbus_Colombia_Page;

public class Redbus_Colombia_Test extends BaseTest{
	private String sheetName = prop.getProperty("collombiaServices");
	XLS_Reader reader = new XLS_Reader("./Resources/RedBusTestData.xlsx");

	@Test
	public void Redbus_services_in_Collombia() throws InterruptedException {
	
		Redbus_Colombia_Page Rc = new Redbus_Colombia_Page(driver);
		Log4jtest.logger_function("Execution of Redbus_services_in_Collombia test start..");
		
		String testcase = "Redbus_services_in_Collombia";
		Log4jtest.logger_function("Find_Ride test- Read test data from excel sheet");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);
		
		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("click on Collombia icon..");
		Rc.Click_Colombia();
		String title = driver.getTitle();
		Log4jtest.logger_function("Redbus_services_in_Collombia title :"+title);	
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Execution of Redbus_services_in_Collombia Test Completed.");

	}
	
	
}
