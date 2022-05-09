package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentThree {

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
		WebElement table = driver.findElement(By.xpath("//table"));

		//finding each rows under table and assigning to webelement
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		//iterating through each rows to get columns
		for (int i = 0; i < rows.size(); i++) {

			//finding each columns under rows and assigning to webelement
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

			//iterating through each column to get values
			for (int j = 0; j < cols.size(); j++) {

				System.out.println(cols.get(j).getText());
			}
		}

	}

}
