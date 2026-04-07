package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ExtentManager;
import com.aventstack.extentreports.*;

public class Hooks {

    public static WebDriver driver;

    static ExtentReports extent = ExtentManager.getInstance();
    public static ExtentTest test;

    @Before
    public void setup(io.cucumber.java.Scenario scenario) {
        test = extent.createTest(scenario.getName());

        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
        extent.flush();
    }
}