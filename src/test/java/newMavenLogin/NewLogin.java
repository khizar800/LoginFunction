package newMavenLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class NewLogin {
	WebDriver driver = null;

	@Before
	public void before_method(){
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
	} 

	@Given("^I open guru99 website$")
	public void open_guru99() throws Throwable {
		driver.navigate().to("http://demo.guru99.com/test/login.html#");
		System.out.println("guru99 website Login page is launched");

	}

	@When("^User enters (\\w+) and (\\w+)$")
	public void user_enters_UserName_and_Password (String email, String passwd) throws Throwable {
		System.out.println(email);
		System.out.println(passwd);

		driver.findElement(By.cssSelector("input#email")).sendKeys(email);
		Thread.sleep(500);
		driver.findElement(By.cssSelector("input#passwd")).sendKeys(passwd);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		System.out.println("data entered in the application");
	}

	@Then("^Successful Login Message Displayed$")
	public void successful_login() throws Throwable {
		driver.getTitle().contains("Title");
		System.out.println("Matching the title of the page after successful Registration.");
	}

	@After
	public void Close_the_browser() throws Throwable {
		boolean funcLogin ;
		if(driver.findElement(By.xpath("//h3[contains(text(),'Successfully Logged in...')]")).isDisplayed())
		{
			funcLogin = true;
		}
		else {
			funcLogin = false;
		}

		if(funcLogin) {
			System.out.println("Successfull login");
			driver.close();
		}
		else { 
			System.out.println("UnSuccessful login");
		driver.close();
		System.out.println("Closes the browser opened through selenium");

		}
	}
}
