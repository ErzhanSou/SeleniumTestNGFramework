package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.SeleniumUtils;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateTo(String url){
        driver.get(url);
    }
    public  void printCurrentURL(){
        System.out.println(driver.getCurrentUrl());
    }

    public void logOut(){
        WebElement profileIcon = driver.findElement(By.xpath("//li[@class='oxd-userdropdown']"));
        WebElement logout = driver.findElement(By.linkText("Logout"));
        SeleniumUtils.click(driver, profileIcon);
        logout.click();
    }

    public void printTitle(){
        driver.getTitle();
    }

    //vararg
    public abstract void search(String ... parameters);
}
