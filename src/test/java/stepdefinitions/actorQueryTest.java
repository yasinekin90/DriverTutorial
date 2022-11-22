package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import pages.BaseTest;
import utils.MyConnection;
import utils.Waits;

import java.sql.ResultSet;

import java.sql.SQLException;


public class actorQueryTest extends BaseTest {

    int actor_id;
    MyConnection myConnection;
    ResultSet resultSet;

    @Given("user on guidersoft query page")
    public void user_on_guidersoft_query_page() {

        driver.get("http://localhost/guidersoft/index.php");
        driver.manage().window().maximize();
    }
    @When("user select required actorlist from dropdownmenu")
    public void user_select_required_actorlist_from_dropdownmenu() throws SQLException {

        myConnection=new MyConnection("jdbc:mysql://127.0.0.1:3306/sakila",
                "root",
                "");

         resultSet =myConnection.getResultSet("SELECT actor_id FROM actor WHERE actor_id=195;");
        resultSet.next();
        actor_id=resultSet.getInt(1);


        Select select = new Select(driver.findElement(By.cssSelector("select[name='q']")));
       select.selectByIndex(1);
       By sorgula=By.cssSelector("input[value='Sorgula']");
       click(sorgula);

    }
    String element;
    @Then("actors should be listed on the page")
    public void actors_should_be_listed_on_the_page() {

     waitForElement(getXpathOfLastNameWithId(actor_id), Waits.EXISTS);
     element=driver.findElement(getXpathOfLastNameWithId(actor_id)).getText();
    }


    @Then("lastName should be exist in DB")
    public void lastnameShouldBeExistInDB() throws SQLException {


         resultSet =myConnection.getResultSet("SELECT * FROM actor WHERE last_name='"+element+"';");
        resultSet.next();

        Assert.assertTrue(resultSet.getInt(1)>0);

        myConnection.tearDown();
    }
}

