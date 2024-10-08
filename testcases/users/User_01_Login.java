package users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.PageGenerator;
import pageObjects.users.UserLoginPO;
import pageObjects.users.UserRegisterPO;
import pageObjects.users.portal.UserHomePO;

public class User_01_Login extends BaseTest {
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserHomePO homePage;
    private WebDriver driver;
    private String username,password;
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);
        // Mở URL lên, qua HomePage
        homePage = PageGenerator.getUserHomePage(driver);
        username = "phuongprod1";
        password = "12345678";

    }
    @Test
    public void User_TC_01_Login(){
        loginPage = homePage.openLoginPage();
        loginPage.enterToUserNameTextbox(username);
        loginPage.enterToPasswordTextbox(password);
        homePage = loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isUserInfoDisplay());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
