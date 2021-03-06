package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {

    private WebDriver driver;

    private By username_textfield = By.id("user_email");
    private By password_textfield = By.id("user_password");
    private By login_button = By.xpath("//*[@class='form-group text-center']//input");
    private By logged_in_username_text = By.xpath("//*[@class='navbar-current-user']");

    public Loginpage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsername_textfield() {
        return driver.findElement(username_textfield);
    }

    public WebElement getPassword_textfield() {
        return driver.findElement(password_textfield);
    }

    public WebElement getLogin_button() {
        return driver.findElement(login_button);
    }

    public WebElement getLogged_in_username_text() {
        return driver.findElement(logged_in_username_text);
    }
}
