package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class FieldTest {
    public static MainPage mainPage;
    public static LoginPage loginPage;
    private static ChromeDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get("https://i.bspb.ru/auth?response_type=code&client_id=1&redirect_uri=https%3A%2F%2Fi.bspb.ru%2Flogin%2Fsuccess&prefetch_uri=https%3A%2F%2Fi.bspb.ru%2Flogin%2Fprefetch&force_new_session=true&locale=ru");
    }

    @Test
    public void fieldTest() {
        //mainPage.clickToEnterButton();
        loginPage.inputUsername("Example");
        loginPage.inputPassword("Example");
        String username = loginPage.getUsername();
        String password = loginPage.getPassword();
        Assert.assertEquals("Example",username);
        Assert.assertEquals("Example",password);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
