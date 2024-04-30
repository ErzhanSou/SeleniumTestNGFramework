package tests.exampleWebsites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utilities.Driver;
import utilities.SeleniumUtils;

public class GoogleTest {
    @BeforeTest (groups = {"sanity"})
    public static void beforeTestMethod(){
        System.out.println("This is before test method GOOGLE");
    }
    @AfterTest (groups = {"sanity"})
    public static void afterTestMethod(){
        System.out.println("This is after test method GOOGLE");
    }

    @Test(groups = {"sanity"})
    public void test1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
    @Test (groups = {"login group"})
    public void test2(){
        System.out.println("This is test 2 of google");
    }

    @Test
    public void googleTest3(){
        System.out.println("this is test 3 of google ");
    }

    @Test (groups = {"login tests"})
    public void login1(){
        System.out.println("Login google test 1");
    }

    @Test (groups = {"login tests"})
    public void login2(){
        System.out.println("Login etsy test 2");
    }

    @BeforeSuite
    public static void beforeSuiteMethod(){
        System.out.println("This is before suite inside google");
    }

    @AfterSuite
    public static void afterSuiteMethod(){
        System.out.println("This is after suite inside google");
    }
}
