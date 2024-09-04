package objects.Cart;

import objects.DefinedWebElement;
import objects.ObjectClass;
import org.openqa.selenium.WebDriver;

public class BeforeCartPopUp extends ObjectClass {
    public BeforeCartPopUp(WebDriver driver) {
        super(driver);
    }

    public DefinedWebElement continuesToTheCart = new DefinedWebElement("//*[contains(text(),'Pokračovat do košíku')]",driver);
}
