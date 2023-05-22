package pomTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomPage.DashboardPage;
import pomPage.LoginPage;

public class BaseTest {
	
	public static WebDriver driver;
	
	LoginPage lp;
	DashboardPage db;
	
	@BeforeSuite
	public void initBrowser() {
		
		WebDriverManager.chromedriver().setup();
		
		//System.setProperty("webdriver.chrome.driver", "D:\\data\\Software\\chromedriver_win32 (1)\\chromedriver.exe");
				
	//	System.setProperty("webdriver.gecko.driver", "D:\\data\\Software\\geckodriver-v0.33.0-win32\\geckodriver.exe");
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--remote-allow-origins=*");
         options.addArguments("--start-maximized");
		 driver = new ChromeDriver(options);
		//driver = new FirefoxDriver();
		
	//	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://141.148.208.161:8002/ouaf/loginPage.jsp");
		driver.findElement(By.xpath("//*[@id='details-button']")).click();
		driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
		
			
	}
	
	
	@BeforeClass
	public void createObject() {
		lp = new LoginPage(driver);
		db = new DashboardPage(driver);
	
	}
 //   @AfterSuite
//    public void closeBrowser() {
//    	driver.quit();
//    }
}
