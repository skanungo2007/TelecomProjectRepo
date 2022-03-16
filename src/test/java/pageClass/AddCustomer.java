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

public class AddCustomer extends BaseTelecomClass {

	@FindBy(xpath="//input[@id='done']")
	WebElement bgStatus;
	
	@FindBy(id="fname")
	WebElement fname;
	
	@FindBy(id="lname")
	WebElement lname;
	
	@FindBy(name="emailid")
	WebElement email;
	
	@FindBy(xpath="//textarea")
	WebElement address;
	
	@FindBy(name="telephoneno")
	WebElement mobile;
	
	@FindBy(css="input[value='Submit']")
	WebElement submitBtn;
	
	
	
	
	public AddCustomer(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void fillCustDetails(String firstName, String lastName, String mail, String addr, String phone) throws InterruptedException {
		
		Actions builder = new Actions(driver);
		
		Action hover = builder.moveToElement(bgStatus).click().build();
		
		hover.perform();
		
		fname.sendKeys(firstName);
		
		lname.sendKeys(lastName);
		
		email.sendKeys(mail);
		
		hover = builder.moveToElement(address).click().sendKeys(addr).build();
		hover.perform();
		
		mobile.sendKeys(phone);
		
		
	}
	
	public void submitCustDetails() throws InterruptedException {
		
		submitBtn.click();
		
		Thread.sleep(1000);
		
	}
	
	

}
