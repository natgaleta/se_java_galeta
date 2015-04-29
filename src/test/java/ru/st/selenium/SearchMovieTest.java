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
import java.util.List;

public class SearchMovieTest extends ru.st.selenium.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testSearchMovie() throws Exception {
	  driver.get(baseUrl + "/php4dvd/");
	  ApplicationManager hlp = new ApplicationManager(driver, baseUrl);
	  
	  //login
	  hlp.login("admin", "admin");
	  
	  //not empty result
      driver.findElement(By.id("q")).clear();
      driver.findElement(By.id("q")).sendKeys("Friends_111");
      driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
      assertTrue(hlp.isElementPresent(By.xpath("//div[@alt='Friends_111']"))); 
      List<WebElement> elements = driver.findElements(By.xpath("//div[@class='movie_box']"));
      for (int i=0;i<elements.size();i++) {
    	  elements.get(i).findElement(By.xpath("//div[@alt='Friends_111']"));
      }
            
      //empty result
      driver.findElement(By.id("q")).clear();
      driver.findElement(By.id("q")).sendKeys("Movie_that_defenitely_gives_empty_result");
      driver.findElement(By.id("q")).sendKeys(Keys.ENTER);    
      assertFalse(hlp.isElementPresent(By.xpath("//div[@class='movie_box']")));
      String textInfo = driver.findElement(By.xpath("//div[@class='content']")).getText();
      Assert.assertTrue(textInfo.contains("No movies where found."), "Empty result is shown incorrectly");
  }

  
}
