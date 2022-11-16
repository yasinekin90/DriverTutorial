package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LocatorInterface;
import utils.Driver;
import utils.Waits;

public class Audi extends BaseTest implements LocatorInterface {

    @Test
    public void overLays() {
        driver.get("https://www.audi.com/ci/en/guides/user-interface/components/overlays.html");
        waitForElement(textOverLays, Waits.VISIBILITY);
    }

    @Test(dataProvider = "dataTexts",dependsOnMethods = "overLays")
    public void clickButtons(Object[] arr) {
        By locator = getXpathOfButtonsWithText(arr[0].toString());
        waitForElement(locator,Waits.EXISTS);


            scrollTo(locator);


        waitForElement(locator,Waits.VISIBILITY);
        click(locator);

        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"aui-modal-dialog__close\"])[1]")),
                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"aui-modal-dialog__close\"])[2]")),
                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"aui-modal-dialog__close\"])[3]")),
                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"aui-modal-dialog__close\"])[4]"))

        ));
        WebElement closeButton= driver.findElements(close).stream().filter(WebElement::isDisplayed).toList().get(0);

        closeButton.click();
        wait.until(ExpectedConditions.invisibilityOf(closeButton));


    }

    @DataProvider
    public Object[][] dataTexts() {

        return new Object[][]{
                {"Open modal as layer"},
                {"Morph modal"},
                {"Open modal as window"},
                {"Open modal full-screen"}
        };

    }

    public void scrollTo(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false)", driver.findElement(locator));

    }

    public By getXpathOfButtonsWithText(String text) {
        return By.xpath("//button[.//*[text()=\""+text+"\"] or text()=\""+text+"\"]");
    }
}
