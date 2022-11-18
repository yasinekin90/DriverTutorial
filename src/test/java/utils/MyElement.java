package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyElement {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;
    private By locator;


    public static void open(String url){
        new MyElement()._open(url);
    }

    public static MyElement $(By locator){
        return new MyElement(locator);
    }
    public static MyElement $(By locator,int index){
        return new MyElement(locator,index);
    }



    private void _open(String url){
        driver=Driver.getDriver();
        driver.get(url);
    }


    private MyElement(){}

    private MyElement(By locator) {
      this(locator,1);
    }

    private MyElement(By locator,int index) {
        this.locator = locator;
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)).get(index-1);
    }

    public String getText() {
        return element.getText();
    }

    public void click() {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public MyElement sendKeys(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
        return this;
    }

    public MyElement scrollIntoView() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",element);
        return this;
    }


    public void pressEnter(){
        element.sendKeys(Keys.ENTER);
    }

    public MyElement shouldBe(Conditions conditions){
        switch (conditions){
            case visible -> wait.until(ExpectedConditions.visibilityOf(element));
            case clickable -> wait.until(ExpectedConditions.elementToBeClickable(element));
            default -> wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        return this;
    }


}
