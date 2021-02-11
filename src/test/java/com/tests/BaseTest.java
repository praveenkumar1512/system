package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.RedBusScreenShots;

public class BaseTest {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	static File file = new File("./config.properties");
	static FileInputStream fis = null;
	static Properties prop = new Properties();

	static {
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException el) {
			el.printStackTrace();
		}
	}

	@BeforeMethod
	public void intializeDriver() {

//--------------------- CHROME BROWSER------------------------------
    String browser=prop.getProperty("browsername");
		if (browser.toLowerCase().equals("chrome") ) 
		{

			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
             String browsertype=prop.getProperty("mode");
			if (browsertype.toLowerCase().equals("headless")) 
			{

				ChromeOptions options = new ChromeOptions();
				options.addArguments("window-size=1920,1080");
				options.addArguments("headless");
				options.addArguments("user-agent=Chrome/88.0.4324.150");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.get(prop.getProperty("url-test"));
			}
			// ---------
			else {

				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(prop.getProperty("url-test"));

			}
		}
// ---------------------------Internet Explorar ----------------------
		 else if (browser.toLowerCase().equals("ie")) {

			System.setProperty("webdriver.ie.driver", "./Resources/drivers/IEDriver.exe"); 
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url-test"));
			
//-------------------------------- FireFox-----------------------
		} else if (browser.toLowerCase().equals("firefox")) 
		{

			System.setProperty("webdriver.gecko.driver", prop.getProperty("geckodriver"));

			if (browser.toLowerCase() == "headless") 
			{

				FirefoxOptions options = new FirefoxOptions();
				options.setHeadless(true);
				driver = new FirefoxDriver(options);
				driver.manage().window().maximize();
				driver.get(prop.getProperty("url-test"));

				
			} else {

				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get(prop.getProperty("url-test"));
			}

		} else {

			System.out.println("Incompatible Browser Selection");

		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@BeforeTest
	public void setExtent() {
	//	intializeDriver("firefox","headmode");

		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", prop.getProperty("host"));
		extent.addSystemInfo("User Name", prop.getProperty("user"));
		extent.addSystemInfo("OS", prop.getProperty("OS"));
		extent.addSystemInfo("Environment", prop.getProperty("enviroment"));

	}

	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in
																							// extent report
			String screenshotPath = RedBusScreenShots.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); // to add screenshot in extent
																							// report

			// extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
			// //to add screencast/video in extent report

		}

		else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
		}

		extent.endTest(extentTest); // ending test and ends the current test and prepare to create html report

		driver.quit();

	}

}
