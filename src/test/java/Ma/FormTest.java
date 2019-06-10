package Ma;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
//import org.openqa.selenium.WebDriver;		
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import utilities.Base;
import utilities.Listeners;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;		

public class FormTest extends Base  {	
	Listeners B = new Listeners();
    		
    	//*********Page Variables*********
    	public static Logger Log = LogManager.getLogger(FormTest.class.getName());
    			
    	@BeforeMethod
		public void initialize() throws IOException {
			driver = initializeDriver();
			Log.info("Driver is initialized");
			driver.get(prop.getProperty("url4"));
		}
    	
    	@Test
		public void Login() throws Exception {

        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));							
        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));							
      		
       //Radio Button1 is selected		
       radio1.click();			
        System.out.println("Radio Button Option 1 Selected");					
       		
        //Radio Button1 is de-selected and Radio Button2 is selected		
       radio2.click();			
       System.out.println("Radio Button Option 2 Selected");					
        		
        // Selecting CheckBox		
        WebElement option1 = driver.findElement(By.id("vfb-6-0"));							

        // This will Toggle the Check box 		
        option1.click();			

        // Check whether the Check box is toggled on 		
        if (option1.isSelected()) {					
            System.out.println("Checkbox is Toggled On");					

        } else {			
            System.out.println("Checkbox is Toggled Off");					
        }		
         
        		
        		
        //Selecting Checkbox and using isSelected Method		
        driver.get("http://demo.guru99.com/test/facebook.html");					
        WebElement chkFBPersist = driver.findElement(By.id("persist_box"));							
        for (int i=0; i<2; i++) {											
            chkFBPersist.click (); 			
            System.out.println("Facebook Persists Checkbox Status is -  "+chkFBPersist.isSelected());							
        }		
		//driver.close();		
        		
    }
    	 @AfterMethod
 		public void teardown(){
 	    	 driver.close();
 		}
}