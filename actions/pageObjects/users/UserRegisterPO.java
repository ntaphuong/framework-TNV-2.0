package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.users.UserLoginPageUI;
import pageUIs.users.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;
    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFullNameTextbox(String fullName) {
        waitForElementClickable(driver, UserRegisterPageUI.FULLNAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.FULLNAME_TEXTBOX,fullName);
    }

    public void enterToUserNameTextbox(String username) {
        waitForElementClickable(driver, UserRegisterPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.USERNAME_TEXTBOX,username);
    }

    public void enterToPassWordTextbox(String password) {
        waitForElementClickable(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX,password);
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementClickable(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);
    }
}
