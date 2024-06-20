package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TextBoxScenarioOutline {
	WebDriver driver;
	JavascriptExecutor jse;
	@Given("user should click the textbox optiont to navigate")
	public void userShouldClickTheTextboxOptiontToNavigate() {

		System.setProperty("window.chrome.driver", "D:\\chromedriver-win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.findElement(By.xpath("//span[.='Text Box']")).click();
	}

	@Given("user should enter the {string},{string},{string},{string} on the textbox")
	public void userShouldEnterTheOnTheTextbox(String name, String email, String permanent, String current) {
		driver.findElement(By.id("userName")).sendKeys(name);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"))
		.sendKeys(current);
		jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.id("permanentAddress")).sendKeys(permanent);
	}

	@When("user should click on  the sumbit button")
	public void userShouldClickOnTheSumbitButton() {
		 driver.findElement(By.id("submit")).click();

	}
	@Then("user should view the listed details")
	public void userShouldViewTheListedDetails() {
		System.out.println(driver.findElement(By.id("name")).getText());
		   System.out.println(driver.findElement(By.id("email")).getText());
		   System.out.println(driver.findElement(By.xpath("//p[@id='currentAddress']")).getText());
		   System.out.println(driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText());

	}
}
