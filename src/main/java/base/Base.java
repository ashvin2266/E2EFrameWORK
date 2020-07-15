package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import Pracice.E2EFramework.HomePageTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public static  Logger log= LogManager.getLogger(Base.class.getName());
	
	public WebDriver initilizeDriver() throws IOException {
		 prop=new Properties();
	FileInputStream file=new FileInputStream("C:\\Users\\ashvi\\eclipse-workspace\\E2EFramework\\src\\main\\java\\PropertiesFile\\Config.properties");
		prop.load(file);
	String Browser=	prop.getProperty("browser");
	if(Browser.equalsIgnoreCase("chrome")) {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();	 
	
	}else if(Browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		
	}
	else if(Browser.equalsIgnoreCase("IE")) {
		WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
	}
	else if(Browser.equalsIgnoreCase("opera")) {
		WebDriverManager.operadriver().setup();
		driver=new OperaDriver();
		
		
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	return driver;	
	}
	public void closeBrowser() {
		driver.close();
	}
	public String getScreenShotPath(String testCaseName,WebDriver driver) {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir") +"\\report\\"+ testCaseName + ".png" ;
		try {
			FileUtils.copyFile(file,new File(destinationFile) );
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return destinationFile;
	}
	 

	

}
