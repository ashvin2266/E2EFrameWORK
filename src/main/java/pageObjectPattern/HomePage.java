package pageObjectPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import base.Base;

public class HomePage extends Base{
	
	@FindBy(id="user_email")
	WebElement email;
	@FindBy(id="user_password")
	WebElement Password;
	@FindBy(xpath="//input[@name='commit']")
	WebElement loginBtn;
	
	
	
	
	  
	 
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);// TODO Auto-generated constructor stub
	}


	public void getEmail(String username) {
		email.sendKeys(username);
	}
	public void getpassword(String password) {
		Password.sendKeys(password);
	}
	public void clicklogin() {
		loginBtn.click();
	}
	
	
	

}
