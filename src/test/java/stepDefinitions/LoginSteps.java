package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

import static org.testng.Assert.*;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();

    @Given("user opens the browser")
    public void openBrowser() {
        driver = DriverFactory.getDriver();
    }

    @When("user navigates to {string}")
    public void navigateTo(String url) {
        driver.get(url);
    }

    @Then("page title should contain {string}")
    public void validateTitle(String expected) {
        assertTrue(driver.getTitle().contains(expected));
    }
}
