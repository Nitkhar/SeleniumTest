package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class DropListTest {
    public static MainPage mainPage;
    private static ChromeDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get("https://www.bspb.ru/");
    }

    @Test
    public void dropListTest() {
        mainPage.clickToCreditButton();
        //Assert.assertEquals(realAtomText, textAtom);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
