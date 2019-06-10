package Ma;

import org.testng.annotations.Test;
//import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//import pages.GuruLogin;
import pages.TravelsPage;
import utilities.Base;
//import utilities.Listeners;
import utilities.PropertyManager;
//import utilities.Util;

	
//*******************************************************************
//Author: Suparna Soman
//Description: Class to test Login functionality
//*******************************************************************

	public class phpTravels extends Base{
		//*********Page Variables*********
		public static Logger Log = LogManager.getLogger(phpTravels.class.getName());
     
		@BeforeMethod
		public void initialize() throws IOException {
			driver = initializeDriver();
			Log.info("Driver is initialized");
			// Maximize Window
			//driver.manage().window().maximize();
			String url = PropertyManager.getInstance().getURL1();
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get(url);
		}
		
	    @Test
		public void Login() throws Exception {
	    	
	    	TravelsPage P= new TravelsPage(driver);
	    	WebDriverWait wait=new WebDriverWait(driver, 5);

	    	
			//String actualBoxtitle;
	    	
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    	Thread.sleep(3000);
	    	P.getcancel().click();
	   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		Thread.sleep(3000);
		P.getnSub().click();
		WebElement slide;
		slide = wait.until(ExpectedConditions.visibilityOfElementLocated((By) P.getslide()));
//		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	   slide.click();
//		
//		P.getnbut().click();
		  
	  }   
	    @AfterMethod
		public void teardown(){
	    	 driver.close();
		}

	}
  
				 