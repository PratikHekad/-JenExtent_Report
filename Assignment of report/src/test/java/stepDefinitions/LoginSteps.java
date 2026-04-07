package stepDefinitions;

import utils.ExcelUtil;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;
import java.util.Map;

import static hooks.Hooks.driver;

public class LoginSteps {

    @Given("user opens the browser")
    public void openBrowser() {
        // handled in Hooks
    }

    @When("user navigates to {string}")
    public void navigateTo(String url) {
        driver.get(url);
    }

    @When("user logs in using Excel data")
    public void loginWithExcel() {

        List<Map<String, String>> data = ExcelUtil.getTestData(
                "src/test/resources/testdata/loginData.xlsx",
                "Sheet1"
        );

        for (Map<String, String> row : data) {

            String username = row.get("username");
            String password = row.get("password");

            try {
                ((JavascriptExecutor) driver)
                        .executeScript("window.scrollBy(0,300)");

                driver.findElement(By.id("userName")).clear();
                driver.findElement(By.id("userName")).sendKeys(username);

                driver.findElement(By.id("password")).clear();
                driver.findElement(By.id("password")).sendKeys(password);

                driver.findElement(By.id("login")).click();

                Thread.sleep(2000);

                if (isElementPresent(By.id("userName-value"))) {
                    System.out.println("✅ PASS: " + username);
                    driver.findElement(By.id("submit")).click(); // logout
                } else {
                    System.out.println("❌ FAIL: " + username);
                }

                driver.navigate().refresh();
                Thread.sleep(2000);

            } catch (Exception e) {
                System.out.println("⚠️ ERROR: " + username);
            }
        }
    }

    @Then("verify login result")
    public void verifyResult() {
        System.out.println("Execution completed");
    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}