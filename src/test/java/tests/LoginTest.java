package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Driver;

public class LoginTest {
    static WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void before(){
        driver = Driver.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        loginPage = new LoginPage();
    }

    @Test
    public void testSuccessFullLogin(){

        loginPage.login("admin", "admin123");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @AfterClass
    public static void driverQuit(){
        driver.manage().deleteAllCookies();
    }
}
