package utilities;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Driver {
    static WebDriver driver;

    public static WebDriver getDriver(){

        // if driver object already exist, then we just return it
        if (driver != null){
            return driver;
        }
        String browser = Config.getProperty("browser");

        switch (browser){

            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-popup-blocking");
                options.addArguments("start-maximized");
                options.addArguments("incognito");

                // Use preferences to disable geolocation permission prompt
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.geolocation", 2); // 2 means Block
                options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);
            }
            case "firefox" -> driver = new FirefoxDriver();

            default -> driver = new ChromeDriver();
        }

        // there are implicit waits applied to the driver
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().fullscreen();

        return driver;
    }
}
