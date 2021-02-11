package com.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.excel.utility.XLS_Reader;
import com.execution.ExecutionTest;
import com.log4j.Log4jtest;
import com.pages.RedBus_JoiOperator_Page;

public class RedBus_JoiOperator_Test extends BaseTest {
	private String sheetName = prop.getProperty("operator");
	XLS_Reader reader = new XLS_Reader("./Resources/RedBusTestData.xlsx");

	@Test
	public void Join_As_Operator() throws InterruptedException {
		Log4jtest.logger_function("Join_As_Operator method execution starting...");
		String testcase = "Join_As_Operator";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		RedBus_JoiOperator_Page join = new RedBus_JoiOperator_Page(driver);
		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Click on bus hire.");
		join.BusHire();
		Log4jtest.logger_function("click on Become an Operator Button ");
		Log4jtest.logger_function("Enetr the signup details from excel file");
		join.signUp_BusHireOperator(testData.get("CompanyName"),testData.get("OperatorName"),
				testData.get("city"),testData.get("mobile"), testData.get("phone"),	
				testData.get("mail"), testData.get("Altermail"), testData.get("Address") ,
				testData.get("PanNo"), testData.get("GSTIN"));
		Log4jtest.logger_function("Get the title of current page ");
		String title = driver.getTitle();
		Log4jtest.logger_function("Operator Page title is : "+title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Join_As_Operator method execution Completed..!");

	
	}

}
