package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;
import pages.PIMPage;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.Duration;

public class PIMTest {
    static WebDriver driver;
    LoginPage loginPage;
    CommonPage commonPage;
    PIMPage pimPage;

    @BeforeMethod
    public void before(){
        driver = Driver.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage();
        commonPage = new CommonPage();
        pimPage = new PIMPage();
    }


    @Test
    public void pimTest(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        loginPage.login("admin", "admin123");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

        commonPage.goToTab(commonPage.pimTab);

        pimPage.addEmployeeButton();

        pimPage.addEmployee();
        pimPage.setSaveButton();


        SeleniumUtils.verifyTextInElement(driver, 10, pimPage.pimNames, pimPage.verifyName);

        commonPage.goToTab(commonPage.pimTab);

        System.out.println(pimPage.fakerIdStored);


        WebElement getEmployeeId = driver.findElement(By.xpath("//div[text()='" + pimPage.fakerIdStored + "']"));
        WebElement getEmployeeFirst = driver.findElement(By.xpath("//div[text()='" + pimPage.fakerIdStored + "']/../following-sibling::div[1]"));
        WebElement getEmployeeLast = driver.findElement(By.xpath("//div[text()='" + pimPage.fakerIdStored + "']/../following-sibling::div[2]"));
//        pimPage.getAll();
//        Assertions.assertEquals(pimPage.verifyName, pimPage.pimNames.getText());
        System.out.println(pimPage.firstNames.size());

        SeleniumUtils.verifyTextInElement(driver, 10, getEmployeeId, pimPage.employeeId);
        SeleniumUtils.verifyTextInElement(driver, 10, getEmployeeFirst, pimPage.firstName);
        SeleniumUtils.verifyTextInElement(driver, 10, getEmployeeLast, pimPage.lastName);
    }
}
