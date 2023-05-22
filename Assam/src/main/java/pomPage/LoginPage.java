package pomPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	Properties prop;
	
	@FindBy(xpath="//input[@id='userId']") 
	private WebElement username;
	
	@FindBy(xpath="//input[@id='password']") 
	private WebElement password;
	
	@FindBy(xpath="//input[@id='loginButton']") 
	private WebElement loginButton;

	
    public LoginPage(WebDriver driver) {
    	
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    public void loginToApp() throws IOException {
    	prop = new Properties();
    	String ConfigFileData = System.getProperty("user.dir")+"\\config.properties";
    	FileInputStream fis = new FileInputStream(ConfigFileData);
     	prop.load(fis);
    	
    	username.sendKeys(prop.getProperty("user"));
    	
    	password.sendKeys(prop.getProperty("pwd"));
    	
    	loginButton.click();
    }
}
