package users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.users.UserLoginPO;

public class User_01_Login extends BaseTest {
    private UserLoginPO loginPage;
    private WebDriver driver;
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);
        // Mở URL lên, qua HomePage

    }
    @Test
    public void User_TC_01_Login(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
