import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.qameta.allure.Step;

import java.util.List;

public class MtsPage extends BasePage {

    private static final String BASE_URL = "https://www.mts.by/";

    private final By cookieAgreeButton = By.id("cookie-agree");
    private final By payBlockTitle = By.xpath("//div[contains(@class, 'pay__wrapper')]//h2");
    private final By serviceTypeSelected = By.xpath("//span[@class = 'select__now']");
    private final By connectionPhoneField = By.id("connection-phone");
    private final By connectionSumField = By.id("connection-sum");
    private final By continueButton = By.xpath("//form[@id = 'pay-connection']/button");
    private final By serviceDetailsLink = By.xpath("//a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']");
    private final By chatButton = By.xpath("//a[@class = 'webim-button-corner webim_button']");
    private final By framePaymentWindow = By.xpath("//iframe[@class = 'bepaid-iframe']");

    private final By selectButton = By.xpath("//button[@class = 'select__header']");

    private final By payFormPhoneField = By.id("connection-phone");
    private final By payFormSumField = By.id("connection-sum");
    private final By payFormEmailField = By.id("connection-email");
    private final By payFormPhoneLabel = By.xpath("//label[@for = 'connection-phone']");
    private final By payFormSumLabel = By.xpath("//label[@for = 'connection-sum']");

    private final By internetFormPhoneField = By.id("internet-phone");
    private final By internetFormSumField = By.id("internet-sum");
    private final By internetFormEmailField = By.id("internet-email");
    private final By internetFormPhoneLabel = By.xpath("//label[@for = 'internet-phone']");
    private final By internetFormSumLabel = By.xpath("//label[@for = 'internet-sum']");

    private final By instalmentFormPhoneField = By.id("score-instalment");
    private final By instalmentFormSumField = By.id("instalment-sum");
    private final By instalmentFormEmailField = By.id("instalment-email");
    private final By instalmentFormSumLabel = By.xpath("//form[@id = 'pay-instalment']//label[@for = 'instalment-sum']");

    private final By arrearsFormPhoneField = By.id("score-arrears");
    private final By arrearsFormSumField = By.id("arrears-sum");
    private final By arrearsFormEmailField = By.id("arrears-email");
    private final By arrearsFormSumLabel = By.xpath("//form[@id = 'pay-arrears']//label[@for = 'instalment-sum']");

    public MtsPage(WebDriver driver) {
        super(driver);
    }

    public MtsPage open() {
        driver.get(BASE_URL);
        return this;
    }

    public MtsPage acceptCookiesIfPresent() {
        List<WebElement> buttons = driver.findElements(cookieAgreeButton);
        if (!buttons.isEmpty()) {
            buttons.get(0).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(cookieAgreeButton));
        }
        return this;
    }

    public String getPayBlockTitle() {
        return waitVisible(payBlockTitle).getText();
    }

    public boolean isPaymentLogoVisible(String altText) {
        By logoLocator = By.xpath("//div[@class='pay__partners']//img[@alt='" + altText + "']");
        WebElement logo = waitVisible(logoLocator);
        return logo.isDisplayed();
    }

    public MtsPage hideChatIfPresent() {
        List<WebElement> chatButtons = driver.findElements(chatButton);
        if (!chatButtons.isEmpty()) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].style.display='none';", chatButtons.get(0));
        }
        return this;
    }

    public PaymentInfoPage clickServiceDetails() {
        click(serviceDetailsLink);
        return new PaymentInfoPage(driver);
    }

    @Step("Проверить, что выбран тип услуги по умолчанию")
    public String getSelectedServiceType() {
        return waitVisible(serviceTypeSelected).getText().trim();
    }

    @Step("Заполнить номер телефона: {phone}")
    public MtsPage fillConnectionPhone(String phone) {
        type(connectionPhoneField, phone);
        return this;
    }

    public String getConnectionPhoneRawValue() {
        return driver.findElement(connectionPhoneField).getAttribute("value");
    }

    @Step("Заполнить сумму: {sum}")
    public MtsPage fillConnectionSum(String sum) {
        type(connectionSumField, sum);
        return this;
    }

    public String getConnectionSumValue() {
        return driver.findElement(connectionSumField).getAttribute("value");
    }

    @Step("Нажать кнопку \"Продолжить\"")
    public MtsPage clickContinue() {
        click(continueButton);
        return this;
    }

    public String getContinueButtonText() {
        return waitVisible(continueButton).getText();
    }

    @Step("Переключиться на окно оплаты")
    public void switchToPaymentFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framePaymentWindow));
    }

    public MtsPage clickServiceList(String text) {
        WebElement header = waitClickable(selectButton);
        header.click();

        WebElement option = waitClickable(
                By.xpath("//ul[contains(@class,'select__list')]//p[@class='select__option' and text()='" + text + "']")
        );
        option.click();
        return this;
    }

    public String getPayFormPhoneFieldText(){
        return waitVisible(payFormPhoneField).getAttribute("placeholder");
    }

    public String getPayFormSumFieldText(){
        return waitVisible(payFormSumField).getAttribute("placeholder");
    }

    public String getPayFormEmailFieldText(){
        return waitVisible(payFormEmailField).getAttribute("placeholder");
    }

    public String getPayFormPhoneLabelText(){
        return waitVisible(payFormPhoneLabel).getText().trim();
    }

    public String getPayFormSumLabelText(){
        return waitVisible(payFormSumLabel).getText().trim();
    }

    public String getInternetFormPhoneFieldText(){
        return waitVisible(internetFormPhoneField).getAttribute("placeholder");
    }

    public String getInternetFormSumFieldText(){
        return waitVisible(internetFormSumField).getAttribute("placeholder");
    }

    public String getInternetFormEmailFieldText(){
        return waitVisible(internetFormEmailField).getAttribute("placeholder");
    }

    public String getInternetFormPhoneLabelText(){
        return waitVisible(internetFormPhoneLabel).getText().trim();
    }

    public String getInternetFormSumLabelText(){
        return waitVisible(internetFormSumLabel).getText().trim();
    }

    public String getInstalmentFormScoreFieldText(){
        return waitVisible(instalmentFormPhoneField).getAttribute("placeholder");
    }

    public String getInstalmentFormSumFieldText(){
        return waitVisible(instalmentFormSumField).getAttribute("placeholder");
    }

    public String getInstalmentFormEmailFieldText(){
        return waitVisible(instalmentFormEmailField).getAttribute("placeholder");
    }

    public String getInstalmentFormSumLabelText(){
        return waitVisible(instalmentFormSumLabel).getText().trim();
    }

    public String getArrearsFormScoreFieldText(){
        return waitVisible(arrearsFormPhoneField).getAttribute("placeholder");
    }

    public String getArrearsFormSumFieldText(){
        return waitVisible(arrearsFormSumField).getAttribute("placeholder");
    }

    public String getArrearsFormEmailFieldText(){
        return waitVisible(arrearsFormEmailField).getAttribute("placeholder");
    }

    public String getArrearsFormSumLabelText(){
        return waitVisible(arrearsFormSumLabel).getText().trim();
    }
}
