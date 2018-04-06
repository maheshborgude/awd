package testcases.dashboard.practice.nonRolling;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

/**
 * This test case validate Count of Favorites Measure present on Dashboard >> Practice for NonRolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail 
 * This test case to validate Count of the Favorites Measure for data nonRolling.
 * @author rakesh.kulkarni
 * Date 15/03/2016
 */
public class TC_PracticeFavoritesMeasureCountNR extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="PracticeFavoritesMeasureCountNR")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");		
		log.info("\nTC To validate Count of Favorites Measure present on Dashboard > practice for NonRolling");
		exe.testexecute(Filelocation,"TC_PFMeasureCountNR",data);
		log.info(" To validate Count of Favorites Measure present on Dashboard > practice for NonRolling Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PracticeFavoritesMeasureCountNR")
    public Object[][] dataProvider() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");
			Object[][] object=ex.getDataingrid(Filelocation,"TC_PFMeasureCountNR_Data");
		Setup.log.info("\n For TC To validate Count of Favorites and NonRolling Measure present on Dashboard > practice for NonRolling, DataFile is used from :"+Filelocation);
        return object;    
    } 
}
