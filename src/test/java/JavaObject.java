
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaObject {
	
    private WebDriver driver;
    
    public JavaObject(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        if (!"What is this?".equals(driver.getTitle())) {
            throw new IllegalStateException("This is a wrong page!");
        }
    }
    
        By masterpassword1 = By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input");
        By sitename1 = By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input");
        By generate1 = By.xpath("html/body/form/table/tbody/tr[3]/td/input");
        By generatedpassword1 = By.xpath("html/body/form/table/tbody/tr[4]/td[2]/input");
        
    public String masterPassword(String masterpassword, String sitename) {

    	String value;
    	driver.findElement(masterpassword1).clear();
    	driver.findElement(masterpassword1).sendKeys(masterpassword);
    	driver.findElement(sitename1).clear();
        driver.findElement(sitename1).sendKeys(sitename);
        driver.findElement(generate1).click();
        value = driver.findElement(generatedpassword1).getAttribute("value");
        
        return value;    
    }

}