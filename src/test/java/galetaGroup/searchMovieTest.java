package galetaGroup;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchMovieTest extends galetaGroup.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testUntitled() throws Exception {
	  driver.get(baseUrl + "/php4dvd/");
	  Helper hlp = new Helper(driver, baseUrl);
	  
	  //login
	  hlp.login("admin", "admin");
	  
	  //not empty result
      driver.findElement(By.id("q")).clear();
      driver.findElement(By.id("q")).sendKeys("Friends_111");
      driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
      
      hlp.isElementPresent(By.xpath("//div[@alt='Friends_111']")); 
      List<WebElement> elements = driver.findElements(By.xpath("//div[@alt='Friends_111']"));
            
      //empty result
      driver.findElement(By.id("q")).clear();
      driver.findElement(By.id("q")).sendKeys("Movie_that_defenitely_gives_empty_result");
      driver.findElement(By.id("q")).sendKeys(Keys.ENTER);    
      hlp.isElementNotPresent(By.xpath("//div[@alt='Movie_that_defenitely_gives_empty_result']"));
      String textInfo = driver.findElement(By.xpath("//div[@class='content']")).getText();
      Assert.assertTrue(textInfo.contains("No movies where found."), "Empty result is shown incorrectly");
  }

  
}
