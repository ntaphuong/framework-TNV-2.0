package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserLoginPO extends BasePage {
    private WebDriver driver;
    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }
}
