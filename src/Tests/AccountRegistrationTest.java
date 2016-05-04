package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class AccountRegistrationTest {
	
	WebDriver driver=new FirefoxDriver();
	
	@Test
	public void Registration(){
		//Uncomment below code for Chrome Browser
		//System.setProperty("webdriver.chrome.driver", "P:\\selenium\\chromedriver.exe");
		NavigateToRegisterNow();
		RegistrationSelection();
		AcceptConditions();
		ExpressRegImportantInfo();
	}
	
	//Register Now Automation
	public void NavigateToRegisterNow(){
		driver.navigate().to("https://www1.my.commbiz.commbank.com.au/logon/usermaintenance/login.aspx");
		driver.switchTo().frame("frmRegistration");
		driver.findElement(By.className("Register_logIn")).click();
	}	
	
	//Select Express Registration
	public void RegistrationSelection(){
		driver.findElement(By.xpath("//input[@id='rdoExpress']")).click();
		driver.findElement(By.id("btnNext")).click();
	}
	
	//Accept terms and conditions
	public void AcceptConditions(){
		driver.findElement(By.id("chkTerms")).click();
		driver.findElement(By.id("btnSubmit")).click();
	}
	
	//Enter important info and create account
	public void ExpressRegImportantInfo() {		
		driver.findElement(By.id("txtUserName")).sendKeys("prahyusha");
		driver.findElement(By.id("txtPassword")).sendKeys("prathyu#Jee1");
		driver.findElement(By.id("txtReenterPassword")).sendKeys("prathyu#Jee1");
		Select ddlSecret1=new Select(driver.findElement(By.id("ddlSecret1")));
		ddlSecret1.selectByIndex(2);
		driver.findElement(By.id("txtSecret1")).sendKeys("veeradhi");
		ddlSecret1=new Select(driver.findElement(By.id("ddlSecret2")));
		ddlSecret1.selectByIndex(3);
		driver.findElement(By.id("txtSecret2")).sendKeys("cricket");
		driver.findElement(By.id("btnSubmit")).click();

		if(driver.findElement(By.xpath("//div[@class='errors']")).isDisplayed()){
			System.out.println("there are validation errors on screen");
		}
		else{
			System.out.println("registration success");
		}
		driver.close();
	}
	
}


