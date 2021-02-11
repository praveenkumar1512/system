package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ManageBookingPage {

	WebDriver driver;

	public ManageBookingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using = "//*[@id=\"manageHeaderdd\"]/div[2]")
	public WebElement manage;
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"hmb\"]/div[2]/ul/li[2]")
	public WebElement cancel;
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"root\"]/div/div[2]/div[1]/div[1]/div/input")
	public WebElement tktElement1;
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/input")
	public WebElement mailElement1;
	
	
	@FindBy(how = How.XPATH,using="//*[@id=\"root\"]/div/div[2]/div[2]/div")
	public WebElement select;
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"hmb\"]/div[2]/ul/li[3]")
	public WebElement rescheduleElement;
	
	@FindBy(how =How.ID,using ="searchTicket")
	public WebElement ticketElement2;
	
	@FindBy(how =How.ID,using ="searchEmail")
	public WebElement mailElement2;
	

	@FindBy(how = How.XPATH,using ="//*[@id=\"hmb\"]/div[2]/ul/li[4]")
	public WebElement showTiketElement;
		
	@FindBy(how =How.ID,using ="searchTicketTIN")
	public WebElement ticketElement3;
	
	@FindBy(how =How.ID,using ="searchTicketEmail")
	public WebElement mailElement3;
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"hmb\"]/div[2]/ul/li[5]")
	public WebElement smsElement;
	
	@FindBy(how =How.ID,using ="ticketSearch")
	public WebElement searchElement;
	
	public void ManageBooking() {
		manage.click();
	} 
	
	public void CancelTiket(String ticket, String email) {
		cancel.click();
		tktElement1.sendKeys(ticket);
		mailElement1.sendKeys(email);
		select.click();
	} 
	public void RescheduleBooking(String ticket, String email) {
		rescheduleElement.click();
		ticketElement2.sendKeys(ticket);
		mailElement2.sendKeys(email);
		searchElement.click();
	}
	 public void My_Ticket(String ticket, String email) {
		 showTiketElement.click();
		 ticketElement3.sendKeys(ticket);
		 mailElement3.sendKeys(email);
		 searchElement.click();
	 }
	
	 public void SMS(String ticket, String email) {
		 smsElement.click();
		 ticketElement3.sendKeys(ticket);
		 mailElement3.sendKeys(email);
		 searchElement.click();
	 }
}
