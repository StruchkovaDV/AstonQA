import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void checkTheNameOfBlock() {
        MtsPage mainPage = new MtsPage(driver)
                .open()
                .acceptCookiesIfPresent();

        String title = mainPage.getPayBlockTitle();

        assertTrue(title.contains("Онлайн пополнение"));
        assertTrue(title.contains("без комиссии"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"})
    void checkPayPartners(String altText) {
        MtsPage mainPage = new MtsPage(driver)
                .open()
                .acceptCookiesIfPresent();

        assertTrue(mainPage.isPaymentLogoVisible(altText));
    }

    @Test
    void checkLink() {
        MtsPage mainPage = new MtsPage(driver)
                .open()
                .acceptCookiesIfPresent()
                .hideChatIfPresent();

        PaymentInfoPage paymentInfoPage = mainPage.clickServiceDetails()
                .waitForLoaded();

        assertEquals(
                paymentInfoPage.getExpectedUrl(),
                paymentInfoPage.getCurrentUrl(),
                "Переход на страницу \"Подробнее о сервисе\" не состоялся."
        );

        assertEquals(
                "Оплата банковской картой",
                paymentInfoPage.getHeaderText(),
                "Заголовок страницы не совпадает с нужным."
        );
    }

    @Test
    void checkContinueButton() {
        MtsPage mainPage = new MtsPage(driver)
                .open()
                .acceptCookiesIfPresent();

        String phone = "297777777";
        String sum = "100";

        assertEquals("Услуги связи", mainPage.getSelectedServiceType());

        mainPage.fillConnectionPhone(phone);
        String phoneRaw = mainPage.getConnectionPhoneRawValue();
        assertNotNull(phoneRaw);
        String digits = phoneRaw.replaceAll("\\D", "");
        assertEquals(phone, digits);

        mainPage.fillConnectionSum(sum);
        assertEquals(sum, mainPage.getConnectionSumValue());

        assertEquals("Продолжить", mainPage.getContinueButtonText());
        mainPage.clickContinue();

        mainPage.switchToPaymentFrame();

        PaymentWindow paymentWindow = new PaymentWindow(driver);
        String title = paymentWindow.getPayDescriptionCost();
        assertTrue(title.contains(sum));
        assertTrue(paymentWindow.getPaymentButtonText().contains(sum));

        assertTrue(paymentWindow.getPayDescriptionText().contains(phone));

        assertEquals("Номер карты", paymentWindow.getCardNumberFieldText());
        assertEquals("Срок действия", paymentWindow.getCardDataFieldText());
        assertEquals("CVC", paymentWindow.getCardCvcFieldText());
        assertEquals("Имя и фамилия на карте", paymentWindow.getCardNameFieldText());

        String[] paymentLogos = {"visa", "mastercard", "belkart", "maestro-system", "mir-system"};
        for(String logo: paymentLogos){
            assertTrue(paymentWindow.isPaymentLogoVisible(logo));
        }
        driver.switchTo().defaultContent();
    }

    @Test
    void checkFieldsOnPayForm(){
        MtsPage mainPage = new MtsPage(driver)
                .open()
                .acceptCookiesIfPresent()
                .clickServiceList("Услуги связи");

        assertEquals("Услуги связи", mainPage.getSelectedServiceType());
        assertEquals("Номер телефона", mainPage.getPayFormPhoneFieldText());
        assertEquals("Сумма", mainPage.getPayFormSumFieldText());
        assertEquals("E-mail для отправки чека", mainPage.getPayFormEmailFieldText());
        assertEquals("+375", mainPage.getPayFormPhoneLabelText());
        assertEquals("Руб.", mainPage.getPayFormSumLabelText());
    }

    @Test
    void checkFieldsOnInternetForm(){
        MtsPage mainPage = new MtsPage(driver)
                .open()
                .acceptCookiesIfPresent()
                .clickServiceList("Домашний интернет");

        assertEquals("Домашний интернет", mainPage.getSelectedServiceType());
        assertEquals("Номер абонента", mainPage.getInternetFormPhoneFieldText());
        assertEquals("Сумма", mainPage.getInternetFormSumFieldText());
        assertEquals("E-mail для отправки чека", mainPage.getInternetFormEmailFieldText());
        assertEquals("+375", mainPage.getInternetFormPhoneLabelText());
        assertEquals("Руб.", mainPage.getInternetFormSumLabelText());
    }

    @Test
    void checkFieldsOnInstalmentForm(){
        MtsPage mainPage = new MtsPage(driver)
                .open()
                .acceptCookiesIfPresent()
                .clickServiceList("Рассрочка");

        assertEquals("Рассрочка", mainPage.getSelectedServiceType());
        assertEquals("Номер счета на 44", mainPage.getInstalmentFormScoreFieldText());
        assertEquals("Сумма", mainPage.getInstalmentFormSumFieldText());
        assertEquals("E-mail для отправки чека", mainPage.getInstalmentFormEmailFieldText());
        assertEquals("Руб.", mainPage.getInstalmentFormSumLabelText());
    }

    @Test
    void checkFieldsOnArrearsForm(){
        MtsPage mainPage = new MtsPage(driver)
                .open()
                .acceptCookiesIfPresent()
                .clickServiceList("Задолженность");

        assertEquals("Задолженность", mainPage.getSelectedServiceType());
        assertEquals("Номер счета на 2073", mainPage.getArrearsFormScoreFieldText());
        assertEquals("Сумма", mainPage.getArrearsFormSumFieldText());
        assertEquals("E-mail для отправки чека", mainPage.getArrearsFormEmailFieldText());
        assertEquals("Руб.", mainPage.getArrearsFormSumLabelText());
    }
}
