package objects.Homepage;

import objects.DefinedWebElement;
import objects.ObjectClass;
import org.openqa.selenium.WebDriver;

public class LeftMenu extends ObjectClass {
    public LeftMenu(WebDriver driver) {
        super(driver);
    }
    DefinedWebElement categoryVyprodej=new DefinedWebElement("//*[@title='Výprodej']",driver);
    DefinedWebElement pocitaceANotebooky=new DefinedWebElement("//a[text()='Počítače a notebooky']/parent::li",driver);

    public void clickOnPocitaceANotebooky(){
        pocitaceANotebooky.getElement().click();
    }

}
