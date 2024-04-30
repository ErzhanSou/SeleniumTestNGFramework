package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class SeleniumUtils {
    public static void windowHandle(WebDriver driver, WebElement element){
        String mainWindowHandle = driver.getWindowHandle();
        element.click();
        for (String windowHandle: driver.getWindowHandles()){
            if(!windowHandle.equals(mainWindowHandle)){
                driver.switchTo().window(windowHandle);
            }
        }
        System.out.println("url after click : " + driver.getCurrentUrl());
    }

    public static void windowHandles(Set<String> handles, WebDriver driver, String xPath){
        List<WebElement> elements = driver.findElements(By.xpath(xPath)); // to get all web elements
        String mainWindow = driver.getWindowHandle(); // original window handle
        for (WebElement element : elements){
            element.click();
        }

        handles = driver.getWindowHandles(); // to store all unique handles
        for (String handle : handles){
            if (!handle.equals(mainWindow)){
                driver.switchTo().window(handle);
                String tabsURL = driver.getCurrentUrl();
                System.out.println("Tabs urls: " + tabsURL);
            }
        }
    }

    /**
        *This method waits for element to be clickable
        * before clicking in it
        * @param driver - is used to open web element
        * @param element - to be clickable
     */
    public static void click(WebDriver driver, WebElement element){
        try {
            FluentWait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .ignoring(ElementClickInterceptedException.class)
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception (e.g., logging, reporting, retry logic)
        }

    }

    /**
    * This method accepts alert, if alert is not there
     * it ignores the exception
     * @param driver
     */
    public static void acceptAlert(WebDriver driver ){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driverWait.until(ExpectedConditions.alertIsPresent());

        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e){
            System.out.println("Alert does not exist");
            e.printStackTrace();
        }
    }

    /**
     * This method dismisses alert, if alert is not there
     * it ignores the exception
     * @param driver
     */
    public static void dismissAlert(WebDriver driver ){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driverWait.until(ExpectedConditions.alertIsPresent());

        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e){
            System.out.println("Alert does not exist");
            e.printStackTrace();
        }
    }

    public static boolean isElementPresent(WebDriver driver, By locator){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    /**
     * This method will try to click on element multiple times
     * by ingoting StaleElement exception
     * @param driver to go to webpage
     * @param locator tp click on
     * @param retries number of times to try
     */
    public static void clickWithRetries(WebDriver driver, By locator, int retries){

        int numOFTrials = 0;

        while (numOFTrials < retries)
        try {
            WebElement element = driver.findElement(locator);
            element.click();
            return; // it's successful, exit the method
        } catch (StaleElementReferenceException e){
            // it's not successful, try again
            numOFTrials++;
            waitForSeconds(1);
        } catch (NoSuchElementException e){
            System.out.println("Wrong locator");
            e.printStackTrace();
            return;
        }
    }

    public static void waitForSeconds(int numberOfSeconds){
        try {
            Thread.sleep(numberOfSeconds * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * This is methods waits for text to appear in the element
     * Then verifies if it matches with excepted text
     * @param driver
     * @param numberOfSeconds to wait for
     * @param element to verify
     * @param exceptedText to verify
     */
    public static void verifyTextInElement(WebDriver driver, int numberOfSeconds, WebElement element, String exceptedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(numberOfSeconds));
        wait.until(ExpectedConditions.textToBePresentInElement(element, exceptedText));
        Assert.assertEquals(exceptedText, element.getText());
    }

    public static void cleanAndSendKeys(WebDriver driver, WebElement element, String textToSend){
        Actions actions = new Actions(driver);
        actions.keyDown(element, Keys.CONTROL).sendKeys("a");
        actions.keyUp(element, Keys.CONTROL);
        actions.keyDown(element, Keys.BACK_SPACE);
        actions.keyUp(element, Keys.BACK_SPACE);

        actions.build().perform();

        element.sendKeys(textToSend);
    }
}
