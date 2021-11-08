package com.hr.pages;

import com.hr.testBase.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class LoginPage extends TestBase {
    Properties prop;

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signInButton;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public void enterUserName(String userNameToEnter) {
        userName.sendKeys(userNameToEnter);
    }

    public void enterPassword(String passwordToEnter) {
        password.sendKeys(passwordToEnter);
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }
}
