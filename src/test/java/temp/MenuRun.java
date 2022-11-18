package temp;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.BaseTest;
import utils.Waits;

import static com.codeborne.selenide.Selenide.*;

public class MenuRun extends BaseTest {
    @Test
    public void test01() {

        open("https://www.htmlelements.com/demos/menu/basic/");
        switchTo().frame(0);

        for (SelenideElement element : $$(By.cssSelector("#menuMainContainer>smart-menu-items-group"))) {
            element.hover();
            sleep(300);
        }
    }

}
