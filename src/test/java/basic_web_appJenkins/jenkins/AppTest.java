package basic_web_appJenkins.jenkins;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}
	/**
	 * Rigourous Test :-)
	 * 
	 * @throws URISyntaxException
	 */
	public void testAppDOHPass() throws URISyntaxException {
		URI serverURL = null;

		serverURL = new URI("http://www.health.gov.au/");
		
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	      
        	ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox");
		

		// Open a Chrome browser.
		WebDriver driver = new ChromeDriver(chromeOptions);

		// Initialize the eyes SDK and set your private API key.
		
		try {
			
			driver.get(serverURL.toString());
			// Click the "Click me!" button.
			String text1=driver.findElement(By.className("flag")).getText();
			System.out.println("this is the value"+text1);
			
			TimeUnit.SECONDS.sleep(3);
			assertEquals("The Department of Health",text1);
			TimeUnit.SECONDS.sleep(11);
		
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser.
			driver.quit();

		}

	}
	/**
	 * Rigourous Test :-)
	 * 
	 * @throws URISyntaxException
	 */
	public void testAppDOHFail() throws URISyntaxException {
		URI serverURL = null;

		serverURL = new URI("http://www.health.gov.au/internet/ministers/publishing.nsf/Content/Profile-BM-1");
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	      
        	ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox");

		

		// Open a Chrome browser.
		WebDriver driver = new ChromeDriver(chromeOptions);

		// Initialize the eyes SDK and set your private API key.
		
		try {
			
			driver.get(serverURL.toString());
			// Click the "Click me!" button.
			String text=driver.findElement(By.id("skip-to-content")).getText();
			String text1=driver.findElement(By.className("flag")).getText();
		
			
			TimeUnit.SECONDS.sleep(3);
			// Visual checkpoint #2.
			
			// End of test.
			TimeUnit.SECONDS.sleep(1);
		
			assertEquals("The Department of Health",text1);
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser.
			driver.quit();

		}	
	}
	/**
	 * Rigourous Test :-)
	 * 
	 * @throws URISyntaxException
	 */
	public void testAppDOHSearchPass() throws URISyntaxException {
		URI serverURL = null;

		serverURL = new URI("http://www.health.gov.au/");

		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	      
        	ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox");
		

		// Open a Chrome browser.
		WebDriver driver = new ChromeDriver(chromeOptions);

		
		
		try {
			
			driver.get(serverURL.toString());
			driver.findElement(By.id("search").id("searchinput")).sendKeys("Department of Health | 2012 Private Health Insurance (PHI) Circulars");
			driver.findElement(By.id("search").id("searchinput")).submit();
			
			String text=driver.findElement(By.id("search-result-count").id("search-total-matching")).getText();
			
			
			assertEquals("119",text);
			
			TimeUnit.SECONDS.sleep(3);
			// Visual checkpoint #2.
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser.
			driver.quit();

		}
	}
	
	/**
	 * Rigourous Test :-)
	 * 
	 * @throws URISyntaxException
	 */
	public void testAppDOHSearchFail() throws URISyntaxException {
		URI serverURL = null;

		serverURL = new URI("http://www.health.gov.au/");

		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	      
        	ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox");
		

		// Open a Chrome browser.
		WebDriver driver = new ChromeDriver(chromeOptions);

		
		
		try {
			
			driver.get(serverURL.toString());
			driver.findElement(By.id("search").id("searchinput")).sendKeys("Department of Health Health Insurance (PHI) Circulars");
			driver.findElement(By.id("search").id("searchinput")).submit();
			
			String text=driver.findElement(By.id("search-result-count").id("search-total-matching")).getText();
			
			
			assertEquals("119",text);
			TimeUnit.SECONDS.sleep(3);
			// Visual checkpoint #2.
			
		
			TimeUnit.SECONDS.sleep(11);
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser.
			driver.quit();

		}
	}

}
