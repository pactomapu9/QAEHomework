package homework_ses_7_8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://google.com/");
		
		if (driver.getCurrentUrl().equals("https://google.com"))
			System.out.println("Test PASSED");
		else
			System.out.println("Test FAILED");
			
		WebElement SearchField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		SearchField.sendKeys("Automation");
		Thread.sleep(2000);
		
		driver.quit();
	}

}
