package pomPage;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class DashboardPage {
	
WebDriver driver;
Actions act;
WebDriverWait wait;
		
	@FindBy(xpath="//frame[@title='Main Frame']") 
	private WebElement MainFrame;
	
	@FindBy(xpath="//iframe[@id='dashboard']") 
	private WebElement Dashboard;
	
	@FindBy(xpath="//iframe[@id='tabPage']") 
	private WebElement TabPage;
	
	@FindBy(xpath="//iframe[@id='zoneMapFrame_201']") 
	private WebElement ZoneMapFrame201;
	
	@FindBy(xpath="//iframe[@id='zoneMapFrame_1']") 
	private WebElement ZoneMapFrame1;
	
	@FindBy(xpath="//span[normalize-space()='Asset Query']") 
	private WebElement AssetQuery;
	
	@FindBy(xpath="//input[@id='badgeNumber']") 
	private WebElement BadgeNumberField;
	
	@FindBy(xpath="//span[@title='Go To Asset ']") 
	private WebElement GoToAsset;
	
	@FindBy(xpath="//input[@id='DELETE']") 
	private WebElement Delete;
	
	@FindBy(xpath="//input[@id='IM_OK']") 
	private WebElement Ok;
	
	
	
	
    public DashboardPage(WebDriver driver) {
    	
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    public void assetQueryClick() throws InterruptedException {
    	
    	driver.switchTo().frame(MainFrame);
    	driver.switchTo().frame(Dashboard);
    	driver.switchTo().frame(ZoneMapFrame201);
    	
    	AssetQuery.click();;
    	
    	
//    	Thread.sleep(1500);
//    	
//         act = new Actions(driver);
//    	
//    	act.sendKeys(Keys.ENTER).perform();
  
    }
    
    public void searchBadgeNumber(String Meter_Number) {
    	driver.switchTo().defaultContent();
    	driver.switchTo().frame(MainFrame);
    	driver.switchTo().frame(TabPage);
    	
    	BadgeNumberField.sendKeys(Meter_Number);
    	
    	 act = new Actions(driver);
    	 act.sendKeys(Keys.ENTER).perform();
    	 GoToAsset.click();
    	 
    }
    
    public void deleteInreceipt() throws InterruptedException {
    	driver.switchTo().defaultContent();
    	driver.switchTo().frame(MainFrame);
    	driver.switchTo().frame(TabPage);
    	driver.switchTo().frame(ZoneMapFrame1);
    	Delete.click();
    	
    	wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.numberOfWindowsToBe(2));

       String parentid2 = driver.getWindowHandle();
		
		System.out.println("parentid" +parentid2);
		
		Set<String> allwindowid2 = driver.getWindowHandles();
		
		System.out.println("All window id"+ allwindowid2);
		
		for(String winid:allwindowid2)
		{
			// to switch to the child id and perform the actions
			if(!(winid.equalsIgnoreCase(parentid2)))
			{
				driver.switchTo().window(winid);
				System.out.println(winid);
				Ok.click();
			}
			
		}
		
		Thread.sleep(1000);
		driver.switchTo().window(parentid2);
//		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
  	    wait.until(ExpectedConditions.alertIsPresent());
  	  
  	  driver.switchTo().alert().accept();
    
    	}
    }
    

 

