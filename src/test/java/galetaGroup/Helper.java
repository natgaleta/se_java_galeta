package galetaGroup;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	
	protected WebDriver driver;
	protected String baseUrl;
		
	public Helper(WebDriver driver, String baseUrl) {
		super();
		this.driver = driver;
		this.baseUrl = baseUrl;
	}
	public boolean acceptNextAlert = true;
	
	public void login (String name, String password)
	{
		isElementPresent(By.name("submit"));
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		isElementPresent(By.linkText("My profile"));
	}
	
    public boolean isElementPresent(By by) {
		    try {
		    	WebDriverWait wait = new WebDriverWait(driver, 30);
		    	wait.until(ExpectedConditions.presenceOfElementLocated(by));
		        return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
	}

    public boolean isElementNotPresent(By by) {
	    try {
	    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	 driver.findElement(by);
	        return false;
	    } catch (NoSuchElementException e) {
	      return true;
	    }
    }
    
    public String closeAlertAndGetItsText() {
        try {
          Alert alert = driver.switchTo().alert();
          String alertText = alert.getText();
          if (acceptNextAlert) {
            alert.accept();
          } else {
            alert.dismiss();
          }
          return alertText;
        } finally {
          acceptNextAlert = true;
        }
      }
    
    public void logout ()
	{
		isElementPresent(By.linkText("Log out"));
		driver.findElement(By.linkText("Log out")).click();
	    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to log out[\\s\\S]$"));
	    isElementPresent(By.name("submit"));
	}

}
