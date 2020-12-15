package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver;
	// locators
		By loc_inp_UserName = By.xpath("//input[@id='USERNAME']");
		By loc_inp_Password = By.xpath("//input[@id='PASSWORD']");
		By loc_btn_Login = By.xpath("//button[@type='submit']/span[text()='LOG ON']");
		By loc_link_SignOut = By.xpath("//a[@id='SignOut']");

	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") +"/src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://lm.salefishsoftware.net/LogOn");
		System.out.println("Inside step - user is on login page ");
		
	}

	@When("user enters valid {string} and valid {string}")
	public void user_enters_valid_username_and_valid_password(String strUserName , String strPassword) {
		driver.findElement(loc_inp_UserName).sendKeys(strUserName);
		driver.findElement(loc_inp_Password).sendKeys(strPassword);
		
		System.out.println("Inside step - user enters valid Username and valid password");
		
	}

	@And("clicks on login button")
	public void clicks_on_login_button() throws InterruptedException {
		driver.findElement(loc_btn_Login).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println("Inside step- clicks on login button");		
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() {
		driver.findElement(loc_link_SignOut).isDisplayed();
		System.out.println("Inside step - user is navigated to home page");
		
	}
}
