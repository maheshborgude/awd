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
public class Dashboard_Provider_SelectFavoriteMeasure extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
    ExcelReader ex= new ExcelReader();

    @Test(dataProvider="TC_SelectFavoriteMeasure_DataProvider", priority=11)
	public void TC_SelectFavoriteMeasure(Hashtable <String,String> data) 
	{
	  try
	  {   
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
		System.out.println("TC Dashboard-Provider Select Favorite Measure Starts");
		configuration.Setup.log.info("\nTC Dashboard-Provider Select Favorite Measure Starts");
		exe.testexecute(Filelocation,"TC_SelectFavoriteMeasure",data);
		System.out.println("TC Dashboard-Provider Select Favorite Measure Ends");
		Setup.log.info("\nTC Dashboard-Provider Select Favorite Measure Ends");
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  Setup.log.fatal(e.toString());
   	 }
	       
	}

	@DataProvider(name="TC_SelectFavoriteMeasure_DataProvider")
    public Object[][] getDataFromDataprovider10() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_SelectFavoriteMeasureData");
		Setup.log.info("\n For TC Dashboard-Provider Select Favorite Measure , DataFile is used from "+Filelocation);
        return object;    
    } 
}
