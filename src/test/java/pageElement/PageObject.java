package pageElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    // CommonSteps
    public void highlightElement(WebDriver driver, WebElement elem) {
    	if (driver instanceof JavascriptExecutor)
    		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);		
    }
    
    public void disHighlightElement(WebDriver driver, WebElement elem) {
    	if (driver instanceof JavascriptExecutor)
    		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px solid red'", elem);		
    }
}