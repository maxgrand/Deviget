package Tools;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
    private final static String WINDOWS_PATH = "chromedriver_win32/chromedriver.exe";
    private static final String LINUX64_PATH = "chromedriver_linux64/chromedriver";
    private final static String CHROME_DRIVER = "webdriver.chrome.driver";

    private final static String GECKO_WINDOWS_PATH = "geckodriver_win32/geckodriver.exe";
    private final static String GECKO_LINUX_PATH = "geckodriver_linux64/geckodriver";
    private final static String GECKO_DRIVER = "webdriver.gecko.driver";


    public static void SetChromeDriver() throws Exception {
        final ClassLoader classLoader = WebDriverFactory.class.getClassLoader();
        if(System.getProperty(CHROME_DRIVER) == null) {
            if (SystemUtils.IS_OS_WINDOWS) {
                System.setProperty(CHROME_DRIVER, classLoader.getResource(WINDOWS_PATH).getPath());
            } else if (SystemUtils.IS_OS_LINUX) {
                if (SystemUtils.OS_ARCH.contains("32")) {
                    throw new Exception("This OS is not supported");
                } else {
                    System.setProperty(CHROME_DRIVER, classLoader.getResource(LINUX64_PATH).getPath());
                    new SystemCommandExecutor().makeDriverExecutable(classLoader.getResource(LINUX64_PATH).getPath());
                }
            } else {
                throw new Exception("This OS is not supported");
            }
        }
    }

    private static void SetGeckoDriver() throws Exception
    {
        final ClassLoader classLoader = WebDriverFactory.class.getClassLoader();
        final SystemCommandExecutor systemCommandExecutor = new SystemCommandExecutor();

        if (SystemUtils.IS_OS_WINDOWS) {
            System.setProperty(GECKO_DRIVER, classLoader.getResource(GECKO_WINDOWS_PATH).getPath());
        } else if (SystemUtils.IS_OS_LINUX) {
            System.setProperty(GECKO_DRIVER, classLoader.getResource(GECKO_LINUX_PATH).getPath());
            systemCommandExecutor.makeDriverExecutable(System.getProperty(GECKO_DRIVER));
        } else {
            throw new Exception("This OS is not supported");
        }
    }

    public static WebDriver GetDriver(final String driver) throws Exception
    {
        switch (driver) {
            case "chrome": {
                SetChromeDriver();
                final ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                return new ChromeDriver(options);
            }
            case "firefox": {
                SetGeckoDriver();
                final FirefoxOptions options = new FirefoxOptions();
                return new FirefoxDriver(options);
            }
            default:
                return null;
        }
    }

    public static void CloseExistingDrivers(String chosenDriver) throws Exception {
        if (SystemUtils.IS_OS_WINDOWS) {
            SystemCommandExecutor.KillBrowserInWindows(chosenDriver);
        } else if (SystemUtils.IS_OS_LINUX) {
            SystemCommandExecutor.KillBrowserInLinux(chosenDriver);
        } else {
            throw new Exception("This OS is not supported");
        }
    }
}
