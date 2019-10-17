package ui.pages;

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
}
