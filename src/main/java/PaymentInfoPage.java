import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentInfoPage extends BasePage {

    private final String EXPECTED_URL = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
    private final By header = By.xpath("//h3[contains(., 'Оплата банковской картой')]");

    public PaymentInfoPage(WebDriver driver) {
        super(driver);
    }

    public PaymentInfoPage waitForLoaded() {
        wait.until(ExpectedConditions.urlToBe(EXPECTED_URL));
        waitVisible(header);
        return this;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getHeaderText() {
        return waitVisible(header).getText();
    }

    public String getExpectedUrl() {
        return EXPECTED_URL;
    }
}