package testcases.analytics.sharedanalytics;

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
 * This test case validate View of Shared Analytics > Analytics
 * This test case validate data present on UI with data given in sheet 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail 
 * @author rakesh.kulkarni
 * Date 29/03/2016
 */
public class TC_SharedAnalyticsView extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="MapView")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("sharedanalytics_excel");
		log.info("\nTC To validate View of Shared Analytics ");
		exe.testexecute(Filelocation,"TC_SharedAnalyticsView",data);
		log.info("\nTC To validate View of Shared Analytics Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="MapView")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("sharedanalytics_excel");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_SharedAnalyticsView_Data");
		Setup.log.info("\n TC To validate View of Shared Analytics "+Filelocation);
        return object;    
    } 
}
