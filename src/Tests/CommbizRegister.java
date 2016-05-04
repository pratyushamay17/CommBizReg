package Tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CommbizRegister {
	WebDriver driver=new FirefoxDriver();
	@Test
	public void Registration(){
		login();
		RegistrationMode();
		ImportantInfo();
		createaccount();
	}
	public void login(){
		driver.navigate().to("https://www1.my.commbiz.commbank.com.au/logon/usermaintenance/login.aspx");
		driver.switchTo().frame("frmRegistration");
		//values(By.xpath("Register_logIn"));
		click(By.xpath("//div[@class='Register_logIn']"));
		Assert.assertTrue(driver.getTitle().equals("Registration Mode"));
		
	}
	public void RegistrationMode(){
		//System.out.println(driver.findElement(By.id("rdoExpres")).isSelected());
		click(By.id("rdoExpress"));
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		click(By.xpath("//input[@id='btnNext']"));
		Assert.assertTrue(driver.getTitle().equals("Important Information"));
	}
	public void ImportantInfo(){
		click(By.id("chkTerms"));
		click(By.id("btnSubmit"));
	}
	public void createaccount(){
		values(By.id("txtUserName"),"dicklo");
		values(By.id("txtPassword"),"smith123");
		values(By.id("txtReenterPassword"),"smith123");
		Select dd1secret1=new Select(driver.findElement(By.id("ddlSecret1")));
		dd1secret1.selectByIndex(1);
		values(By.id("txtSecret1"),"smiths");
		Select ddlSecret2=new Select(driver.findElement(By.id("ddlSecret2")));
		ddlSecret2.selectByVisibleText("What is your favourite sports team ?");
		values(By.id("txtSecret2"),"cricket");
		click(By.id("btnSubmit"));
		Assert.assertTrue("create account is unsuccessful", driver.getTitle().equals("Step 1 - Service Details"));
		driver.close();
	}
//	public void element(By by){
//		driver.findElement(by);
//	}
	public void values(By by,String val){
	driver.findElement(by).sendKeys(val);;	
	}
	public void click(By by){
		driver.findElement(by).click();
	}
}
