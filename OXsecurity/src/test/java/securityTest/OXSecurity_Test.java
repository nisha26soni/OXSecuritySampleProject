package securityTest;

import org.testng.annotations.Test;
import Utilities.baseClass;
import pages.Issues_page;
import pages.login_page;

public class OXSecurity_Test extends baseClass {

	login_page lp;
	Issues_page ip;

	@Test(priority = 1)
	public void testLogin() {
		// Log in to the system using credentials from config.properties
		lp = new login_page(driver);
		lp.click_login();
		lp.enter_username(configReader.getProperty("username"));
		lp.click_continue();
		lp.enter_password(configReader.getProperty("password"));
		lp.click_continue();
	}

	@Test(priority = 2)
	public void FilterIssues() throws InterruptedException {
		ip = new Issues_page(driver);
		// Navigate to the 'Issues' section
		Thread.sleep(9000);
		ip.click_issuesTab();
		Thread.sleep(5000);
		ip.click_severity();
		Thread.sleep(5000);
		// click on severity and select high
		ip.click_high();
		ip.get_count(); //Print count on console.
		
	}
}
