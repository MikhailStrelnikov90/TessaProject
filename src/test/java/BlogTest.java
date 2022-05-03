import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BlogTest {
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
        mainPage.clickBlogButton();
        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        blog = new Blog(driver);
    }

    @Test //Переход на другие страницы блога при нажатии на пейджинг
    public void pagingTest(){
        blog.getPagingBlog();
    }

    @Test //Скролл страницы блога с помощью функциональных элементов
    public void scrollBlogTest(){
        blog.scrollBlogPage();
    }

    @Test //Переход на страницу "Статьи" при нажатии на кнопку "Статьи"
    public void moveOnArticlesTest(){
        blog.clickArticles();
    }

    @Test //Переход на страницу "Тэги" при нажатии на кнопку "Тэги"
    public void moveOnTagsTest(){
        blog.clickTags();
    }

    @Test //Поиск информации по блогу через кнопку "Поиск"
    public void moveOnSearch(){
    blog.searchBlog("tessa");
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
