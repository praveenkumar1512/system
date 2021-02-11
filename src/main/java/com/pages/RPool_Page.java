package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RPool_Page {
	WebDriver driver;

	public RPool_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "cars")
	public WebElement poolElement;

	@FindBy(how = How.XPATH, using = "//*[@id=\"howItWorks\"]/div/div/div[1]/span[2]")
	public WebElement Offerride;

	@FindBy(how = How.XPATH, using = "//*[@id=\"howItWorks\"]/div/div/div[2]/div[1]/div[1]/div[2]")
	public WebElement activate_AccountElement;

	@FindBy(how = How.XPATH, using = "//*[@id=\"howItWorks\"]/div/div/div[2]/div[1]/div[2]")
	public WebElement request_Element;

	@FindBy(how = How.XPATH, using = "//*[@id=\"howItWorks\"]/div/div/div[2]/div[1]/div[3]")
	public WebElement ChooseElement;

	@FindBy(how = How.XPATH, using = "//*[@id=\"howItWorks\"]/div/div/div[2]/div[1]/div[4]")
	public WebElement Pay_Point_element;

	@FindBy(how = How.XPATH, using = "//*[@id=\"howItWorks\"]/div/div/div[2]/div[1]/div[2]/div[1]")
	public WebElement offer_Element;

	@FindBy(how = How.XPATH, using = "//*[@id=\"howItWorks\"]/div/div/div[2]/div[1]/div[3]/div[1]")
	public WebElement choose_offer_Element;

	@FindBy(how = How.XPATH, using = "//*[@id=\"howItWorks\"]/div/div/div[2]/div[1]/div[4]/div[1]")
	public WebElement getPoint_Element;

	@FindBy(how = How.XPATH, using = "//*[@id=\"howItWorks\"]/div/div/div[2]/div[1]/div[1]/div[1]")
	public WebElement offerActivate_Element;

	public void rpool() {
		poolElement.click();
	}

	public void Find_CarRide() {
		poolElement.click();
		request_Element.click();
		ChooseElement.click();
		activate_AccountElement.click();
		Pay_Point_element.click();

	}

	public void Offer_CarRide() {
		poolElement.click();
		Offerride.click();
		offer_Element.click();
		choose_offer_Element.click();
		offerActivate_Element.click();
		getPoint_Element.click();

	}
}
