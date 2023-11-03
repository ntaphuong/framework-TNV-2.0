package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    private String projectPath = System.getProperty("user.dir");
    protected void getBrowserDriver(String browserName){
        if(browserName.equalsIgnoreCase("firefox")){
           // System.setProperty("webdriver.gecko.driver", projectPath+"\\browserDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("chrome")){
            driver = new FirefoxDriver();
        } else if(browserName.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("BrowserName is Not Valid.");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("");
    }
}
