package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {
	public static WebDriver driver;
PageObjects po;
@Given("^Navigate to Home page$")
	public void Navigate_to_HomePage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumfolder\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver();
	 po = new PageObjects(driver);
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		
	}
	@When("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		PageObjects.signin.click();
		PageObjects.userName.sendKeys("lalitha");
		PageObjects.password.sendKeys("Password123");
		PageObjects.login.click();
	}
	@Then("^user logged in successfully$")
	public void user_logged_in_successfully() throws Throwable {
		System.out.println("User login successfully");
	}
	@When("^Lalitha searches below products in the search box:")
	public void larry_searches_below_products_in_the_search_box(DataTable dt) {
		List<String> product=dt.asList(String.class);
		for(String s: product) {
			driver.findElement(By.id("myInput")).sendKeys(s);
			driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
		}
}
	@Then("^product should be added in the cart if available")
	public void product_should_be_added_in_the_cart_if_available_in_TestMeApp() {
	}
}
