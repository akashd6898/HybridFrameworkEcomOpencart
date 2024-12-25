package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLogin extends BasePage{

    public UserLogin(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[text()=\"Login\"]")
    WebElement loginMenu;

    @FindBy(xpath = "//input[@id=\"input-email\"]")
    WebElement loginEmail;

    @FindBy(xpath = "//input[@id=\"input-password\"]")
    WebElement  loginPassword;


    public void loginEmail(String email) {
        loginEmail.sendKeys(email);
    }
    public void loginPassword(String password) {
        loginPassword.sendKeys(password);
    }
}
