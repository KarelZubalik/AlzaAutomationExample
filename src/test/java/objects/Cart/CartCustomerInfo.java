package objects.Cart;

import objects.DefinedWebElement;
import objects.ObjectClass;
import org.openqa.selenium.WebDriver;

public class CartCustomerInfo extends ObjectClass {
    public CartCustomerInfo(WebDriver driver) {
        super(driver);
    }

    public DefinedWebElement emailInput=new DefinedWebElement("//*[@id='userEmail']",driver);
    public DefinedWebElement phoneInput=new DefinedWebElement("//*[@id='inpTelNumber']",driver);
    public DefinedWebElement billingInformationsCheckbox=new DefinedWebElement("//*[@for='questionBillingInformation']",driver);
    public DefinedWebElement nameInput=new DefinedWebElement("//*[@id='name']",driver);
    public DefinedWebElement streetInput=new DefinedWebElement("//*[@id='street']",driver);
    public DefinedWebElement cityInput=new DefinedWebElement("//*[@id='city']",driver);
    public DefinedWebElement zipCodeInput=new DefinedWebElement("//*[@id='zip']",driver);
    public DefinedWebElement vatParamIcoInput=new DefinedWebElement("//*[@id='vatParamIco']",driver);
    public DefinedWebElement vatParamIcdphInput=new DefinedWebElement("//*[@id='vatParamIcdph']",driver);
    public DefinedWebElement accountNumberInput=new DefinedWebElement("//*[@id='accountNumber']",driver);
    public DefinedWebElement bankCodeInput=new DefinedWebElement("//*[@id='bankCode']",driver);
    public DefinedWebElement specificSymbolInput=new DefinedWebElement("//*[@id='specificSymbol']",driver);
    public DefinedWebElement internalOrderNumberInput=new DefinedWebElement("//*[@id='internalOrderNumber']",driver);
    public DefinedWebElement questionRememberUserDataCheckBox=new DefinedWebElement("//*[@for='questionRememberUserData']",driver);
    public DefinedWebElement passwordInput=new DefinedWebElement("//*[@id='password']",driver);
    public DefinedWebElement passwordAgain =new DefinedWebElement("//*[@id='passwordAgain']",driver);
    }

