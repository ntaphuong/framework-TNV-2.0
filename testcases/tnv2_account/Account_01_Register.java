package tnv2_account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Account_01_Register {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        // Ver 2.x/ 3.x / 4.x (4.6 trở về thì mới cần set projectPath như này)
        //Dùng bản Selenium mới nhất (4.11 trở lên) thì nó sẽ tự tải driver về
        //4.6 - 4.10 là có tính năng này rồi - nhưng vẫn gặp 1 issue là trên chrome nó chỉ tải và support đến version chrome browser 114 thôi
        //Còn 115 trở lên nó ko tải được - lấy version 114 để dùng cho chrome browser 115 trở lên -> LỖI
//
//        if (osName.contains("Windows")) {
//            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//        } else {
//            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://trangnguyen.edu.vn/");
        // Verify popup is display
        By imgPopup1 = By.cssSelector("img[alt=\"Quảng cáo Trạng Nguyên\"]");
        List<WebElement> PopupElements = driver.findElements(imgPopup1);
        if(PopupElements.size() > 0 && PopupElements.get(0).isDisplayed()){
            // close popup
            driver.findElement(By.cssSelector("button>svg[stroke=\'currentColor\'][height=\'25\']")).click();
            //sleepInSecond(2);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
//          Assert.assertTrue(driver.findElement(By.cssSelector("img[alt=\"Quảng cáo Trạng Nguyên\"]")).isDisplayed());
        // Click Register
        driver.findElement(By.xpath("//a[@href=\"/dang-ky/\"]//div//span[text()='Đăng ký']")).click();

        // Verify popup is display again
        By imgPopup2 = By.cssSelector("img[alt=\"Quảng cáo Trạng Nguyên\"]");
        List<WebElement> PopupElements2 = driver.findElements(imgPopup2);
        if(PopupElements2.size() > 0 && PopupElements.get(0).isDisplayed()){
            // close popup
            driver.findElement(By.cssSelector("button>svg[stroke=\"currentColor\"]")).click();
            //sleepInSecond(2);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }
    @Test
    public void Register_01_Empty_Data_HocSinh(){
        // click button Học sinh
        driver.findElement(By.xpath("//span[text()=\"Học sinh\"]/parent::button")).click();

        driver.findElement(By.id("fullname")).clear();
        driver.findElement(By.id("username1")).clear();
        driver.findElement(By.id("password1")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.xpath("//span/span[text()=\"Đăng ký\"]")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("input[id=fullname][placeholder=\"Ví dụ: Trần Đăng Khoa\"]~p")).getText(),"Bắt buộc nhập thông tin trường này");
        Assert.assertEquals(driver.findElement(By.cssSelector("input[id=username1][placeholder=\"Ví dụ: trandangkhoa\"]~p")).getText(),"Bắt buộc nhập thông tin trường này");
        Assert.assertEquals(driver.findElement(By.cssSelector("input[id=password1][placeholder=\"******\"]~p")).getText(),"Bắt buộc nhập thông tin trường này");
        Assert.assertEquals(driver.findElement(By.cssSelector("input[id=password][placeholder=\"******\"]~p")).getText(),"Xác nhận mật khẩu không được để trống.");
//        Assert.assertEquals(driver.findElement(By.cssSelector("select[name=\"grade_id\"]~p")).getText(),"Bắt buộc nhập thông tin trường này");
    }

    @Test
    public void Register_01_Empty_Data_PhuHuynh(){
        // click button Học sinh
        driver.findElement(By.xpath("//span[text()=\"Phụ huynh\"]/parent::button")).click();

        driver.findElement(By.id("fullname")).clear();
        driver.findElement(By.id("username1")).clear();
        driver.findElement(By.id("password1")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("phone_number")).clear();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.xpath("//span/span[text()=\"Đăng ký\"]")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("input[id=fullname][placeholder=\"Ví dụ: Trần Đăng Khoa\"]~p")).getText(),"Bắt buộc nhập thông tin trường này");
        Assert.assertEquals(driver.findElement(By.cssSelector("input[id=username1][placeholder=\"Ví dụ: trandangkhoa\"]~p")).getText(),"Bắt buộc nhập thông tin trường này");
        Assert.assertEquals(driver.findElement(By.cssSelector("input[id=password1][placeholder=\"******\"]~p")).getText(),"Bắt buộc nhập thông tin trường này");
        Assert.assertEquals(driver.findElement(By.cssSelector("input[id=password][placeholder=\"******\"]~p")).getText(),"Xác nhận mật khẩu không được để trống.");
        Assert.assertEquals(driver.findElement(By.cssSelector("input[id='phone_number']~p")).getText(),"Bắt buộc nhập thông tin trường này");
        Assert.assertEquals(driver.findElement(By.cssSelector("input[placeholder=\"Ví dụ: trandangkhoa@gmail.com\"]~p")).getText(),"Bắt buộc nhập thông tin trường này");
    }

    @Test
    // Họ tên tối thiểu 4 kí tự,
    // phải lọc ký tự đặc biệt,

    // có ký tự ',
    // cần loại bỏ dấu cách ở đầu và cuối
    public void Register_02_Invalid_Fullname(){
        // click button Học sinh
        driver.findElement(By.xpath("//span[text()=\"Học sinh\"]/parent::button")).click();

        //  driver.findElement(By.id("fullname")).sendKeys("the");
        driver.findElement(By.id("username1")).sendKeys("prodhs6");
        driver.findElement(By.id("password1")).sendKeys("123456");
        driver.findElement(By.id("password")).sendKeys("123456");

        Select drpGrade = new Select(driver.findElement(By.cssSelector("select[name='grade_id']")));
        drpGrade.selectByVisibleText("Khối 1");

        CheckInvalid("fullname", "the", "input[id=fullname][placeholder=\"Ví dụ: Trần Đăng Khoa\"]~p", "Tên tối thiểu 4 ký tự!");
        driver.findElement(By.id("fullname")).clear();
        CheckInvalid("fullname", "the!", "input[id=fullname][placeholder=\"Ví dụ: Trần Đăng Khoa\"]~p", "Họ và tên không được sử dụng các ký tự đặc biệt.");
        driver.findElement(By.id("fullname")).clear();

//        driver.findElement(By.id("fullname")).sendKeys("prod học sinh 6'");
//        By success = By.xpath("//div[@id=\"4\"]//div[text()=\"Bạn đã đăng ký tài khoản thành công!\"]");
//        List<WebElement> successElements = driver.findElements(success);
//        if(successElements.size() > 0){
//            System.out.println("size = ");
//            System.out.print(successElements.size());
//            Assert.assertTrue(successElements.get(0).isDisplayed());
//        }
//        else{
//            System.out.println("size = 0");
//        }
    }
    public void CheckInvalid(String idName, String textSendkey, String pathCssSelector, String textEquals){
        driver.findElement(By.id(idName)).sendKeys(textSendkey);
        driver.findElement(By.xpath("//span/span[text()=\"Đăng ký\"]")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(pathCssSelector)).getText(),textEquals);
    }

    @Test
    // username: viết thường, tối thiểu 3 ký tự,ko chấp nhận dấu cách
    public void Register_03_Invalid_Username(){
        // click button Học sinh
        driver.findElement(By.xpath("//span[text()=\"Học sinh\"]/parent::button")).click();

        driver.findElement(By.id("fullname")).sendKeys("thevu");
        //  driver.findElement(By.id("username1")).sendKeys("prodhs6");
        driver.findElement(By.id("password1")).sendKeys("123456");
        driver.findElement(By.id("password")).sendKeys("123456");

        Select drpGrade = new Select(driver.findElement(By.cssSelector("select[name='grade_id']")));
        drpGrade.selectByVisibleText("Khối 1");

        CheckInvalid("username1", "The", "input[id=username1][placeholder=\"Ví dụ: trandangkhoa\"]~p", "Tên đăng nhập không nhập chữ hoa, dấu cách và ký tự đặc biệt");
        driver.findElement(By.id("username1")).clear();

        CheckInvalid("username1", "Th", "input[id=username1][placeholder=\"Ví dụ: trandangkhoa\"]~p", "Tên đăng nhập tối thiểu 3 ký tự!");
        driver.findElement(By.id("username1")).clear();

        CheckInvalid("username1", "The", "input[id=username1][placeholder=\"Ví dụ: trandangkhoa\"]~p", "Tên đăng nhập không nhập chữ hoa, dấu cách và ký tự đặc biệt");
        driver.findElement(By.id("username1")).clear();

    }
    @Test
    public void Register_04_Invalid_Password(){
        // click button Học sinh
        driver.findElement(By.xpath("//span[text()=\"Học sinh\"]/parent::button")).click();

        driver.findElement(By.id("fullname")).sendKeys("thevu");
        driver.findElement(By.id("username1")).sendKeys("prodhs6");

        Select drpGrade = new Select(driver.findElement(By.cssSelector("select[name='grade_id']")));
        drpGrade.selectByVisibleText("Khối 1");

        CheckInvalid("password1", "1234", "input[id=password1][placeholder=\"******\"]~p", "Mật khẩu tối thiểu 6 ký tự!");
        CheckInvalid("password", "1234", "input[id=password][placeholder=\"******\"]~p", "Mật khẩu tối thiểu 6 ký tự!");

    }
    @Test
    public void Register_05_Incorrect_Confirm_Password(){
        // click button Học sinh
        driver.findElement(By.xpath("//span[text()=\"Học sinh\"]/parent::button")).click();

        driver.findElement(By.id("fullname")).sendKeys("thevu");
        driver.findElement(By.id("username1")).sendKeys("prodhs6");
        driver.findElement(By.id("password1")).sendKeys("123456");

        Select drpGrade = new Select(driver.findElement(By.cssSelector("select[name='grade_id']")));
        drpGrade.selectByVisibleText("Khối 1");

        CheckInvalid("password", "1234", "input[id=password][placeholder=\"******\"]~p", "Mật khẩu nhập lại không khớp");

    }
    @Test
    public void Register_06_Invalid_Phone_Number(){

    }
    @Test
    public void Register_06_Invalid_Email_Address(){

    }
    @Test
    public void Register_07_No_Choose_Grade(){
        // click button Học sinh
        driver.findElement(By.xpath("//span[text()=\"Học sinh\"]/parent::button")).click();

        driver.findElement(By.id("fullname")).sendKeys("thevu");
        driver.findElement(By.id("username1")).sendKeys("prodhs6");
        driver.findElement(By.id("password1")).sendKeys("123456");
        driver.findElement(By.id("password")).sendKeys("123456");
        Select drpGrade = new Select(driver.findElement(By.cssSelector("select[name='grade_id']")));
        drpGrade.deselectByValue("Khối 1");
        driver.findElement(By.xpath("//span/span[text()=\"Đăng ký\"]")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("select[name=\"grade_id\"]~p")).getText(),"Bắt buộc nhập thông tin trường này");
    }


}
