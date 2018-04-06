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
public class Dashboard_Provider_MeasureSpecific extends Setup {
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
    ExcelReader ex= new ExcelReader();
    
	 @Test(dataProvider="ProviderMeasureSpecific_DataProvider", priority=7)
		public void TC_checkProviderMeasureSpecific(Hashtable <String,String> data) 
		{
		  try
		  {   
			String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
			System.out.println("TC Check Dashboard-Provider Mesure Specific Data Starts");
			configuration.Setup.log.info("\nTC Check Dashboard-Provider Mesure Specific Data Starts");
			exe.testexecute(Filelocation,"TC_ProviderMeasureSpecific",data);
			System.out.println("TC Check Dashboard-Provider Mesure Specific Data  Ends");
			Setup.log.info("\nTC Check Dashboard-Provider Mesure Specific Data  Ends");
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
			  Setup.log.fatal(e.toString());
		  }
		       
		}

		@DataProvider(name="ProviderMeasureSpecific_DataProvider")
	    public Object[][] getDataFromDataprovider6() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderMeasureSpecificData");
			Setup.log.info("\n For TC Check Dashboard-Provider Mesure Specific Data ,DataFile is used from "+Filelocation);
	        return object;    
	    } 
}
