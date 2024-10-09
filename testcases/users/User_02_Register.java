package users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.users.UserLoginPO;
import pageObjects.users.UserRegisterPO;
import pageObjects.users.portal.UserHomePO;

public class User_02_Register extends BaseTest {
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserHomePO homePage;
    private WebDriver driver;
    private String fullName, username, password, confirmPassword, grade, province, district, school, className, phoneNumber, email, address;
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);
        // Mở URL lên, qua HomePage
        homePage = PageGenerator.getUserHomePage(driver);
        fullName = "Nguyễn Thị Ánh Phượng";
        username = "phuongtest1";
        password = "12345678";
        confirmPassword = "12345678";
        grade = "Khối 1";
        province = "Hà Nội";
        district = "Cầu Giấy";
        school = "Trường tiểu học Harvard";
        className = "1";
        phoneNumber = "0396850623";
        email = "phuong@gmail.com";
        address = "Golden Palace";

    }
    @Test
    public void User_TC_01_Register_Success(){
        loginPage = homePage.openLoginPage();
        registerPage = homePage.clickToRegisterLink();
        registerPage.enterToFullNameTextbox(fullName);
        registerPage.enterToUserNameTextbox(username);
        registerPage.enterToPassWordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(confirmPassword);
        registerPage.selectGradeDropdown(grade);
        registerPage.clicktoMaleCheckbox();
        registerPage.clickToContinueButton();
        registerPage.selectProvinceDropdown(province);
        registerPage.selectDistrictDropdown(district);
        registerPage.selectSchoolDropdown(school);
        registerPage.selectClassDropdown(className);
        registerPage.enterToPhoneNumberTextbox(phoneNumber);
        registerPage.enterToEmailTextbox(email);
        registerPage.enterToAdressTextbox(address);
        registerPage.clickToConditionCheckbox();
        registerPage.clickToFinishRegisterButton();

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}