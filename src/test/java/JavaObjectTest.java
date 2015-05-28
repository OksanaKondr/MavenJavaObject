
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;
//import JavaObject;

public class JavaObjectTest {

	WebDriver driver;
	JavaObject page = new JavaObject(driver);
	
	@BeforeClass
	public void startup()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\automation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://angel.net/~nic/passwd.current.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void javaObjectTest1() throws InterruptedException
	{
		Assert.assertEquals((!page.masterPassword("Az7~!@#$%^&*()_+-=;:/?.>,<|[{]}\"\'`\\", "www.javatpoint.com").equals("")), true);
		Thread.sleep(1000);
	}		
	
	@Test
	public void javaObjectTest2() throws InterruptedException
	{	
		Assert.assertEquals((page.masterPassword("Az7~!@#$%^&*()_+-=;:/?.>,<|[{]}\"\'`\\", "www.javatpoint.com")), 
				             page.masterPassword("Az7~!@#$%^&*()_+-=;:/?.>,<|[{]}\"\'`\\", "www.javatpoint.com"));
		Thread.sleep(1000);
		
		Assert.assertEquals((page.masterPassword("Az7~!@#$%^&*()_+-=;:/?.>,<|[{]}\"\'`\\", "www.javatpoint.com")), 
				             page.masterPassword("anothermasterpassword", "www.javatpoint.com"));
		Thread.sleep(1000);
		
		Assert.assertEquals((page.masterPassword("Az7~!@#$%^&*()_+-=;:/?.>,<|[{]}\"\'`\\", "www.javatpoint.com")), 
				             page.masterPassword("Az7~!@#$%^&*()_+-=;:/?.>,<|[{]}\"\'`\\", "livejournal.com"));
		Thread.sleep(1000);
	}	
	
	@Test
	public void javaObjectTest3() throws InterruptedException
	{		
		Assert.assertEquals((page.masterPassword("Az7~!@#$%^&*()_+-=;:/?.>,<|[{]}\"\'`\\", "www.javatpoint.com").length()-3), 
	                         page.masterPassword("Az7~!@#$%^&*()_+-=;:/?.>,<|[{]}\"\'`\\", "www.javatpoint.com").length(), "@1a");
	}		

	@AfterClass
	public void teardown()
	{
		driver.quit();		
	}

}
