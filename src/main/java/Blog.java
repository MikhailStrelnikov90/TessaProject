import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Blog {
    private WebDriver driver;
    public Blog(WebDriver driver) {
        this.driver = driver;
    }
    private By articlesButton = By.xpath("//div[@class='menu-inner']/a[@class='menu-item'][1]");
    private By tagsButton = By.xpath("//div[@class='menu-inner']/a[@class='menu-item'][2]");
    private By searchButton = By.xpath("//div[@class='menu-inner']/span[@class='menu-item search']");
    private By changeThemeButton = By.xpath("//div[@class='menu-inner']/a[@class='menu-item theme-switch']");
    private By scrollUpBlog = By.xpath("//a[@class='fixed-button'][1]");
    private By pagingBlog = By.xpath("//ul[@class='pagination']/li");
    private By searchField = By.xpath("//span[@class=\"algolia-autocomplete\"]/input[@type=\"text\"]");

    public void getPagingBlog() {
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//ul[@class=\"pagination\"]/li[3]")).click();
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> pagingButtons = driver.findElements(pagingBlog);
        for (int i = 1; i <= pagingButtons.size(); ) {
            driver.findElement(By.xpath("//ul[@class=\"pagination\"]/li[" + i + "]")).click();
            i++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            }
        }

    public Articles clickArticles() {
        driver.findElement(articlesButton).click();
        return new Articles(driver);
    }

    public Tags clickTags() {
        driver.findElement(tagsButton).click();
        return new Tags(driver);
    }

    public void clickSearch() {

        driver.findElement(searchButton).click();
    }

    public Blog enterTextOnField (String text){
        driver.findElement(searchField).sendKeys(text);
        return this;
    }

    public void searchBlog(String text){
        this.clickSearch();
        this.enterTextOnField(text);
    }

    public void clickTheme() {
        driver.findElement(changeThemeButton).click();
    }

    public void scrollBlogPage() {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
        driver.findElement(scrollUpBlog).click();
    }
}
