package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CommonPage extends BasePage {

    public CommonPage(){
        super(Driver.getDriver());
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "a[href='/web/index.php/pim/viewPimModule']")
    public WebElement pimTab;

    @FindBy(linkText = "Leave")
    public WebElement leaveTab;

    @FindBy(linkText = "Dashboard")
    public WebElement dashboard;

    @FindBy (css = "a[href='/web/index.php/directory/viewDirectory']")
    public WebElement directoryTab;

    public void goToTab(WebElement element){
        element.click();
    }

    @Override
    public void search(String ... parameters) {

    }
}
