package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.BaseTest;
import utils.Waits;

import java.util.List;

public class ShadowDom extends BaseTest {


    @Test
    public void test01(){
        driver.get("https://www.htmlelements.com/demos/input/shadow-dom/");

        waitForElement(By.cssSelector("div.demo-technical-demo"), Waits.EXISTS);
        WebElement iFrame = driver.findElement(By.cssSelector("iframe[class='demo-frame']"));
        driver.switchTo().frame(iFrame);

        // shadow root icindeki elementler icin, cssSelector, id, tagname
        WebElement textArea =
                driver.findElement(By.tagName("smart-ui-text-area"))
                        .getShadowRoot()
                        .findElement(By.cssSelector("textarea[smart-id='input']"));
        textArea.sendKeys("guider soft");

        List<WebElement> list =  driver.findElement(By.tagName("smart-ui-text-area"))
                .getShadowRoot()
                .findElements(By.tagName(""));
        for (WebElement webElement : list) {
            new Actions(driver).moveToElement(webElement).pause(200).build().perform();
        }
    }



    @AfterTest
    public void afterTest(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
