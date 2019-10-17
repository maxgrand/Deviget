package ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    //region protected methods

    protected void goToHomePage(String url, int waitPeriod, WebElement...element) {
        driver.navigate().to(url);

        if(element.length > 0){
            this.waitLoader(element[0], waitPeriod);
        }
    }

    //endregion

    //region private methods

    private void waitLoader(WebElement element, int timeOut)
    {
        new WebDriverWait(this.driver,timeOut).until(ExpectedConditions.invisibilityOf(element));
    }

    //endregion
}
