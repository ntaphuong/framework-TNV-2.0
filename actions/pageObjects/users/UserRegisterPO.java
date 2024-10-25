package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.users.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;
    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFullNameTextbox(String fullName) {
        waitForElementClickable(driver, UserRegisterPageUI.FULLNAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.FULLNAME_TEXTBOX,fullName);
    }

    public void enterToUserNameTextbox(String username) {
        waitForElementClickable(driver, UserRegisterPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.USERNAME_TEXTBOX,username);
    }

    public void enterToPassWordTextbox(String password) {
        waitForElementClickable(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX,password);
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementClickable(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);
    }

    public void selectGradeDropdown(String grade) {
        waitForElementClickable(driver,UserRegisterPageUI.GRADE_DROPDOWN_LIST);
        clickToElement(driver,UserRegisterPageUI.GRADE_DROPDOWN_LIST);
        selectItemInCustomDropdown(driver, UserRegisterPageUI.GRADE_DROPDOWN_LIST_ELEMENT,UserRegisterPageUI.GRADE_DROPDOWN_ELEMENT,grade);
    }

    public void clickToMaleCheckbox() {
        waitForElementClickable(driver, UserRegisterPageUI.FEMALE_CHECKBOX);
        clickToElement(driver,UserRegisterPageUI.FEMALE_CHECKBOX);

    }

    public void clickToContinueButton() {
        waitForElementClickable(driver, UserRegisterPageUI.CONTINUE_BUTTON);
        clickToElement(driver, UserRegisterPageUI.CONTINUE_BUTTON);
    }

    public void selectProvinceDropdown(String province) {
        waitForElementClickable(driver,UserRegisterPageUI.PROVINCE_DROPDOWN_LIST);
        selectItemInDropdown(driver,UserRegisterPageUI.PROVINCE_DROPDOWN_LIST,province);
    }

    public void selectDistrictDropdown(String district) {
        waitForElementClickable(driver,UserRegisterPageUI.DISTRICT_DROPDOWN_LIST);
        selectItemInDropdown(driver,UserRegisterPageUI.DISTRICT_DROPDOWN_LIST,district);
    }

    public void selectSchoolDropdown(String school) {
        waitForElementClickable(driver,UserRegisterPageUI.SCHOOL_DROPDOWN_LIST);
        selectItemInDropdown(driver,UserRegisterPageUI.SCHOOL_DROPDOWN_LIST,school);
    }

    public void clickToConditionCheckbox() {
        waitForElementClickable(driver, UserRegisterPageUI.CONDITIONS_CHECKBOX);
        clickToElement(driver,UserRegisterPageUI.CONDITIONS_CHECKBOX);
    }

    public void clickToFinishRegisterButton() {
        waitForElementClickable(driver,UserRegisterPageUI.FINAL_REGISTER_BUTTON);
        clickToElement(driver,UserRegisterPageUI.FINAL_REGISTER_BUTTON);
    }

    public String getRegistrationSuccessfulTextBoxValue() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTRATION_SUCCESSFUL_POPUP);
        waitForElementVisible(driver, UserRegisterPageUI.REGISTRATION_SUCCESSFUL_TEXTBOX);
        return getElementAttribute(driver, UserRegisterPageUI.REGISTRATION_SUCCESSFUL_TEXTBOX,"value");

    }
}
