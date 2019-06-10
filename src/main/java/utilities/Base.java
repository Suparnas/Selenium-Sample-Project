package utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

//*******************************************************************
//Author: Suparna Soman
//Description: Base class defines the basic drivers for all the tests
//*******************************************************************

public class Base {

	public static WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
 prop= new Properties();
FileInputStream fis=new FileInputStream("./resources/data.properties");
prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{
	//Execute in Chrome Driver
	System.setProperty("webdriver.chrome.driver","./resources/chromedriver");
	driver= new ChromeDriver(); 
}

else if (browserName.equals("firefox"))
{
	//Execute in Firefox Driver
	System.setProperty("webdriver.gecko.driver","./resources/geckodriver");
	driver= new FirefoxDriver();
}

else if (browserName.equals("IE"))
{
	//Execute in IE Driver
	 driver= new InternetExplorerDriver();
}
else if (browserName.equals("safari"))
{
	//Execute in IE Driver
	 driver= new SafariDriver();
}
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;
}

public void getScreenshot(String result) throws IOException
//public void getScreenshot() throws IOException
{
// Call Webdriver to click the screenshot.
File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//Save the screenshot
FileUtils.copyFile(src, new File("./test-output/"+result+"screenShot.png"));
}

public void getPartialScreenShot(WebElement element) throws IOException {

    String screenShot = System.getProperty("./test-output/") + "screenShot.png";

    File screen = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

    Point p = element.getLocation();

    int width = element.getSize().getWidth();
    int height = element.getSize().getHeight();

    BufferedImage img = ImageIO.read(screen);

    BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width,
        height);

    ImageIO.write(dest, "png", screen);

    FileUtils.copyFile(screen, new File(screenShot));
}


}

	
	

