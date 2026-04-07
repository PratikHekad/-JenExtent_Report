package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.ExcelUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.Assert;

public class ExcelLoginStepsWithOneTestCase extends BaseTest {

    LoginPage loginPage;
    private String expectedResult;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage = new LoginPage(driver);
    }

    // @When("user enters username {string} and password {string}")
    // public void user_enters_credentials(String user, String pass) {
    //     loginPage.enterUsername(user);
    //     loginPage.enterPassword(pass);
    // }
    
    @When("user logs in using excel data")
public void user_logs_in_using_excel_data() throws Exception {

    Object[][] data = ExcelUtil.getExcelData(
        "src/test/resources/testdata/loginData.xlsx",
        "Sheet1"
    );

    for (Object[] row : data) {

        String username = row[0].toString();
        String password = row[1].toString();
        String expectedResult = row[2].toString();

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        // Validation
        if(expectedResult.equalsIgnoreCase("success")) {
            //wait for profile page to load and validate URL contains "profile"
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("profile"));
            Assert.assertTrue(driver.getCurrentUrl().contains("profile"),"It should contain profile but login showed");
        } else {
            //wait for login page to reload and validate URL contains "login"
            // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
            // wait.until(ExpectedConditions.urlContains("login"));
            Thread.sleep(5000);
            Assert.assertTrue(driver.getCurrentUrl().contains("login"),"It should contain login but profile showed");
        }

        // Reset for next iteration
        driver.manage().deleteAllCookies();
        driver.get("https://demoqa.com/login");
    }
}


    @And("clicks on login button with excel")
    public void clicks_login() {
        // This step is now handled inside the login_using_excel method
    }

    @Then("login result should be profile page for success and login page for failure")
    public void validate_login() {
        // Validation is now handled inside the login_using_excel method
        quitDriver();
    }
}