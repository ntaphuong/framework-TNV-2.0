package users;

import commons.BaseTest;
import org.testng.annotations.BeforeClass;

public class TC_001_Login extends BaseTest {
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        // Mở URL lên, qua HomePage
        homePage = PageGenerator.getUserHomePage(driver);
        firstName = "Phượng";
        lastName = "Nguyễn";
        day = "19";
        month = "January";
        year = "1989";
        emailAddress = "phuong"+generateRandomNumber()+"@gmail.com";
        companyName = "PhuongNTACompany";
        password = "123456";
    }
}
