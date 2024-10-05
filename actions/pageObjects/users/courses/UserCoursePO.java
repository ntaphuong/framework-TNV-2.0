package pageObjects.users.courses;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserCoursePO extends BasePage {
    private WebDriver driver;
    public UserCoursePO(WebDriver driver) {
        this.driver = driver;
    }
}
