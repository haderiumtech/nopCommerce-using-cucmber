package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver webDriver ) {
		driver= webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(id="Email") @CacheLookup WebElement userEmail;
	@FindBy(id="Password") @CacheLookup WebElement userPassword;
	@FindBy(xpath="//*[contains(text(),'Log in')]") @CacheLookup WebElement loginBtn;
	@FindBy(linkText="Logout") @CacheLookup WebElement logoutBtn;
	
	
	public void setUserName(String Email) {
		userEmail.clear();
		userEmail.sendKeys(Email);
	}
	public void setPassword(String Password) {
		userPassword.clear();
		userPassword.sendKeys(Password);
	}
	public void clickLogin() {
		loginBtn.click();
	}
	public void clickLogout() {
		logoutBtn.click();
	}

}
