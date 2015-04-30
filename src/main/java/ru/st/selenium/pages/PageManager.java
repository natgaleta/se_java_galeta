package ru.st.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageManager {

  private WebDriver driver;

  public LoginPage loginPage;
  public AddFilmPage addFilmPage;
  public FilmViewPage filmViewPage;
  public HomePage homePage;
  public InternalPage internalPage;
  public UserProfilePage userProfilePage;
  public UserManagementPage userManagementPage;

  public PageManager(WebDriver driver) {
    this.driver = driver;
    loginPage = initElements(new LoginPage(this));
    addFilmPage = initElements(new AddFilmPage(this));
    homePage = initElements(new HomePage(this));
    filmViewPage = initElements(new FilmViewPage(this));
    internalPage = initElements(new InternalPage(this));
    userProfilePage = initElements(new UserProfilePage(this));
    userManagementPage = initElements(new UserManagementPage(this));
  }
  
  private <T extends Page> T initElements(T page) {
    //PageFactory.initElements(driver, page);
    //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), page);
    PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 10), page);
    return page;
  }
  
  public WebDriver getWebDriver() {
    return driver;
  }

}
