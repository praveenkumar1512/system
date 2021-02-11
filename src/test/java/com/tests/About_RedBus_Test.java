package com.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.excel.utility.XLS_Reader;
import com.execution.ExecutionTest;
import com.log4j.Log4jtest;
import com.pages.About_RedBus_Page;

public class About_RedBus_Test extends BaseTest{
	static About_RedBus_Page about;
	private String sheetName = prop.getProperty("about");
	XLS_Reader reader = new XLS_Reader("./Resources/RedBusTestData.xlsx");

	@Test(priority = 1)
	public void RedBus_About() {
		Log4jtest.logger_function("RedBus_About test execution starting...");
		String testcase = "RedBus_About";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		about= new About_RedBus_Page(driver);
		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Click on about us ");
		about.Aboutus();
		Log4jtest.logger_function("About us Page is Open now ");
		Log4jtest.logger_function("Get the title of current page ");
		String title = driver.getTitle();
		Log4jtest.logger_function("RedBus_About Page title is : "+title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("RedBus_About test execution Completed..!");

	}
	@Test(priority = 2)
	public void RedBus_Contact() {
		Log4jtest.logger_function("RedBus_Contact test execution starting...");
		String testcase = "RedBus_Contact";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		about= new About_RedBus_Page(driver);
		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Click on Contact us ");
		about.Contact();
		Log4jtest.logger_function("Contact us Page is Open now ");
		Log4jtest.logger_function("Get the title of current page ");
		String title = driver.getTitle();
		Log4jtest.logger_function("RedBus_Contact Page title is : "+title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("RedBus_Contact test execution Completed..!");
	
	}
	@Test(priority = 3)
	public void Redbus_Careers() {
		Log4jtest.logger_function("Redbus_Careers test execution starting...");
		String testcase = "Redbus_Careers";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		about= new About_RedBus_Page(driver);
		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Click on careers us ");
		about.Contact();
		Log4jtest.logger_function("careers Page is Open now ");
		Log4jtest.logger_function("Get the title of careers page ");
		String title = driver.getTitle();
		Log4jtest.logger_function("Redbus_Careers Page title is : "+title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Redbus_Careers test execution Completed..!");
	
	}
}
