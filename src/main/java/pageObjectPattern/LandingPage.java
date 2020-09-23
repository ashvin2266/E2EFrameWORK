package pageObjectPattern;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Base;

public class LandingPage extends Base{
	@FindBy(linkText = ("Login"))
	WebElement login;
	@FindBy(xpath = ("//a[@class='navbar-brand']"))
	WebElement logo;
	@FindBy(xpath = ("//div[@class='text-center']/h2"))
	WebElement title;
	@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']")
	WebElement navBar;
	@FindBy(linkText="(+1) 323-744-6780")
	WebElement TelNo;
	@FindBy(xpath="//div[@class='col-sm-6 col-md-8 hidden-xs video-banner']/h3")
	WebElement bannerText;
	@FindBy(linkText="Register")
	WebElement register;
	@FindBy(linkText="Practice")
	WebElement practice;
	
	
	
	public LandingPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	public void clickLogin() {
		login.click();
	}
	public void verifyLogo() {
		boolean Logo=logo.isDisplayed();
        Assert.assertTrue(Logo);
        System.out.println(Logo);
        log.info("logo is verified");
	}
	public void verifyTitle() {
		String expected="FEATURED COURSES";
		String actual=title.getText();
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		log.info("Title of the page verified");
	}
	public void verifyNavigationBar() {
		Assert.assertTrue(navBar.isDisplayed());
		
	}
	public void verifyTelNo() {
		Assert.assertTrue(TelNo.isDisplayed());
	}
	public void verifyBannerText() {
		String expectedText="AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING";
		String ActualText=bannerText.getText();
		Assert.assertEquals(ActualText, expectedText);
		System.out.println(ActualText);
	} 
	public void clickOnRegisterBtn() {
		register.click();}
		public void clickPractice() {
			practice.click();
	}

}
