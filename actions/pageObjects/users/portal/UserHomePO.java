package pageObjects.users.portal;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.users.UserLoginPO;
import pageObjects.users.UserRegisterPO;
import pageUIs.users.portal.UserHomePageUI;

public class UserHomePO extends BasePage {
    private WebDriver driver;
    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    public UserLoginPO openLoginPage() {
        waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
        clickToElement(driver,UserHomePageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }

    public boolean isUserInfoDisplay() {
        waitForElementVisible(driver,UserHomePageUI.USER_INFO);
        return isElementDisplay(driver,UserHomePageUI.USER_INFO);
    }

    public UserRegisterPO clickToRegisterLink() {
        waitForElementClickable(driver,UserHomePageUI.REGISTER_BUTTON);
        clickToElement(driver,UserHomePageUI.REGISTER_BUTTON);
        return PageGenerator.getUserRegisterPage(driver);
    }
}
