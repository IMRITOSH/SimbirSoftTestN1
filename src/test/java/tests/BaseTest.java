package tests;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest {
    public  void openSite(WebDriver driver){
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
