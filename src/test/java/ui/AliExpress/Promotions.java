package ui.AliExpress;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import ui.BaseTest;
import ui.pages.AliExpressPage;

public class Promotions extends BaseTest {
    @Test()
    public void HuaweiTest(){
        AliExpressPage huaweiPromoPage = new AliExpressPage(driver);
        SoftAssertions softly = new SoftAssertions();

        huaweiPromoPage.goToPromotion("");
        String promoUrl = huaweiPromoPage.verifyUrl();

        softly.assertThat(promoUrl)
                .as("Domain Url is not the expected one, should be from:"
                        + "Huawei" + "but actually is : " + promoUrl )
                .contains("Huawei");

        huaweiPromoPage.selectSecondProduct();
        huaweiPromoPage.buyProduct("France");

        softly.assertThat(huaweiPromoPage.verifyLoginIsPresent())
                .as("Login pop up for completing buy not appearing").isTrue();

        softly.assertAll();

    }
}