package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.CustomersPage;
import utils.Webdriver;

import java.time.Duration;

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
    public void sortCustomers() {
            customersPage.goToAddCustomerTab();
            Assertions.assertTrue(customersPage.sortCustomersFirstName());

    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
