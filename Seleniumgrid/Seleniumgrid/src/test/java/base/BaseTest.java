package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

import utilities.BrowserFactory;

public class BaseTest {
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		WebDriver wd=BrowserFactory.getDriver(browser);
		driver.set(wd);
		driver.get().get("https://opensource-demo.orangehrmlive.com");
	}
	 public WebDriver getDriver() {
	        return driver.get();
	    }

	    @AfterMethod
	    public void tearDown() {

	        driver.get().quit();
	        driver.remove();
	    }
	
	

}
