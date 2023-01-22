package homework_ses9_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
// ++++++++++++++ Exercise 2.1 Web tables +++++++++++++++++++++++ 

		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.w3schools.com//html//html_tables.asp");
		
				
		int a = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr")).size(); // Number of rows in the table
		int b = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[1]/th")).size(); // Number of columns in the table
		
		
		for (int i = 2; i <= a; i++ ) {
			for (int j = 1; j <= b; j++) {
				System.out.println(driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[" + i + "]/td[" + j +"]")).getText());	// Print each cell (without header)	
			}
		}
		
		
		driver.quit();
		
// ++++++++++++++ Exercise 2.2 Two-dimensional arrays +++++++++++++++++++++++
		
		int [ ] [ ] ar = {   { 20, 18, 22, 20, 16 },
                { 18, 20, 18, 21, 20 },
                { 16, 18, 16, 20, 24 },
                {  25, 24, 22, 24, 25 }
            };

		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				System.out.println(ar[i][j]);
			}
				
		}
	}

}
