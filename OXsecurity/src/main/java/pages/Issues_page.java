package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Issues_page {
	protected WebDriver driver;

	public Issues_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/issues']")
	WebElement issues_tab;
	public void click_issuesTab() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15000));
		WebElement wb = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/issues']")));

		issues_tab.click();

	}

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary MuiButton-fullWidth MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary MuiButton-fullWidth css-1jr3rvc-button']")
	WebElement activeIssues;
	public void click_activeIssues() {

		activeIssues.click();

	}

	@FindBy(xpath = "//div[@data-testid='filter_box filter_header_Severity']//div[@role='button']")
	WebElement severity;
	public void click_severity() {
		severity.click();
	}

	@FindBy(xpath = "//span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeSmall PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeSmall MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeSmall css-39-checkboxPlaceholderIcon-ref css-vwe1sl-checkboxWithExclude-checkboxPlaceholderIcon']//input[@value='High']")
	WebElement high;
	public void click_high() throws InterruptedException {
		// find scrollable element
		WebElement wb = driver.findElement(By.xpath("//div[@class='css-139fun8-aside']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		Long scrollTop = (Long) jsExecutor.executeScript("return arguments[0].scrollTop;", wb);
		Long scrollLeft = (Long) jsExecutor.executeScript("return arguments[0].scrollLeft;", wb);
		// Scroll to a specific position within the element
		int scrollPositionTop = 300; // Desired scroll position
		int scrollPositionLeft = 0; // Desired scroll position
		jsExecutor.executeScript("arguments[0].scrollTo(arguments[1], arguments[2]);", wb, scrollPositionLeft,
				scrollPositionTop);

		// Wait for a few seconds to see the scrolling action (optional)
		Thread.sleep(3000);
		high.click();
		Thread.sleep(2000);
		// scroll to top to see issue count
		jsExecutor.executeScript("arguments[0].scrollTo(arguments[1], arguments[2]);", wb, 0, 0);
		// Wait for a few seconds to see the count on top
		Thread.sleep(3000);
	}

	@FindBy(xpath = "//span[@class='css-2dl6fu-count']")
	WebElement count;

	public void get_count() {
		System.out.println("Count of high severity active issues :-> " + count.getText());

	}

}
