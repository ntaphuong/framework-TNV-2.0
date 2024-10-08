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
        waitForElementClickable(driver, UserRegisterPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.USERNAME_TEXTBOX,fullName);
    }
}
