package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditPage {
    public WebDriver driver;

    public CreditPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'subheader-container')]/h1")
    private WebElement creditPageText;

    public String getCreditPageText(){
        String text = creditPageText.getText();
        return text;
    }
}
