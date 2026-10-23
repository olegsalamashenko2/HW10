package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTests {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        loginPage =  new LoginPage(driver);
    }

    @Test(priority = 1)
    public void pageTitleTest() {
        var title = driver.getTitle();
        Assert.assertEquals(title, "Swag Labs");
    }

    @DataProvider(name = "loadData")
    public Object[][] loadData() {
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"}
        };
    }

    @Test(priority = 2, dataProvider = "loadData")
    public void loadDataTest(String username, String password) {
        loginPage.enterLogin(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @AfterMethod()
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
