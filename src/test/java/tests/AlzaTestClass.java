package tests;

import org.testng.annotations.BeforeClass;
import utils.ChromeInizializator.ChromeDriverInit;

public abstract class AlzaTestClass extends TestsClass{
    ChromeDriverInit chromeDriverInit;
    @BeforeClass
    @Override
    protected void beforeClass() {
        chromeDriverInit=new ChromeDriverInit();
        driver=chromeDriverInit.instanceCreator();
    }
}
