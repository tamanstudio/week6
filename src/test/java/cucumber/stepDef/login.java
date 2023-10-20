package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://kasirdemo.belajarqa.com/";
    @Given("User in on kasirAja login page")
    public void user_in_on_kasirAja_login_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //assertion halaman login
        String loginPageAssert = driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/h2")).getText();
        Assert.assertEquals(loginPageAssert, "hai, kasirAja");
    }

    @When("User enter the valid credentials")
    public void userEnterTheValidCredentials() {
        //input Email
        driver.findElement(By.id("email")).sendKeys("tdd-selenium@gmail.com");
        //input password
        driver.findElement(By.id("password")).sendKeys("tdd-selenium");
    }

    @And("Click on Login")
    public void clickOnLogin() {
        //click login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("Home Page should be displayed")
    public void homePageShouldBeDisplayed() {
        //Assert nama toko
        driver.findElement(By.xpath("//div[contains(text(), 'dashboard')]"));
        String username = driver.findElement(By.xpath("//dd[contains(text(), 'hai')]/preceding-sibling::dt")).getText();
        Assert.assertEquals(username, "tdd-selenium");
    }

    @When("User enter the Invalid credentials")
    public void userEnterTheInvalidCredentials() {
        //input Email
        driver.findElement(By.id("email")).sendKeys("tdd-selenium@gmail.com");
        //input password yang salah
        driver.findElement(By.id("password")).sendKeys("passdsalah");
    }

    @Then("Error Message Should be displayed")
    public void errorMessageShouldBeDisplayed() {
        String ErrorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(ErrorLogin, "Kredensial yang Anda berikan salah");
    }
}
