package Steps;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class LoginSteps{

    WebDriver driver;

    @Given("I open Chrome and start application$")
    public void iOpenChromeAndStart()throws Throwable{

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https//www.facebook.com");
    }

    @When("I enter valid username and valid password$")
    public void iEnterValidUsernameAndPaswsowrd()throws Throwable{

        driver.findElement(By.id("email")).sendKeys("haseeb.khan@ten10.com");
        driver.findElement(By.id("pass")).sendKeys("Test123");
    }

    @And("I click the login button$")
    public void iClickTheLoginButton()throws Throwable{

        driver.findElement(By.id("loginbutton")).click();
    }

    @Then("I should be able to login successfully$")
    public void iShouldBeAbleToLogin()throws Throwable{

    }

}
