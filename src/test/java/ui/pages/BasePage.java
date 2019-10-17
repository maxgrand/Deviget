package ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait elementWait;
    protected JavascriptExecutor jsExecutor;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        this.elementWait = new WebDriverWait(this.driver,2);
        jsExecutor = (JavascriptExecutor)this.driver;
    }
}
