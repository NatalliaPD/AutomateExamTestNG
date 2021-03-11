package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import page.AddCategoryPage;
import util.BrowserFactory;

public class AddCategoryTest {

	
	WebDriver driver;
	
	@BeforeMethod
	public void init() {
	    driver = BrowserFactory.startBrowser();
	}
	@Test
	public void addCategory() throws InterruptedException {
	driver = BrowserFactory.startBrowser();
	
	//Store the current window handle
	String winHandleBefore = driver.getWindowHandle();
	
	AddCategoryPage addcategorypage = PageFactory.initElements(driver,AddCategoryPage.class);
	
	addcategorypage.addCategory();
	
	
	
	//addcategorypage.wait(3);
	addcategorypage.addDuplicateCategory();
	Thread.sleep(3000);
	addcategorypage.clickAddCategButton();
	Thread.sleep(2000);
	
	// Switch to new window opened
	for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	    
	    //close the new window
	 //   driver.close();
	    
	    //return to the first window
	    driver.switchTo().window(winHandleBefore);
	}
	}
	
	public void softAssert() {
	SoftAssert softAssertion = new SoftAssert();
	String expectedMessage = "The category you want to add already exists: Spring-2021.";
	String actualMessage = driver.getTitle();
	System.out.println(actualMessage);
	softAssertion.assertEquals("duplicate category", "The category you want to add already exists: Spring-2021.");
	
	//Assert.assertEquals(actualMessage, expectedMessage, "Inadequate message");
	
	//WebElement displayedMessage = driver.findElement(By.name("The category you want to add already exists: Spring-2021."));
	//System.out.println("duplicate category name");
//	Assert.assertEquals(actualMessage, expectedMessage, message);
	
}
	
	
	//@AfterMethod
	// public void tearDown() { 
	//	BrowserFactory.tearDown();
	//}
}

