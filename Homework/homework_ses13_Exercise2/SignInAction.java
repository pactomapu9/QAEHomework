package homework_ses13_Exercise2;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


public class SignInAction {
	
	public static void Execute(WebDriver driver, String sUsername, String sPassword) throws Exception{
		// Click Sign In link
		HomePage.lnkSignIn(driver).click();
		Reporter.log("Step 1 - Click Sign In link - PASSED");

		// Click Sign In with Email link
		HomePage.lnkEmail(driver).click();
		Reporter.log("Step 2 - Click Sign In with Email link - PASSED");

		// Enter email address
		SignInPage.txtbxEmail(driver).sendKeys(sUsername);
		Reporter.log("Step 3 - Enter email address - PASSED");

		// Enter password
		SignInPage.txtbxPassword(driver).sendKeys(sPassword);
		Reporter.log("Step 4 - Enter password - PASSED");

		// Click SignIn button
		SignInPage.btnLogin(driver).click();
		Reporter.log("Step 5 - Click SignIn button - PASSED");

	}
}
