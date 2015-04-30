package ru.st.selenium.applogic2;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.model.Film;

public class FilmHelper2 extends DriverBasedHelper implements FilmHelper {

  public FilmHelper2(ApplicationManager2 manager) {
    super(manager.getWebDriver());
  }

  @Override
  public void create(Film film) {
    pages.addFilmPage.clickAddMovie()
    .ensurePageLoaded()
    .setFilmTitle(film.getTitle())
    .setYear(film.getYear())
    .setFilmDuration(film.getDuration())
    .setKnownAs(film.getKnownAs()).clickSubmit();
  }

  @Override
  public void isFilmCreated(Film film) {
	Assert.assertTrue(pages.filmViewPage.ensurePageLoaded().getFilmMainInfo().contains(film.getTitle()));
  }
  
  @Override
  public void delete(Film film) {
   pages.filmViewPage.ensurePageLoaded().clickRemove();
   Assert.assertTrue(pages.filmViewPage.closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
  }

  @Override
  public List<Film> search(String title) {
    pages.homePage.ensurePageLoaded().setSearchField(title).submitSearch();
    List<WebElement> elements = pages.homePage.getMovieBoxField();
    for (WebElement e : elements) {
  	  Assert.assertTrue(e.getText().contains(title));
    }
	return null;  
  }

}
