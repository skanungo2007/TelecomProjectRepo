package pageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseClass.BaseTelecomClass;

public class HomePage extends BaseTelecomClass {
	
	
	@FindBy(linkText="Add Customer")
	@CacheLookup
	WebElement addCustomer;
	
	
	@FindBy(linkText="Add Tariff Plan to Customer")
	@CacheLookup
	WebElement addPlanCustomer;
	
	@FindBy(linkText="Add Tariff Plan")
	@CacheLookup
	WebElement addTariff;
	
	@FindBy(linkText="Pay Billing")
	@CacheLookup
	WebElement payBill;
	

	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void verifyPage() {
		
		String expected = "Guru99 Telecom";
		
		String actual = driver.getTitle();
		
		Assert.assertEquals(actual, expected);
		
		System.out.println(driver.getCurrentUrl());
		
	}
	
	public void naviagateCustomer() {
		
		addCustomer.click();
	}
	
	public void naviagateAddTariffCustomer() {
		
		addPlanCustomer.click();
		
	}
	
	public void navigateAddPlan() {
		
		addTariff.click();
		
	}
	
	public void naviagateBilling() {
		
		payBill.click();
	}

}
