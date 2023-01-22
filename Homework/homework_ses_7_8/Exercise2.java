package homework_ses_7_8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise2 {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://workoglobe.com/");
		
		// Next commands are made "long" on purpose to reinforce the learning material
		driver.findElement(By.cssSelector("#home > div.page.page-1 > div.wrapper.df-c > div.search.df-c.ai-c > div:nth-child(2) > div > form > input")).sendKeys("QA Engineer");
		driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[2]/div[2]/div[2]/div/form/button")).click();
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
