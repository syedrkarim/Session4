package variousconcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;


public class LearnDropdown {
	WebDriver driver;
	
	By USERNAME= By.xpath("//*[@id=\"username\"]");
	By PASSWORD=By.xpath("//*[@id=\"password\"]");
	By LOGIN= By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DASHBOARD=By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	By CUSTOMER=By.xpath("//span[contains(text(),'Customers')]");
	By ADDCUSTOMER=By.xpath("//a[contains(text(),'Add Customer')]");
	By FULLNAME=By.xpath("//*[@id=\"account\"]");
	
	
	@Before
	public void initDriver() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test
	public void loginTest() {
		
		driver.findElement(USERNAME).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD).sendKeys("abc123");
		driver.findElement(LOGIN).click();
		String dashBoard=driver.findElement(DASHBOARD).getText();
		
		//Assert.assertEquals("Page not found", "Dashboard",dashBoard );
		Assert.assertEquals("Page not found", "Dashboard- iBilling", driver.getTitle());
	
	}
	@Test
	public void addCustomer() {
		loginTest();
		driver.findElement(CUSTOMER).click();
		driver.findElement(ADDCUSTOMER).click();
		driver.findElement(FULLNAME).sendKeys("selenium java");
		WebElement dd=driver.findElement(By.xpath("//select[@id='cid']"));
		Select sel= new Select(dd);
		sel.selectByVisibleText("Techfios");
		
	}
	
	
	/*@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}*/
	
	
	
	

}
