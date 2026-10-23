package org.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "user-name")
    private WebElement name;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    
}
