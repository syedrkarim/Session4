package variousconcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnMouseHover {

	WebDriver driver;
	By USERNAME= By.xpath("//*[@id=\"username\"]");
	By PASSWORD=By.xpath("//*[@id=\"password\"]");
		
		@Before
		public void initDriver() {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.dell.com/en-us");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		
		@Test
		public void mouseHover() {
			
			
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Products')]"))).build().perform();
			driver.findElement(By.xpath("//a[text()='Networking']")).click();
			
		
		}
}
