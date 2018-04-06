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
public class Dashboard_Provider_MeasureIdName extends Setup {

	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
    ExcelReader ex= new ExcelReader();
    
    @Test(dataProvider="ProviderMeasureIdName_DataProvider", priority=3)
	public void ProviderMeasureIdName(Hashtable <String,String> data) 
	{
	  try
	  {   
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
		System.out.println("TC Check Dashboard-Provider Measure id and Name Starts");
		configuration.Setup.log.info("\n TC Check Dashboard-Provider Measure id and Name Starts");
		exe.testexecute(Filelocation,"TC_ProviderMeasureIdName",data);
		System.out.println("TC Check Dashboard-Provider Measure id and Name Ends");
		Setup.log.info("\n TC Check Dashboard-Provider Measure id and Name Ends");
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  Setup.log.fatal(e.toString());
	   }
	       
	}

	@DataProvider(name="ProviderMeasureIdName_DataProvider")
    public Object[][] getDataFromDataprovider2() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderMeasureIdNameData");
		Setup.log.info("\n For TC Check Dashboard-Provider Measure id and Name , Use Data from TC_ProviderMeasureIdNameData sheet of file "+Filelocation);
        return object;    
    }
}
