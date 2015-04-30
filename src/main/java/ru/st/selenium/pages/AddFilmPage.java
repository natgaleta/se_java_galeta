package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddFilmPage extends AnyPage {

	public AddFilmPage(PageManager pages) {
		super(pages);
	}
	
  @FindBy(name = "name")
  private WebElement filmTitleField;
	
  @FindBy(name = "aka")
  private WebElement knownAsField;
  
  @FindBy(name = "duration")
  private WebElement durationField;
  
  @FindBy(name = "year")
  private WebElement yearField;
  
  @FindBy(id = "submit")
  private WebElement submitButton;
  
  @FindBy(css = "img[alt=\"Add movie\"]")
  private WebElement addMovie;
   
  @FindBy(xpath = "//input[@class='required digits error']")
  private WebElement errorRequiredDigits;
  
  public AddFilmPage setFilmTitle(String text) {
	  filmTitleField.sendKeys(text);
      return this;
  }
  
  public AddFilmPage setKnownAs(String text) {
	  knownAsField.sendKeys(text);
      return this;
  }
  
  public String getErrorText() {
	  return errorRequiredDigits.getText();
  }
  
  public AddFilmPage setYear(String text) {
	  yearField.sendKeys(text);
      return this;
  }
  
  public AddFilmPage setFilmDuration(String text) {
	  durationField.sendKeys(text);
      return this;
  }
  
  public AddFilmPage clickSubmit() {
	  submitButton.click();
      return this;
  }
  
  public AddFilmPage clickAddMovie() {
	  addMovie.click();
      return this;
  }

  public AddFilmPage ensurePageLoaded() {
	    super.ensurePageLoaded();
	    wait.until(presenceOfElementLocated(By.id("imdbsearch")));
	    return this;
	  }
}
