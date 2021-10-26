package org.example;

import org.example.SoftAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardPage extends Page{

    public WebDriver driver;
    public CardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"payment-system-select\"]")
    private WebElement paymentSystemSelect;

    @FindBy(xpath = "//*[@id=\"card_secondname\"]")
    private WebElement secondNameField;

    @FindBy(xpath = "//*[@id=\"card_firstname\"]")
    private WebElement firstNameField;

    @FindBy(xpath = "//*[@id=\"card_thirdname\"]")
    private WebElement thirdNameField;

    @FindBy(xpath = "//*[@id=\"card_email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"card_phone\"]")
    private WebElement phoneField;

    @FindBy(xpath = "//*[@id=\"card_fullname_eng\"]")
    private WebElement cardNameField;

    @Override
    public void fillFields(Map<String, String> fields) {
        paymentSystemSelect.sendKeys(fields.get("Платежная система"));
        secondNameField.sendKeys(fields.get("Фамилия"));
        firstNameField.sendKeys(fields.get("Имя"));
        thirdNameField.sendKeys(fields.get("Отчество"));
        emailField.sendKeys(fields.get("E-Mail"));
        phoneField.sendKeys(fields.get("Номер мобильного телефона"));
    }

    @Override
    public void checkFields(Map<String, String> fields) {
        SoftAssert softAssertions = new SoftAssert();

        String paymentSystem = paymentSystemSelect.getText();
        String secondName = secondNameField.getAttribute("value");
        String firstName = firstNameField.getAttribute("value");
        String thirdName = thirdNameField.getAttribute("value");
        String email = emailField.getAttribute("value");
        String phone = phoneField.getAttribute("value");
        String cardName = cardNameField.getAttribute("value");

        softAssertions.AssertEquals(paymentSystem, fields.get("Платежная система"), "Платежная система");
        softAssertions.AssertEquals(secondName, fields.get("Фамилия"), "Фамилия");
        softAssertions.AssertEquals(firstName, fields.get("Имя"), "Имя");
        softAssertions.AssertEquals(thirdName, fields.get("Отчество"), "Отчество");
        softAssertions.AssertEquals(email, fields.get("E-Mail"), "E-Mail");
        softAssertions.AssertEquals(phone, fields.get("Номер мобильного телефона"), "Номер мобильного телефона");
        softAssertions.AssertEquals(cardName, fields.get("Имя на карте"), "Имя на карте");

        softAssertions.AssertAll();
        //assertEquals(1,2);
    }

    @Override
    public boolean checkTheHeader(String header) {
        return false;
    }
}
