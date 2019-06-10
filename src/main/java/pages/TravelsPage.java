package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsPage {

	WebDriver driver;
	//By cancel = By.xpath("//button[text()='No Thanks']"); //xpath with text
	By cancel = By.xpath("//button[@id='onesignal-popover-cancel-button']");
	By slide = By.xpath("//button[@class='lc-e7c2r4 e1m5b1js0']");
	By nSub = By.xpath("//div[@class='mc-closeModal']");
	By button = By.xpath("//a[@class='btn btn-primary btn-lg btn-block']");

	
	
	
	public TravelsPage(WebDriver driver) {
		this.driver =driver;
	}
	
	
	public WebElement getcancel() {
		return driver.findElement(cancel);
	}
	public WebElement getslide() {
		return driver.findElement(slide);
	}
	public WebElement getnSub() {
		return driver.findElement(nSub);
	}
	public WebElement getnbut() {
		return driver.findElement(button);
	}
	
	
	
}
