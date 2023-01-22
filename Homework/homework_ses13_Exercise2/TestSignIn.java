package homework_ses13_Exercise2;

import java.time.Duration;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestSignIn {   
		
		WebDriver driver;
		Logger Log;

@DataProvider (name = "LoginInformation")
	public static Object[][] LoginData() throws Exception{
		Object[][] logindata = ExcelUtils.getTableArray(Constant.Path_TestData + Constant.File_TestData,Constant.Sheet_TestData);
		return logindata ;	
	}
	
@BeforeClass
	public void setup() throws Exception{
	
		// Set excel file and logger
		Log = Logger.getLogger(TestSignIn.class.getName());
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,Constant.Sheet_TestData);
		DOMConfigurator.configure("log4j.xml");
		
		// Create new instance of Chrome driver
		driver = new ChromeDriver();
	    Log.info("Create a new instance of Chrome driver");
		driver.manage().window().maximize();
		Log.info("Maximize window");
		
		// Set timeouts
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

		
@AfterClass
	public void Quit() {

		// Close Chrome browser
		driver.quit();
		Log.info("Browser closed");
	}


@Test (dataProvider = "LoginInformation")
	public void LogIn_and_Out(String username, String password, String rowNumber) throws Exception{
		
			String result = "PASSED";
			boolean failFlag = false;
			LogParams(username, password);
			failFlag = Navigate();
				if (failFlag) {
					result = "FAILED";
					SaveData(rowNumber, result);
					throw new Exception("Navigation tooked more than 5 seconds --> FAIL");
				}
			failFlag = LogIn(username, password, rowNumber);
				if (failFlag) {
					result = "FAILED";
					SaveData(rowNumber, result);
					throw new Exception("Login failed --> FAIL");
				}
			failFlag = LogOut();
				if (failFlag) {
					result = "FAILED";
					SaveData(rowNumber, result);
					throw new Exception("Logout failed --> FAIL");
				}
			SaveData(rowNumber, result);
	}


private void LogParams(String username, String password) {
	Log.info("Email: " + username + "; Password: " + password);
}


private boolean Navigate() {
	
	boolean failFlag = false;
    // Navigate the page
    try {
    	driver.navigate().to(Constant.URL);
		Log.info("Launch " + Constant.URL);
    } catch (org.openqa.selenium.TimeoutException e) {
    	Log.info("Launch of " + Constant.URL + "took longer than 5 seconds - FAIL");
    	failFlag = true;
    	return failFlag;
    }
    return failFlag;
}


private boolean LogIn(String username, String password, String notused) {
    // Click SignIn
	boolean failFlag = false;

    // Sign in with email and password
    try {
    	SignInAction.Execute(driver, username, password);
    	Log.info("Login and password entered and submitted");
    } catch (Exception e) {
    	Log.info("Something wrong on SignIn page while entering email and password");
    	failFlag = true;
    	return failFlag;
    }
    return failFlag;
}


private boolean LogOut() {

	boolean failFlag = false;
	// Sign out
	try {
		SignOutAction.Execute(driver);
	    Log.info("Logged out");
	} catch (Exception e) {
	    Log.info("Something went wrong while logging out");
	    return failFlag = true;
	}
	return failFlag;
}


private void SaveData(String rowNumber, String result) {

	int currentrow = Integer.parseInt(rowNumber);

	//Save the result of the test to excel
	Log.info("Test " + result);
	Log.info("Trying to save the results of testing in TestData.xlsx file");
	try {
		ExcelUtils.setCellData(result, currentrow, 3); // The user is logged in, so the test is passed
		Log.info("Result is saved in TestData.xlsx file");
	} catch (Exception e) {
		Log.info("Saving to TestData.xlsx failed");
	}
	
}
		
}
