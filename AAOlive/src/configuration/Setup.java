package configuration;

//import java.io.File;
import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import buisness.Listeners.RTAppender;
import buisness.managers.ConfigurationManager;

public class Setup {


    //Declared as public static to use same webdriver instance publicly
    public static WebDriver driver ;
    public static SoftAssert testcase;
    public static Logger log =Logger.getLogger("rootLogger");
    ConfigurationManager rd=new ConfigurationManager();
  //  SplashScreen screen = SplashScreen.getSplashScree();
    
    //@BeforeSuite annotation describes this method has to run before all suites
   
    @BeforeSuite
    public void setup() throws Exception 
    { 
    	 
    	 System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");	
    	 String browser=rd.read_Configfile("browser");
         if(browser.equalsIgnoreCase("firefox"))
         {    
     		driver = new FirefoxDriver();
         }
         else if(browser.equalsIgnoreCase("iexplorer"))
         {
          
       // Update the driver path with your location
          System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
          driver = new InternetExplorerDriver();
         }
         else if(browser.equalsIgnoreCase("chrome"))
         {
       // Update the driver path with your location
          System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
          driver = new ChromeDriver();
          Setup.log.info("Google Chrome is launched.");
         }
         else if(browser.equalsIgnoreCase("HTMLUnit"))
         {
        	 driver = new HtmlUnitDriver( BrowserVersion.FIREFOX_38);
         }
         else if(browser.equalsIgnoreCase("PhantomJS"))
         {
        	 Capabilities caps = new DesiredCapabilities();
             ((DesiredCapabilities) caps).setJavascriptEnabled(true);                
             ((DesiredCapabilities) caps).setCapability("takesScreenshot", true);  
             ((DesiredCapabilities) caps).setCapability(
                     PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                     System.getProperty("user.dir")+"\\Drivers\\phantomjs.exe"
                 );
             try{
            	 driver = new  PhantomJSDriver(caps);
             }
             catch(Error e)
             {
            	 e.printStackTrace();
             }
             catch(Exception e)
             {
            	 e.printStackTrace();
             }
         }
 		
        Setup.log.info("Browser Started");
     //  Setup.log.addAppender(new RTAppender());
     //   screen.stop();
        driver.manage().window().maximize();        
        driver.get(rd.read_Configfile("url")); 
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    } 
    
    @AfterSuite
    public void trans_report()
    {
    	try{
    	java.util.Date date= new java.util.Date();
		 Timestamp t = new Timestamp(date.getTime());
		 String dateNow = t.toString().replace(":","_");
            /**
             * Rakesh Kulkarni
             * Code is updated to move report to 192.168.105.22 Server
             */
		 
          ///  String path="\\\\192.168.105.22\\Testing\\Testing\\Automation\\AAO Demo Smoke Test\\Old Report\\";
		   String path="\\\\drive\\Shared\\Testing\\Testing\\Automation\\Test\\AAO";
            File SrcFile=new File(System.getProperty("user.dir")+"\\test-output\\TestAutomationReports\\");
            Thread.sleep(2000);
            FileUtils.copyDirectory(SrcFile,new File(SrcFile+"AAO_"+dateNow+"_Report"));
            log.info("Reports copied to path" + SrcFile);
        } 
 
    	catch(Exception e)
    	{
    		log.fatal(e);
    	}
    	finally
    	{
    		driver.quit();
    		log.info("Browser closed");
    	}
    	
    }

}
