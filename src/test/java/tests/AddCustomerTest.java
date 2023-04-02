package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddCustomerPage;
import utils.Webdriver;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Epic("Add customer tests")
public class AddCustomerTest extends BaseTest {
    WebDriver driver = Webdriver.getChromeDriver();
    AddCustomerPage addCustomerPage = new AddCustomerPage(driver);

    @BeforeAll
    public void setup() {
        openSite(driver);
    }

    @Test
    @Description("Создание клиента")
    public void addCustomer() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        addCustomerPage.goToAddCustomerTab();
        addCustomerPage.inputCustomerInformation("test", "test", "test");
        Alert alert = wait.until(alertIsPresent());
        String alertMessage = alert.getText();

        Assertions.assertTrue(alertMessage.contains("Customer added successfully with customer id :"));

    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
