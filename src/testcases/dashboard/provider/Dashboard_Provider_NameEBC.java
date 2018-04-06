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
public class Dashboard_Provider_NameEBC extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
    ExcelReader ex= new ExcelReader();
    
	@Test(dataProvider="ProviderNameEBC_DataProvider", priority=2)
	public void providerNameEBC(Hashtable <String,String> data) 
	{
	  try
	  {   
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
		System.out.println("TC Check Dashboard-Provider Name Exceed and Below Count Starts");
		configuration.Setup.log.info("\n  Starts");
		exe.testexecute(Filelocation,"TC_ProviderNameEBC",data);
		System.out.println("TC Check Dashboard-Provider Name Exceed and Below Count Ends");
		Setup.log.info("\nTC Check Dashboard-Provider Name Exceed and Below Count Ends");
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  Setup.log.fatal(e.toString());
	   }
	       
	}

	@DataProvider(name="ProviderNameEBC_DataProvider")
    public Object[][] getDataFromDataprovider1() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderNameEBCData");
		Setup.log.info("\n For TC Check Dashboard-Provider Name Exceed and Below Count, Use Data from TC_ProviderNameEBCData sheet of file "+Filelocation);
        return object;    
    } 
}
