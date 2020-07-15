package Pracice.E2EFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pageObjectPattern.HomePage;
import pageObjectPattern.LandingPage;
import pageObjectPattern.RegisterPage;

public class RegisterPageTest extends Base {
	
	
	
	private static Logger log= LogManager.getLogger(RegisterPage.class.getName());
	LandingPage l;
	HomePage hp;
	RegisterPage rp;
	
	
	@BeforeTest
	public void OpenBrowser() throws IOException {
		initilizeDriver();
		log.info("Browser is open");
	}
	@Test(priority=1)
	public void verifyRegisterPage() {
		driver.get(prop.getProperty("url"));
		log.info("Url is open");
		l=new LandingPage(driver);
		l.clickOnRegisterBtn();
		rp=new RegisterPage(driver);
		rp.verifyPage();
		
		
	}
	@Test(priority=2)
	public void verifylogo() {
		driver.get(prop.getProperty("url"));
		log.info("Url is open");
		l=new LandingPage(driver);
		l.clickOnRegisterBtn();
		rp=new RegisterPage(driver);
		rp.verifyLogo();
		log.info("Logo is displayed");
		
	}
	@Test(priority=3)
	public void registerForm() {
		driver.get(prop.getProperty("url"));
		log.info("Url is open");
		l=new LandingPage(driver);
		l.clickOnRegisterBtn();
		rp=new RegisterPage(driver);
		rp.registerForm();
		log.info("Registration form is filled up");
	}
	@Test (priority=4)
	public void registerFormError() {
		driver.get(prop.getProperty("url"));
		log.info("Url is open");
		l=new LandingPage(driver);
		l.clickOnRegisterBtn();
		rp=new RegisterPage(driver);
		rp.registerForm();
		rp.verifyErrorMsg();
		log.info("Error Message is verified");
	}
	@AfterTest
	public void closeBrowser() {
//		driver.close();
	}
}

