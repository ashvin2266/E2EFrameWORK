package Pracice.E2EFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import base.Base;

public class PracticePageTest extends Base {
	public WebDriver driver;
	
	private static Logger log=LogManager.getLogger(PracticePageTest.class.getName()) ;
	@BeforeTest
	public void initalization() throws IOException {
		driver=initilizeDriver();
		log.info("Browser is open");
	}
	
	
	
	
	
	
	
	
	
	

}
