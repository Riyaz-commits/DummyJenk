package SDET.SeleniumTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");  
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://www.orangehrm.com/");

       Thread.sleep(3000);
       
       driver.findElement(By.xpath("//a[@class='btn-orange trial-btn pulse ']")).click();
       
       Thread.sleep(5000);
       driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Riyaz Basha");
       driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Shaik");
       driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("riyaz@gmail.com");
       
  WebElement dropdownxapth =     driver.findElement(By.xpath("//select[@id='Form_submitForm_Country']"));
        Select s = new Select(dropdownxapth);
        s.selectByVisibleText("Brazil");
        
        Thread.sleep(1000);
    
       
    }
}
