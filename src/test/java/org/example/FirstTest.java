package org.example;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
    /**
     * Переменные для проверки
    */
    String headerNameSmokeTestFirst = "ЧАСТНЫМ КЛИЕНТАМ";
    String headerNameSmokeTestSecond = "БИЗНЕСУ";
    String headerNameSmokeTestThird = "УЧАСТНИКАМ ВЭД";
    String headerNameSmokeTestFourth = "ФИНАНСОВЫЕ РЫНКИ";
    String headerNameSmokeTestFifth = "PRIVATE BANKING";
    String headerNameSmokeTestSix = "ИНВЕСТОРАМ";
    String headerNameSmokeTestLast = "ЧАСТНЫМ КЛИЕНТАМ";

    public static MainPage mainPage;
    private static ChromeDriver driver;
    /**
     * осуществление первоначальной настройки
     */

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
    /**
     * тестовый метод для осуществления аутентификации
     */
    @Test
    public void smokeTest() {
        String currentHeaderName = mainPage.getHeaderName();
        Assert.assertEquals(headerNameSmokeTestFirst, currentHeaderName);

        mainPage.clickToBusinessButton();
        currentHeaderName = mainPage.getHeaderName();
        Assert.assertEquals(headerNameSmokeTestSecond, currentHeaderName);

        mainPage.clickToForeignTradeButton();
        currentHeaderName = mainPage.getHeaderName();
        Assert.assertEquals(headerNameSmokeTestThird, currentHeaderName);

        mainPage.clickToFinanceButton();
        currentHeaderName = mainPage.getHeaderName();
        Assert.assertEquals(headerNameSmokeTestFourth, currentHeaderName);

        mainPage.clickToVipButton();
        currentHeaderName = mainPage.getHeaderName();
        Assert.assertEquals(headerNameSmokeTestFifth, currentHeaderName);

        mainPage.clickToInvestorsButton();
        currentHeaderName = mainPage.getHeaderName();
        Assert.assertEquals(headerNameSmokeTestSix, currentHeaderName);

        mainPage.clickToRetailButton();
        currentHeaderName = mainPage.getHeaderName();
        Assert.assertEquals(headerNameSmokeTestLast, currentHeaderName);
    }

    /**
     * осуществление выхода из аккаунта с последующим закрытием окна браузера
     */
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
