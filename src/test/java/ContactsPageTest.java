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
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mikhail-PC\\IdeaProjects\\MyTessaTests\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mytessa.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCheckButton();
        contactsPage = new ContactsPage(driver);
    }

    @Test //Отправка запроса при заполнении формы на странице контактной информации
    public void contactsFormTest(){
        contactsPage.sendFormContacts("username", "123456", "123@123", "syntellect", "text");
        String alertText2 = contactsPage.textAlert();
        Assert.assertEquals("Ваш запрос был успешно отправлен!", alertText2);
    }

    @Test //Возврат на главную страницу при нажатии на логотип системы Tessa на странице контактной информации
    public void clickOnLogoTest() throws InterruptedException {
        contactsPage.clickLogoButton();
        Thread.sleep(2000);
        mainPage = new MainPage(driver);
        String textFlipButton = mainPage.textForAssertField();
        Assert.assertEquals("Самая быстрая СЭД", textFlipButton);
    }


    @Test //Возврат на главную страницу при нажатии на ссылку главной страницы на странице контактной информации
    public void clickOnLinkTest() throws InterruptedException {
        contactsPage.clickLinkOnMainPage();
        Thread.sleep(2000);
        mainPage = new MainPage(driver);
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
