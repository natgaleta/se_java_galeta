package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ru.st.selenium.model.Film;

public class HomePage extends AnyPage {
	
	public boolean acceptNextAlert = true;
	
	public HomePage(PageManager pages) {
		super(pages);
	}
	
  @FindBy(id = "q")
  private WebElement searchField;
	
  @FindBy(xpath = "//div[@class='movie_cover']")
  private List<WebElement> movieBox;
  
  public HomePage setSearchField(String text) {
	  searchField.sendKeys(text);
      return this;
  }
  
  public List<WebElement> getMovieBoxField() {
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='movie_box']")));
	  return movieBox;
  }
  
  public HomePage submitSearch() {
	  searchField.sendKeys(Keys.ENTER);
      return this;
  }
  
  public HomePage ensurePageLoaded() {
	    super.ensurePageLoaded();
	    wait.until(presenceOfElementLocated(By.id("q")));
	    return this;
  }
  
}
