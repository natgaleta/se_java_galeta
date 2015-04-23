package galetaGroup;

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

	public void login (String name, String password)
	{
		driver.get(baseUrl + "/php4dvd/");
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

}
