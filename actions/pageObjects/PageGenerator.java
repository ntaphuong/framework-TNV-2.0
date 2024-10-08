package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.users.UserLoginPO;
import pageObjects.users.UserRegisterPO;
import pageObjects.users.courses.UserCoursePO;
import pageObjects.users.portal.UserAboutMePO;
import pageObjects.users.portal.UserHomePO;
import pageObjects.users.portal.UserNewsPO;
import pageObjects.users.userInfomation.UserChangePasswordPO;
import pageObjects.users.userInfomation.UserEditInformationPO;

public class PageGenerator {
    public static UserLoginPO getUserLoginPage(WebDriver driver){
        return new UserLoginPO(driver);
    }
    public static UserRegisterPO getUserRegisterPage(WebDriver driver){
        return new UserRegisterPO(driver);
    }
    public static UserAboutMePO getUserAboutMePage(WebDriver driver){
        return new UserAboutMePO(driver);
    }
    public static UserHomePO getUserHomePage(WebDriver driver){
        System.out.println("Title Portal: "+driver.getTitle());
        return new UserHomePO(driver);
    }
    public static UserNewsPO getUserNewsPage(WebDriver driver){
        return new UserNewsPO(driver);
    }
    public static UserChangePasswordPO getUserChangePasswordPage(WebDriver driver){
        return new UserChangePasswordPO(driver);
    }
    public static UserEditInformationPO getUserEditInformationPage(WebDriver driver){
        return new UserEditInformationPO(driver);
    }
    public static UserCoursePO getUserCoursePage(WebDriver driver){
        return new UserCoursePO(driver);
    }



}
