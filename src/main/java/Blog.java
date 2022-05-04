import org.openqa.selenium.*;

import java.util.List;

public class Blog {
    private final WebDriver driver;
    public Blog(WebDriver driver) {
        this.driver = driver;
    }
    private final By articlesButton = By.xpath("//div[@class='menu-inner']/a[@class='menu-item'][1]");
    private final By tagsButton = By.xpath("//div[@class='menu-inner']/a[@class='menu-item'][2]");
    private final By searchButton = By.xpath("//div[@class='menu-inner']/span[@class='menu-item search']");
    private final By changeThemeButton = By.xpath("//div[@class='menu-inner']/a[@class='menu-item theme-switch']");
    private final By scrollUpBlog = By.xpath("//a[@class='fixed-button'][1]");
    private final By pagingBlog = By.xpath("//ul[@class='pagination']/li");
    private final By searchField = By.xpath("//span[@class=\"algolia-autocomplete\"]/input[@type=\"text\"]");

    public void getPagingBlog() throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@class=\"pagination\"]/li[3]")).click();
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        List<WebElement> pagingButtons = driver.findElements(pagingBlog);
        for (int i = 1; i <= pagingButtons.size(); ) {
            driver.findElement(By.xpath("//ul[@class=\"pagination\"]/li[" + i + "]")).click();
            i++;
            Thread.sleep(2000);
            ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(2000);
            }
        }

        public String textForAssertButtons(){
        return driver.findElement(By.xpath("//header[@class=\"desktop\"]//a[@title=\"Блог платформы TESSA\"]")).getText();
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

    public void enterTextOnField (String text){
        driver.findElement(searchField).sendKeys(text);
    }

    public void searchBlog(String text) throws InterruptedException {
        this.clickSearch();
        this.enterTextOnField(text);
        Thread.sleep(5000);
        this.driver.findElement(By.xpath("//div[@class=\"suggestion\"][1]")).click();
        Thread.sleep(3000);

    }

    public void clickTheme() {
        driver.findElement(changeThemeButton).click();
    }

    public void scrollBlogPage() {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
        driver.findElement(scrollUpBlog).click();
    }

    public String textForAssertPaging(){
        return driver.findElement(By.xpath("//h1[@class=\"single-title\"]/a[@href=\"/2016/11/welcome/\"]")).getText();
    }

    public String textForAssertScroll(){
        return driver.findElement(By.xpath("//h1[@class=\"single-title\"]/a[@href=\"/2022/03/tessa-3-6-0-7/\"]")).getText();
    }

    public String textForAssertArticles(){
        return driver.findElement(By.xpath("//h2[@class=\"single-title animate__animated animate__pulse animate__faster\"]")).getText();
    }

    public String textForAssertTags(){
        return driver.findElement(By.xpath("//h2[@class=\"single-title animate__animated animate__pulse animate__faster\"]")).getText();
    }

    public String textForAssertSearch(){
        return driver.findElement(By.xpath("//h2[@id=\"заключение\"]")).getText();
    }
}
