package com.nopcommerce.tesCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.utilities.ReadConfig;




public class BaseClass {

	ReadConfig readConfig=new ReadConfig();
	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.getUseremail();
	public String password=readConfig.getPassword();
	
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br){
		
		
		if(br.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+readConfig.getChromePath());
	        driver=new ChromeDriver();
		}
			
//		}
//		else if(br.equals("ie")) {
//			
//			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+readConfig.getIEPath());
//	        driver=new InternetExplorerDriver();
//		}
		else if(br.equals("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+readConfig.getFirefoxPath());
	        driver=new FirefoxDriver();
		}
        logger=Logger.getLogger("nopCommerce");
        PropertyConfigurator.configure("Log4j.properties");
	
	}
	
	@AfterClass
	public void tearDown(){
			
			driver.close();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
	
	
	
}

