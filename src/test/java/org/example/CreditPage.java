package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class CreditPage extends Page {
    public WebDriver driver;

    public CreditPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'subheader-container')]/h1")
    private WebElement creditPageText;

    @Override
    public boolean checkTheHeader(String header) {
        return false;
    }

    @Override
    public void checkFields(Map<String, String> fields) {
        /** !!!*/
    }

    @Override
    public void fillFields(Map<String, String> fields) {
        /** !!!*/
    }

    public String getCreditPageText(){
        String text = creditPageText.getText();
        return text;
    }
}
