package Pracice.E2EFramework;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import base.Base;
import pageObjectPattern.LandingPage;

public class LandingPageTest extends Base {
	public WebDriver driver;
	private static  Logger log= LogManager.getLogger(LandingPageTest.class.getName());
public	LandingPage l;
	@BeforeTest
	public void initalization() throws IOException {
		driver=initilizeDriver();
		log.info("Browser is open");
		
	}
		
		@Test(priority=5)
		public void navigateLandingPage() throws IOException {
			driver.get(prop.getProperty("url"));
			 l=new LandingPage(driver);
			l.clickLogin();
			log.error("succesfully login done");
		}
		@Test(priority=1)
		public void verifyLogo() throws IOException {
			driver.get(prop.getProperty("url"));
			 l=new LandingPage(driver);
			l.verifyLogo();
			log.info("Successfully logo is display on page");
			l.verifyTitle();
			log.info("Successfully Title is verified" );
		}
		@Test(priority=2)
		public void verifyNavigationBar() {
			driver.get(prop.getProperty("url"));
			 l=new LandingPage(driver);
			l.verifyNavigationBar();
			log.info("Navigation Bar is verified");
			}
		@Test(priority=3)
		public void verifyTelNo() {
			driver.get(prop.getProperty("url"));
			 l=new LandingPage(driver);
			l.verifyTelNo();
			log.info("Telephone number is verified");
		}
		@Test(priority=4)
		public void verifyBannerText() {
			driver.get(prop.getProperty("url"));
			 l=new LandingPage(driver);
			l.verifyBannerText();
			log.error("banner text is not present");
		}
		
		@AfterTest
		public void tearDown() {
			driver.close();
//			driver.quit();
		}
		
		
		

	}


