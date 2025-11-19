package register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {
	@Test
	public void verifyRegisterAccountUsingMandatoryFields() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");

		// click on My Account
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		// click on Register
		driver.findElement(By.linkText("Register")).click();
		// Enter First Name
		driver.findElement(By.id("input-firstname")).sendKeys("Automation");
		// Enter Last Name
		driver.findElement(By.id("input-lastname")).sendKeys("Tester");
		// Enter E-Mail
		driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
		// Enter Telephone
		driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
		// Enter Password
		driver.findElement(By.id("input-password")).sendKeys("Tester@1234");
		// Enter Password Confirm
		driver.findElement(By.id("input-confirm")).sendKeys("Tester@1234");
		// click on Privacy Policy check box
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		// click on Continue button
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		driver.close();
	}

	public String generateNewEmail() {
		Date date = new Date();
		String dateString = date.toString();
		String dateWithoutSpaces = dateString.replaceAll("\\s", "");
		String dateWithoutSacesAndColons = dateWithoutSpaces.replaceAll("\\:", "");
		String newEmail = dateWithoutSacesAndColons + "@gmail.com";
		return newEmail;
	}
}
