package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class DashboardTest extends BaseTest {
	@Test
	public void dashboardValidation() {

		
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");

        getDriver().findElement(By.name("password")).sendKeys("admin123");

        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		

		String text = getDriver().findElement(By.xpath("//h6")).getText();

		Assert.assertTrue(text.contains("Dashboard"));
	}

}
