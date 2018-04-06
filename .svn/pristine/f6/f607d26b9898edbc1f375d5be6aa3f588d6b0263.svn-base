package testcases.dashboard.location.rolling;


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
 * This test case validate Count of Measure present on Dashboard >> Location >>Select Location and verify Count of measure For Rolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case validate Count of Measure present on Dashboard >> Location >>Select Location and verify Count of measure For Rolling
 * @author rakesh.kulkarni
 * Date 30/03/2016
 */
public class TC_LocationMeasureCountR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="LocationMeasureCountR")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");

	    	Setup.log.info("TC_ProviderCount test case starts");
	    	exe.testexecute(Filelocation,"TC_LMeasureCountR",data);
	    	Setup.log.info("TC_ProviderCount test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="LocationMeasureCountR")

	    public Object[][] getDataForDashboardProviderCount() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_LMeasureCountR_Data");
	        return object;    
	    }
}
