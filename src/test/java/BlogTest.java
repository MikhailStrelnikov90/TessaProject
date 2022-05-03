import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BlogTest {
    private WebDriver driver;
    private Blog blog;

    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mikhail-PC\\IdeaProjects\\MyTessaTests\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mytessa.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBlogButton();
        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        blog = new Blog(driver);
    }

    @Test //Переход на другие страницы блога при нажатии на пейджинг
    public void pagingTest() throws InterruptedException {
        blog.getPagingBlog();
        String textPagingBlog = blog.textForAssertPaging();
        Assert.assertEquals("Добро пожаловать в блог ECM/BPM системы TESSA", textPagingBlog);
    }

    @Test //Скролл страницы блога с помощью функциональных элементов
    public void scrollBlogTest(){
        blog.scrollBlogPage();
        String textScrollBlog = blog.textForAssertScroll();
        Assert.assertEquals("Обновление СЭД TESSA 3.6.0.7", textScrollBlog);
    }

    @Test //Переход на страницу "Статьи" при нажатии на кнопку "Статьи"
    public void moveOnArticlesTest(){
        blog.clickArticles();
        String textArticlesBlog = blog.textForAssertArticles();
        Assert.assertEquals("Все статьи", textArticlesBlog);
    }

    @Test //Переход на страницу "Тэги" при нажатии на кнопку "Тэги"
    public void moveOnTagsTest(){
        blog.clickTags();
        String textTagsBlog = blog.textForAssertTags();
        Assert.assertEquals("Все Тэги", textTagsBlog);
    }

    @Test //Поиск информации по блогу через кнопку "Поиск"
    public void moveOnSearch() throws InterruptedException {
        blog.searchBlog("user");
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
        String textSearchBlog = blog.textForAssertSearch();
        Assert.assertEquals("Заключение", textSearchBlog);
    }

    @Test //Изменение темы блога при нажатии на кнопку "Сменить тему"
    public void moveOnChangeThemeTest(){
        blog.clickTheme();
    }

    @After
    public void finish(){
        driver.quit();
    }
}
