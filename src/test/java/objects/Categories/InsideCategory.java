package objects.Categories;

import objects.DefinedWebElement;
import objects.ObjectClass;
import objects.Product.ItemInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class InsideCategory extends ObjectClass {
    public InsideCategory(WebDriver driver) {
        super(driver);
    }
    public DefinedWebElement subSectionPocitace =new DefinedWebElement("//span[text()='Počítače']/parent::a",driver);
    public DefinedWebElement imageOfRandomProduct=new DefinedWebElement("//*[@id='boxes']//*[@class='bi js-block-image']",driver);
    public DefinedWebElement wholeProduct=new DefinedWebElement("//*[contains(@class,'box browsingitem js-box canBuy inStockAvailability')]",driver);
    public DefinedWebElement categoryProductPrice=new DefinedWebElement("//*[@class=\"price-box__price\"]",driver);
    public DefinedWebElement categoryProductName=new DefinedWebElement("//*[@class=\"name browsinglink js-box-link\"]",driver);
    public DefinedWebElement categoryProductKoupitButton=new DefinedWebElement("//*[@class=\"btnk1\"]",driver);

    public List<WebElement> getAllProductsNames(){
        wholeProduct.getElement().isDisplayed();
        return driver.findElements(By.xpath(wholeProduct.getxPath()+categoryProductName.getxPath()));
    }
    public List<WebElement> getAllProductsPrices(){
        wholeProduct.getElement().isDisplayed();
        return driver.findElements(By.xpath(wholeProduct.getxPath()+categoryProductPrice.getxPath()));
    }
    public List<WebElement> getAllProductsKoupitButtons(){
        wholeProduct.getElement().isDisplayed();
        return driver.findElements(By.xpath(wholeProduct.getxPath()+categoryProductKoupitButton.getxPath()));
    }

    public List<ItemInfo> getItemInfoList(){
        List<ItemInfo> itemInfos= new ArrayList<>();
        List<WebElement> names=getAllProductsNames();
        List<WebElement> prices=getAllProductsPrices();
        for (int i = 0; i < names.size(); i++) {
            itemInfos.add(new ItemInfo(names.get(i).getText(),Integer.parseInt(prices.get(i).getText().replace(",-","").replace(" ",""))));
        }
        return itemInfos;
    }
}
