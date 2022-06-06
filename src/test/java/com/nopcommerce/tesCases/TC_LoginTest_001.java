package com.nopcommerce.tesCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass{
	
       @Test
       public void loginTest() throws InterruptedException {
		
		driver.get(baseURL);
		logger.info("URL is opened....");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("username is provided");
		lp.setPassword(password);
		logger.info("pasword is provided");
		lp.clickSubmit();
		logger.info("login is clicked");
		
		Thread.sleep(5000);
		
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
		

		    Assert.assertTrue(true);
		    lp.clickLink();
		    logger.info("Login is passed");
		    
		}else {
			
			   Assert.assertTrue(false);
			  logger.info("Login is passed");
		}
		
	}
	
}
	
