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

public class Dashboard_Provider_Quarterlist {
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
    ExcelReader ex= new ExcelReader();
    
	@Test(dataProvider="TC_Quaterlist_DataProvider", priority=17)
	public void TC_Quaterlist(Hashtable <String,String> data) 
	{
	  try
	  {   
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
		System.out.println("TC Check Dashboard-Provider QuarterlistData Starts");
		configuration.Setup.log.info("\nTC Check Dashboard-Provider QuarterlistData Starts");
		exe.testexecute(Filelocation,"TC_Quaterlist",data);
		System.out.println("TC Check Dashboard-Provider QuarterlistData Ends");
		Setup.log.info("\nTC Check Dashboard-Provider QuarterlistData Ends");
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  Setup.log.fatal(e.toString());
	  }
	       
	}

	@DataProvider(name="TC_Quaterlist_DataProvider")
    public Object[][] getDataFromDataprovider9() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_QuarterlistData");
		Setup.log.info("\n For TC Check Dashboard-Provider QuarterlistData, DataFile is used from "+Filelocation);
        return object;    
    }
}
