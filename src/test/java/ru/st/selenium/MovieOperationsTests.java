package ru.st.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MovieOperationsTests extends ru.st.selenium.pages.TestBase {
  
  private StringBuffer verificationErrors = new StringBuffer();
  
  @Test
  public void testAddMovie() throws Exception {
	  
	  driver.get(baseUrl + "/php4dvd/");
	  ApplicationManager hlp = new ApplicationManager(driver, baseUrl);
	  
	  //login
	  hlp.login("admin", "admin");  
      
	  //invalid data
	  Assert.assertTrue(hlp.isElementPresent(By.cssSelector("img[alt=\"Add movie\"]")));
      driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
      Assert.assertTrue(hlp.isElementPresent(By.cssSelector("img[alt=\"Save\"]"))); 
      driver.findElement(By.name("name")).clear();
      driver.findElement(By.name("name")).sendKeys("Friends_111");
      driver.findElement(By.name("aka")).clear();
      driver.findElement(By.name("aka")).sendKeys("new");
      driver.findElement(By.name("duration")).clear();
      driver.findElement(By.name("duration")).sendKeys("65");
      driver.findElement(By.name("rating")).clear();
      driver.findElement(By.name("rating")).sendKeys("5");
      driver.findElement(By.id("seen_no")).click();
      driver.findElement(By.name("notes")).clear();
      driver.findElement(By.name("notes")).sendKeys("notes");
      driver.findElement(By.id("text_languages_0")).clear();
      driver.findElement(By.id("text_languages_0")).sendKeys("en");
      driver.findElement(By.name("country")).clear();
      driver.findElement(By.name("country")).sendKeys("RU");
      driver.findElement(By.id("submit")).click();
      Assert.assertTrue(hlp.isElementPresent(By.xpath("//input[@class='required digits error']")));
      
      //add data to make it valid
      driver.findElement(By.name("year")).clear();
      driver.findElement(By.name("year")).sendKeys("2015");
      driver.findElement(By.id("submit")).click();
      Assert.assertTrue(hlp.isElementPresent(By.xpath("//div[@class='maininfo_full']")));  
      String textInfo = driver.findElement(By.xpath("//div[@class='maininfo_full']")).getText();
      Assert.assertTrue(textInfo.contains("Friends_111"), "Movie wasn't found");
      
      //logout
      hlp.logout();
  }
  
  @Test
  public void testRemoveMovie() throws Exception {
	  
	  driver.get(baseUrl + "/php4dvd/");
	  ApplicationManager hlp = new ApplicationManager(driver, baseUrl);
	  
	  //login
	  hlp.login("admin", "admin"); 
	  
      //remove movie 
      driver.findElement(By.xpath("//div[@alt='Friends_111']")).click();
      driver.findElement(By.cssSelector("img[alt=\"Remove\"]")).click();
      Assert.assertTrue(hlp.closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
          
      //logout
      hlp.logout();
  }
}
