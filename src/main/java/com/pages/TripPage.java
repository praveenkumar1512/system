package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.ExplicitWaitClass;

public class TripPage {

	WebDriver driver;

	public TripPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "src")
	public WebElement srcElement;

	@FindBy(how = How.XPATH, using = ".//*[@id='search']/div/div[1]/div/ul/li[1]")
	public WebElement srcSend;
	
	@FindBy(how = How.ID, using = "dest")
	public WebElement destElement;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='search']/div/div[2]/div/ul/li[1]")
	public WebElement destSend;

	@FindBy(how = How.ID, using = "onward_cal")
	public WebElement cal;

	@FindBy(how = How.ID, using = "search_btn")
	public WebElement searchbtn;
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"filter-block\"]/div/div[2]/ul[1]/li[2]/i[1]")
	public WebElement filter2;

	@FindBy(how = How.XPATH,using="//*[@id=\"root\"]/div/div[3]/div[1]/i")
	public WebElement pop;
	
	
	@FindBy(how = How.XPATH,using="//*[@id=\"fixer\"]/div/div/div[2]")
	public WebElement modifyElement;
	
	@FindBy(how = How.XPATH,using="//*[@id=\"fixer\"]/section/div/div[4]/button")
	public WebElement ModifysearchElement;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"filter-block\"]/div/div[2]/ul[2]/li[1]/label[1]")
	public WebElement departureTime;
		
	@FindBy(how = How.XPATH, using = "//*[@id=\"filter-block\"]/div/div[2]/ul[3]/li[2]/label[1]")
	public WebElement BtypeElement;
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"filter-block\"]/div/div[2]/ul[4]/li[2]/label[1]")
	public WebElement arrivalTime;
	
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"filter-block\"]/div/div[2]/div[5]/i")
	public WebElement boardingElement;
	
	@FindBy(how = How.LINK_TEXT, using = "WIFI")
	public WebElement wifiElement;
	
	public void Source(String location) {
		srcElement.sendKeys(location);
		ExplicitWaitClass.checkClickableExplicitly(driver, srcSend,10);
		srcSend.click();
	}

	public void Destination(String location) {
		destElement.sendKeys(location);
		ExplicitWaitClass.checkClickableExplicitly(driver, destSend,10);
		destSend.click();
	}

	public void Calander() {
		
		//ExplicitWaitClass.checkClickableExplicitly(driver, cal,20);
		cal.click();
	}

	public void SelectDate(String monthyear, String Selectday) throws InterruptedException {

		List<WebElement> elements = driver
				.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]"));
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getText().equals(monthyear)) {
				// Selecting the date
				List<WebElement> days = driver
						.findElements(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td"));
				for (WebElement d : days) {
					if (d.getText().equals(Selectday)) {
						d.click();
						Thread.sleep(200);
						return;
					}
				}
			}
		}
	}

	public void SearchBuses() throws InterruptedException {	
		searchbtn.click();
		Thread.sleep(5000);
		pop.click();
	}
	
	public void Filter() throws InterruptedException {
		Thread.sleep(500);
		filter2.click();
	}
	
	public void Modify(String loc1,String loc2) throws InterruptedException {
		modifyElement.click();
		Thread.sleep(500);
		//ExplicitWaitClass.checkClickableExplicitly(driver, modifyElement,10);
		srcElement.clear();
		srcElement.sendKeys(loc1);
		destElement.clear();
		destElement.sendKeys(loc2);
		Thread.sleep(500);
		//ExplicitWaitClass.checkClickableExplicitly(driver, destElement,10);
		ModifysearchElement.click();
		ExplicitWaitClass.checkClickableExplicitly(driver, ModifysearchElement,10);

	}
	public void BusDeparture() {
		ExplicitWaitClass.checkClickableExplicitly(driver,departureTime,10);
		departureTime.click();
	}
	public void BusType() {
		ExplicitWaitClass.checkClickableExplicitly(driver,BtypeElement,10);
		BtypeElement.click();
	}
	public void BusArrival() {
		arrivalTime.click();
		boardingElement.click();
	}
	
}
