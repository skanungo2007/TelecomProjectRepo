package pageClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseTelecomClass;
import utilityClass.TelecomUtility;

public class PayBill extends BaseTelecomClass {

	
	@FindBy(how=How.NAME, using="customer_id")
	WebElement customerId;
	
	@FindBy(how=How.CSS, using="input[value='submit']")
	WebElement subBtn;
	
	@FindBy(how=How.XPATH, using="//table[@class='alt']/tbody/tr[4]")
	WebElement tariffAmount;
	
	
	@FindBy(how=How.XPATH, using="//table[@class='alt']/tbody/tr[5]")
	WebElement usageCharge;
	
	@FindBy(how=How.XPATH, using="//table[@class='alt']/tbody/tr[6]")
	WebElement totalBill;
	
	public PayBill(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void customerBill(String id) throws InterruptedException {
		
		customerId.sendKeys(id);
		
		subBtn.click();
		
		Thread.sleep(1000);
		
		TelecomUtility.windowScroll();
	}
	
	public void showBill() {
		
		System.out.println();
		
		System.out.println(tariffAmount.getText());
		System.out.println(usageCharge.getText());
		System.out.println(totalBill.getText());
		
		System.out.println();
	}
}
