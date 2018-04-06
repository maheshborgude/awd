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
public class Dashboard_Provider_MeasurePatientDrill extends Setup {
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
    ExcelReader ex= new ExcelReader();
    
	 @Test(dataProvider="ProviderMeasurePatientDrill_DataProvider", priority=8)
		public void TC_checkProviderMeasurePatientDrill(Hashtable <String,String> data) 
		{
		  try
		  {   
			String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
			System.out.println("TC Check Dashboard-Provider Mesure Patient-Drill-Data Starts");
			configuration.Setup.log.info("\n TC Check Dashboard-Provider Mesure Patient-Drill-Data Starts");
			exe.testexecute(Filelocation,"TC_ProviderMeasurePatientDrill",data);
			System.out.println("TC Check Dashboard-Provider Mesure Patient-Drill-Data Ends");
			Setup.log.info("\nTC Check Dashboard-Provider Mesure Patient-Drill-Data Ends");
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
			  Setup.log.fatal(e.toString());
		  }
		       
		}

		@DataProvider(name="ProviderMeasurePatientDrill_DataProvider")
	    public Object[][] getDataFromDataprovider7() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderMeasurePatientDrillD");
			Setup.log.info("\n For TC Check Dashboard-Provider Mesure Patient-Drill-Data, DataFile is used from "+Filelocation);
	        return object;    
	    } 
}
