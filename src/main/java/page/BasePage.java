package page;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

WebDriver driver;
	

	public void waitForElement(WebDriver driver, int timeInSecs, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, 6);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Add category']")));
	//wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	 public void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
		  TakesScreenshot ts = ((TakesScreenshot) driver);
		  SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		  Date date = new Date();
		  String label = formatter.format(date);
		  File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		  String currentDir = System.getProperty("user.dir");
		  FileHandler.copy(sourceFile, new File(currentDir + "/screenshots/" + label + ".png"));
		 }
	
}


