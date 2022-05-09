package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentTwo {

	public static void main(String[] args) {

		// Setting up Browser property
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://html.com/tags/table/");

		// Maximize web page
		driver.manage().window().maximize();

		// Implicit timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// finding table and assigning to webelement
		WebElement table = driver.findElement(By.xpath("//table[@class='attributes-list']"));

		// finding all rows available under table
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// printing the No.of.Rows
		System.out.println("The Total No.of.Rows = " + rows.size());

		// Getting the columns available under second row
		List<WebElement> cols = rows.get(1).findElements(By.tagName("td"));

		// printing the size of columns

		System.out.println("The Total No.of.columns = " + cols.size());

		/*
		 * OR //Getting the columns available under first row List <WebElement> cols1 =
		 * rows.get(0).findElements(By.tagName("th"));
		 * 
		 * //printing the size of columns System.out.println("The Total No.of.Columns "
		 * + cols1.size());
		 */
	}

}
