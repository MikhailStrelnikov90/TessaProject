import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ContactsPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    private ContactsPage contactsPage;

    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mikhail-PC\\IdeaProjects\\MyTessaTests\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mytessa.ru/");
        mainPage = new MainPage(driver);
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
    public void clickOnLogoTest(){
        contactsPage.clickLogoButton();
    }


    @Test //Возврат на главную страницу при нажатии на ссылку главной страницы на странице контактной информации
    public void clickOnLinkTest(){
        contactsPage.clickLinkOnMainPage();
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
