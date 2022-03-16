package baseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilityClass.TelecomUtility;

public class BaseTelecomClass {

	protected static WebDriver driver;
	
	protected ExtentHtmlReporter htmlReporter;
	protected ExtentReports reports;
	protected ExtentTest test;
	
	String driverPath;
	String screenshotPath;
	
	@BeforeSuite
	public void setupReport() {
		

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\ExtentReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		htmlReporter.config().setDocumentTitle("Telecom Project");
		htmlReporter.config().setReportName("Selenium Extent Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		
		reports.setSystemInfo("Application Name", "Guru99 Telecom");
		reports.setSystemInfo("User Name", "Subhadeep");
		reports.setSystemInfo("Environment", "Local");
		reports.setSystemInfo("OS", "Windows 10");
		
	}
	
	@BeforeTest
	public void setup() throws IOException {
		
		if(TelecomUtility.readTelecomProperty("browser").equalsIgnoreCase("chrome")) {
			
			driverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
			
			System.setProperty("webdriver.chrome.driver", driverPath);
			
			driver = new ChromeDriver();
			
			
			
		} else if(TelecomUtility.readTelecomProperty("browser").equalsIgnoreCase("edge")) {
			
			driverPath = System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe";
			
			System.setProperty("webdriver.edge.driver", driverPath);
			
			driver = new EdgeDriver();
			
			
		} else if(TelecomUtility.readTelecomProperty("browser").equalsIgnoreCase("firefox")) {
			
			driverPath = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
			
			System.setProperty("webdriver.gecko.driver", driverPath);
			
			driver = new FirefoxDriver();
			
			
			
		} else {
			
			driverPath = System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe";
			
			System.setProperty("webdriver.ie.driver", driverPath);
			
			driver = new InternetExplorerDriver();
			
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get(TelecomUtility.readTelecomProperty("url"));
		
		
		
	}
	
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		
		Thread.sleep(2000);
		
		reports.flush();

		driver.quit();
	}
	
	
	@AfterMethod
	public void getReport(ITestResult result) throws IOException {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			
			screenshotPath = TelecomUtility.captureScreen(driver, result.getName());
			
			test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			
		} else if(result.getStatus() == ITestResult.SKIP) {
			
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
			
		} else if(result.getStatus() == ITestResult.SUCCESS) {
			
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
			
		}
	}
	
	
}
