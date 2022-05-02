import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Reviews {
    private WebDriver driver;

    public Reviews(WebDriver driver) {
        this.driver = driver;
    }

    private By textReviews = By.xpath("//div[@class=\"new_header\"]");  //текст на странице отзывы

    public String textOnReviews(){
        return driver.findElement(textReviews).getText();
    }
}
