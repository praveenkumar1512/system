package com.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.excel.utility.XLS_Reader;
import com.execution.ExecutionTest;
import com.log4j.Log4jtest;
import com.pages.loginPage;

public class LoginTest extends BaseTest {
	static loginPage lp;

	private String sheetName = prop.getProperty("ReadLoginData");
	XLS_Reader reader = new XLS_Reader("./Resources/RedBusTestData.xlsx");

	@Test(priority = 1)
	public void Valid_Login_with_FaceBook() throws InterruptedException {
		lp = new loginPage(driver);
		Log4jtest.logger_function("Execution of Valid_Login_with_FaceBook test start..");

		String testcase = "Valid_Login_with_FaceBook";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Click on login icon");
		lp.Login();
		Log4jtest.logger_function("Click on log in with faceboock");
		lp.Login_with_FB(testData.get("User Id"), testData.get("Password"));
		Log4jtest.logger_function("Click on close mobile otp");
		lp.click_close();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String title = driver.getTitle();
		Log4jtest.logger_function("Title is :" + title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Execution of Valid_Login_with_FaceBook test is Completed.!");

	}

	@Test(priority = 2)
	public void Invalid_Login_with_FaceBook() throws InterruptedException {

		lp = new loginPage(driver);
		Log4jtest.logger_function("Execution of Invalid_Login_with_FaceBook test started..");
		String testcase = "Invalid_Login_with_FaceBook";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Click on login icon");
		lp.Login();
		Thread.sleep(3000);
		Log4jtest.logger_function("Click on log in with faceboock");
		lp.InvalidLogin_with_FB(testData.get("User Id"), testData.get("Password"));
		// use screenshot for invalid login with incorrect mobile number
		Thread.sleep(3000);
		Log4jtest.logger_function("Click on close mobile otp");
		lp.click_close();
		Thread.sleep(200);
		Log4jtest.logger_function("Execution of Invalid_Login_with_FaceBook test is Completed.!");

	}

	@Test(priority = 3)
	public void My_Trip() throws InterruptedException {

		lp = new loginPage(driver);

		Log4jtest.logger_function("Execution of My_Trip test is Started.!");
		String testcase = "My_Trip";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Click on login icon");
		lp.Login();
		Thread.sleep(2000);
		Log4jtest.logger_function("Click on log in with faceboock");
		lp.Login_with_FB(testData.get("User Id"), testData.get("Password"));
		Thread.sleep(3000);
		Log4jtest.logger_function("Click on close mobile otp");
		lp.click_close();
		Thread.sleep(2000);
		Log4jtest.logger_function("Click on my trip");
		lp.MyTrip();
		String title = driver.getTitle();
		Log4jtest.logger_function("Title is :" + title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Thread.sleep(200);
		Log4jtest.logger_function("Execution of My_Trip test is Completed.!");

	}

	@Test(priority = 4)
	public void Valid_update_MyProfile() throws InterruptedException {

		lp = new loginPage(driver);

		Log4jtest.logger_function("Execution of Valid_update_MyProfile test is Started.!");
		String testcase = "Valid_update_MyProfile";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Click on sign in icon");
		lp.Login();
		Thread.sleep(2000);
		Log4jtest.logger_function("Click on log in with faceboock");
		lp.Login_with_FB(testData.get("User Id"), testData.get("Password"));
		Thread.sleep(3000);
		Log4jtest.logger_function("Click on close mobile otp");
		lp.click_close();
		Thread.sleep(2000);
		Log4jtest.logger_function("Click on my profile for update");
		lp.Profile(testData.get("Update ProfileName"), testData.get("Update Mobile"));
		Thread.sleep(500);
		lp.CloseMobile_Otp();
		String title = driver.getTitle();
		Log4jtest.logger_function("Title is :" + title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Execution of Valid_update_MyProfile test is Completed.!");

	}

	@Test(priority = 5)
	public void InValid_update_MyProfile() throws InterruptedException {

		lp = new loginPage(driver);

		Log4jtest.logger_function("Execution of InValid_update_MyProfile test is Started.!");
		String testcase = "InValid_update_MyProfile";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Click on signin icon");
		lp.Login();
		Thread.sleep(2000);
		Log4jtest.logger_function("Click on log in with faceboock and read the data from Excel sheet");
		lp.Login_with_FB(testData.get("User Id"), testData.get("Password"));
		Thread.sleep(3000);
		Log4jtest.logger_function("Click on close otp");
		lp.click_close();
		Thread.sleep(2000);
		Log4jtest.logger_function("Click on my profile for update and read the data from excel sheet");
		lp.Profile("Praveen", "23456789");
		// use screenshot for invalid mobile number
		String title = driver.getTitle();
		Log4jtest.logger_function("Title is :" + title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Execution of InValid_update_MyProfile test is Completed.!");

	}

	@Test(priority = 6)
	public void WalletsCards_Balance() throws InterruptedException {
		lp = new loginPage(driver);
		Log4jtest.logger_function("Execution of WalletsCards_Balance test is Started.!");
		String testcase = "WalletsCards_Balance";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Click on sign in icon");
		lp.Login();
		Thread.sleep(2000);
		Log4jtest.logger_function("Click on log in with faceboock read the data from excel sheet");
		lp.Login_with_FB(testData.get("User Id"), testData.get("Password"));
		Thread.sleep(3000);
		Log4jtest.logger_function("Click on close mobile otp");
		lp.click_close();
		Thread.sleep(2000);
		Log4jtest.logger_function("Click on Wallets and Cards Balance");
		lp.Wallets_cards();
		Thread.sleep(500);
		String title = driver.getTitle();
		Log4jtest.logger_function("Title is :" + title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Execution of WalletsCards_Balance test is Completed.!");

	}

	@Test(priority = 7)
	public void Wallet_History() throws InterruptedException {
		lp = new loginPage(driver);

		Log4jtest.logger_function("Execution of Wallet_History test is Started.!");
		String testcase = "Wallet_History";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Click on signin  icon");
		lp.Login();
		Thread.sleep(2000);
		Log4jtest.logger_function("Click on log in with faceboock and Enter the data from excel sheet");
		lp.Login_with_FB(testData.get("User Id"), testData.get("Password"));
		Thread.sleep(3000);
		Log4jtest.logger_function("Click on close mobile otp");
		lp.click_close();
		Thread.sleep(2000);
		Log4jtest.logger_function("Click on wallet ");
		lp.Wallet();
		String title = driver.getTitle();
		Log4jtest.logger_function("Title is :" + title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Execution of Wallet_History test is Completed.!");

	}

	@Test(priority = 8)
	public void signOut() throws InterruptedException {
		lp = new loginPage(driver);

		Log4jtest.logger_function("Execution of signOut test is started.!");
		String testcase = "signOut";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Click on sign in icon");
		lp.Login();
		Thread.sleep(2000);
		Log4jtest.logger_function("Click on log in with faceboock and Enetr the data from excel sheet");
		lp.Login_with_FB(testData.get("User Id"), testData.get("Password"));
		Thread.sleep(3000);
		Log4jtest.logger_function("Click on close mobile otp");
		lp.click_close();
		Thread.sleep(2000);
		Log4jtest.logger_function("Click on sign out ");
		lp.SignOut();
		String title = driver.getTitle();
		Log4jtest.logger_function("Title is :" + title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Execution of signOut test is Completed.!");

	}

	@Test(priority = 9)
	public void signOut_from_allDevices() throws InterruptedException {
		lp = new loginPage(driver);

		Log4jtest.logger_function("Execution of signOut_from_allDevices test is started.!");
		String testcase = "signOut_from_allDevices";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testcase);

		extentTest = extent.startTest(testcase);
		ExecutionTest.tocheckExecutionRequired(testData.get("Execution Required"), testcase);
		Log4jtest.logger_function("Click on sign in icon");
		lp.Login();
		Thread.sleep(2000);
		Log4jtest.logger_function("Click on log in with faceboock and Enetr the data from Excel sheet ");
		lp.Login_with_FB(testData.get("User Id"), testData.get("Password"));
		Thread.sleep(3000);
		Log4jtest.logger_function("Click on close mobile otp");
		lp.click_close();
		Thread.sleep(2000);
		Log4jtest.logger_function("Click on sign out from all devices");
		lp.SignOut_All();
		String title = driver.getTitle();
		Log4jtest.logger_function("Title is :" + title);
		Assert.assertEquals(title, testData.get("Expected Title"));
		Log4jtest.logger_function("Execution of signOut_from_all Devices test is Completed.!");

	}
}
