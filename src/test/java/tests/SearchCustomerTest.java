package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddCustomerPage;
import pages.CustomersPage;
import utils.Webdriver;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

@Tag("SearchCustomerTests")
@Epic("Search customer tests")
public class SearchCustomerTest {
    static WebDriver driver = Webdriver.getChromeDriver();
    CustomersPage customersPage = new CustomersPage(driver);
    AddCustomerPage addCustomerPage = new AddCustomerPage(driver);

    @BeforeAll
    public static void setup() {
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeEach
    public void beforeTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            addCustomerPage.goToAddCustomerTab();
            addCustomerPage.inputCustomerInformation("Imran", "Tepsurkaev", "E585IB");
            Alert alert = wait.until(alertIsPresent());
            alert.accept();

    }

    @Test
    @Description("Поиск клиента по имени")
    public void searchCustomer() {
            customersPage.goToAddCustomerTab();
            Assertions.assertTrue(customersPage.searchCustomer("Imran"));
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
