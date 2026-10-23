package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTests {

    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void pageTitleTest() {
        var title = driver.getTitle();
        Assert.assertEquals(title, "Swag Labs");

        var login = driver.findElement(By.id("user-name"));
        var password = driver.findElement(By.id("password"));

        softAssert.assertTrue(login.isDisplayed());
        softAssert.assertTrue(password.isDisplayed());
    }

    @AfterMethod()
    public void tearDown() {
        try {
            softAssert.assertAll();
        }
        finally {
            if (driver != null) driver.quit();
        }
    }
}
