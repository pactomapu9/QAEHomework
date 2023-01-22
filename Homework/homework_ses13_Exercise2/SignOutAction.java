package homework_ses13_Exercise2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class SignOutAction {
	
	public static void Execute(WebDriver driver) throws Exception {
		
		// Logout
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(HomePage.LnkLoggedUser))).click();

		try {
		HomePage.lnkLogOut(driver).click();
		Reporter.log("Step 6 - Click Logout - PASSED");
		} catch(org.openqa.selenium.TimeoutException e) {
			Reporter.log("Step 6 - Click Logout - took longer than 5 seconds - FAIL");
		}
		
	}
}
