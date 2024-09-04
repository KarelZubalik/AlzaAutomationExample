package objects.Product;

import objects.DefinedWebElement;
import objects.ObjectClass;
import org.openqa.selenium.WebDriver;

public class ProductDetail extends ObjectClass {
    public ProductDetail(WebDriver driver) {
        super(driver);
    }
    public DefinedWebElement buyProductButton=new DefinedWebElement("//*[@class=\"price-detail__buy-actions\"]",driver);
}
