import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentWindow extends BasePage{

    private final By payDescriptionCost = By.xpath("//div[contains(@class , 'pay-description__cost')]");
    private final By payDescriptionText = By.xpath("//div[contains(@class , 'pay-description__text')]");
    private final By cardNumberField = By.xpath("//input[@autocomplete='cc-number']/following-sibling::label[1]");
    private final By cardDataField = By.xpath("//input[@autocomplete='cc-exp']/following-sibling::label[1]");
    private final By cardCvcField = By.xpath("//input[@autocomplete = 'cc-csc']/following-sibling::label[1]");
    private final By cardNameField = By.xpath("//input[@autocomplete = 'cc-name']/following-sibling::label[1]");
    private final By paymentButton = By.xpath("//div[@class='card-page__card']//button");

    public PaymentWindow(WebDriver driver) {
        super(driver);
    }

    public String getPayDescriptionCost(){
        return waitVisible(payDescriptionCost).getText().trim();
    }

    public String getPayDescriptionText(){
        return waitVisible(payDescriptionText).getText().trim();
    }

    public String getPaymentButtonText(){
        return waitVisible(paymentButton).getText().trim();
    }

    public String getCardNumberFieldText(){
        return waitVisible(cardNumberField).getText().trim();
    }

    public String getCardDataFieldText(){
        return waitVisible(cardDataField).getText().trim();
    }

    public String getCardCvcFieldText(){
        return waitVisible(cardCvcField).getText().trim();
    }

    public String getCardNameFieldText(){
        return waitVisible(cardNameField).getText().trim();
    }

    public boolean isPaymentLogoVisible(String scrText) {
        By logoLocator = By.xpath("//img[contains(@src, '" + scrText + "')]");
        WebElement logo = waitVisible(logoLocator);
        return logo.isDisplayed();
    }
}
