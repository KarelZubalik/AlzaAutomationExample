package utils.Waiters;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Arrays;

public class FluentWaiter {
    public FluentWaiter(WebDriver driver) {
        this.driver = driver;

    }

    public FluentWaiter(WebDriver driver, String webElementXpath) {
        this.driver = driver;
        this.webElementXpath = webElementXpath;
    }


    String webElementXpath;
    long timeout=15;
    long pollingrate=500;


    WebDriver driver;

    private WebElement waitForAllWaits(long miliseconds, long seconds, String webElement){
        FluentWait<WebDriver> wait= new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(miliseconds))
                .ignoreAll(Arrays.asList(
                        org.openqa.selenium.NoSuchElementException.class,
                        StaleElementReferenceException.class,
                        ElementNotInteractableException.class
                ));
        wait.pollingEvery(Duration.ofMillis(miliseconds)).withTimeout(Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete';"));
        wait.until((ExpectedConditions.jsReturnsValue("return $.active==0;")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(webElement)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElement)));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(webElement)));
    }

    private WebElement waitForAllWaits(long miliseconds, long secons, WebElement webElement){
        FluentWait<WebDriver> wait= new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(secons))
                .pollingEvery(Duration.ofMillis(miliseconds))
                .ignoreAll(Arrays.asList(
                        org.openqa.selenium.NoSuchElementException.class,
                        StaleElementReferenceException.class,
                        ElementNotInteractableException.class
                ));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete';"));
        wait.until((ExpectedConditions.jsReturnsValue("return $.active==0;")));
        wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    private  WebElement fluentWaitForPresenceOfElementLocated(long MiliSeconds, long WaitTimeout, String webElement) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(WaitTimeout))
                .pollingEvery(Duration.ofMillis(MiliSeconds))
                .ignoring(NoSuchElementException.class);
        WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(webElement)));
        return element;
    }
    private WebElement fluentWaitForElementToClickable(long MiliSeconds, long WaitTimeout, String webElement) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(WaitTimeout))
                .pollingEvery(Duration.ofMillis(MiliSeconds))
                .ignoring(NoSuchElementException.class);
        WebElement element;
        element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(webElement)));
        return element;
    }
    private void clickOnNoMoveElement(String element){
        int b = 1;
        while (b==1){
            try {
                Rectangle res = forAllReady(element).getRect();
                int x1 = res.getX();
                int y1 = res.getY();
//                System.out.println(res.getX());
//                System.out.println(res.getY());
                Thread.sleep(500);
                Rectangle rez = forAllReady(element).getRect();
                int x2 = rez.getX();
                int y2 = rez.getY();
//                System.out.println(rez.getX());
//                System.out.println(rez.getY());
                if ((x1 == x2) && (y1 == y2)) {
                    System.out.println("Lokace je Stejná");
                    b += 1;
                } else {
                    System.out.println("Lokace není stejná :(");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  WebElement forAllReady() {
        return forAllReady(webElementXpath);
    }
    public  WebElement forAllReady(String webElement) {
        return forAllReady(pollingrate,timeout,webElement);
    }
    public WebElement forAllReady(long pollMil, long secTimeout) {
        return forAllReady(pollMil,secTimeout,webElementXpath);
    }
    public WebElement forAllReady(long pollMil, long secTimeout, String webElement) {
        return waitForAllWaits(pollMil,secTimeout,webElement);
    }

    public  WebElement forAllReady(WebElement webElement) {
        return forAllReady(pollingrate,timeout,webElement);
    }
    public WebElement forAllReady(long pollMil, long secTimeout, WebElement webElement) {
        return waitForAllWaits(pollMil,secTimeout,webElement);
    }
    public void waitForInvisible(){
        waitForInvisible(webElementXpath);
    }

    public  void waitForInvisible(String webElement) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(webElement)));
    }
}
