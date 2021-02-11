package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.ExplicitWaitClass;

public class About_RedBus_Page {

	WebDriver driver;

	public About_RedBus_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(how = How.LINK_TEXT, using = "About Us")
	public WebElement aboutElemenet;
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"rh_footer\"]/div[2]/div/div/ul/h6")
	public WebElement scrollElement;
	
	@FindBy(how = How.LINK_TEXT, using = "Contact Us")
	public WebElement contactElemenet;
	
	@FindBy(how = How.LINK_TEXT, using = "Careers")
	public WebElement careerElemenet;
	
	/*-------------  Method to scroll down the page ----------------*/
	public void scroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	/*----------------------- About us -------------------------------*/
	public void Aboutus() {
		scroll(scrollElement);
		// ----- ExplicitWait for aboutElemenet -----
		ExplicitWaitClass.checkClickableExplicitly(driver, aboutElemenet,10);
		aboutElemenet.click();
	}
	
	/*----------------------- Contact -------------------------------*/
	public void Contact() {
		scroll(scrollElement);
		// ----ExplicitWait for career element ------
		ExplicitWaitClass.checkClickableExplicitly(driver, contactElemenet,10);
		contactElemenet.click();
	}
	
	/*----------------------- careers -------------------------------*/
	public void Careers() {
		scroll(scrollElement);
		// ------ExplicitWait for career element------
		ExplicitWaitClass.checkClickableExplicitly(driver, careerElemenet,10);
		careerElemenet.click();
	}
}
