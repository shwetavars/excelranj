package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.HomePage;
import page.LoginPage;
import util.BrowserFactory_TestNG;
import util.xls_reader;



public class AddContactTest {
	xls_reader reader = new xls_reader("/Users/Gaurav/eclipse-workspace/TESTNGARTIFACTasdf/Data/TESTNG.xlsx");
	String email = reader.getcelldata("Sheet1", "Email", 2);
	String pwd = reader.getcelldata("Sheet1", "Password", 2);
	String nam = reader.getcelldata("Sheet1", "Name", 2);
	String com = reader.getcelldata("Sheet1", "Company", 2);
	String emc = reader.getcelldata("Sheet1", "EmailContact", 2);
	String phone1 = reader.getcelldata("Sheet1","Phone", 2);
	String add = reader.getcelldata("Sheet1", "address", 2);
	String cit = reader.getcelldata("Sheet1", "city", 2);
	String stat = reader.getcelldata("Sheet1", "state", 2);
	String zip1 = reader.getcelldata("Sheet1", "zipcode", 2);
	String coun= reader.getcelldata("Sheet1", "country", 2);
	
	
	@Test
	public void Addcontact()
	{
		System.out.println(email);
		WebDriver driver= BrowserFactory_TestNG.startBrowser("chrome", "http://techfios.com/test/billing/?ng=login/");
		LoginPage log= PageFactory.initElements(driver, LoginPage.class);
		log.Login(email, pwd);
		
		HomePage hom= PageFactory.initElements(driver, HomePage.class);
		hom.NavigatingtoAddContact();
		hom.verifypageLogin();
		
		AddContactPage adcp = PageFactory.initElements(driver, AddContactPage.class);
		adcp.FillingUpAddressForm(nam,com,emc,phone1,add,cit,stat,zip1,coun);
		
		
	}
	

}
