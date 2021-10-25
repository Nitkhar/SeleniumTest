package org.example;
import org.assertj.core.api.SoftAssertions;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
    /**
     * Переменные для проверки
    */
    final static String HEADER_NAME_SMOKE_TEST_FIRST = "ЧАСТНЫМ КЛИЕНТАМ";
    final static String HEADER_NAME_SMOKE_TEST_SECOND = "БИЗНЕС";
    final static String HEADER_NAME_SMOKE_TEST_THIRD = "УЧАСТНИКАМ ВЭД";
    final static String HEADER_NAME_SMOKE_TEST_FOURTH = "ФИНАНСОВЫЕ РЫНКИ";
    final static String HEADER_NAME_SMOKE_TEST_FIFTH = "PRIVATE BANKING";
    final static String HEADER_NAME_SMOKE_TEST_SIX = "ИНВЕСТОРАМ";
    final static String HEADER_NAME_SMOKE_TEST_LAST = "ЧАСТНЫМ КЛИЕНТАМ";

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
        SoftAssertions softAssertions = new SoftAssertions();
        String currentHeaderName = mainPage.getHeaderName();
        softAssertions.assertThat(HEADER_NAME_SMOKE_TEST_FIRST).isEqualTo(currentHeaderName);

        mainPage.clickToBusinessButton();
        currentHeaderName = mainPage.getHeaderName();
        //asert.assertEquals(HEADER_NAME_SMOKE_TEST_SECOND, currentHeaderName);
        softAssertions.assertThat(HEADER_NAME_SMOKE_TEST_SECOND).isEqualTo(currentHeaderName);

        mainPage.clickToForeignTradeButton();
        currentHeaderName = mainPage.getHeaderName();
        //asert.assertEquals(HEADER_NAME_SMOKE_TEST_THIRD, currentHeaderName);
        softAssertions.assertThat(HEADER_NAME_SMOKE_TEST_THIRD).isEqualTo(currentHeaderName);

        mainPage.clickToFinanceButton();
        currentHeaderName = mainPage.getHeaderName();
        //asert.assertEquals(HEADER_NAME_SMOKE_TEST_FOURTH, currentHeaderName);
        softAssertions.assertThat(HEADER_NAME_SMOKE_TEST_FOURTH).isEqualTo(currentHeaderName);

        mainPage.clickToVipButton();
        currentHeaderName = mainPage.getHeaderName();
        //asert.assertEquals(HEADER_NAME_SMOKE_TEST_FIFTH, currentHeaderName);
        softAssertions.assertThat(HEADER_NAME_SMOKE_TEST_FIFTH).isEqualTo(currentHeaderName);

        mainPage.clickToInvestorsButton();
        currentHeaderName = mainPage.getHeaderName();
        //asert.assertEquals(HEADER_NAME_SMOKE_TEST_SIX, currentHeaderName);
        softAssertions.assertThat(HEADER_NAME_SMOKE_TEST_SIX).isEqualTo(currentHeaderName);

        mainPage.clickToRetailButton();
        currentHeaderName = mainPage.getHeaderName();
        //asert.assertEquals(HEADER_NAME_SMOKE_TEST_LAST, currentHeaderName);
        softAssertions.assertThat(HEADER_NAME_SMOKE_TEST_LAST).isEqualTo(currentHeaderName);
        softAssertions.assertAll();
    }

    /**
     * осуществление выхода из аккаунта с последующим закрытием окна браузера
     */
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
