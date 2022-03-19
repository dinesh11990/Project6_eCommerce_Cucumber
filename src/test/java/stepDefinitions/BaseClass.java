package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import com.krish.page_objects.AddcustomerPage;
import com.krish.page_objects.LoginPage;
import com.krish.page_objects.SearchCustomerPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public AddcustomerPage addCust;
	public SearchCustomerPage searchCust;
	
	
	//Created for generating random string for Unique email
	
	public static String randomSting() {
		
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		
		return (generatedString1);
		
	}

}
