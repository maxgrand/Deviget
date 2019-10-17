package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AliExpressPage extends BasePage{
    private String url = "https://es.aliexpress.com";

    //region Page elements

    @FindBy(className = "close-layer")
    private WebElement popUpCloseButton;

    @FindBy(className = "ui-banner-slider-nav")
    private WebElement navigationSlider;

    @FindBy(css = "[delivery-id='342795']")
    private WebElement huaweiPriceFallPromotion;

    @FindBy(className = "spggbwf")
    private List<WebElement> huaweiResultPageDivContainer;

    @FindBy(className = "sku-property-text")
    private WebElement huaweiCellphoneOption;

    @FindBy(id = "icon-payment-waiting")
    private WebElement unavailableDeliveryAlertIcon;

    @FindBy(className = "product-shipping-info black-link")
    private WebElement shippingPopUp;

    @FindBy(className = "next-dialog-body")
    private WebElement shippingPopUpButton;

    @FindBy(className = "next-input-control")
    private WebElement shippingDropdown;

    @FindBy(css = "[role='searchbox']")
    private WebElement shippingAutoCompleteInput;

    @FindBy(className = "country-name")
    private WebElement chosenCountry;

    @FindBy(css = "[ae_button_type='detail_shipping_panel_apply']")
    private WebElement shippingApplyNowButton;

    @FindBy(css = ".next-btn.next-large.next-btn-primary.buynow")
    private WebElement buyNowButton;

    @FindBy(id = "batman-dialog-wrap")
    private WebElement loginPopUp;

    //endregion

    public AliExpressPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
        this.goToHomePage(this.url,0);
    }

    //region page behaviour methods

    public void goToPromotion(String promotionType){
        this.clickElement(popUpCloseButton);
        WebElement chosenPromotion = null;

        switch (promotionType.toLowerCase()){
            default:
                chosenPromotion = this.huaweiPriceFallPromotion;
        }

        for (WebElement slide : navigationSlider.findElements(By.xpath("//span[@data-role='navButton']"))){
            if(chosenPromotion.isDisplayed()){
                this.url = this.FirstChild(chosenPromotion).getAttribute("href");
                this.goToHomePage(this.url,0);
                break;
            }else {
                slide.click();
            }
        }
    }

    public void selectSecondProduct(){
        WebElement buyButton = this.huaweiResultPageDivContainer.get(1).findElement(By.className("shop"));
        this.clickElement(buyButton);
    }

    public void buyProduct(String...shippingCountry){
        this.clickElement(huaweiCellphoneOption);

        this.scrollTo(buyNowButton);

        if(this.unavailableDeliveryAlertIcon.isDisplayed()){
            if(shippingCountry.length > 0){
                this.changeShipping(shippingCountry[0]);
            }else{
                throw new IllegalArgumentException("Native country is un-available for shipping");
            }
        }

        this.clickElement(buyNowButton);
    }

    //region validations and private methods

    public String verifyUrl() {
        return this.driver.getCurrentUrl();
    }

    public boolean verifyLoginIsPresent(){
        return this.loginPopUp.isDisplayed();
    }

    private void changeShipping(String shippingCountry) {
        this.clickElement(shippingPopUpButton);
        this.clickElement(this.shippingDropdown);
        this.sendKeys(this.shippingAutoCompleteInput, shippingCountry);
        this.clickElement(this.chosenCountry);
        this.clickElement(shippingApplyNowButton);
    }

    //endregion

    //endregion
}
