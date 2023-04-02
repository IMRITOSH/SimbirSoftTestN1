package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @FindBy(xpath = "//input[@ng-model='searchCustomer']")
    private WebElement inputSearchCustomer;

    @FindBy(xpath = "//tbody/tr/td[1]")
    private WebElement foundFieldFirstName;

    @Step("Открытие вкладки с таблицей клиентов")
    public void goToCustomersTab() {
        buttonTabCustomers.click();
    }

    @Step("Нажатие на поле First Name")
    public void clickfieldFirstName() {
        fieldFirstName.click();
    }

    @Step("Отсортирвоать клиентов в алфавитном порядке по имени")
    public boolean sortCustomers(String[][] table, String sortedRow) {
        String[][] sortedTable = fillTwoDimensionalArray(tableCustomers.getText());
        boolean isTrue = true;
        List<String> listRows;
        List<String> sortedListRows;

        switch (sortedRow) {
            case "First name":
                listRows = fillListRows(table, 0);
                Collections.sort(listRows, Collections.reverseOrder());
                sortedListRows = fillListRows(sortedTable, 0);
                isTrue = equalsLists(sortedListRows, listRows);
                break;
            case "Last name":
                listRows = fillListRows(table, 1);
                Collections.sort(listRows, Collections.reverseOrder());
                sortedListRows = fillListRows(sortedTable, 1);
                isTrue = equalsLists(sortedListRows, listRows);
                break;
            case "Post code":
                listRows = fillListRows(table, 2);
                Collections.sort(listRows, Collections.reverseOrder());
                sortedListRows = fillListRows(sortedTable, 2);
                isTrue = equalsLists(sortedListRows, listRows);
                break;
        }

        return isTrue;
    }

    @Step("Поиск клиента по введенному имени")
    public boolean searchCustomer(String searchedString) {
        inputSearchCustomer.sendKeys(searchedString);

        if (foundFieldFirstName.getText().equals(searchedString)) {
            return true;
        }

        return false;
    }

    public String[][] fillTwoDimensionalArray(String stringForFillArray) {
        String[] rows = stringForFillArray.split("\n");
        String[][] matrix = new String[rows.length][];
        int index = 0;
        for (String row : rows) {
            matrix[index++] = row.split(" ");
        }

        return matrix;
    }

    public List<String> fillListRows(String[][] matrix, int numberRows) {
        List<String> rows = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            rows.add(matrix[i][numberRows]);
        }

        return rows;
    }

    public boolean equalsLists(List<String> sortedList, List<String> listRows) {
        for (int i = 0; i < sortedList.size(); i++) {
            if (!sortedList.get(i).equals(listRows.get(i))) {
                return false;
            }
        }

        return true;
    }
}
