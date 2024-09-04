package tests;

import objects.Cart.BeforeCartPopUp;
import objects.Cart.Cart;
import objects.Cart.CartTransport;
import objects.Cart.CartCustomerInfo;
import objects.Categories.InsideCategory;
import objects.Homepage.CookieHandler;
import objects.Homepage.LeftMenu;
import objects.Product.ProductDetail;
import org.testng.annotations.Test;

public class E2ECartTest extends AlzaTestClass{
    CookieHandler cookieHandler;
    LeftMenu leftMenu;
    InsideCategory insideCategory;
    ProductDetail productDetail;
    BeforeCartPopUp beforeCartPopUp;
    Cart cart;
    CartTransport cartTransport;
    CartCustomerInfo cartCustomerInfo;
    @Test(testName = "Precondition")
    public void precondition(){
        cookieHandler= new CookieHandler(driver);
        leftMenu=new LeftMenu(driver);
        insideCategory=new InsideCategory(driver);
        productDetail=new ProductDetail(driver);
        beforeCartPopUp=new BeforeCartPopUp(driver);
        cart =new Cart(driver);
        cartTransport =new CartTransport(driver);
        cartCustomerInfo =new CartCustomerInfo(driver);
        cart = new Cart(driver);

        cookieHandler.handleCookie();
    }

    @Test(testName = "goToPocitaceANotebooky",priority = 1,dependsOnMethods = "precondition")
    public void goToPocitaceANotebooky() {
        leftMenu.clickOnPocitaceANotebooky();
    }

    @Test(testName = "goToDetail",priority = 2,dependsOnMethods = "goToPocitaceANotebooky")
    public void goToDetail() {
        insideCategory.subSectionPocitace.getElement().click();
        insideCategory.getAllProductsNames().get(0).click();
    }

    @Test(testName = "addToCart",priority = 3,dependsOnMethods = "goToDetail")
    public void addToCart() {
        productDetail.buyProductButton.getElement().click();
        beforeCartPopUp.continuesToTheCart.getElement().click();
    }

    @Test(testName = "goToTransport",priority = 4,dependsOnMethods = "addToCart")
    public void goToTransport() {
        cart.nextStep.getElement().click();
        cart.popUpDontForget.getElement().click();
    }

    @Test(testName = "fillTransport",priority = 5,dependsOnMethods = "goToTransport")
    public void fillTransport() {
        cartTransport.personalCollectionHolesovice.getElement().click();
        cartTransport.personalCollectionHolesovicePopUpNextButton.getElement().click();
        cartTransport.showAllPayments.getElement().click();
        cartTransport.cashPay.getElement().click();
        cartTransport.nextButton.getElement().click();
        cartTransport.handleAlzaPlusPopup();
    }

    @Test(testName = "fillCustomerInformation",priority = 6,dependsOnMethods = "fillTransport")
    public void fillCustomerInformation() {
        cartCustomerInfo.emailInput.getElement().clear();
        cartCustomerInfo.emailInput.getElement().sendKeys("seleniumTestUser@selenium.com");
        cartCustomerInfo.phoneInput.getElement().sendKeys("123456789");
        cartCustomerInfo.billingInformationsCheckbox.getElement().click();
        cartCustomerInfo.nameInput.getElement().sendKeys("seleniumUser");
        cartCustomerInfo.streetInput.getElement().sendKeys("randomStreet");
        cartCustomerInfo.cityInput.getElement().sendKeys("randomCity");
        cartCustomerInfo.zipCodeInput.getElement().sendKeys("0000");
        cartCustomerInfo.vatParamIcoInput.getElement().sendKeys("12345678");
        cartCustomerInfo.vatParamIcdphInput.getElement().sendKeys("CZ12345678");
        cartCustomerInfo.accountNumberInput.getElement().sendKeys("1234567891234567891");
        cartCustomerInfo.bankCodeInput.getElement().sendKeys("1234");
        cartCustomerInfo.specificSymbolInput.getElement().sendKeys("123456789");
        cartCustomerInfo.internalOrderNumberInput.getElement().sendKeys("12345777");
        cartCustomerInfo.questionRememberUserDataCheckBox.getElement().click();
        cartCustomerInfo.passwordInput.getElement().sendKeys("password123");
        cartCustomerInfo.passwordAgain.getElement().sendKeys("password123");
    }
}
