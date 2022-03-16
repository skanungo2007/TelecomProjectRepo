package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseTelecomClass;

public class AddTariffPlan extends BaseTelecomClass {

	@FindBy(id="rental1")
	WebElement monthlyRental;
	
	
	@FindBy(id="local_minutes")
	WebElement freeLocalMin;
	
	@FindBy(id="inter_minutes")
	WebElement freeIntMin;
	
	@FindBy(id="sms_pack")
	WebElement smsPack;
	
	@FindBy(id="minutes_charges")
	WebElement localPerMinCharge;
	
	@FindBy(id="inter_charges")
	WebElement intPerMinCharge;
	
	@FindBy(id="sms_charges")
	WebElement smsCharge;
	
	@FindBy(css="input[value='submit']")
	WebElement subBtn;
	
	@FindBy(how=How.XPATH, using="//a[text()='Home']")
	WebElement homeBtn;
	
	
	public AddTariffPlan(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void addPlan(double rental, double localMin, double intMin, double smsPackValue, double localCharge, double intCharge, double smsCharges) throws InterruptedException {
		
		int r = (int) rental;
		int lm = (int) localMin;
		int im = (int) intMin;
		int spv = (int) smsPackValue;
		int lc = (int) localCharge;
		int ic = (int) intCharge;
		int sc = (int) smsCharges;
		
		
		monthlyRental.sendKeys(String.valueOf(r));
		freeLocalMin.sendKeys(String.valueOf(lm));
		freeIntMin.sendKeys(String.valueOf(im));
		smsPack.sendKeys(String.valueOf(spv));
		localPerMinCharge.sendKeys(String.valueOf(lc));
		intPerMinCharge.sendKeys(String.valueOf(ic));
		smsCharge.sendKeys(String.valueOf(sc));
		
		subBtn.click();
		
		Thread.sleep(2000);
		
		homeBtn.click();
	}
}
