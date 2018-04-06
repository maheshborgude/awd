package testcases.dashboard.provider;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class Dashboard_Provider_CheckMeasureduration {
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
    ExcelReader ex= new ExcelReader();
    
    
	@Test(dataProvider="TC_CheckMeasureDurationD", priority=19)
	public void TC_CheckMeasureDuration(Hashtable <String,String> data) 
	{
	  try
	  {   
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
		System.out.println("TC CheckMeasureDuration Starts");
		configuration.Setup.log.info("\nTC  TC_CheckMeasureDuration Starts");
		exe.testexecute(Filelocation,"TC_CheckMeasureDuration",data);
		System.out.println("TC Check Dashboard-Provider TC_CheckMeasureDuration Ends");
		Setup.log.info("\nTC Check Dashboard-Provider TC_CheckMeasureDuration Ends");
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  Setup.log.fatal(e.toString());
	  }
	       
	}

	@DataProvider(name="TC_CheckMeasureDurationD")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_CheckMeasureDurationD");
		Setup.log.info("\n For TC Check Dashboard-Provider TC_CheckMeasureDurationD, DataFile is used from "+Filelocation);
        return object;    
    } 

}
