package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage extends BasePage {

    public LoginPage(){
        super(Driver.getDriver());
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(name = "username")
    public WebElement username;

    @FindBy (name = "password")
    public WebElement password;

    @FindBy(css = "button[type=submit]")
    public WebElement loginButton;

    @FindBy(css = "a[href='/web/index.php/pim/viewPimModule']")
    public WebElement PIMPage;

    public void login (String userName, String passWord){
        username.sendKeys(userName);
        password.sendKeys(passWord);
        loginButton.click();
    }

    @Override
    public void search(String ... parameters) {

    }
}
