package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TextBox {
	 WebDriver driver;
	 JavascriptExecutor jse;
@Given("user should click the textbox option")
public void userShouldClickTheTextboxOption() {
   System.setProperty("window.chrome.driver", "D:\\chromedriver-win32\\chromedriver.exe");
  driver= new ChromeDriver();
   driver.get("https://demoqa.com/text-box");
   driver.findElement(By.xpath("//span[.='Text Box']")).click();
}


  @Given("user should enter the details in the textbox") 
public void userShouldEnterTheDetailsInTheTextbox() { 
  driver.findElement(By.id("userName")).sendKeys("Arjun"); 
  driver.findElement(By.id("userEmail")).sendKeys("Arjun@gmail.com"); 
  driver.findElement(By.xpath("//textarea[@placeholder='Current Address']")) 
  .sendKeys("that area"); 
  jse=(JavascriptExecutor)driver; 
  jse.executeScript("window.scrollBy(0,500)"); 
  driver.findElement(By.id("permanentAddress")).sendKeys("to this Address");
}
 
@When("user should press the sumbit button")
public void userShouldPressTheSumbitButton() {
    driver.findElement(By.id("submit")).click();
}


//@Test(dependsOnMethods = "userShouldPressTheSumbitButton")
@Then("user should view the details listed")
public void userShouldViewTheDetailsListed() {
   System.out.println(driver.findElement(By.id("name")).getText());
   System.out.println(driver.findElement(By.id("email")).getText());
   System.out.println(driver.findElement(By.xpath("//p[@id='currentAddress']")).getText());
   System.out.println(driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText());
}


@Given("user should enter the {string},{string},{string},{string} in the textbox")
public void userShouldEnterTheInTheTextbox(String name, String email, String cadd, String padd) {
	 driver.findElement(By.id("userName")).sendKeys(name);
	   driver.findElement(By.id("userEmail")).sendKeys(email);
			   driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"))
			   .sendKeys(cadd);
			   jse=(JavascriptExecutor)driver;
			   jse.executeScript("window.scrollBy(0,500)");
			   driver.findElement(By.id("permanentAddress")).sendKeys(padd);}

@Then("list should not be listed")
public void listShouldNotBeListed() {
 boolean status= driver.findElement(By.id("email")).isDisplayed();
 Assert.assertEquals(status, false);
}

}

