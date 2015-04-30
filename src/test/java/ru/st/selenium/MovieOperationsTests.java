package ru.st.selenium;


import org.testng.annotations.*;
import ru.st.selenium.model.Film;
import ru.st.selenium.model.User;

public class MovieOperationsTests extends ru.st.selenium.pages.TestBase {
  
  @BeforeMethod
  public void login() throws Exception {
	  if (app.getUserHelper().isNotLoggedIn()) {
		  User user = new User().setLogin("admin").setPassword("admin");
		  app.getUserHelper().loginAs(user);
		  //assertTrue(app.getUserHelper().isLoggedInAs(user));
	    }
	  return;	 
  }
  
  @Test 
  public void testAddAndRemoveMovie() throws Exception {
	    Film film = new Film()
	    .setTitle("Friends")
	    .setKnownAs("Famous Film")
	    .setYear("2000")
	    .setDuration("500");
	    app.getFilmHelper().create(film);
	    app.getFilmHelper().isFilmCreated(film);
	    app.getFilmHelper().delete(film);	    
  }
  
  @Test
  public void testSearchMovie() throws Exception {
	  app.getFilmHelper().search("Friends_111");
	  app.getFilmHelper().search("Movie_that_defenitely_gives_empty_result");
  }
  
  
  
}
