package homework_ses_10part3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.qaevolution.com/websandbox.html");
		
		driver.switchTo().frame("iframe1");
		
		String header = driver.findElement(By.cssSelector("body > header > div > div > div.logo > h1 > a")).getText();
		System.out.println("The header of iFrame2 is " + header);
		
		driver.quit();
	}

}
