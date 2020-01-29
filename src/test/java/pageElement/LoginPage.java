package pageElement;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageObject {
	
	public WebDriverWait wait = new WebDriverWait(driver, 25);

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="tab-flight-tab-hp")
	private WebElement flightTab;
	
	@FindBy(id="flight-type-one-way-label-hp-flight")
	private WebElement flightSingleOption;
	
	@FindBy(id="flight-origin-hp-flight")
	private WebElement fromInput;
	
	@FindBy(id="flight-destination-hp-flight")
	private WebElement destinationInput;
	
	@FindBy(id="flight-departing-single-hp-flight")
	private WebElement departingDate;
	
	@FindBy(xpath="//*[@id=\"gcw-flights-form-hp-flight\"]/div[8]/label/button")
	private WebElement buttonSubmit;
	
	@FindBy(xpath="//*[contains(text(),'Selecciona tu salida a Hermosillo')]")
	private WebElement resultsDisplay;
	
	@FindBy(xpath="//*[contains(@class,\"full-bold no-wrap\")]")
	private List<WebElement> result;
	
	
	public void clickflightTab() {
		wait.until(ExpectedConditions.visibilityOf(this.flightTab));
		this.highlightElement(driver, this.flightTab);
		this.flightTab.click();
		this.disHighlightElement(driver, this.flightTab);
	}
	
	public void clickOptionSingle() {
		wait.until(ExpectedConditions.visibilityOf(this.flightSingleOption));
		this.highlightElement(driver, this.flightSingleOption);
		this.flightSingleOption.click();
		this.disHighlightElement(driver, this.flightSingleOption);
	}
	
	public void enterFrom(String from) {
		this.highlightElement(driver, this.fromInput);
		this.fromInput.clear();
		this.fromInput.sendKeys(from);
		this.disHighlightElement(driver, this.fromInput);
	}
	
	public void enterDestination(String destination) {
		this.highlightElement(driver, this.destinationInput);
		this.destinationInput.clear();
		this.destinationInput.sendKeys(destination);
		//this.disHighlightElement(driver, this.destinationInput);
	}
	
	public void enterDate(String date) {
		this.highlightElement(driver, this.departingDate);
		this.departingDate.clear();
		this.departingDate.sendKeys(date);
		this.departingDate.sendKeys(Keys.ENTER);
		//this.disHighlightElement(driver, this.departingDate);
	}
	
	
	public void clickButtonSearch() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(this.buttonSubmit));
		this.highlightElement(driver, this.buttonSubmit);
		this.buttonSubmit.click();
		this.disHighlightElement(driver, this.buttonSubmit);
	}
	
	public void resultDisplay() {
		wait.until(ExpectedConditions.visibilityOf(this.resultsDisplay));
		this.highlightElement(driver, this.resultsDisplay);
	}
	
	public boolean compareResults() {
		int[] arr = new int[result.size()];
		int index = 0;
		for (WebElement element : result) {
		   String test = element.getText();
		   test = test.substring(4, test.length()).replace(",", "");
		   
		   arr[index] = Integer.parseInt(test);
		   index++;

		}
		
		int[] arrSorted = arr;
		Arrays.sort(arrSorted);  
	
		if (Arrays.equals(arr, arrSorted))
			return true;
		else 
			return false;
	}

}