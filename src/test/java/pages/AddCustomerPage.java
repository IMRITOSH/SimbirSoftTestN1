package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

    public AddCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[ng-click='addCust()']")
    private WebElement buttonTabAddCustomer;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement inputPostCode;

    @FindBy(css = "button.btn.btn-default")
    private WebElement buttonSubmitAddCustomer;

    @Step("Открытие вкладки создания клиента")
    public void goToAddCustomerTab() {
        buttonTabAddCustomer.click();
    }

    @Step("Ввод данных и добавление клиента")
    public void inputCustomerInformation(String firstName, String lastName, String postCode) {
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputPostCode.sendKeys(postCode);

        buttonSubmitAddCustomer.click();
    }
}
