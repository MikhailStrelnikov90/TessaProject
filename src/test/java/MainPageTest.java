import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainPageTest {

private WebDriver driver;
private MainPage mainPage;
private Blog blog;

    @Before
    public void start(){
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mikhail-PC\\IdeaProjects\\MyTessaTests\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.get("https://mytessa.ru/");
    mainPage = new MainPage(driver);
    }

    @Test //Переход на другие страницы сайта через меню на главной странице
    public void moveAllPagesOnMainPage(){
        mainPage.listAllPages();
        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        blog = new Blog(driver);
        String textBlogPage = blog.textForAssertButtons();
        Assert.assertEquals("Блог платформы TESSA", textBlogPage);
    }

    @Test //Поиск информации по сайту через кнопку "Поиск по сайту"
    public void searchInfoTest(){
    mainPage.clickSearchMainPage();
    mainPage.textForSearchField("tessa");
        String textSearchPage = mainPage.textForAssertSearch();
        Assert.assertEquals("Поиск по сайту", textSearchPage);
    }

    @Test //Переход на английскую версию страницы через кнопку "Изменить язык"
    public void ChangeLanguage(){
        mainPage.clickEngVersButton();
        String textEngVerPage = mainPage.textForAssertEngVer();
        Assert.assertEquals("TESSA - document management system", textEngVerPage);
    }

    @Test //Заказ обратного звонка при нажатии на кнопку "Заказать звонок"
    public void callTest(){
    mainPage.callForm("user", "1234567890");
        String alertText = mainPage.textAlert();
        Assert.assertEquals("Ваш запрос был успешно отправлен!", alertText);
    }

    @Test //Заказ обратного звонка с невалидными данными при нажатии на кнопку "Заказать звонок"
    public void callWithInvValTest(){
        mainPage.callForm("user", "12345678");
        String alertText = mainPage.textAlert();
        Assert.assertEquals("Поле «Телефон для связи» обязательно для заполнения.", alertText);
    }

    @Test //Переход на другие страницы сайта через кнопки на главной странице
    public void linkPagesButtonTest() throws InterruptedException {
        mainPage.allLinksMainPage();
        Thread.sleep(3000);
        Reviews reviews = new Reviews(driver);
        String textButton = reviews.textOnReviews();
        Assert.assertEquals("Отзывы, рекомендательные письма", textButton);
    }

    @Test //Перелистывание блока с преимуществами системы нажатиями на кнопки "Следующая тема" и "Предыдущая тема" на главной странице
    public void flippingChapter1() throws InterruptedException {
        mainPage.flippingNext();
        Thread.sleep(2000);
        mainPage.flippingBack();
        Thread.sleep(2000);
        String textFlipButton = mainPage.textForAssertField();
        Assert.assertEquals("Самая быстрая СЭД", textFlipButton);
    }

    @Test //Перелистывание отзывов заказчиков нажатиями на кнопки "Следующая тема" и "Предыдущая тема" на главной странице
    public void flippingChapter2() throws InterruptedException {
        mainPage.flippingNextAndBackReviews();
        Thread.sleep(2000);
        String textFlipReviews = mainPage.textForAssertFlippingReviews();
        Assert.assertEquals("ВТБ", textFlipReviews);
    }


    @Test //Отправка запроса при заполнении формы на главной странице
    public void feedBackTest(){
    mainPage.feedbackForm("username", "12345", "test");
   String alertText = mainPage.textAlert();
   Assert.assertEquals("Ваш запрос был успешно отправлен!", alertText);
   }

   @Test //Отправка запроса при заполнении формы невалидными значениями на главной странице
   public void feedBackWithInvalidValTest(){
       mainPage.feedbackForm("", "12345", "test");
       String alertText = mainPage.textAlert();
       Assert.assertEquals("Поле «Ваше имя» обязательно для заполнения.", alertText);
   }


   @Test //Перелистывание блока с преимуществами системы нажатиями на кнопки на главной странице
   public void listButtoncheck() throws InterruptedException {
    mainPage.listAllButtons();
    Thread.sleep(5000);
    String textLastButton = mainPage.textLsButton();
    Assert.assertEquals("Сохраненных нервных клеток", textLastButton);
   }

   @Test //Скролл главной страницы с помощью функциональных элементов
   public void scrollMainPageTest() throws InterruptedException {
       mainPage.scrollDownMainPage();
       Thread.sleep(1000);
       mainPage.scrollUpMainPage();
       Thread.sleep(1000);
       String textFlipButton = mainPage.textForAssertField();
       Assert.assertEquals("Самая быстрая СЭД", textFlipButton);
   }

    @After
    public void finish(){
    driver.quit();
    }

}
