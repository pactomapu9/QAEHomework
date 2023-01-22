package homework_ses13_Exercise2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
	
    private static String txtbxEmail = "#screen-login > form > input:nth-child(2)";
    private static String txtbxPassword = "#screen-login > form > input:nth-child(4)";
    private static String btnLogin = "#screen-login > form > div:nth-child(6) > input";
    
    // Email textbox method
    public static WebElement txtbxEmail(WebDriver driver){
 	   return LocatorUtils.findElement(driver, "css", txtbxEmail); 
    }

    // Password textbox method
    public static WebElement txtbxPassword(WebDriver driver){
    	return LocatorUtils.findElement(driver, "css", txtbxPassword);
    }

    // Login button method
    public static WebElement btnLogin(WebDriver driver){
       return LocatorUtils.findElement(driver, "css", btnLogin);

    }
    
}
