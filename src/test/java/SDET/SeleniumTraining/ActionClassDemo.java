package SDET.SeleniumTraining;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClassDemo {
	public static Properties prop;
	public static WebDriver driver;
	
	@Test
	public  void FlowTest() throws InterruptedException, IOException {
		FileInputStream fis = new FileInputStream(".\\Resources\\Testdata.properties");
		System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "default-src * 'unsafe-inline' 'unsafe-eval'; script-src * 'unsafe-inline' 'unsafe-eval'; connect-src * 'unsafe-inline'; img-src * data: blob: 'unsafe-inline'; frame-src *; style-src * 'unsafe-inline';");

		Properties prop = new Properties();
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
			WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");  
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

	//	FileInputStream fis = new FileInputStream("C:\\Users\\RIYAZ BASHA SHAIK\\2022\\SeleniumTraining\\Resources\\Testdata.properties");
		


		

		String PropUrl =    prop.getProperty("url");

		System.out.println(PropUrl);

		driver.get(PropUrl);

		JavascriptExecutor je = (JavascriptExecutor) driver;

		WebElement element =
				driver.findElement(By.xpath("//a[contains(text(),' Press Releases')]"));



		// now execute query which actually will scroll until that element is not //
		

		je.executeScript("arguments[0].scrollIntoView(true);",element);

		/*
		 * WebDriverWait wait = new WebDriverWait(driver,1000);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//div[contains(text(),'COMPOSE')]")));
		 */
		
		je.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;')"
						,element);

				TakesScreenshot scrShot =((TakesScreenshot)driver);

				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

				//Move image file to new destination
				// creating an object of Random class   
				Random random = new Random();   
				// Generates random integers 0 to 49  
				int x = random.nextInt(500000); 
				File DestFile=new
						File(".\\target\\Screenshots\\scrnshotNew"+x+".png"
								);

				//Copy file at destination

				FileUtils.copyFile(SrcFile, DestFile);


				driver.quit();


	}

}
