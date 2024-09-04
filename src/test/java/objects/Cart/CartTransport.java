package objects.Cart;

import objects.DefinedWebElement;
import objects.ObjectClass;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class CartTransport extends ObjectClass {
    public CartTransport(WebDriver driver) {
        super(driver);
    }
    public DefinedWebElement personalCollectionHolesovice=new DefinedWebElement("//*[@data-deliveryid='595']/self::div",driver);
    public DefinedWebElement personalCollectionHolesovicePopUpNextButton=new DefinedWebElement("//*[@id='personalCentralDialog']//a[2]",driver);
    public DefinedWebElement showAllPayments=new DefinedWebElement("//*[@id='showAllPayments']",driver);
    public DefinedWebElement cashPay=new DefinedWebElement("//*[@data-paymentid='234']/self::div",driver);
    public DefinedWebElement nextButton=new DefinedWebElement("//*[@id='order2ButtonsContainer']//*[@id='confirmOrder2Button']",driver);
    public DefinedWebElement alzaPlusPopupCloseButton=new DefinedWebElement("//button[@data-testid=\"dialog-close-button\"]",driver);

    public void handleAlzaPlusPopup(){
        try {
            if (alzaPlusPopupCloseButton.getFluentWaiter().forAllReady(500,4).isDisplayed()){
             alzaPlusPopupCloseButton.getElement().click();
            }
        } catch (TimeoutException e) {
            System.out.println("AlzaPlusPopup se nezobrazil.");
        }
    }
}

