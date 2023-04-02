package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.CustomersPage;
import utils.Webdriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Epic("Sorted customers tests")
public class SortedCustomersTest extends BaseTest {
    WebDriver driver = Webdriver.getChromeDriver();
    CustomersPage customersPage = new CustomersPage(driver);

    @BeforeAll
    public void setup() {
        openSite(driver);
    }

    @Test
    @Description("Сортировка клиентов по имени")
    public void sortCustomers() {
        customersPage.goToCustomersTab();
        String[][] table = customersPage.fillTwoDimensionalArray(customersPage.tableCustomers.getText());
        customersPage.clickfieldFirstName();
        Assertions.assertTrue(customersPage.sortCustomers(table, "First name"));
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
