package StepDefinitions;

import Pages.LoginPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;


public class Login extends CommonMethods {


    @When("user enters valid email and valid Password")
    public void user_enters_valid_email_and_valid_password() {
       // LoginPage login = new LoginPage();
        // all these object in this class commented after page initializer class created.

        // driver.findElement(By.id("txtUsername")).sendKeys(ConfigReader.getPropertyValue("username"));
        //  WebElement usernameTextBox = driver.findElement(By.id("txtUsername"));
        sendText(login.usernameTextBox, ConfigReader.getPropertyValue("username"));

        // driver.findElement(By.id("txtPassword")).sendKeys(ConfigReader.getPropertyValue("password"));
        //  WebElement passwordTextBox = driver.findElement(By.id("txtPassword"));
        sendText(login.passwordTextBox, ConfigReader.getPropertyValue("password"));

    }

    @When("click on login button")
    public void click_on_login_button() {
       // LoginPage login = new LoginPage();

        // WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        doClick(login.loginBtn);
    }

    @Then("user is logged in successfully")
    public void user_is_logged_in_successfully() {




        boolean userloggedIn = driver.findElement(By.xpath("//a[contains(text(), 'Welcome')]")).isDisplayed();
        if (userloggedIn) {
            System.out.println("User is logged in Successfully");
        }
    }


    @When("user enters valid {string} and valid {string}")
    public void user_enters_valid_and_valid(String username, String password) {
       // LoginPage login = new LoginPage();
        // WebElement usernameTextBox = driver.findElement(By.id("txtUsername"));
        sendText(login.usernameTextBox, username);

        // WebElement passwordTextBox = driver.findElement(By.id("txtPassword"));
        sendText(login.passwordTextBox, password);
    }


    @When("user enters username and password and verifies login")
    public void user_enters_username_and_password_and_verifies_login(DataTable dataTable) {
       // LoginPage login = new LoginPage();

        List<Map<String, String>> credential = dataTable.asMaps();

        for (Map<String, String> cre : credential) {
            String userName = cre.get("username");
            String password = cre.get("password");

            // WebElement usernameTextBox = driver.findElement(By.id("txtUsername"));
            sendText(login.usernameTextBox, userName);

            //  WebElement passwordTextBox = driver.findElement(By.id("txtPassword"));
            sendText(login.passwordTextBox, password);

            // WebElement loginBtn = driver.findElement(By.id("btnLogin"));
            doClick(login.loginBtn);

            // WebElement welcomeIcon = driver.findElement(By.id("welcome"));
            doClick(login.welcomeIcon);

            WebElement logout = driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a"));
            doClick(logout);

        }


    }


}