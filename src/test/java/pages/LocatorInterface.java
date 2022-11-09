package pages;

import org.openqa.selenium.By;

public interface LocatorInterface {
    String url = "http://142.93.110.12:9119/#/login";
    By usernameInputLogin = By.cssSelector("input[name='username']");
    By passwordInputLogin = By.cssSelector("input[name='password']");
    By buttonSubmitLogin = By.xpath("//button[text()='LOG IN']");
    By buttonLogout = By.cssSelector("a[href='#/logout']");
}
