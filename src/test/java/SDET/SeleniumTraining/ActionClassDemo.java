package SDET.SeleniumTraining;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClassDemo {
	public static Properties prop;
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		FileInputStream fis = new FileInputStream(".\\Resources\\Testdata.properties");
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

				File DestFile=new
						File(".\\target\\scrnshotNew.png"
								);

				//Copy file at destination

				FileUtils.copyFile(SrcFile, DestFile);


				driver.quit();


	}

}
