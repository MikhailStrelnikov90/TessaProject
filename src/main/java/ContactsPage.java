import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsPage {
    private WebDriver driver;

    public ContactsPage(WebDriver driver) {

        this.driver = driver;
    }

    private By headContacts = By.xpath("//div[@class='new_header']");
    private By nameFieldContacts = By.xpath("//input[@name='user_name']");
    private By numberFieldContacts = By.xpath("//input[@name='user_phone']");
    private By mailFieldContacts = By.xpath("//input[@name='user_email']");
    private By nameCompanyFieldContacts = By.xpath("//input[@name='user_company']");
    private By textFieldContacts = By.xpath("//textarea[@name='user_comments']");
    private By formContactsButton = By.xpath("//form[@class='contacts_form']/div/button[@class='contacts_subm_btn btn send-message']");
    private By logoButton = By.xpath("//img[@src=\"/img/svg_icons/icon_main_logo.svg\"]");
    private By linkOnMainPage = By.xpath("//li[1]/a[@class=\"bread_crumbs_link\"]");

    public void clickLinkOnMainPage(){
        driver.findElement(linkOnMainPage).click();
    }

    public void clickLogoButton(){
        driver.findElement(logoButton).click();
    }

    public ContactsPage typeNameContacts(String name){
        driver.findElement(nameFieldContacts).sendKeys(name);
        return this;
    }

    public ContactsPage typeNumberContacts(String number) {
        driver.findElement(numberFieldContacts).sendKeys(number);
        return this;
    }

    public ContactsPage typeMailContacts(String mail) {
        driver.findElement(mailFieldContacts).sendKeys(mail);
        return this;
    }

    public ContactsPage typeCompanyContacts(String nameCompany) {
        driver.findElement(nameCompanyFieldContacts).sendKeys(nameCompany);
        return this;
    }

    public ContactsPage typeTextContacts(String text) {
        driver.findElement(textFieldContacts).sendKeys(text);
        return this;
    }

    public void clickFormContacts() {
        driver.findElement(formContactsButton).click();

    }

    public String textAlert(){
        return driver.switchTo().alert().getText();
    }

    public ContactsPage sendFormContacts(String name, String number, String mail, String nameCompany, String text) {
     this.typeNameContacts(name);
     this.typeNumberContacts(number);
     this.typeMailContacts(mail);
     this.typeCompanyContacts(nameCompany);
     this.typeTextContacts(text);
     this.clickFormContacts();
     return this;
    }
}
