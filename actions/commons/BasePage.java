package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    /* Web Browser */
    public void openPageUrl(WebDriver driver, String pageUrl){
        driver.get(pageUrl);
    }

    public  String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }

    public String getCurrentPageUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode(WebDriver driver){
        return driver.getPageSource();

    }

    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver){
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver){
        driver.navigate().refresh();
    }
    public Alert waitForAlertPresence(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }
    public void acceptToAlert(WebDriver driver){
        waitForAlertPresence(driver).accept();
       // driver.switchTo().alert().accept();
    }
    public void cancelToAlert(WebDriver driver){
        waitForAlertPresence(driver).dismiss();
    }
    public String getTextInAlert(WebDriver driver){
        return waitForAlertPresence(driver).getText();
    }
    public void sendkeyToAlert(WebDriver driver, String KeysToSend){
        waitForAlertPresence(driver).sendKeys(KeysToSend);
    }
    // Windows
    public void sleepInSecond(long timeInSecond){
        try{
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //Dùng cho case duy nhất 2 tab/ window
    public void switchToWindowByID(WebDriver driver, String pageID){
        Set<String> allIDS = driver.getWindowHandles();
        for(String id : allIDS){
            if(!id.equals(pageID)){
                driver.switchTo().window(id);
                sleepInSecond(1);
                break;
            }
        }

    }
    // Dùng cho case từ 2 tab/ window trở lên
    public void switchToWindowByTitle(WebDriver driver, String pageTitle){
        Set<String> allIDs = driver.getWindowHandles();
        for(String id: allIDs){
            // Switch vào từng ID trước
            driver.switchTo().window(id);
            sleepInSecond(1);

            String actualPageTitle = driver.getTitle();
            if(actualPageTitle.equals(pageTitle)){
                //Thoát khỏi vòng lặp ko duyệt item tiếp theo nữa
                break;
            }
        }
    }
    public  void  closeAllWindowWithoutParentID(WebDriver driver, String parentID){
        Set<String> allIDs = driver.getWindowHandles();
        for(String id : allIDs){
            if(!id.equals(parentID)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

}
