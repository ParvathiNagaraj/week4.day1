package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassroomSession {

	public static void main(String[] args) {

		// Setting up Browser property
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://erail.in/");

		// Maximize web page
		driver.manage().window().maximize();

		// Implicit timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Finding From class and clearing data
		driver.findElement(By.id("txtStationFrom")).clear();

		// Sending values to From field
		driver.findElement(By.id("txtStationFrom")).sendKeys("MDU", Keys.TAB);

		// Finding To class and clearing data
		driver.findElement(By.id("txtStationTo")).clear();

		// Sending values to TO field
		driver.findElement(By.id("txtStationTo")).sendKeys("TPJ", Keys.TAB);

		// Unchecking sortonData field
		driver.findElement(By.id("chkSelectDateOnly")).click();

		// We can use below xpath instead of finding tr and td tag seperately
		// WebElement table1 = driver.findElement(By.xpath("//table[@class='DataTable
		// TrainList TrainListHeader']//tr/td[2]"));

		// finding table and assigning to webelement
		WebElement table = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));

		// finding rows available under table and assigning to list
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// iterating through each rows
		for (int i = 0; i < rows.size(); i++) {

			// finding columns available under each rows and assigning to list
			List<WebElement> col = rows.get(i).findElements(By.tagName("td"));

			// printing particular columns
			System.out.println(
					"Train Number = " + col.get(0).getText() + " and " + "Train Name = " + col.get(1).getText());

		}

	}

}
