import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsPage {
    private final WebDriver driver;

    public ContactsPage(WebDriver driver) {

        this.driver = driver;
    }

    private final By headContacts = By.xpath("//div[@class='new_header']");
    private final By nameFieldContacts = By.xpath("//input[@name='user_name']");
    private final By numberFieldContacts = By.xpath("//input[@name='user_phone']");
    private final By mailFieldContacts = By.xpath("//input[@name='user_email']");
    private final By nameCompanyFieldContacts = By.xpath("//input[@name='user_company']");
    private final By textFieldContacts = By.xpath("//textarea[@name='user_comments']");
    private final By formContactsButton = By.xpath("//form[@class='contacts_form']/div/button[@class='contacts_subm_btn btn send-message']");
    private final By logoButton = By.xpath("//img[@src=\"/img/svg_icons/icon_main_logo.svg\"]");
    private final By linkOnMainPage = By.xpath("//li[1]/a[@class=\"bread_crumbs_link\"]");

    public void clickLinkOnMainPage(){
        driver.findElement(linkOnMainPage).click();
    }

    public void clickLogoButton(){
        driver.findElement(logoButton).click();
    }

    public void typeNameContacts(String name){
        driver.findElement(nameFieldContacts).sendKeys(name);
    }

    public void typeNumberContacts(String number) {
        driver.findElement(numberFieldContacts).sendKeys(number);
    }

    public void typeMailContacts(String mail) {
        driver.findElement(mailFieldContacts).sendKeys(mail);
    }

    public void typeCompanyContacts(String nameCompany) {
        driver.findElement(nameCompanyFieldContacts).sendKeys(nameCompany);
    }

    public void typeTextContacts(String text) {
        driver.findElement(textFieldContacts).sendKeys(text);
    }

    public void clickFormContacts() {
        driver.findElement(formContactsButton).click();

    }

    public String textAlert(){
        return driver.switchTo().alert().getText();
    }

    public void sendFormContacts(String name, String number, String mail, String nameCompany, String text) {
     this.typeNameContacts(name);
     this.typeNumberContacts(number);
     this.typeMailContacts(mail);
     this.typeCompanyContacts(nameCompany);
     this.typeTextContacts(text);
     this.clickFormContacts();
    }
}
