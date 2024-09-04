package objects.Cart;

import objects.DefinedWebElement;
import objects.ObjectClass;
import org.openqa.selenium.WebDriver;

public class Cart extends ObjectClass {
    public Cart(WebDriver driver) {
        super(driver);
    }
    public DefinedWebElement cartIcon =new DefinedWebElement("//*[@data-testid=\"headerBasketIcon\"]",driver);
    public DefinedWebElement nextStep=new DefinedWebElement("//*[@id='blockBtnRight']/a",driver);
    public DefinedWebElement popUpDontForget=new DefinedWebElement("//*[@class='btnx normal grey js-close-button close-button']",driver);
    public DefinedWebElement crossOnProduct=new DefinedWebElement("//*[@title='Odstranit']",driver);
    public DefinedWebElement limitationsBlock=new DefinedWebElement("//*[@id='blockLimitations']",driver);
    public DefinedWebElement finalPrice=new DefinedWebElement("//*[@class=\"last price\"]",driver);
}
