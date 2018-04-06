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
public class Dashboard_Provider_FavoriteSection extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
    ExcelReader ex= new ExcelReader();
    
	@Test(dataProvider="TC_Favorite_DataProvider", priority=12)
	public void TC_Favorite(Hashtable <String,String> data) 
	{
	  try
	  {   
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
		System.out.println("TC Check Dashboard-Provider Favorite Section Starts");
		configuration.Setup.log.info("\nTC Check Dashboard-Provider Favorite Section starts");
		exe.testexecute(Filelocation,"TC_Favorite",data);
		System.out.println("TC Check Dashboard-Provider Favorite Section Ends");
		Setup.log.info("\nTC Check Dashboard-Provider Favorite Section Ends");
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  Setup.log.fatal(e.toString());
	  }
	       
	}

	@DataProvider(name="TC_Favorite_DataProvider")
    public Object[][] getDataFromDataprovider11() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_FavoriteData");
		Setup.log.info("\n For TC Check Dashboard-Provider Favorite Section , DataFile is used from "+Filelocation);
        return object;    
    }
}
