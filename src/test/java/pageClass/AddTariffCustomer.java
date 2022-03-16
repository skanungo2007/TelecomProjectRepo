package pageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseTelecomClass;
import utilityClass.TelecomUtility;

public class AddTariffCustomer extends BaseTelecomClass {
	
	
	@FindBy(id="customer_id")
	WebElement custId;
	
	@FindBy(css="input[name='submit']")
	WebElement btn;
	
	@FindBy(xpath="//table[@class='alt']/tbody/tr/td[1]/input[@id='sele']")
	WebElement tariffSelect;
	
	@FindBy(css="input[value='Add Tariff Plan to Customer']")
	WebElement addTariffBtn;
	
	
	@FindBy(xpath="//a[@class='button' and text()='Home']")
	WebElement homeBtn;
	
	
	public AddTariffCustomer(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterId(String Id) throws InterruptedException {
		
		custId.sendKeys(Id);
		
		btn.click();
		
		Thread.sleep(500);
		
		
	}
	
	public void addCustomerPlan() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		TelecomUtility.windowScroll();
		
		Thread.sleep(500);
		
		js.executeScript("arguments[0].click();", tariffSelect);
		
		
		Thread.sleep(2000);
		
		addTariffBtn.click();
		
		Thread.sleep(2000);
		
		homeBtn.click();
	}

}
