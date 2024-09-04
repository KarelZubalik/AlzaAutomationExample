package objects.Homepage;

import objects.DefinedWebElement;
import objects.ObjectClass;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookieHandler extends ObjectClass {
    public CookieHandler(WebDriver driver) {
        super(driver);
    }

    DefinedWebElement acceptCookie = new DefinedWebElement("//*[@class=\"btnx cookies-info__button js-cookies-info-accept\"]",driver);

    public void handleCookie(){
        try{
            WebElement element=acceptCookie.getFluentWaiter().forAllReady(500,5);
            if (element.isDisplayed()){
                acceptCookie.getElement().click();
            }
        } catch (TimeoutException e) {
            System.out.println("Cookie se nezobrazila.");
        }
    }
}
