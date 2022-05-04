import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ContactsPageTest {
    private WebDriver driver;
    private ContactsPage contactsPage;
    private MainPage mainPage;

    @Before
    public void start(){
        String driverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mytessa.ru/");
        MainPage mainPage = new MainPage(driver);
        contactsPage = mainPage.clickCheckButton();
    }

    @Test //Отправка запроса при заполнении формы на странице контактной информации
    public void contactsFormTest(){
        contactsPage.sendFormContacts("username", "123456", "123@123", "syntellect", "text");
        String alertText2 = contactsPage.textAlert();
        Assert.assertEquals("Ваш запрос был успешно отправлен!", alertText2);
    }

    @Test //Возврат на главную страницу при нажатии на логотип системы Tessa на странице контактной информации
    public void clickOnLogoTest() throws InterruptedException {
        mainPage = contactsPage.clickLogoButton();
        Thread.sleep(2000);
        String textFlipButton = mainPage.textForAssertField();
        Assert.assertEquals("Самая быстрая СЭД", textFlipButton);
    }


    @Test //Возврат на главную страницу при нажатии на ссылку главной страницы на странице контактной информации
    public void clickOnLinkTest() throws InterruptedException {
        mainPage = contactsPage.clickLinkOnMainPage();
        String textFlipButton = mainPage.textForAssertField();
        Assert.assertEquals("Самая быстрая СЭД", textFlipButton);
    }

    @Test //Отправка запроса при заполнении формы невалидными данными на странице контактной информации
    public void contactsFormWithInvValTest(){
        contactsPage.sendFormContacts("", "123456", "123@123", "syntellect", "text");
        String alertText2 = contactsPage.textAlert();
        Assert.assertEquals("Поле «Ваше имя» обязательно для заполнения.", alertText2);
    }

    @After
    public void finish(){
        driver.quit();
    }
}
