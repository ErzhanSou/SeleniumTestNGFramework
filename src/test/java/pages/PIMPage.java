package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.Duration;
import java.util.List;

public class PIMPage {

    Faker faker = new Faker();

    public String firstName = faker.funnyName().name();
    public String lastName = faker.name().lastName();
    public String employeeId = faker.idNumber().valid().substring(0,5);

    public String verifyName = firstName + " " + lastName;
    public String fakerIdStored = employeeId;
    public PIMPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    public WebElement addButton;

    @FindBy(name = "firstName")
    public WebElement inputFirstName;

    @FindBy(name = "lastName")
    public WebElement inputLastName;

    @FindBy(xpath = "//input[@name='lastName']/following::input[@class='oxd-input oxd-input--active']")
    public WebElement inputEmployeeId;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement saveButton;

    @FindBy(css = "h6[class='oxd-text oxd-text--h6 --strong']")
    public WebElement pimNames;

    @FindBy(xpath = "//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/following::div[@class='oxd-table-cell oxd-padding-cell'][3]")
    public List<WebElement> firstNames;

    @FindBy(xpath = "//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/following::div[@class='oxd-table-cell oxd-padding-cell'][4]")
    public List<WebElement> lastNames;

    @FindBy(xpath = "//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/following::div[@class='oxd-table-cell oxd-padding-cell'][2]")
    public List<WebElement> ids;

    public void addEmployeeButton(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    /**
     * This method add employee with randomly generated data
     */
    public void addEmployee(){
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        SeleniumUtils.cleanAndSendKeys(Driver.getDriver(), inputEmployeeId, employeeId);
    }

    public void setSaveButton(){
        saveButton.click();
    }

    public void getAll(){
        for (int i = 0; i < firstNames.size(); i++) {

            System.out.println("First name and Last name: " + firstNames.get(i).getText() + " - " + lastNames.get(i).getText());
            System.out.println("ID: " + ids.get(i).getText());

        }
    }

}
