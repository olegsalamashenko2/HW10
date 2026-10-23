package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "user-name")
    private WebElement name;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterLogin(String login) {
        name.clear();
        name.sendKeys(login);
    }

    public void enterPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
