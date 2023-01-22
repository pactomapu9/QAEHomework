package homework_ses_10part4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover1 {

	public static void main(String[] args) {
		
	    // Create a new instance of Chrome driver
	    WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/menu/");
        System.out.println("demoqa webpage Displayed");
        driver.manage().window().maximize();
	    
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
              
        Actions actions = new Actions(driver);
        
       	WebElement menuOption = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/a"));
    
    	actions.moveToElement(menuOption).perform();
    	System.out.println("Done Mouse hover on 'Main Item 2' from Menu");
    	
       	WebElement subMenuOption = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/a")); 
    
    	actions.moveToElement(subMenuOption).perform();
    	System.out.println("Done Mouse hover on 'SUB SUB List' from Menu");
    	

    	WebElement selectMenuOption = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/ul/li[2]/a"));
    	selectMenuOption.click();
    	System.out.println("Selected 'Sub Sub Item 2' from Menu");
    	
    	driver.quit();
        
	}

}
