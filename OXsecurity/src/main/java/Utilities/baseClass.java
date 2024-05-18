package Utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class baseClass {
	protected WebDriver driver;
	protected ConfigReader configReader;
	@BeforeClass
	public void setUp() {
		configReader = new ConfigReader();
       // Setup Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // Initialize WebDriver
        driver = new ChromeDriver(options);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the OX Security login page
        driver.get(configReader.getProperty("url"));
    }
	@AfterClass
	public void cleanUp()
	{
		driver.close();
		//driver.quit();
	}

}
