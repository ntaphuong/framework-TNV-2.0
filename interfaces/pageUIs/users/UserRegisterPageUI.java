package pageUIs.users;

public class UserRegisterPageUI {
    public static final String ADD_POPUP = "XPATH=//button/img[@alt='Đóng']";
    public static final String FULLNAME_TEXTBOX = "XPATH=//input[@name='fullname']";
    public static final String USERNAME_TEXTBOX = "XPATH=//input[@name='username']";
    public static final String PASSWORD_TEXTBOX = "XPATH=//input[@name='password']";
    public static final String CONFIRM_PASSWORD_TEXTBOX = "XPATH=//input[@name='confirmPassword']";
    public static final String GRADE_DROPDOWN_LIST = "XPATH=//div[text()='Khối']/parent::label/preceding-sibling::input";
    public static final String GRADE_DROPDOWN_LIST_ELEMENT = "XPATH=//div[@data-trigger='ComboBox']/div[@role='listbox']";
    public static final String GRADE_DROPDOWN_ELEMENT = "//div[@role='listbox']//span[1]";
    public static final String FEMALE_CHECKBOX = "XPATH=//label[contains(text(),'Nữ')]//*[name()='svg']//*[name()='path' and contains(@class,'tn-rounded')]";
    public static final String CONTINUE_BUTTON = "XPATH=//button[text()='Tiếp tục']";
    public static final String PROVINCE_DROPDOWN_LIST = "XPATH=//input[@name='provinceId']/preceding-sibling::div//input";
    public static final String PROVINCE_DROPDOWN_ELEMENT = "//div[@role='listbox']//span[1]";
    public static final String DISTRICT_DROPDOWN_LIST = "XPATH=//input[@name='districtId']/preceding-sibling::div[1]//input";
    public static final String DISTRICT_DROPDOWN_ELEMENT ="//div[@role='listbox']//span[1]";
    public static final String SCHOOL_DROPDOWN_LIST = "XPATH=//input[@name='schoolId']/preceding-sibling::div[1]//input";
    public static final String SCHOOL_DROPDOWN_ELEMENT = "//div[@role='listbox']//span[1]";
//    public static final String CONDITIONS_CHECKBOX = "XPATH=//label[@class='d_flex gap_12px items_center leading_normal transition-prop_opacity ease_ease-in-out duration_normal']" +
//            "//div[@class='d_flex items_center justify_center shrink_0 pos_relative w_20px h_20px']" +
//            "//*[name()='svg']//*[name()='path' and contains(@class,'tn-rounded')]";

    public static final String CONDITIONS_CHECKBOX = "xpath=//div[text()='Địa chỉ (không bắt buộc)']/parent::label/parent::div/parent::div/following-sibling::div//div";
    public static final String FINAL_REGISTER_BUTTON = "XPATH=//button[text()='Hoàn tất']";
    public static final String REGISTRATION_SUCCESSFUL_TEXTBOX = "XPATH=//div[text()='Đăng ký tài khoản thành công']";
    public static final String REGISTRATION_SUCCESSFUL_POPUP = "XPATH=//section[@class='outline-style_solid ring-width_0px max-h_inherit pos_relative']";
    public static final String CONTINUE_BUTTON_POPUP = "XPATH=//div[@class='pos_relative h_100%']//button[text()='Tiếp tục']";
}
