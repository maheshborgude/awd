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
 * This test case validate View of Practice Provider Measure Computation Summary View present on Practice >>
 *              Select Measure >> Provider Tab >> Select Provider  For Rolling<p>
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case to validate View of Practice Provider Measure Computation Summary View present on Practice >>
 *              Select Measure >> Provider Tab >> Select Provider  For Rolling<p>
 * @author rakesh.kulkarni
 * Date 24/03/2016
 */
public class TC_PracticeProvidersMeasureComputationSummaryViewR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="PracticeProvidersMeasureComputationSummaryViewR")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");

	    	Setup.log.info("TC_PracticeProvidersMeasureComputationSummaryViewR test case starts");
	    	exe.testexecute(Filelocation,"TC_PProvidersMCSViewR",data);
	    	Setup.log.info("TC_PracticeProvidersMeasureComputationSummaryViewR case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="PracticeProvidersMeasureComputationSummaryViewR")

	    public Object[][] dataProvider() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_PProvidersMCSViewR_Data");
	        return object;    
	    }
}
