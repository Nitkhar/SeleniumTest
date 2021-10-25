package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class DropListTest {
    public static MainPage mainPage;
    public static CreditPage creditPage;
    private static ChromeDriver driver;
    final static String creditPageHeader = "Потребительские кредиты";

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        creditPage = new CreditPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bspb.ru/");
    }

    @Test
    public void dropListTest() {
        mainPage.clickToCreditButton();
        String creditPageText = creditPage.getCreditPageText();
        Assert.assertEquals(creditPageText, creditPageHeader);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
