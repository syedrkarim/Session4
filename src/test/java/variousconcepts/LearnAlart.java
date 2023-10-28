package variousconcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class LearnAlart {

WebDriver driver;
	
	@Before
	public void initDriver() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test
	public void handlingAlart() {
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		String alartText=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alartText);
		
		
	}
	
	
}
