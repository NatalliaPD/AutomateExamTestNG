package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import page.CheckMonthsPage;
import util.BrowserFactory;

public class CheckMonthsTest {

	WebDriver driver;
	
	@BeforeMethod
	public void init() {
	    driver = BrowserFactory.startBrowser();
	}
	@Test
	public void checkMonths() throws InterruptedException {
	driver = BrowserFactory.startBrowser();
	CheckMonthsPage checkmonthspage = PageFactory.initElements(driver,CheckMonthsPage.class);
	
	int count = 0;
	String[] exp = {"None", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	WebElement dropdown = driver.findElement(By.name("due_month"));
	
	Select sel = new Select(dropdown);
	
	List<WebElement> options = sel.getOptions();
	for(WebElement e : options) {
		for (int i = 0; i < exp.length; i++) {
			if (e.getText().equals(exp[i])) {
				 count++;
			}
			  }
		}
	  if (count == exp.length) {
		  System.out.println("All months present");
	  } else {
		  System.out.println("Error in months list!");
		  
		  Assert.assertEquals("Verification passed: all months present", exp.length);
		 
	  }
	  
	
	  }
	  
	
	}
	

