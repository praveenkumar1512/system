package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.ExplicitWaitClass;

public class RedBus_Partners_Page {
	WebDriver driver;

	public RedBus_Partners_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(how = How.LINK_TEXT, using = "Goibibo")
	public WebElement GoibioElemenet;
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"rh_footer\"]/div[2]/div/div/ul/h6")
	public WebElement scrollElement;
	
	@FindBy(how = How.LINK_TEXT,using ="Makemytrip")
	public WebElement make;
	
	public void scroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void GoibiboPartner() {
		scroll(scrollElement);
		ExplicitWaitClass.checkClickableExplicitly(driver, GoibioElemenet,10);
		GoibioElemenet.click();
	}
	public void MakeMyTripPartner() {
		scroll(scrollElement);
		ExplicitWaitClass.checkClickableExplicitly(driver, GoibioElemenet,10);
		make.click();
	}
	
	
}
