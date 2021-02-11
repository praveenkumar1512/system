package com.pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RedBus_JoiOperator_Page {
	WebDriver driver;

	public RedBus_JoiOperator_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.LINK_TEXT, using = "BUS HIRE")
	public WebElement BushireElemenet;

	@FindBy(how = How.XPATH, using = "//div[@class='_3VcoR-iRCX0iy6hxaxf6ER']")
	public WebElement scrollElement;

	@FindBy(how = How.XPATH, using = "//div[@class='_254VH5WNgWgjclgRRPngBJ']")
	public WebElement BecomeAnOperator;

	@FindBy(how = How.ID, using = "Name")
	public WebElement CompanyNameElement;

	@FindBy(how = How.ID, using = "OperatorName")
	public WebElement operatorNameElement;

	@FindBy(how = How.ID, using = "City")
	public WebElement CityElement;

	@FindBy(how = How.ID, using = "PrimaryPhNumber")
	public WebElement P_MobileElement;

	@FindBy(how = How.ID, using = "AlternatePhNumber")
	public WebElement A_MobileElement;

	@FindBy(how = How.ID, using = "EmailAddress")
	public WebElement mailid;

	@FindBy(how = How.ID, using = "AlternateEmailAddress")
	public WebElement A_mailElement;

	@FindBy(how = How.ID, using = "OperatorAddress")
	public WebElement FullAddressElement;

	@FindBy(how = How.ID, using = "PAN")
	public WebElement PAN_Element;

	@FindBy(how = How.ID, using = "GSTIN")
	public WebElement GSTIN_Element;

	@FindBy(how = How.XPATH, using = "//div[@id='submitFormDetails']")
	public WebElement Submit_button;

	@FindBy(how = How.XPATH, using = "//*[@id=\"reactContentMount\"]/div/div[5]/div[1]/div[10]/div/div/div[1]")
	public WebElement Assertion;

	public void BusHire() throws InterruptedException {
		BushireElemenet.click();
		// ExplicitWait(scrollElement);
		scroll(scrollElement);
	}

	public void scroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void signUp_BusHireOperator(String name, String operatorname, String city, String no, String AlternateNo,
			String email, String alternate_id, String Address, String panNo, String GstinNo)
			throws InterruptedException {
		String mainWindow = driver.getWindowHandle();
		// ExplicitWait(BecomeAnOperator);
		BecomeAnOperator.click();
		Set<String> handles = driver.getWindowHandles();
		for (String childWindow : handles) {
			if (!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
				CompanyNameElement.sendKeys(name);
				operatorNameElement.sendKeys(name);
				CityElement.sendKeys(city);
				P_MobileElement.sendKeys(no);
				A_MobileElement.sendKeys(AlternateNo);
				mailid.sendKeys(email);
				A_mailElement.sendKeys(alternate_id);
				FullAddressElement.sendKeys(Address);
				PAN_Element.sendKeys(panNo);
				GSTIN_Element.sendKeys(GstinNo);
				Submit_button.click();
			}
		}
		driver.switchTo().window(mainWindow);
	}
}
