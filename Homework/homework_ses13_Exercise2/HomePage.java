package homework_ses13_Exercise2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
    public static String lnkSignIn = "tab_signin";
    public static String lnkEmail = "#tabs-func > li.dropdown > div > a.si_menuitem_last";
    public static String LnkLoggedUser = "tab_account";
    public static String linkLogOut = "#tabs-func > li.dropdown > div > a.si_menuitem_last";
    
    public static String ExpectedTitle = "Time Converter and World Clock - Conversion at a Glance - Pick best time to schedule conference calls, webinars, online meetings and phone calls.";
  
    // Sign In link method
    public static WebElement lnkSignIn(WebDriver driver){
 	   return LocatorUtils.findElement(driver, "id", lnkSignIn);  	   
    }
 	   
 	// Sign In with Email link
    public static WebElement lnkEmail(WebDriver driver){
 	 	 return LocatorUtils.findElement(driver, "css", lnkEmail);  
 	}
    
 	// Logout
    public static WebElement lnkLogOut(WebDriver driver){
 	 	 return LocatorUtils.findElement(driver, "css", linkLogOut);  
 	}
 
}
