package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void pageTitleTest() {
        var title = driver.getTitle();
        Assert.assertEquals(title, "Swag Labs");
    }

    @AfterMethod()
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
