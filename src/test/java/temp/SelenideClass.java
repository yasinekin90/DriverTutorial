package temp;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.Conditions;

import static com.codeborne.selenide.Selenide.*;


public class SelenideClass {
    @Test
    public void test1(){
        open("https://demowebshop.tricentis.com/");
        $(By.id("small-searchterms"))
                .shouldBe(Condition.visible)
                .scrollIntoView(false)
                .setValue("computer")
                .pressEnter();

        System.out.println($(By.cssSelector("div.product-item"),3)
                .shouldBe(Condition.visible)
                .scrollIntoView(false)
                .getText()
        );

        System.out.println("------------------------");
        $$("div.product-item")
                .shouldHave(CollectionCondition.sizeGreaterThan(3))
                .filter(Condition.matchText(".*own.*"))
                .shouldHave(CollectionCondition.sizeGreaterThan(1))
                .stream()
                .forEach(n-> System.out.println(n.getText()));
    }

}
