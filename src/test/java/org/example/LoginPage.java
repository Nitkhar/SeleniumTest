package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.awt.*;
public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@id=\"login-form\"]/div[1]/input")
    private WebElement userField;

    @FindBy(xpath = "//*[@id=\"login-form\"]/div[2]/input")
    private WebElement passwordField;

    public void inputUsername(String text) {
        userField.sendKeys(text);
    }

    public void inputPassword(String text) {
        passwordField.sendKeys(text);
    }

    public String getUsername(){
        return userField.getAttribute("value");
    }

    public String getPassword(){
       return passwordField.getAttribute("value");
    }
}
