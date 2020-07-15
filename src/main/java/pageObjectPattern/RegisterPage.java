package pageObjectPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Base;

public class RegisterPage extends Base {

	
	@FindBy(id="user_name")
	WebElement fullName;
	@FindBy(id="user_email")
	WebElement emailId;
	@FindBy(name="user[password]")
	WebElement password;
	@FindBy(id="user_password_confirmation")
	WebElement confirmPass;
	@FindBy(id="user[unsubscribe_from_marketing_emails]")
	WebElement msglink;
	@FindBy(id="user_agreed_to_terms")
	WebElement termCondition;
	@FindBy(name="commit")
	WebElement signUpbtn;
	@FindBy(linkText="Log In with a School Account")
	WebElement schoolAC;
	@FindBy(xpath="//a[@class='navbar-brand header-logo']")
	WebElement pageLogo;
	@FindBy(xpath="//div[@class='alert alert-danger alert-registration-page']/ul")
	WebElement errorMSG;
	
	
	
	public RegisterPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	public void verifyPage() {
		
		String title= driver.getTitle();
	System.out.println(title);
		Assert.assertEquals(title,"Rahul Shetty Academy");
		String Actualurl=driver.getCurrentUrl();
		System.out.println(Actualurl);
		Assert.assertEquals(Actualurl,"https://sso.teachable.com/secure/9521/users/sign_up?reset_purchase_session=1" );
	}
	public void verifyLogo() {
		boolean logo=pageLogo.isDisplayed();
		Assert.assertTrue(logo);
	}
	public void registerForm() {
		
		fullName.sendKeys("ABC Test");
		emailId.sendKeys("abc@hotmail.com");
		password.sendKeys("123456");
		confirmPass.sendKeys("123456");
		signUpbtn.click();
	}
	public void verifyErrorMsg() {
		
		String MSG=errorMSG.getText();
		System.out.println(MSG);
		Assert.assertEquals(MSG, "You must agree to the Terms of Use and Privacy Policy");
	}
	
	
	
}
