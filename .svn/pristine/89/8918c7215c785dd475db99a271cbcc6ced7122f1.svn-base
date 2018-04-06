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
public class Dashboard_Provider_Count {
	

	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
    ExcelReader ex= new ExcelReader();
	
	@Test(dataProvider="ProviderCount_DataProvider" , priority=1)
	public void providercount(Hashtable <String,String> data) 
	{
	  try
	  {   
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
		System.out.println("TC Dashboard Provider Count Starts");
		configuration.Setup.log.info("\n TC Dashboard-Provider Count Starts");
		exe.testexecute(Filelocation,"TC_ProviderCount",data);
		System.out.println("TC Dashboard-Provider Count End");
		Setup.log.info("\n TC Dashboard-Provider Count End");
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  Setup.log.fatal(e.toString());
	   }
	       
	 }

	@DataProvider(name="ProviderCount_DataProvider")
    public Object[][] getDataFromDataprovider() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderCountData");
		Setup.log.info("\n For TC Dashboard-Provider Count , Use Data from TC_ProviderCountData sheet of file "+Filelocation);
        return object;    
    } 
}
