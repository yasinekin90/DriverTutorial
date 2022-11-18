package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.BaseTest;

import java.util.List;

public class MenuHoverShadowRoot extends BaseTest {

    @Test
    public void test2() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.htmlelements.com/demos/menu/shadow-dom/");

        driver.switchTo().frame(0);

        List<WebElement> elements = driver.findElement(By.tagName("smart-ui-menu"))
                .getShadowRoot()
                .findElements(By.cssSelector("div[smart-id='mainContainer'] > smart-menu-items-group"));

        for (WebElement element : elements) {
            //scrollIntoView(element);
            hover(element);
            element.click();
//            List<WebElement> subElements = element
//                    .findElements(By.xpath(".//div"));

            List<WebElement> subElements = element
                    .findElements(By.cssSelector("div.smart-menu-item-container > smart-menu-item"));

            for (WebElement subElement : subElements) {
                scrollIntoView(subElement);
                hover(subElement);
                Thread.sleep(300);
            }

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
