package org.example;

import io.cucumber.java.ru.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;
import java.util.concurrent.TimeUnit;


public class MyStepdefs {
    public static MainPage mainPage;
    public static LoginPage loginPage;
    public static BluButtonPage bluButtonPage;
    public static CardPage cardPage;
    private static ChromeDriver driver;
    private static SoftAssertions softAssertions = new SoftAssertions();
    final static String REAL_ATOM_TEXT = "Безопасность";
    public static Page currentPage;


    @Когда("пользователь заходит на страницу входа в Банк Санкт-Петербург")
    public void пользовательЗаходитНаСтраницуВходаВБанкСанктПетербург() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://i.bspb.ru/auth?response_type=code&client_id=1&redirect_uri=https%3A%2F%2Fi.bspb.ru%2Flogin%2Fsuccess&prefetch_uri=https%3A%2F%2Fi.bspb.ru%2Flogin%2Fprefetch&force_new_session=true&locale=ru");
    }

    @И("вводит {word} поле логина и {word} в поле пароля")
    public void вводитЛогинПолеЛогинаИПарольВПолеПароля(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
    }

    @Тогда("в поле логина появляется текст {word}, а в поле пароля текст {word}")
    public void вПолеЛогинаПоявляетсяТекстЛогинАВПолеПароляТекстПароль(String username, String password) {
        String usernameInField = loginPage.getUsername();
        String passwordInField = loginPage.getPassword();
        Assert.assertEquals(username,usernameInField);
        Assert.assertEquals(password,passwordInField);
    }

    @И("закрывает браузер")
    public void закрываетБраузер() {
        driver.quit();
    }

    @Дано("пользователь заходит на главную страницу Банка Санкт-Петербург")
    public void пользовательЗаходитНаГлавнуюСтраницуБанкаСанктПетербург() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        bluButtonPage = new BluButtonPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bspb.ru/");
    }

    @Когда("пользователь нажимает на пятую кнопку-переключатель")
    public void пользовательНажимаетНаПятуюКнопкуПереключатель() {
        bluButtonPage.clickToSmallButton();
    }

    @И("нажимает на большую голубую кнопку")
    public void нажимаетНаБольшуюГолубуюКнопку() {
        bluButtonPage.clickToBluBatton();
    }

    @Тогда("пользователь переходит на страницу Безопасность")
    public void пользовательПереходитНаСтраницу() {
        String textAtom = bluButtonPage.getAtomText();
        Assert.assertEquals(REAL_ATOM_TEXT, textAtom);
    }

    @Когда("пользователь нажимает на кнопку Потребительский кредит в списке Кредиты")
    public void пользовательНажимаетНаКнопкуВСписке() {
        mainPage.clickToCreditButton();
    }

    @Тогда("пользователь заходит на страницу Потребительский кредит")
    public void пользовательЗаходитНаСтраницуПотребительскийКредит() {

    }

    @И("проверяет что находится на странице {string}")
    public void проверяетЧтоНаходитсяНаСтранице(String arg0) {
        String currentHeaderName = mainPage.getHeaderName();
        softAssertions.assertThat(arg0).isEqualTo(currentHeaderName);
    }

    @Затем("переходит на страницу Бизнесу")
    public void переходитНаСтраницуБизнесу() {
        mainPage.clickToBusinessButton();
    }

    @Затем("переходит на страницу Участникам ВЭД")
    public void переходитНаСтраницуУчастникамВЭД() {
        mainPage.clickToForeignTradeButton();
    }

    @Затем("переходит на страницу Финансовые рынки")
    public void переходитНаСтраницуФинансовыеРынки() {
        mainPage.clickToFinanceButton();
    }

    @Затем("переходит на страницу Private Banking")
    public void переходитНаСтраницуPrivateBanking() {
        mainPage.clickToVipButton();
    }

    @Затем("переходит на страницу Инвесторам")
    public void переходитНаСтраницуИнвесторам() {
        mainPage.clickToInvestorsButton();
    }

    @Затем("переходит на страницу Частным клиентам")
    public void переходитНаСтраницуЧастнымКлиентам() {
        mainPage.clickToRetailButton();
    }

    @И("пользователь вводит текст {string} в текстовое поле {string}")
    public void пользовательВводитТекстВТекстовоеПоле(String text, String fieldsName) {

    }

    @Дано("пользователь заходит на страницу заказа карты")
    public void пользовательЗаходитНаСтраницуЗаказаКарты() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        cardPage = new CardPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        currentPage = cardPage;
        driver.get("https://www.bspb.ru/retail/cards/form/?cardApplication.cardType=Cards_Pers_Premium_MCWorld&bspb_param=analytics-btn");
    }

    @Когда("пользователь заполняет поля данными:")
    public void пользовательЗаполняетПоляДанными(Map<String, String> fields) {
        currentPage.fillFields(fields);
    }

    @Затем("пользователь проверяет что данные в полях соответствуют требуемым:")
    public void пользовательПроверяетЧтоДанныеВПоляхСоответствуютТребуемым(Map<String, String> fields) {
        currentPage.checkFields(fields);
    }
}
