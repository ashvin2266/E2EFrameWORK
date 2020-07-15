package Pracice.E2EFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pageObjectPattern.HomePage;
import pageObjectPattern.LandingPage;

public class HomePageTest extends Base{
	public WebDriver driver;
//	private static  Logger log= LogManager.getLogger(HomePageTest.class.getName());
	LandingPage l;
	HomePage hp;
	

	@BeforeTest
	public void initalization() throws IOException {
		driver=initilizeDriver();
		log.info("Driver is initalize");
		
		
	}
	@Test(dataProvider="getData")
	public void getLogin(String username,String password) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("URL is open");
		
		 l=new LandingPage(driver);
		l.clickLogin();
	      hp=new HomePage(driver);
	     hp.getEmail(username);
	     hp.getpassword(password);
	     hp.clicklogin();
	     log.info("error message is displayed");
		
	}
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data=new Object[2][2];
		data[0][0]="def@hotmail.com";
		data[0][1]="987654";
		data[1][0]="abc@gmail.com";
		data[1][1]="123456";
		return data;
	}
	@AfterTest
	public void tearDown() {
//		driver.close();
		driver.quit();
		log.info("Browser is closed");
	}

}
