package objects;

import org.openqa.selenium.WebDriver;

public abstract class ObjectClass {
    public ObjectClass(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver driver;
}
