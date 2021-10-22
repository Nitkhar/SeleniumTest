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

public class MainPage {

    public WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора кнопки "Кредиты"
     */
    @FindBy(xpath = "//*[contains(@class, 'active')]")
    private WebElement headerText;

    @FindBy(xpath = "//*[contains(@href, '/business')]")
    private WebElement headerButtonBusiness;

    @FindBy(xpath = "//*[contains(@href, '/foreign-trade')]")
    private WebElement headerButtonForeignTrade;

    @FindBy(xpath = "//*[contains(@href, '/finance')]")
    private WebElement headerButtonFinance;

    @FindBy(xpath = "//*[contains(@href, '/vip')]")
    private WebElement headerButtonVip;

    @FindBy(xpath = "//*[contains(@href, '/investors')]")
    private WebElement headerButtonInvestors;

    @FindBy(xpath = "//*[contains(@href, '/retail')]")
    private WebElement headerButtonRetail;

    @FindBy(xpath = "//*[contains(@data-hover, 'dropdown')]")
    private WebElement creditDropList;

    @FindBy(xpath = "//*[contains(@class, 'bspb blue button')]")
    private WebElement enterButton;

    public void clickToBusinessButton() {
        headerButtonBusiness.click();
    }

    public void clickToForeignTradeButton() {
        headerButtonForeignTrade.click();
    }

    public void clickToFinanceButton() {
        headerButtonFinance.click();
    }

    public void clickToVipButton() {
        headerButtonVip.click();
    }

    public void clickToInvestorsButton() {
        headerButtonInvestors.click();
    }

    public void clickToRetailButton() {
        headerButtonRetail.click();
    }

    public String getHeaderName() {
        String name = headerText.getText();
    return name; }

    public void clickToCreditButton() {
        Actions action = new Actions(driver);
        action.moveToElement(creditDropList).moveToElement(driver.findElement(By.xpath("//*[@id=\"menubar\"]/div[2]/ul/li[1]/div/div/div[1]/div[1]/a"))).click().build().perform();
    }

    public void clickToEnterButton() {
        enterButton.click();
    }

    public void sleep(int seconds)
    {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {

        }
    }
}
