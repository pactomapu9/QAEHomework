package homework_ses11;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestSignIn {

	public static void main(String[] args) throws Exception {
		
		final int SHORT_DELAY = 1000; //short delay

			
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Tests");
		
		int r = 1; // r is row number in the excel sheet; r = 1 is the second row
		
		String TestCaseID, email, password; //TestCaseId contains data from TestCaseId field; email and password are data for the tests
		
		// Open Chrome and go to URL
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		
		// While TestCaseID field is not empty do tests with data from each row in the table
		while (true) {
			driver.get(Constant.URL); // Go to the main page
			Thread.sleep(SHORT_DELAY);
			TestCaseID = ExcelUtils.getCellData(r, 0).toString(); // Get TestCaseID from the excel sheet
			if (TestCaseID.isEmpty()) break; // Stop testing if there is no TestCaseID
			
			email = ExcelUtils.getCellData(r, 1).toString(); // Get email from the excel sheet
			password = ExcelUtils.getCellData(r, 2).toString(); // Get password from the excel sheet
			
			// Click on "Sign in with email"
			WebElement TabSignIn = driver.findElement(By.xpath("//*[@id=\"tab_signin\"]/span"));
			Thread.sleep(SHORT_DELAY);
			actions.moveToElement(TabSignIn).perform();
			Thread.sleep(SHORT_DELAY);
			driver.findElement(By.xpath("//*[@id=\"tabs-func\"]/li[1]/div/a[3]")).click();
			Thread.sleep(SHORT_DELAY);
			
			// Enter email
			driver.findElement(By.xpath("//*[@id=\"screen-login\"]/form/input[2]")).sendKeys(email);
			Thread.sleep(SHORT_DELAY);
			
			// enter password
			driver.findElement(By.xpath("//*[@id=\"screen-login\"]/form/input[3]")).sendKeys(password);
			Thread.sleep(SHORT_DELAY);
			
			// click Sign In
			driver.findElement(By.xpath("//*[@id=\"screen-login\"]/form/div[1]/input")).click();
			
			if (ExcelUtils.getCellData(r, 3).equals("positive")) { // If the test is supposed to be positive
				
				// try proceed with the test (the user should be logged in)
				try {
					// Go to user
					driver.findElement(By.xpath("//*[@id=\"tab_account\"]")).click(); // DOESN'T WORK
					Thread.sleep(SHORT_DELAY);
					// And Logout
					driver.findElement(By.cssSelector("#tabs-func > li.dropdown > div > a.si_menuitem_last")).click();
					Thread.sleep(SHORT_DELAY);
					ExcelUtils.setCellData("passed", "GREEN", r, 4); // The user is logged in, so the test is passed
				} catch (Exception e) {
					ExcelUtils.setCellData("failed", "RED", r, 4); // The user was not signed in, so the test is failed
				}
				
			}
			
			else // If the test supposed to be negative
			{
				//Try proceed with the test (an error message should occur)
				try {
				
					driver.findElement(By.xpath("//*[@id=\"screen-login\"]/form/div[1]")); //Just try to find an error message on the page
					ExcelUtils.setCellData("passed", "GREEN", r, 4); // An error message is found, so the test is passed
				} catch (Exception e) {
					ExcelUtils.setCellData("failed", "RED", r, 4); // An error message was not found, so the test is failed
				}
			}
			
			r++; // Go to the next row
		}
		
		driver.quit(); // Quit Chrome

	}

}
 