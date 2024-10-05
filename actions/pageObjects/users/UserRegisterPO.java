package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;
    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }
}
