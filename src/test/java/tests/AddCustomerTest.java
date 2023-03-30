package tests;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddCustomerPage;
import utils.Webdriver;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

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
