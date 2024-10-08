package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.users.portal.UserHomePO;
import pageUIs.users.UserLoginPageUI;

public class UserLoginPO extends BasePage {
    private WebDriver driver;
    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUserNameTextbox(String username) {
        waitForElementClickable(driver, UserLoginPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.USERNAME_TEXTBOX,username);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementClickable(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public UserHomePO clickToLoginButton() {
        waitForElementClickable(driver,UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,UserLoginPageUI.LOGIN_BUTTON);
      //  System.out.println("Title Login: "+driver.getTitle());
        sleepInSeconds(3);
        return PageGenerator.getUserHomePage(driver);

    }
}
