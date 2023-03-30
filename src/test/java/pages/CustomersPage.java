package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.Collections;

public class CustomersPage {

    public CustomersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    private WebElement buttonTabCustomers;

    @FindBy(xpath = "//thead/tr/td[1]/a")
    private WebElement fieldFirstName;

    @FindBy(xpath = "//tbody")
    public WebElement tableCustomers;

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    private WebElement inputSearchCustomer;

    @FindBy(xpath = "//td[text()='Imran']")
    private WebElement firstNameSearchCustomer;

    public void goToAddCustomerTab() {
        buttonTabCustomers.click();
    }

    public boolean sortCustomersFirstName() {
        String[] tableRows = tableCustomers.getText().split("\n");
        Arrays.sort(tableRows, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));

        fieldFirstName.click();
        String[] sortedTableRows = tableCustomers.getText().split("\n");

        for (int i = 0; i < sortedTableRows.length; i++) {
            if (!sortedTableRows[i].equals(tableRows[i])) {
                return false;
            }
        }

        return true;
    }

    public boolean searchCustomer(String firstName) {
        inputSearchCustomer.sendKeys(firstName);

        if (firstNameSearchCustomer.getText().equals(firstName)) {
            return true;
        }

        return false;
    }
}
