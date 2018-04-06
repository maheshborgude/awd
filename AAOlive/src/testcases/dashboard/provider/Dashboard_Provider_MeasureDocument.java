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

public class Dashboard_Provider_MeasureDocument {
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
    ExcelReader ex= new ExcelReader();
    
	@Test(dataProvider="ProviderMeasureDocumnet_DataProvider", priority=16)
	public void TC_ProviderMeasureDocument(Hashtable <String,String> data) 
	{
	  try
	  {   
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
		System.out.println("TC Check Dashboard-Provider Measure Document Starts");
		configuration.Setup.log.info("\n TC Check Dashboard-Provider Measure Document Starts");
		exe.testexecute(Filelocation,"TC_ProviderMeasureDocument",data);
		System.out.println("TC Check Dashboard-Provider Measure Document Ends");
		Setup.log.info("\nTC Check Dashboard-Provider Measure Document Ends");
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  Setup.log.fatal(e.toString());
	 }
	       
	}

	@DataProvider(name="ProviderMeasureDocumnet_DataProvider")
    public Object[][] getDataFromDataprovider8() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderMeasureDocumentD");
		Setup.log.info("\n For TC Check Dashboard-Provider Measure Document , DataFile is used from "+Filelocation);
        return object;    
    } 
	
}
