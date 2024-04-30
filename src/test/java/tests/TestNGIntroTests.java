package tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGIntroTests {

    @BeforeTest
    public static void beforeTestMethod(){
        System.out.println("This is before test methods");
    }

    @AfterTest
    public static void afterTestMethod(){
        System.out.println("This is after test method");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("This is Before class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is before method");
    }

    @Test
    public void test1(){
        System.out.println("I am test 1");
    }

    @Test
    public void test2(){
        System.out.println("I am test 2");
    }

    @Test
    public void test3(){
        System.out.println("I am test 3");
    }

    @Test
    public void test4(){
        System.out.println("I am test 4");
    }


}
