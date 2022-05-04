import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Partners {
    private final WebDriver driver;

    public Partners(WebDriver driver) {

        this.driver = driver;
    }
    private final By headPartners = By.xpath("//div[@class='new_header']");
    private final By back = By.xpath("//li[@class='bread_crumbs_list_item'][1]/a[@class='bread_crumbs_link']");
    private final By scroll = By.xpath("//a[@class='scroll_up is_visible']");

    public void ScrollPartnersPage(){
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
        driver.findElement(scroll).click();
    }

    public String HeadPartnersPage(){
        return driver.findElement(headPartners).getText();
    }

    public MainPage BackToMainPage() {
        driver.findElement(back).click();
        return new MainPage(driver);
    }
}
