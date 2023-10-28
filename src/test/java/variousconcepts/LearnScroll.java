package variousconcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnScroll {
WebDriver driver;
	
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
	public void scrollUpDown() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor)driver; //type casting
		js.executeScript("scroll(0,2000)");
		Thread.sleep(2000);
		js.executeScript("scroll(0,0)");
		
		
	}
}
