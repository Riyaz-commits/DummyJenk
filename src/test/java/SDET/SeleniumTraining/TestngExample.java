package SDET.SeleniumTraining;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngExample extends TestBaseCl {

	
	public WebDriver driver;
	
	@Test
	public void PassEmail()
	{
		System.out.println("Test Method1");
	//	driver.findElement(By.xpath("//input[@class='home-tril-email']")).sendKeys("RiyazBasha@gmail.com");
		
	}
	@Test
	public void MousehoverOragne()
	{
		System.out.println("Test Method 2");
		/*
		 * WebElement why =
		 * driver.findElement(By.xpath("//a[contains(text(),'Why OrangeHRM ')]"));
		 * 
		 * 
		 * Actions a = new Actions(driver);
		 * a.moveToElement(why).click().build().perform();
		 */
		
	}
	@Test
	public void m3()
	{
		System.out.println("Test Method 3");
	}
	@AfterMethod
	public void After()
	{
		System.out.println("Executing After every test case");
	
	}
	
	@BeforeMethod
	public void before() throws IOException
	{
		System.out.println("Executing before every test case");
		initialization();
	}
}
