package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDropDown {

	public static void main(String[] args) {

		// Setting up Browser property
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("http://leaftaps.com/opentaps/control/login");

		// Maximize web page
		driver.manage().window().maximize();

		// locating username by id locator and sending keys
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		// locating password by id locator and sending keys
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// locating submit using classname and login
		driver.findElement(By.className("decorativeSubmit")).click();

		// clicking on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// clicking on Leads link
		driver.findElement(By.linkText("Leads")).click();

		// clicking on Create Lead Link
		driver.findElement(By.linkText("Create Lead")).click();

		// declaring webelement for Industry dropdown
		WebElement element1 = driver.findElement(By.id("createLeadForm_industryEnumId"));

		// accessing the select class for webelement
		Select select = new Select(element1);

		// getting options under industry dropdown using getoptions method
		List<WebElement> options = select.getOptions();

		System.out.println("The options available under Industry dropdown");
		System.out.println("==============================================");

		// iterating through each value
		for (WebElement eachoption : options) {

			// printing each options
			System.out.println(eachoption.getText());
		}

		// declaring webelement for Ownership dropdown
		WebElement element2 = driver.findElement(By.id("createLeadForm_ownershipEnumId"));

		// accessing the select class for webelement
		Select select1 = new Select(element2);

		// getting options under ownership dropdown using getoptions method
		List<WebElement> options1 = select1.getOptions();

		// selecting last option in ownership dropdown
		select1.selectByIndex(options1.size() - 1);

	}

}
