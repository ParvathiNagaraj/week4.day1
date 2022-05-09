package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentChittorgarh {

	public static void main(String[] args) {

		// Setting up Browser property
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://www.chittorgarh.com/");

		// Maximize web page
		driver.manage().window().maximize();

		// Implicit timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// finding stock market class and clicking
		driver.findElement(By.id("navbtn_stockmarket")).click();

		// finding NSE Bulk deals and clicking
		driver.findElement(By.linkText("NSE Bulk Deals")).click();

		// finding table and assigning to webelement
		WebElement table = driver
				.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']"));

		// finding all rows available under table
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Declaring SET to get all column data to avoid duplicates
		Set<String> set = new HashSet<String>();

		// Declaring new LIST to get all column data to compare and check duplicate is
		// available or not
		List<String> list = new ArrayList<String>();

		// Iterating through each row
		for (int i = 1; i < rows.size(); i++) {

			// finding columns under each row and assigning to list
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

			// printing SecurityName column alone
			System.out.println(cols.get(2).getText());

			// adding cols value to set to avoid duplicate values
			set.add(cols.get(2).getText());

			// adding cols value to list to compare and check duplicate valus is available
			// or not
			list.add(cols.get(2).getText());

		}

		System.out.println("=============================================================");

		// Ensuring duplicate value is present in securityNames column
		// if both size are same then print below statement
		if (set.size() == list.size()) {

			System.out.println("Duplicate values not available in SecurityNames column");
		}

		// if both size are not same then print below statement

		else {

			System.out.println("Duplicate values available in SecurityNames column");
		}

	}

}
