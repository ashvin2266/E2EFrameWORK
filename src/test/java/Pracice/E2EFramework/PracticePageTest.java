package Pracice.E2EFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pageObjectPattern.HomePage;
import pageObjectPattern.LandingPage;

public class PracticePageTest extends Base {
	public WebDriver driver;
	public HomePage hp;
	public LandingPage l;
	
	private static Logger log=LogManager.getLogger(PracticePageTest.class.getName()) ;
	@BeforeTest
	public void initalization() throws IOException {
		driver=initilizeDriver();
		log.info("Browser is open");}
		
		@Test
		public void getLoginIn() {
			driver.get(prop.getProperty("url"));
			hp=new HomePage(driver);
			new LandingPage(driver).clickPractice();
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	

}
