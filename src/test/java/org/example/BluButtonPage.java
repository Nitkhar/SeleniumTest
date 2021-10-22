package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BluButtonPage {
    public WebDriver driver;
    public BluButtonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//*[@href='/retail/cards/']")
    private WebElement tnAtomText;
    @FindBy(xpath = "//*[contains(@class, 'switcher')]//div[5]")
    private WebElement smallbutton;
    public String getAtomText(){
        return tnAtomText.getText();
    }

    public void clickToBluBatton() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[5]/div/a")).click();
    }

    public void clickToSmallButton(){
        smallbutton.click();
        this.sleep(2);
    }

    public void sleep(int seconds)
    {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {

        }
    }

}
