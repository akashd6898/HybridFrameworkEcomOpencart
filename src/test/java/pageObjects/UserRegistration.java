package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistration extends BasePage {

    public UserRegistration(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class=\"dropdown\"]")
    WebElement account_dropdown;

    @FindBy(xpath="//li[@class=\"dropdown open\"]")
    WebElement account_dropdown_open;

    @FindBy(xpath = "//li[@class=\"dropdown open\"]//ul//li")
    WebElement register_menu;

    @FindBy(xpath = "//input[@id=\"input-firstname\"]")
    WebElement firstname;

    @FindBy(xpath = "//input[@id=\"input-lastname\"]")
    WebElement lastname;

    @FindBy(xpath = "//input[@id=\"input-email\"]")
    WebElement email;

    @FindBy(xpath = "//input[@id=\"input-telephone\"]")
    WebElement telephone;

    @FindBy(xpath = "//input[@id=\"input-password\"]")
    WebElement password;

    @FindBy(xpath = "//input[@id=\"input-confirm\"]")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@name=\"newsletter\" and @value=\"1\"]")
    WebElement newsletterYes;

    @FindBy(xpath = "//input[@name=\"newsletter\" and @value=\"0\"]")
    WebElement newsletterNo;

    @FindBy(xpath="//input[@name=\"agree\"]")
    WebElement policyOption;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    WebElement registrationSubmit;

    public void clickAccountMenu()
    {
        account_dropdown.click();
    }
    public void clickRegisterMenu()
    {
        register_menu.click();
    }

    public void userName(String firstname_value, String lastname_value){
        firstname.sendKeys(firstname_value);
        lastname.sendKeys(lastname_value);
    }

    public void enterEmail(String email_value){
        email.sendKeys(email_value);
    }

    public void enterTelephone(String telephone_value){
        telephone.sendKeys(telephone_value);
    }

    public void enterPassword(String password_value){
        password.sendKeys(password_value);
    }

    public void enterConfirmPassword(String confirmPassword_value){
        confirmPassword.sendKeys(confirmPassword_value);
    }

    public void setNewsletter(boolean newsletter_option){
        if (newsletter_option){
            newsletterYes.click();
        }
        else{
            newsletterNo.click();
        }
    }

    public String getPassword() {
        try
        {
            return password.getText();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void checkboxPolicy(boolean option)
    {
        if(option)
        {
            policyOption.click();
        }
    }

    public Boolean submitButtonStatus()
    {
        return registrationSubmit.isEnabled();
    }

    public String getConfirmPassword() {
        try
        {
            return confirmPassword.getText();
        }
        catch (Exception e) {
            return (e.getMessage());
        }
    }
}
