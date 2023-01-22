package homework_ses_10part3;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		
		String MainWindowHandle = driver.getWindowHandle();
		
		WebElement NewWindowButton = driver.findElement(By.xpath("//*[@id=\"windowButton\"]"));
		for (int i=0; i < 5; i++) NewWindowButton.click();
		
		Set<String> AllWindowsHandles = driver.getWindowHandles();
		
		for (String window : AllWindowsHandles) {
			
			if (!window.equalsIgnoreCase(MainWindowHandle)) {
				driver.switchTo().window(window);
				driver.navigate().to("http://google.com");
			}
			else {
				driver.switchTo().window(MainWindowHandle);
				driver.close();
			}
		}
		
		driver.quit();
	}

}
