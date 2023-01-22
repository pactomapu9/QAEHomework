package homework_ses13_Exercise2;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocatorUtils {
	
	public static WebElement findElement(WebDriver driver, String locatorType, String locator) {
		
		Logger Log = Logger.getLogger(LocatorUtils.class.getName());
		
		DOMConfigurator.configure("log4j.xml");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constant.SHORT_DELAY));
		WebElement element=null;
		
		switch(locatorType) {
		  case "id":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
				element = driver.findElement(By.id(locator));
				Log.info("WebElement found successfully");
		  break;
		  case "css":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
				element = driver.findElement(By.cssSelector(locator));
				Log.info("WebElement found successfully");
		  break;
		  case "xpath":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
				element = driver.findElement(By.xpath(locator));
				Log.info("WebElement found successfully");		
		}
			
		return element;
	}

}
