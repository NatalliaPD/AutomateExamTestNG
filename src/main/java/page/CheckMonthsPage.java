package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckMonthsPage extends BasePage{

	WebDriver driver;

	public CheckMonthsPage() {

	}

	public CheckMonthsPage(WebDriver driver) {
		this.driver = driver;
	}

// Element Library
	@FindBy(how = How.NAME, using = "due_month")
	WebElement MonthsDropDown;

	// Interactive methods
	public void selectMonthsDropwdown() {

		MonthsDropDown.click();
	}

	public String getPageTitle() {
		return driver.getTitle();

	}
}
