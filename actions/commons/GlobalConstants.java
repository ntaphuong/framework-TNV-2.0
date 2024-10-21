package commons;

public class GlobalConstants {
    // System Infor
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SEPARATOR = System.getProperty("file.separator");
    public static final String JAVA_VERSION =  System.getProperty("java.version");

    // Wait Infor
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;
    // Browser Logs / Extension
    public static final String BROWSER_LOG_PATH = PROJECT_PATH + SEPARATOR+ "browserLogs"+ SEPARATOR;
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH+SEPARATOR+"browserExtensions"+ SEPARATOR;
}
