package utilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import baseClass.BaseTelecomClass;

public class TelecomUtility extends BaseTelecomClass {
	
	
	public static String readTelecomProperty(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src/test/java\\config\\config.properties");
		
		Properties property = new Properties();
		
		property.load(fis);
		
		return property.get(key).toString();
		
	}
	
	public static String captureScreen(WebDriver driver, String name) throws IOException {
		
		long timeStamp = System.currentTimeMillis();
		
		String dateTime = String.valueOf(timeStamp);
		
		
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir") + "//FailedStepScreenshot//" + name + dateTime + ".png";
		
		File destFile = new File(destination);
		
		FileUtils.copyFile(srcFile, destFile);
		
		Reporter.log("<img src='"+destination+"' width='250' height='150' />");
		
		return destination;
		
		
	}
	
	public static void windowScroll() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,300)");
	}

}
