package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Redbus_Colombia_Page {
	WebDriver driver;

	public Redbus_Colombia_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using = "//*[@id=\"our_distribution_div\"]/div/ul/li[1]/span[1]/span")
	public WebElement colombiaElement;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"rh_header\"]/div/div/div[2]/div[2]/div[6]")
	public WebElement CorporativoElement;
	
	public void Click_Colombia(){
		colombiaElement.click();
		
	}
	
}
