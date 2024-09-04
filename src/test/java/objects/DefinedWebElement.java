package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waiters.FluentWaiter;

public class DefinedWebElement {
    //Třída pro zjednodušení práce s elementy.
    //Uchovává v sobě xPath + provolání elementu přes wait metody.
    public DefinedWebElement(String xPath, WebDriver driver) {
        this.xPath = xPath;
        this.driver = driver;
        fluentWaiter =new FluentWaiter(driver,xPath);
    }
    WebElement element;
    String xPath;
    WebDriver driver;
    FluentWaiter fluentWaiter;

    public WebElement getElement() {
        return fluentWaiter.forAllReady(xPath);
    }

    public String getxPath() {
        return xPath;
    }

    public FluentWaiter getFluentWaiter() {
        return fluentWaiter;
    }
}
