import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IntegrationPage {
    private WebDriver driver;

    public IntegrationPage(WebDriver driver) {
        this.driver = driver;
    }
    private By headIntegrationPage = By.xpath("//div[@class='new_header']");
    private By back = By.xpath("//li[@class='bread_crumbs_list_item'][1]/a[@class='bread_crumbs_link']");
    private By scroll = By.xpath("//a[@class='scroll_up is_visible']");
}
