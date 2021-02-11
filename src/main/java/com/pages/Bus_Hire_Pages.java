package com.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.ExplicitWaitClass;

public class Bus_Hire_Pages {

	WebDriver driver;

	public Bus_Hire_Pages(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "redBus Bus Hire")
	public WebElement BusElement;

	@FindBy(how = How.XPATH, using = "//*[@id=\"reactContentMount\"]/div/div[1]/div/div/div/div[2]/div[1]/div/img")
	public WebElement BookingmanageElement;

	@FindBy(how = How.XPATH, using = "//*[@id=\"reactContentMount\"]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[2]")
	public WebElement cancelationElement;

	@FindBy(how = How.XPATH, using = "//input[@id='Bookid']")
	public WebElement IDElement;

	@FindBy(how = How.ID, using = "phoneNum")
	public WebElement NumberElement;

	@FindBy(how = How.ID, using = "veribtn")
	public WebElement verify;

	@FindBy(how = How.XPATH, using = "//*[@id=\"reactContentMount\"]/div/div[1]/div/div/div/div[2]/div[2]/div/img[2]")
	public WebElement BsignIconElement;

	@FindBy(how = How.XPATH, using = "//*[@id=\"reactContentMount\"]/div/div[1]/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]")
	public WebElement offerElement;

	
	public void Manage() {
		BusElement.click();
		BookingmanageElement.click();
	}

	public void RedBusCancelation(String id, String phone) throws InterruptedException {
		cancelationElement.click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		IDElement.sendKeys(id);	
		NumberElement.sendKeys(phone);
		verify.click();
	}

	public void Offer() {
		BusElement.click();
		BsignIconElement.click();
		offerElement.click();
	}
	
	
	
}
