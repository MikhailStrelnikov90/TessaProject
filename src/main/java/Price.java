import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Price {
    private final WebDriver driver;

    public Price(WebDriver driver) {
        this.driver = driver;
    }
    private final By headPrice = By.xpath("//div[@class='new_header']");
    private final By back = By.xpath("//li[@class='bread_crumbs_list_item'][1]/a[@class='bread_crumbs_link']");
    private final By scroll = By.xpath("//a[@class='scroll_up is_visible']");

    public void ScrollPricePage(){
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
        driver.findElement(scroll).click();
    }

    public String HeadPricePage(){

        return driver.findElement(headPrice).getText();
    }

    public void BackToMainPage() {
        driver.findElement(back).click();
        new MainPage(driver);
    }
}
