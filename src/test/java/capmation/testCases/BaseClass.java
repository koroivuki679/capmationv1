package capmation.testCases;


import com.github.javafaker.Faker;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import capmation.utilities.ReadConfig;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;



public class BaseClass {
	
	//object for readconfig class
	ReadConfig readConfig = new ReadConfig();
	
	public static WebDriver driver;
	public static Logger logger;
	
	public String baseURL=readConfig.getURL();
	public String searchTerm=readConfig.getSearchTerm();
	public String name=readConfig.getName();
	public String email =readConfig.getEmail();
	public String phoneNum =readConfig.getPhoneNumber();
	public String geckodriverPath =readConfig.getFirefoxPath();
	public String chromedriverPath =readConfig.getChromePath();
	public String msedgedriverPath = readConfig.getMsEdgePath();
	public String operadriverPath= readConfig.getOperaPath();

	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String brwsr)
	{
		
		logger =Logger.getLogger("capmation");
		PropertyConfigurator.configure("./test-classes/log4j.properties");
		
		if (brwsr.equals("chrome"))
				{
					System.setProperty("webdriver.chrome.driver",chromedriverPath);
					driver=new ChromeDriver();
				}
		
		else if(brwsr.equals("firefox"))
				{
					System.setProperty("webdriver.gecko.driver",geckodriverPath);
					driver=new FirefoxDriver();
				}
				
		else if(brwsr.equals("microsoft_edge"))
				{
					System.setProperty("webdriver.edge.driver",msedgedriverPath);
					driver=new EdgeDriver();
				}
		
		else if(brwsr.equals("opera"))
				{
					System.setProperty("webdriver.opera.driver",operadriverPath);
					driver=new OperaDriver();
				}
		
//		else if(brwsr.equals("safari"))
//				{
//					System.setProperty("webdriver.opera.driver",safaridriverPath);
//					driver=new SafariDriver();
//				}

		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/test-classes/Screenshots" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}
