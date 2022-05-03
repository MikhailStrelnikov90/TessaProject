import org.openqa.selenium.*;

import java.util.List;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //Элементы управления главного меню сайта
    private By aboutSystemButton = By.xpath("//div[@class='container']//li[@class='header_nav_list_item'][1]"); //кнопка "Система" в главном меню
    private By logoButton = By.xpath("//div[@class='site_logo']"); //логотип в верхнем левом углу сайта
    private By aboutCompanyButton = By.xpath("//div[@class='container']//li[@class='header_nav_list_item'][2]"); //кнопка "Компания в главном меню сайта
    private By ServiceButton = By.xpath("//div[@class='container']//li[@class='header_nav_list_item'][3]"); //кнопка "Услуги" в главном меню
    private By priceListButton = By.xpath("//div[@class='container']//li[@class='header_nav_list_item'][4]"); //кнопка "Купить" в главном меню
    private By partnersButton = By.xpath("//div[@class='container']//li[@class='header_nav_list_item'][5]"); //кнопка "Партнеры" в главном меню
    private By blogTessaButton = By.xpath("//div[@class='container']//li[@class='header_nav_list_item'][6]"); //кнопка "Блог" в главном меню
    //элементы формы "Контакты" на главной странице
    private By nameField = By.xpath("//div/input[@name='user_name']");
    private By numberField = By.xpath("//div/input[@name='user_contacts']");
    private By textField = By.xpath("//div/textarea[@name='user_comments']");
    private By feedbackButton = By.xpath("//form[@class='contacts_form']/div/button[@name='contacts_subm']");
    //элементы формы "Поиск по сайту"
    private By searchButton = By.xpath("//div[@class=\"user_action_stuff\"]//div[@class=\"search_box_button\"]");
    private By searchField = By.xpath("//div[@class=\"user_action_stuff\"]//div[@class=\"header_search_wrap_helper\"]//input[@type=\"search\"]");
    //элементы формы "Заказать звонок"
    private By callButton = By.xpath("//div[@class=\"call_back\"]/a[@class=\"call_back_btn\"]");
    private By callNameField = By.xpath("//input[@name=\"user_call_name\"]");
    private By callNumberField = By.xpath("//form[@class=\"call_request_form\"]/div[@class=\"field_group\"]/input[@name=\"user_contacts\"]");
    private By callEndButton = By.xpath("//button[@id=\"call_req_btn\"]");
    //ссылки на страницы сайта на главной странице
    private By linkOnContactsButton1 = By.xpath("//div[@class=\"swiper-slide slide_speed swiper-slide-active\"]//a[@href=\"/company/contacts/\"]");    //кнопка "Проверьте сами"
    private By linkOnIntegrationVTBButton = By.xpath("//div[@class=\"slide_btn_wrap\"]/a[@href=\"/system/implementations/TESSA-v-vtb24\"]");  //кнопка "Подробнее о внедрении"
    private By linkOnContactsButton2 = By.xpath("//div[@class=\"swiper-slide slide_users skrollable skrollable-between swiper-slide-active\"]//a[@href=\"/company/contacts/\"]");  //кнопка "Подобрать для себя"
    private By linkOnNews = By.xpath("//div[@class=\"news_btn_wrap\"]/a[@href=\"/company/news/\"]");   //кнопка "Все новости"
    private By linkIntegrations = By.xpath("//div[@class=\"proj_btn_wrap\"]/a[@href=\"/system/implementations/\"]"); //кнопка "Все проекты"
    private By linkOnCustomers = By.xpath("//div[@class=\"reviews_btn_wrap\"]/a[@href=\"/company/customers/\"]");  //кнопка "Все клиенты"
    private By linkOnReviews = By.xpath("//div[@class=\"reviews_btn_wrap\"]/a[@href=\"/company/reviews/\"]");   //кнопка "Все отзывы"
    private By engVerButton = By.xpath("//div[@class=\"user_action_stuff\"]//a[@class=\"lang_box\"]"); //кнопка перехода на англоязычную версию страницы
    //другие элементы
    private By textForAssert = By.xpath("//div[@class=\"swiper-slide slide_speed swiper-slide-active\"]/div[@class=\"container\"]/div[@class=\"slide_desc\"]"); //текст для проверки
    private By flipNextReviews = By.xpath("//div[@class=\"reviews_btn_next\"]"); //перелистывание отзывов вперед на главной страницы
    private By flipBackReviews = By.xpath("//div[@class=\"reviews_btn_prev\"]"); //перелистывание отзывов назад на главной странице
    private By scrollUp = By.xpath("//a[@class='scroll_up is_visible']"); //скролл вверх
    private By scrollDown = By.xpath("//div[2]/div[@class='slide_down_btn_wrap']/a"); //скролл вниз по кнопке на главной странице
    private By flipNext = By.xpath("//div[@class='main_slider_button_next']"); //перелистывание направо меню на главной странице
    private By flipLeft = By.xpath("//div[@class='main_slider_button_prev']"); //перелистывание налево меню на главной странице

    public void flippingNextAndBackReviews(){
        driver.findElement(flipNextReviews).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(flipBackReviews).click();
    }


    public String textForAssertField(){
        return driver.findElement(textForAssert).getText();
    }

    public void allLinksMainPage(){
        driver.findElement(linkOnContactsButton1).click();
        driver.navigate().back();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(flipNext).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(linkOnIntegrationVTBButton).click();
        driver.navigate().back();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(flipNext).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(flipNext).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(linkOnContactsButton2).click();
        driver.navigate().back();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(linkOnNews).click();
        driver.navigate().back();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(linkIntegrations).click();
        driver.navigate().back();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(linkOnCustomers).click();
        driver.navigate().back();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(linkOnReviews).click();
    }

    public MainPage callForm(String name, String number){
        this.clickCallButton();
        this.enterCallName(name);
        this.enterCallNumber(number);
        this.clickCallEndForm();
        return this;
    }

    public MainPage enterCallName(String name){
        driver.findElement(callNameField).sendKeys(name);
        return this;
    }

    public MainPage enterCallNumber(String number){
        driver.findElement(callNumberField).sendKeys(number);
        return this;
    }

    public void clickCallEndForm(){
    driver.findElement(callEndButton).click();
    }

    public void clickCallButton(){
        driver.findElement(callButton).click();
    }

    public void clickEngVersButton(){
        driver.findElement(engVerButton).click();
    }


    public void clickSearchMainPage(){
        driver.findElement(searchButton).click();
    }

    public MainPage textForSearchField(String text){
        this.sendTextForSearchField(text);
        this.driver.findElement(searchField).sendKeys(Keys.ENTER);
        return this;
    }

    public MainPage sendTextForSearchField(String text){
        driver.findElement(searchField).sendKeys(text);
        return this;
    }

    public void listAllButtons() {
        List<WebElement> listButtons = driver.findElements(By.xpath("//ul[@class='slider_nav_list']/li"));
        for (WebElement buttons : listButtons){
            buttons.click();
        }
    }

    public void listAllPages(){
        List<WebElement> listPages = driver.findElements(By.xpath("//div[@class=\"container\"]//ul[@class=\"header_nav_list\"]/li"));
        for(int i = 1; i <= listPages.size();){
            driver.findElement(By.xpath("//div[@class=\"container\"]//ul[@class=\"header_nav_list\"]/li["+ i +"]")).click();
            i++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            }
        }

    public MainPage typeName (String name){
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public MainPage typeNumber (String number) {
        driver.findElement(numberField).sendKeys(number);
        return this;
    }

    public MainPage typetext (String text) {
        driver.findElement(textField).sendKeys(text);
        return this;
    }

    public AboutSystem clickSystemButton() {
        driver.findElement(aboutSystemButton).click();
        return new AboutSystem(driver);
    }

    public AboutCompany clickCompanyButton() {
        driver.findElement(aboutCompanyButton).click();
        return new AboutCompany(driver);
    }

    public AboutService clickServiceButton() {
        driver.findElement(ServiceButton).click();
        return new AboutService(driver);
    }

    public void clickLogoButton(){
        driver.findElement(logoButton).click();
    }

    public Price clickPriceListButton() {
        driver.findElement(priceListButton).click();
        return new Price(driver);
    }

    public Partners clickPartnersButton() {
        driver.findElement(partnersButton).click();
        return new Partners(driver);
    }

    public Blog clickBlogButton() {
        driver.findElement(blogTessaButton).click();
        return new Blog(driver);
    }

    public ContactsPage clickCheckButton() {
        driver.findElement(linkOnContactsButton1).click();
        return new ContactsPage(driver);
    }

    public void clickFeedbackButton() {
        driver.findElement(feedbackButton).click();
    }

    public MainPage feedbackForm(String name, String number, String text) {
        this.typeName(name);
        this.typeNumber(number);
        this.typetext(text);
        this.clickFeedbackButton();
        return this;
    }

    public String textAlert(){
        return driver.switchTo().alert().getText();
    }

    public String textLsButton(){
        return driver.findElement(By.xpath("//div[6]/div[@class=\"container\"]/div[@class=\"slide_desc\"]")).getText();
    }

    public void flippingNext() {
        driver.findElement(flipNext).click();
    }

    public void flippingBack() {
        driver.findElement(flipLeft).click();
    }

    public void scrollDownMainPage() {
        driver.findElement(scrollDown).click();
    }

    public void scrollUpMainPage() {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(scrollUp).click();
    }
}
