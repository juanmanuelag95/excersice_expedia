package stepDefinitions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageElement.LoginPage;


public class test {
    public static WebDriver driver = new ChromeDriver();
    public static LoginPage loginPage = new LoginPage(driver);
    
    
    @After("@TestEscenario2")
    public void afterStart() throws Throwable {
    	driver.close();
    }   
    
    @Given("^User is on page$")
    public void user_is_on_page() throws Throwable {
    	driver.get("https://www.expedia.mx/");
    }

    @Then("^flight section Selected$")
    public void flight_section_Selected() throws Throwable {
    	loginPage.clickflightTab();
    	loginPage.clickOptionSingle();
    }

    @Then("^Search flight \"([^\"]*)\" - \"([^\"]*)\" on (\\d+)/(\\d+)/(\\d+)$")
    public void search_flight_on(String arg1, String arg2, int arg3, int arg4, int arg5) throws Throwable {

    	String date = Integer.toString(arg3) + "/0" + Integer.toString(arg4) + "/" + Integer.toString(arg5) ;
    	loginPage.enterFrom(arg1);
    	loginPage.enterDestination(arg2);
    	loginPage.enterDate(date);
    	//loginPage.clickButtonSearch(); not needed
    }

    @Then("^Verify results$")
    public void verify_results() throws Throwable {
    	loginPage.resultDisplay();
    }

    @Then("^Result values order$")
    public void result_values_order() throws Throwable {
    	System.out.println(loginPage.compareResults());
    }

}