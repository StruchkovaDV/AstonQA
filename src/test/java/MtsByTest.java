import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsByTest {

    private static WebDriver driver;
    private static final String BASE_URL = "https://www.mts.by/";
    private static WebDriverWait wait;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(BASE_URL);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@id = 'cookie-agree']"))
        );
        if (btn != null) {
            btn.click();
        }
        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        By.xpath("//button[@id = 'cookie-agree']"))
        );
    }

    @Test
    void checkTheNameOfBlock() {
        WebElement ttl = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class, 'pay__wrapper')]//h2"))
        );
        String textTitle = ttl.getText();

        assertTrue(textTitle.contains("Онлайн пополнение"));
        assertTrue(textTitle.contains("без комиссии"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"})
    void checkPayPartners(String altText) {
        WebElement logo = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class = 'pay__partners']//img[@alt = '" + altText + "']")
                )
        );

        assertNotNull(logo);
        assertTrue(logo.isDisplayed());
    }

    @Test
    void checkLink() {
        List<WebElement> chatButtons = driver.findElements(
                By.xpath("//a[@class = 'webim-button-corner webim_button']")
        );
        if (!chatButtons.isEmpty()) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].style.display='none';", chatButtons.get(0));
        }

        WebElement link = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']")
                )
        );
        link.click();

        wait.until(
                ExpectedConditions.urlToBe(
                        "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/")
        );

        WebElement pageHeader = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h3[contains(., 'Оплата банковской картой')]")
                )
        );

        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl(),
                "Переход на страницу \"Подробнее о сервисе\" не состоялся.");
        assertNotNull(pageHeader);
        assertEquals("Оплата банковской картой",
                pageHeader.getText(),
                "Заголовок страницы не совпадает с нужным.");
    }

    @Test
    void checkContinueButton() {
        WebElement selectedNow = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@class = 'select__now']"))
        );
        assertNotNull(selectedNow);
        String actual = selectedNow.getText().trim();
        assertEquals("Услуги связи", actual);

        WebElement phoneField = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@id = 'connection-phone']")
                )
        );
        phoneField.click();
        phoneField.clear();
        phoneField.sendKeys("297777777");
        String valuePhone = phoneField.getAttribute("value");
        String digits = valuePhone.replaceAll("\\D", "");
        assertEquals("297777777", digits);

        WebElement sumField = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@id = 'connection-sum']")
                )
        );
        assertNotNull(sumField);
        sumField.click();
        sumField.clear();
        sumField.sendKeys("100");
        String valueSum = sumField.getAttribute("value");
        assertEquals("100", valueSum);

        WebElement continueButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//form[@id = 'pay-connection']/button")
                )
        );
        assertNotNull(continueButton);
        String valueButton = continueButton.getText();
        assertEquals("Продолжить", valueButton);
        continueButton.click();

        wait.until(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                        By.xpath("//iframe[@class = 'bepaid-iframe']"))
        );

        WebElement payDescriptionCost = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class , 'pay-description__cost')]")
                )
        );
        assertTrue(payDescriptionCost.getText().trim().contains("100"));

        WebElement payDescriptionText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class , 'pay-description__text')]")
                )
        );
        assertTrue(payDescriptionText.getText().trim().contains("297777777"));
    }

    @AfterEach
    public void close() {
        driver.quit();
    }
}
