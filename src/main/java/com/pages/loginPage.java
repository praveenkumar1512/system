package com.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.ExplicitWaitClass;


public class loginPage {
	WebDriver driver;

	public loginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "sign-in-icon-down")
	public WebElement signIconElement;

	@FindBy(how = How.ID, using = "signInLink")
	public WebElement signElement;

	@FindBy(how = How.CLASS_NAME, using = "modalIframe")
	public WebElement frame;

	@FindBy(how = How.ID, using = "newFbId")
	public WebElement facebook_button;

	@FindBy(how = How.ID, using = "email")
	public WebElement facebook_email;

	@FindBy(how = How.ID, using = "pass")
	public WebElement facebook_password;

	@FindBy(how = How.ID, using = "loginbutton")
	public WebElement LogIn_button;

	@FindBy(how = How.XPATH, using = "//i[@class= 'icon-close']")
	public WebElement close;

	@FindBy(how = How.XPATH, using = "//*[@id=\"hc\"]/ul/li[1]")
	public WebElement tripElement;

	@FindBy(how = How.XPATH, using = "//*[@id=\"hc\"]/ul/li[3]")
	public WebElement profileElement;

	@FindBy(how = How.ID, using = "Editbtn")
	public WebElement editElement;

	@FindBy(how = How.ID, using = "profile-displayName")
	public WebElement NameElement;

	@FindBy(how = How.ID, using = "profile-DOB")
	public WebElement DOBElement;

	@FindBy(how = How.ID, using = "male")
	public WebElement genderElement;

	@FindBy(how = How.ID, using = "profile-mobile")
	public WebElement mobileElement;

	@FindBy(how = How.ID, using = "Savebtn")
	public WebElement saveElement;

	@FindBy(how = How.XPATH, using = "//*[@id=\"profiledetails\"]/div[2]/div[3]/div/div[4]/span[2]")
	public WebElement close_Otp_Element;

	@FindBy(how = How.XPATH, using = "//*[@id=\"hc\"]/ul/li[2]")
	public WebElement walletCardElement;

	@FindBy(how = How.XPATH, using = "//*[@id=\"hc\"]/ul/li[4]")
	public WebElement walletElement;

	@FindBy(how = How.ID, using = "signOutLink")
	public WebElement singout_Element;

	@FindBy(how = How.ID, using = "signOutAllLink")
	public WebElement singout_all_Element;

	
	public void Login() {
		//click on signIcon
		signIconElement.click();
		// Explicit wait for signElement
		ExplicitWaitClass.checkClickableExplicitly(driver, signElement,10);
		signElement.click();

	}

	/*------------------Login with facebook credentials-------------*/
	public void Login_with_FB(String username, String pass) throws InterruptedException {
		driver.switchTo().frame(frame);
		String mainWindow = driver.getWindowHandle();
	
		ExplicitWaitClass.checkClickableExplicitly(driver, facebook_button,10);
		facebook_button.click();
		Set<String> handles = driver.getWindowHandles();

		for (String childWindow : handles) {
			if (!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
				// Explicit wait for username
				ExplicitWaitClass.checkClickableExplicitly(driver, facebook_email,10);
				facebook_email.sendKeys(username);				
				// Explicit wait for password
				ExplicitWaitClass.checkClickableExplicitly(driver, facebook_password,10);
				facebook_password.sendKeys(pass);
				// Explicit wait for login button
				ExplicitWaitClass.checkClickableExplicitly(driver, LogIn_button,10);
				LogIn_button.click();
			}
			Thread.sleep(2000);

		}
		driver.switchTo().window(mainWindow);
		Thread.sleep(1000);
	}

	/*-----------close mobile otp pop up windows-------------*/
	public void click_close() {
		close.click();
	}
	
	/*------------------Login with invalid facebook credentials-------------*/
	public void InvalidLogin_with_FB(String username, String pass) throws InterruptedException {
		driver.switchTo().frame(frame);
		String mainWindow = driver.getWindowHandle();
		facebook_button.click();
		Set<String> handles = driver.getWindowHandles();

		for (String childWindow : handles) {
			if (!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
				// Explicit wait for username
				ExplicitWaitClass.checkClickableExplicitly(driver, facebook_email,10);
				facebook_email.sendKeys(username);				
				// Explicit wait for password
				ExplicitWaitClass.checkClickableExplicitly(driver, facebook_password,10);
				facebook_password.sendKeys(pass);
				// Explicit wait for login button
				ExplicitWaitClass.checkClickableExplicitly(driver, LogIn_button,10);
				Thread.sleep(500);
				LogIn_button.click();
				Thread.sleep(500);
				String title = driver.getTitle();
				System.out.println(title);
				Assert.assertEquals(title,"Book Bus Travel");
			}
			Thread.sleep(2000);

		}
		driver.switchTo().window(mainWindow);
		Thread.sleep(1000);
	}
	
/*-------------profile methode used to 
 * update my profile-----------------------*/
	public void Profile(String name, String mob) {
		signIconElement.click();
		profileElement.click();
		editElement.click();
		NameElement.sendKeys(name);
		DOBElement.click();
		genderElement.click();
		mobileElement.sendKeys(mob);
		saveElement.click();
	}

	/*-------close mobile otp window
	at profile updation time------*/
	
	public void CloseMobile_Otp() {
		close_Otp_Element.click();
	}

	// -------------- click on my trip to check my trip details---------
	public void MyTrip() throws InterruptedException {
		signIconElement.click();
		Thread.sleep(2000);
		tripElement.click();
	}

	// -------------- click on Wallets and cards to check card balance details---------
	public void Wallets_cards() throws InterruptedException {
		signIconElement.click();
		Thread.sleep(2000);
		walletCardElement.click();
	}

	//--------------use to check wallet ---------
	public void Wallet() throws InterruptedException {
		signIconElement.click();
		Thread.sleep(2000);
		walletElement.click();
	}

	//--------use to sign out profile -----------
	public void SignOut() throws InterruptedException {
		signIconElement.click();
		Thread.sleep(2000);
		singout_Element.click();
	}
	
	//--------use to signout profile from all devices -----------
	public void SignOut_All() throws InterruptedException {
		signIconElement.click();
		Thread.sleep(2000);
		singout_all_Element.click();
	}

}
