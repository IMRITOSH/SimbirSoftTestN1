package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

    public AddCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    private WebElement buttonTabAddCustomer;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement inputPostCode;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSubmitAddCustomer;

    public void goToAddCustomerTab() {
        buttonTabAddCustomer.click();
    }

    public void inputCustomerInformation(String firstName, String lastName, String postCode) {
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputPostCode.sendKeys(postCode);

        buttonSubmitAddCustomer.click();
    }
}
