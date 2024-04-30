package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DirectoryPage extends BasePage {
    public DirectoryPage(){
        super(Driver.getDriver());
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[2]")
    public WebElement jobTitleSelector;

    @FindBy (xpath = "//span[text()='HR Manager']")
    public WebElement selectFinancialOfficer;

    @FindBy (xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement searchButton;

    @FindBy (xpath = "//div[@class='orangehrm-directory-card-body']/div")
    public List<WebElement> getAllUser;


    @Override
    public void search(String ... parameters) {
        String employeeName = parameters[0];
        String jobTitle = parameters[1];
        String location = parameters[2];
    }
}
