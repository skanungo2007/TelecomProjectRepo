package pageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseTelecomClass;

public class FetchId extends BaseTelecomClass {
	
	@FindBy(xpath="//table[@class='alt access']//tr/td[2]")
	WebElement id;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement home;
	
	
	public FetchId(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String getId() {
		
		return id.getText();
		
	}

	
	public void returnToHome() throws InterruptedException {
		
		home.click();
		
		Thread.sleep(1000);
	}
}
