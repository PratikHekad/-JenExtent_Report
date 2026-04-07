package utilities;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;



public class BrowserFactory {
	public static WebDriver getDriver(String browser) {
		
		WebDriver driver=null;
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options=new ChromeOptions();
				driver=new RemoteWebDriver(new URL("http://localhost:4444"),options);
			}
		}catch(Exception e) {
			throw new RuntimeException("Driver initialization failed", e);
		}
		return driver;
		
	}

}
