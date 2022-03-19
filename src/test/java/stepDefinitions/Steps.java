package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.krish.page_objects.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps extends BaseClass {

	public WebDriver driver;
	public LoginPage lp;



	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {

		System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver.exe");

		driver=new ChromeDriver();

		lp=new LoginPage(driver);
	}

	@When("^User Opens URL \"(.*?)\"$")
	public void user_Opens_URL(String url) {

		driver.get(url);
		driver.manage().window().maximize();
	}

	////Given("^\"(.*?)\" is elder to \"(.*?)\" and \"(.*?)\"$")
	@When("^User enters Email as \"(.*?)\" and Password as \"(.*?)\"$")
	public void user_enters_Email_as_and_Password_as(String email, String password) {


		lp.setUserName(email);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {

		lp.clickLogin();
		Thread.sleep(3000);
	}

	@Then("Page Title should be \"(.*?)\"$")
	public void page_Title_should_be(String title) throws InterruptedException {

		if(driver.getPageSource().contains("Login was unsuccessful.")) {

			driver.close();
			Assert.assertTrue(false);

		}else {

			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(3000);

	}

	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws InterruptedException {

		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {

		driver.quit();
	}

	
//-------------------------------Customer feature step definitions--------------------------------------------

	
	@Then("^User can view Dashboard$")
	public void user_can_view_Dashboard()  {
		
		addCust = new AddcustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
		
	}

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

		addCust.clickOnSave();
		Thread.sleep(2000);
	}

	@Then("^User can view confirmation message \"([^\"]*)\"$")
	public void user_can_view_confirmation_message(String msg) {
		
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));

	}



}
