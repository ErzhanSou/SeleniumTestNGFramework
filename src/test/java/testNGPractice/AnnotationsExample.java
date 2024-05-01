package testNGPractice;

import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsExample {
    @BeforeSuite
    public static void beforeSuitMethodTest(){
        System.out.println("Setting up the suite environment");
    }

    @BeforeTest
    public static void beforeTestMethodTest(){
        System.out.println("Configuring test environment");
    }

    @BeforeClass
    public static void beforeClassMethodTest(){
        System.out.println("Loading class resources.");
    }

    @BeforeMethod
    public void beforeMethodTest(){
        System.out.println("Initializing test method setup.");
    }

    @Test
    public void test1Test(){
        Assert.assertTrue(10 > 7);
    }

    @Test
    public void test2Test(){
        Assert.assertTrue(true || false);
    }

    @Test
    public void test3Test(){
        Assert.assertTrue("hello".equals("hello"));
    }

    @AfterMethod
    public void afterMethodTest(){
        System.out.println("Cleaning up after test method.");
    }

    @AfterClass
    public static void afterClassMethodTest(){
        System.out.println("Releasing class resources.");
    }

    @AfterTest
    public static void afterTestMethodTest(){
        System.out.println("Tearing down test environment.");
    }


}
