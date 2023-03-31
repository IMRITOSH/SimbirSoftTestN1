package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.CustomersPage;
import utils.Webdriver;

import java.time.Duration;

@Epic("Sorted customers tests")
public class SortedCustomersTest {
    static WebDriver driver = Webdriver.getChromeDriver();
    CustomersPage customersPage = new CustomersPage(driver);

    @BeforeAll
    public static void setup() {
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    @Description("Сортировка клиентов по имени")
    public void sortCustomers() {
        customersPage.goToAddCustomerTab();
        Assertions.assertTrue(customersPage.sortCustomersFirstName());

    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
