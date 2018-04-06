package testcases.dashboard.provider;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

/**
 * 
 * @author Nikita Desai
 *
 */
@Listeners({ buisness.Listeners.Screenshot.class })
public class Dashboard_Provider_ScoreColor extends Setup {
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
    ExcelReader ex= new ExcelReader();
    
	@Test(dataProvider="ProviderScoreColor_DataProvider", priority=10)
	public void TC_ProviderScoreColor(Hashtable <String,String> data) 
	{
	  try
	  {   
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
		System.out.println("TC Check Dashboard-Provider Score-Color Starts");
		configuration.Setup.log.info("\nTC Check Dashboard-Provider Score-Color Starts");
		exe.testexecute(Filelocation,"TC_ProviderScoreColor",data);
		System.out.println("TC Check Dashboard-Provider Score-Color Ends");
		Setup.log.info("\nTC Check Dashboard-Provider Score-Color Ends");
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  Setup.log.fatal(e.toString());
	 }
	       
	}

	@DataProvider(name="ProviderScoreColor_DataProvider")
    public Object[][] getDataFromDataprovider9() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderScorecolorData");
		Setup.log.info("\n For TC Check Dashboard-Provider Score-Color ,DataFile is used from "+Filelocation);
        return object;    
    }
}
