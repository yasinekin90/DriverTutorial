package stepdefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.BaseTest;
import utils.Waits;

import java.util.Map;

import static pages.LocatorClass.*;

public class MyStepdefs extends BaseTest {


    @Given("user on homepage")
    public void userOnHomepage() {
        driver.get(url);
    }

    @When("user login as follow")
    public void userLoginAsFollow(DataTable table) {
        Map<String, String> map = table.asMap();
        sendKeys(usernameInputLogin, map.get("username"));
        sendKeys(passwordInputLogin, map.get("password"));
        click(buttonSubmitLogin);
    }

    @Then("login should be successfull")
    public void loginShouldBeSuccessfull() {
        waitForElement(buttonLogout, Waits.VISIBILITY);
    }
}
