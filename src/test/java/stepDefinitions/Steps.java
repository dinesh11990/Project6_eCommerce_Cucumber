package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.krish.page_objects.*;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps extends BaseClass {

	//public static WebDriver driver;
	//public LoginPage lp;
	
	//Before is the cucumber hook which is not possible to separate it in BaseClass
	@Before
	public void setup() throws IOException {
		
		
		//Logger (Logger not working need to check)
		logger=Logger.getLogger("nopCommerce"); //Added logger
		PropertyConfigurator.configure("Log4j.properties"); //Added logger
		
		
		//Reading properties
		configProp = new Properties();
		//Load the File
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile);
		
			
		
		String br=configProp.getProperty("browser");
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
		driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
		driver = new FirefoxDriver();
		}
		else if(br.equals("ie")) {
		System.setProperty("webdriver.ie.driver",configProp.getProperty("iepath"));
		driver = new InternetExplorerDriver();
		}
		
		logger.info("******Launching browser**********");
		
	}
	



	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		

		lp=new LoginPage(driver);
	}

	@When("^User Opens URL \"(.*?)\"$")
	public void user_Opens_URL(String url) {

		logger.info("******Opening URL**********");
		driver.get(url);
		driver.manage().window().maximize();
	}

	////Given("^\"(.*?)\" is elder to \"(.*?)\" and \"(.*?)\"$")
	@When("^User enters Email as \"(.*?)\" and Password as \"(.*?)\"$")
	public void user_enters_Email_as_and_Password_as(String email, String password) {

		logger.info("******Providing Login Info**********");
		lp.setUserName(email);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {
		logger.info("******Started Login r**********");
		lp.clickLogin();
		Thread.sleep(3000);
	}

	@Then("Page Title should be \"(.*?)\"$")
	public void page_Title_should_be(String title) throws InterruptedException {

		if(driver.getPageSource().contains("Login was unsuccessful.")) {

			driver.close();
			logger.info("******Login Passed**********");
			Assert.assertTrue(false);

		}else {
			
			logger.info("******Login Failed**********");
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(3000);

	}

	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws InterruptedException {
		
		logger.info("******Click on Logout link**********");
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		
		logger.info("******Closing browser**********");
		driver.quit();
	}


	//-------------------------------Customer feature step definitions--------------------------------------------


	@Then("^User can view Dashboard$")
	public void user_can_view_Dashboard()  {

		addCust = new AddcustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());

	}

	/*@When("^User clicks on customers Menu$")
	public void user_clicks_on_customers_Menu() throws InterruptedException  {

		Thread.sleep(3000);
		addCust.clicksOnCustomersMenu();
	}*/

	@When("^User click on customers Menu$")
	public void user_click_on_customers_Menu() throws InterruptedException  {

		Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
	}

	@When("^Click on customers Menu Item$")
	public void click_on_customers_Menu_Item() throws InterruptedException  {

		Thread.sleep(3000);
		addCust.clickOnCustomersMenuItem();

	}

	@When("^Click on Add new button$")
	public void click_on_Add_new_button() throws InterruptedException {

		addCust.clickOnAddnew();
		Thread.sleep(2000);
	}

	@Then("^User can view Add new customer page$")
	public void user_can_view_Add_new_customer_page(){

		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());

	}

	@When("^User enter customer info$")
	public void user_enter_customer_info() throws InterruptedException {
		
		
		logger.info("******Adding new customer**********");
		logger.info("******Providing customer details**********");
		String email = randomSting()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		addCust.setCustomerRoles("Guest");
		Thread.sleep(3000);

		addCust.setManagerOfVendor("Vendor 2");
		addCust.setGender("Male");
		addCust.setFirstName("Dinesh");
		addCust.setLastName("Krishna");
		addCust.setDob("03/05/1990");
		addCust.setCompanyName("Renault");
		addCust.setAdminContent("Testing");
	}

	@When("^Click on Save button$")
	public void click_on_Save_button() throws InterruptedException{
		logger.info("******Saving customer data**********");
		addCust.clickOnSave();
		Thread.sleep(2000);
	}

	@Then("^User can view confirmation message \"([^\"]*)\"$")
	public void user_can_view_confirmation_message(String msg) {

		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));

	}

	//----------------------Steps for searching a customer using Email ID---------------------------------

	@When("^Enter cutomer Email$")
	public void enter_cutomer_Email()  {

		logger.info("******Searching customer by email id**********");
		searchCust = new SearchCustomerPage(driver);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");


	}

	@When("^Click on search button$")
	public void click_on_search_button() throws InterruptedException  {

		searchCust.clickSearch();
		Thread.sleep(3000);
	}

	@Then("^User should found Email in the Search table$")
	public void user_should_found_Email_in_the_Search_table()  {

		boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}

	//--------------------------Steps for searching a customer by using FirstName and LastName-----------------------------


	@When("^Enter customer FirstName$")
	public void enter_customer_FirstName() {

		logger.info("******Searching customer by name**********");
		searchCust = new SearchCustomerPage(driver);
		searchCust.setFirstName("Victoria");

	}

	@When("^Enter customer LastName$")
	public void enter_customer_LastName()  {
		searchCust.setLastName("Terces");
	}

	@Then("^User should found Name in the search table$")
	public void user_should_found_Name_in_the_search_table() {

		boolean status=searchCust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
	}


}
