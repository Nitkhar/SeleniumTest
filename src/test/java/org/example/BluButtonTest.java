package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BluButtonTest {

    public static MainPage mainPage;
    public static BluButtonPage bluButtonPage;
    private static ChromeDriver driver;
    final static String REAL_ATOM_TEXT = "Безопасность";


    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        bluButtonPage = new BluButtonPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get("https://www.bspb.ru/");
    }

    @Test
    public void bluButtonTest() {
        bluButtonPage.clickToSmallButton();
        bluButtonPage.clickToBluBatton();
        String textAtom = bluButtonPage.getAtomText();
        Assert.assertEquals(REAL_ATOM_TEXT, textAtom);
    }
    /**
     * осуществление выхода из аккаунта с последующим закрытием окна браузера
     */
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
