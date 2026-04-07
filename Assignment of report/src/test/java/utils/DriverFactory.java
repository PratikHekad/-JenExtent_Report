package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverFactory {

    private static WebDriver driver;

    public static void initDriver() {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName("chrome");

            driver = new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"),
                    cap
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}