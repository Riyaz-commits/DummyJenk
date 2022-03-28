package SDET.SeleniumTraining;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseCl {

	public static WebDriver driver;
	public static Properties prop;


		public TestBaseCl()
		{

			try {
				prop = new Properties();
			//	FileInputStream fis = new FileInputStream("C:\\Users\\RIYAZ BASHA SHAIK\\2022\\HybridFrameworkRepo-master\\src\\main\\java\\com\\orangehrm\\qa\\config\\config.properties");
				FileInputStream fis = new FileInputStream(".\\Resources\\Testdata.properties");
				prop.load(fis);
			}
			catch(FileNotFoundException e){

				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}


	public static WebDriver initialization()
	{
		/*
		 * String browsername = prop.getProperty("browser");
		 * 
		 * if(browsername.equalsIgnoreCase("chrome")) { System.setProperty(
		 * "webdriver.chrome.driver","C:\\Users\\RIYAZ BASHA SHAIK\\2022\\HybridFrameworkRepo-master\\src\\main\\java\\com\\orangehrm\\qa\\util\\chromedriver.exe"
		 * );
		 * 
		 * driver = new ChromeDriver();
		 * 
		 * } else if(browsername.equalsIgnoreCase("firefox")) {
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\Users\\riyshaik\\eclipsePersonal\\SeleniumProject\\src\\main\\java\\com\\orangehrm\\qa\\util\\deckodriver.exe"
		 * ); driver = new FirefoxDriver(); }
		 * 
		 * e_driver= new EventFiringWebDriver(driver);
		 * 
		 * wbListener= new WebEventListener(); e_driver.register(wbListener);
		 * driver=e_driver;
		 */
		/*if (System.getProperty("browser").equalsIgnoreCase("Chrome")) {*/
			
		//	System.setProperty("webdriver.chrome.driver",".\\src\\main\\java\\com\\orangehrm\\qa\\util\\chromedriver.exe");
			ChromeOptions handlingSSL = new ChromeOptions();

			//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
			handlingSSL.setAcceptInsecureCerts(true);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(handlingSSL);
			//driver = new ChromeDriver(handlingSSL);
			/*
			 * } else if (System.getProperty("browser").equalsIgnoreCase("Firefox")) {
			 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); }
			 * else if (System.getProperty("browser").equalsIgnoreCase("IE")) {
			 * WebDriverManager.iedriver().setup(); InternetExplorerOptions capabilities =
			 * new InternetExplorerOptions(); capabilities.ignoreZoomSettings(); driver =
			 * new InternetExplorerDriver(capabilities);
			 * 
			 * } else if (System.getProperty("browser").equalsIgnoreCase("Edge")) {
			 * WebDriverManager.edgedriver().setup(); driver = new EdgeDriver(); }
			 */
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		return driver;
	}

	
}
