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

public class Dashboard_Provider_FavortieMeasure extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe=new TestExecutor();
    ExcelReader ex= new ExcelReader();
    
	@Test(dataProvider="ProviderFavortieMeasure_DataProvider", priority=6)
	public void TC_checkProviderFavoriteMeasure(Hashtable <String,String> data) 
	{
	  try
	  {   
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
		System.out.println("TC Check Dashboard-Provider Favorite Measure Starts");
		configuration.Setup.log.info("\nTC Check Dashboard-Provider Favorite Measure Starts");
		exe.testexecute(Filelocation,"TC_ProivderFavoriteMeasure",data);
		System.out.println("TC Check Dashboard-Provider Favorite Measure Ends");
		Setup.log.info("\nTC Check Dashboard-Provider Favorite Measure Ends");
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  Setup.log.fatal(e.toString());
	  }
	       
	}

	@DataProvider(name="ProviderFavortieMeasure_DataProvider")
    public Object[][] getDataFromDataprovider5() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dash_provider_excel");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderFavoriteMeasureData");
		Setup.log.info("\n For TC Check Dashboard-Provider Favorite Measure, Use Data from TC_FavoriteMeasureData sheet of file "+Filelocation);
        return object;    
    } 
}
