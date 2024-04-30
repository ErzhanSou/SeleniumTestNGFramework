package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.DirectoryPage;
import pages.LoginPage;
import utilities.Driver;
import utilities.SeleniumUtils;

public class verifyChiefTest {
    LoginPage loginPage;
    CommonPage commonPage;
    DirectoryPage directoryPage;
    WebDriver driver;


    @BeforeSuite
    public void before(){
        loginPage = new LoginPage();
        commonPage = new CommonPage();
        directoryPage = new DirectoryPage();
        driver = Driver.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void verifyChief(){
        loginPage.login("Admin", "admin123");
        SeleniumUtils.click(driver, commonPage.directoryTab);
        SeleniumUtils.click(driver, directoryPage.jobTitleSelector);
        SeleniumUtils.click(driver, directoryPage.selectFinancialOfficer);
        SeleniumUtils.click(driver, directoryPage.searchButton);

        for (WebElement element : directoryPage.getAllUser){
            System.out.println(element.getText());
        }
    }

}
