package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilmViewPage extends AnyPage {
	
	public boolean acceptNextAlert = true;
	
	public FilmViewPage(PageManager pages) {
		super(pages);
	}
	
  @FindBy(xpath = "//div[@class='maininfo_full']")
  private WebElement mainInfoField;
	
  @FindBy(css = "img[alt=\"Remove\"]")
  private WebElement removeButton;
  
    
  public String getFilmMainInfo() {
	  return mainInfoField.getText();
  }
    
  public FilmViewPage clickRemove() {
	  removeButton.click();
      return this;
  }
  
  public FilmViewPage ensurePageLoaded() {
	    super.ensurePageLoaded();
	    wait.until(presenceOfElementLocated(By.xpath("//div[@class='maininfo_full']")));
	    return this;
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
  
}
