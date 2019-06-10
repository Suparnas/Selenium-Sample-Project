package utilities;

import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//***********************************************************************************
//Author: Suparna Soman
//Description: Event listeners represent the interfaces responsible to handle events
//***********************************************************************************

public class Listeners implements ITestListener {

	 protected static WebDriver driver;
	 protected static ExtentReports reports;
	 public static ExtentTest test;
	 Base B = new Base();
	public void onTestStart(ITestResult result) {
		 System.out.println("Test Started");
		  test = reports.startTest(result.getMethod().getMethodName());
		  test.log(LogStatus.INFO, result.getMethod().getMethodName() + " test started");
		 }

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success\n");
		  test.log(LogStatus.PASS, result.getMethod().getMethodName() + " test passed");
		 }

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed\n");
		  test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " test failed");
		  try {
			B.getScreenshot(result.getName());
			//String file = test.addScreenCapture(result.getName()+"screenshot.png");
			String file = test.addScreenCapture(result.getName()+"screenshot.png");
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test failed", file);
			//B.getScreenshot();
		} catch (IOException e) {
			e.printStackTrace(); // To print stack trace
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped \n");
		  test.log(LogStatus.SKIP, result.getMethod().getMethodName() + " test skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(" Test Success within percentage");
	 }		

	public void onStart(ITestContext context) {
		System.out.println("Started");
		  driver = new ChromeDriver(); // Set the drivers path in environment variables to avoid code(System.setProperty())
		 // reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");		
		  reports = new ExtentReports( "./test-output/Extentreports.html");		
	}

	public void onFinish(ITestContext context) {
		System.out.println("on finish");
		  driver.close();
		  reports.endTest(test);
		  reports.flush();
	}

}
