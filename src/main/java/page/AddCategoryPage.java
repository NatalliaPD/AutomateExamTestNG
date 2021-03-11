package page;


	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

	

public class AddCategoryPage extends BasePage {

	WebDriver driver;

	public AddCategoryPage() {

	}

	public AddCategoryPage(WebDriver driver) {
		this.driver = driver;
	}

// Element Library
	@FindBy(how = How.ID_OR_NAME, using = "categorydata")
	//@FindBy(how = How.CSS, using = "input[name='categorydata']")
	WebElement CategType;
	@FindBy(how = How.XPATH, using = "//input[@value='Add category']")
	//@FindBy(how = How.CSS, using = "input[value='Add category']")
	WebElement AddCategButton;

	// Interactive Methods

	public void addCategory() throws InterruptedException {
		
		CategType.sendKeys("Spring-2021");
		
		waitForElement(driver, 3, AddCategButton);
		
		AddCategButton.click();
		//AddCategButton.wait(2);
	}

	public void addDuplicateCategory() {
		
		CategType.sendKeys("Spring-2021");
		
	}
	public void clickAddCategButton() {
		AddCategButton.click();
		
		// how to add assert to use message duplicate category?
	}
	public String getPageTitle() {
		   return driver.getTitle();

	

}
}