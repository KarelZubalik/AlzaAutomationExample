package tests;

import objects.Cart.Cart;
import objects.Categories.InsideCategory;
import objects.DefinedWebElement;
import objects.Homepage.CookieHandler;
import objects.Homepage.LeftMenu;
import objects.Product.ItemInfo;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Waiters.FluentWaiter;

import java.util.List;


public class PriceControlTest extends AlzaTestClass{

    CookieHandler cookieHandler;
    LeftMenu leftMenu;
    InsideCategory insideCategory;
    Cart cart;
    List<ItemInfo> itemInfos;
    @Test(testName = "Precondition")
    public void precondition(){
        cookieHandler= new CookieHandler(driver);
        leftMenu=new LeftMenu(driver);
        insideCategory=new InsideCategory(driver);
        cart =new Cart(driver);
        cart =new Cart(driver);

        cookieHandler.handleCookie();
    }

    @Test(testName = "goToPocitaceANotebooky",priority = 1,dependsOnMethods = "precondition")
    public void goToPocitaceANotebooky() {
        leftMenu.clickOnPocitaceANotebooky();
    }

    @Test(testName = "getProductInformations",priority = 2,dependsOnMethods = "goToPocitaceANotebooky")
    public void getProductInformations() {
        insideCategory.subSectionPocitace.getElement().click();
        itemInfos=insideCategory.getItemInfoList();
        insideCategory.wholeProduct.getElement().isDisplayed();
//        for (ItemInfo item:insideCategory.getItemInfoList()){
//            System.out.println(item);
//        }
    }

    @Test(testName = "addAllProductsToCart",priority = 2,dependsOnMethods = "getProductInformations")
    public void addAllProductsToCart() {
        FluentWaiter waiter=new FluentWaiter(driver);
        insideCategory.getAllProductsKoupitButtons().forEach(element->waiter.forAllReady(element).click());
    }

    @Test(testName = "goToCart",priority = 2,dependsOnMethods = "addAllProductsToCart")
    public void goToCart() {
        cart.cartIcon.getElement().click();
        itemInfos.forEach(System.out::println);
    }

    @Test(testName = "controlCart",priority = 2,dependsOnMethods = "goToCart")
    public void controlCart() {
        SoftAssert softAssert = new SoftAssert();
        //cartIcon kvůli FluentWaitu
        int finalPrice=0;
        cart.cartIcon.getElement();
        for (ItemInfo itemInfo : itemInfos) {
            softAssert.assertTrue(new DefinedWebElement("//*[@class='mainItem'][contains(text(),'" + itemInfo.getName().split(" \\(")[0] + "')]", driver).getElement().isDisplayed(), "Item:" + itemInfo.getName() + " se nepřidal do košíku.");
            finalPrice += itemInfo.getPrice();
        }
        System.out.println(cart.finalPrice.getElement().getText().replace("Kč","").replace(" ",""));
        softAssert.assertEquals(finalPrice,Integer.parseInt(cart.finalPrice.getElement().getText().replace("Kč","").replace(" ","")),"Finální cena neodpovídá správně hodnotě!");
        softAssert.assertAll();
    }
}
