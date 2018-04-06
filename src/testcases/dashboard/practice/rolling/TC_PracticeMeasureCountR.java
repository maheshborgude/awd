package testcases.dashboard.practice.rolling;

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
 * This test case validate Count of Measure Dashboard >> Practice For Rolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case validate Count of Measure Dashboard >> Practice For Rolling
 * @author rakesh.kulkarni
 * Date 15/03/2016
 */
public class TC_PracticeMeasureCountR extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="PracticeMeasureCountR",groups = "CountGroup")
	public void TC_AllMeasuresTC_PracticeMeasureCountR(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");		
		log.info("\nTC To validate  count of Measure present on Dashboard >> Practice For Rolling");
		exe.testexecute(Filelocation,"TC_PracticeMeasureCountR",data);
		log.info("\nTC To validate count of Measure present on Dashboard >> Practice For Rolling Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PracticeMeasureCountR")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");
			Object[][] object=ex.getDataingrid(Filelocation,"TC_PracticeMeasureCountR_Data");
		Setup.log.info("\n For TC To validate count of Measure present on Dashboard >> Practice For Rolling, DataFile is used from "+Filelocation);
        return object;    
    }
}
