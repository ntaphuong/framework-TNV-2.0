package commons;
// Log4j1.9
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//Loj4j2.3.1

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.time.Duration;
import java.util.Locale;
import java.util.Random;

public class BaseTest {
    protected WebDriver driver;
    protected final Logger log;

    // Khởi tạo log
    public BaseTest() {
        log = LogManager.getLogger(getClass());
    }

    protected int generateRandomNumber(){
        return  new Random().nextInt(99999);
    }
    protected WebDriver getBrowserDriver(String browserName){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser Name is not valid");
        }
        driver.get("https://trangnguyen.edu.vn/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().fullscreen();
        return driver;
    }
    protected WebDriver getBrowserDriver(String browserName, String url){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser Name is not valid");
        }
        driver.get(url);
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().fullscreen();
        return driver;
    }

    protected boolean verifyTrue(boolean condition){
        boolean status = true;
        try {
            Assert.assertTrue(condition);
            log.info("--------------------------PASSED----------------------------");
        } catch (Throwable e) {
            status = false;
            log.info("--------------------------FAILED----------------------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }
    protected boolean verifyFalse(boolean condition){
        boolean status = true;
        try {
            Assert.assertFalse(condition);
            log.info("--------------------------PASSED----------------------------");
        } catch (Throwable e) {
            status = false;
            log.info("--------------------------FAILED----------------------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }
    protected boolean verifyEquals(Object actual, Object expected){
        boolean status = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("--------------------------PASSED----------------------------");
        } catch (Throwable e) {
            status = false;
            log.info("--------------------------FAILED----------------------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    public WebDriver getDriver() {
        return  driver;
    }
    @BeforeSuite
    public void deleteReportFolder(){
        deleteAllFileInFolder("htmlAllure");
    }

    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

//    protected void closeBrowserDriver(){
//        String cmd = null;
//        try{
//            String osName = System.getProperty("os.name").toLowerCase();
//            log.info("OS name = " + osName);
//            String driverInstanceName = driver.toString().toLowerCase();
//            log.info("Driver instance name = " + driverInstanceName);
//
//            String browserDriverName = null;
//            if(driverInstanceName.contains("chrome")){
//                browserDriverName = "chromedriver";
//            } else if(driverInstanceName.contains("firefox")){
//                browserDriverName = "geckodriver";
//            }else if(driverInstanceName.contains("edge")){
//                browserDriverName = "msedgedriver";
//            } else if(driverInstanceName.contains("opera")){
//                browserDriverName = "operadriver";
//            } else{
//                browserDriverName = "safaridriver";
//            }
//            log.info("Browser driver name = " + browserDriverName);
//        }
//    }
}
