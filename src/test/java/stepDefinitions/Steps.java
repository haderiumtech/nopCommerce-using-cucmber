package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;


public class Steps {

	public WebDriver driver;
	public LoginPage lp;
	
	@Given("user lauch chrome browser")
	public void user_lauch_chrome_browser() {
	   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
	   driver=new ChromeDriver();
	   lp=new LoginPage(driver);
	}

	@When("user opens URL {string}")
	public void user_opens_url(String url) {
		driver.manage().window().maximize();
	    driver.get(url);
	}

	@When("user enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String Email, String Password) {
	   lp.setUserName(Email);
	   lp.setPassword(Password);
	}

	@When("click on login")
	public void click_on_login() {
	  lp.clickLogin();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
	   if(driver.getPageSource().contains("Login was unsuccessful")) {
		   driver.close();
		  assertTrue(false);
	   }else{
		  assertEquals(title, driver.getTitle());
	   }
	}

	@When("User Click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
	   lp.clickLogout();
	   Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
	   driver.close();
	}
}
