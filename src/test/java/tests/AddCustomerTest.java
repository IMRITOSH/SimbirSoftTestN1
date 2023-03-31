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

@Epic("Add customer tests")
public class AddCustomerTest {
    static WebDriver driver = Webdriver.getChromeDriver();
    AddCustomerPage addCustomerPage = new AddCustomerPage(driver);

    @BeforeAll
    public static void setup() {
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    @Description("Создание клиента")
    public void addCustomer() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        addCustomerPage.goToAddCustomerTab();
        addCustomerPage.inputCustomerInformation("test", "test", "test");
        Alert alert = wait.until(alertIsPresent());
        String alertMessage = alert.getText().substring(0, alert.getText().length() - 1);

        Assertions.assertEquals(alertMessage, "Customer added successfully with customer id :");

    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
