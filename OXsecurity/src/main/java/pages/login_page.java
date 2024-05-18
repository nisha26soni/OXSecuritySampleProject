package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_page {
	protected WebDriver driver;

	public login_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='MuiButton-icon MuiButton-startIcon MuiButton-iconSizeMedium css-6xugel']/parent::button")
	private WebElement login;
	public void click_login() {
		login.click();
	}

	@FindBy(xpath = "//*[@id=\"username\"]")
	private WebElement username;
	public void enter_username(String u_name) {
		username.sendKeys(u_name);
	}

	@FindBy(xpath = "//button[contains(text(), 'Continue')]")
	private WebElement btn_continue;
	public void click_continue() {
		//Scroll down so that continue button is visible 
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		btn_continue.click();
	}
	
	@FindBy(xpath="//*[@id=\"password\"]")
	private WebElement password;
	public void enter_password(String pass)
	{
		password.sendKeys(pass);
		
	}
	
	
}
