package testClass;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseClass.BaseTelecomClass;
import dataClass.ReadExcel;
import pageClass.AddCustomer;
import pageClass.AddTariffCustomer;
import pageClass.AddTariffPlan;
import pageClass.FetchId;
import pageClass.HomePage;
import pageClass.PayBill;
import utilityClass.TelecomUtility;

public class TelecomTest extends BaseTelecomClass {
	
	
	String customerId;
	
	
	
	@Test(priority=0)
	public void verifyHomePage() {
		
		test = reports.createTest("Verify HomePage");
		
		HomePage home = new HomePage(driver);
		
		home.verifyPage();
		
		
		
	}
	
	
	@Test(priority=1, dataProvider="customerData", dataProviderClass=ReadExcel.class)
	public void addCustomerDetails(@Optional() String fname, String lname, String email, String address, String phone) throws InterruptedException {
		
		test = reports.createTest("Add Customer Details");
		
		HomePage home = new HomePage(driver);
		
		AddCustomer customer = new AddCustomer(driver);

		home.naviagateCustomer();
		
		customer.fillCustDetails(fname, lname, email, address, phone);
		
		customer.submitCustDetails();
		
	}
	
	
	@Test(priority=2)
	public void getCustomerDetails() throws InterruptedException {
		
		test = reports.createTest("Fetch Customer Details");
		
		FetchId custID = new FetchId(driver);
		
		customerId = custID.getId();
		
		System.out.println("ID: " + customerId);
		
		custID.returnToHome();
		
	}
	
	
	
	@Test(priority=3, dataProvider="tariff", dataProviderClass=ReadExcel.class)
	public void AddTariff(@Optional() double rental, double localMin, double intMin, double smsPack, double localCharge, double intCharge, double smsCharge) throws InterruptedException {
		
		test = reports.createTest("Add Tariff Plan");
		
		HomePage home = new HomePage(driver);
		
		AddTariffPlan tariff = new AddTariffPlan(driver);
		
		home.navigateAddPlan();
		
		tariff.addPlan(rental, localMin, intMin, smsPack, localCharge, intCharge, smsCharge);
		
		
		
	}
	
	
	
	
	@Test(priority=4)
	public void addPlanCustomer() throws InterruptedException {
		
		test = reports.createTest("Add Plan For Customer");
		
		HomePage home = new HomePage(driver);
		
		AddTariffCustomer customerTariff = new AddTariffCustomer(driver);
		
		home.naviagateAddTariffCustomer();
		customerTariff.enterId(customerId);
		
		customerTariff.addCustomerPlan();
		
		
	}
	

	
	@Test(priority=5)
	public void payCustomerBill() throws InterruptedException {
		
		test = reports.createTest("Pay Bill");
		
		
		HomePage home = new HomePage(driver);
		
		PayBill pay = new PayBill(driver);
		
		home.naviagateBilling();
		
		pay.customerBill(customerId);
		
		pay.showBill();
		
	}
	
	
}
