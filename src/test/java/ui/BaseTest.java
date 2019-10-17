package ui;

import Tools.ConstantsAndConfig;
import Tools.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest extends TestNG {

    public WebDriver driver;

    @BeforeMethod
    public void generalTestSetup() {
        try {
            String chosenDriver = ConstantsAndConfig.getDesiredDriver();
            WebDriverFactory.CloseExistingDrivers(chosenDriver);
            this.driver = WebDriverFactory.GetDriver(chosenDriver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun=true)
    public void closeDriver() {
        try {
            this.driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}