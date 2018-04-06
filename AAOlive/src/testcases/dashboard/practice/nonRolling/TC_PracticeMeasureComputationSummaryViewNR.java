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
 * This test case validate View of Measure Computation Summary present on Dashboard >> Practice For nonRolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case validate View of Measure Computation Summary present on Dashboard >> Practice For nonRolling
 * @author Rakesh.kulkarni
 * Created Date: 17/03/2016
 */
public class TC_PracticeMeasureComputationSummaryViewNR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="PracticeMeasureComputationSummaryNR")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");

	    	Setup.log.info("TC_PracticeMeasureComputationSummaryViewNR test case starts starts");
	    	exe.testexecute(Filelocation,"TC_PMCSummaryViewNR",data);
	    	Setup.log.info("TC_PracticeMeasureComputationSummaryViewNR  test case starts ends");
	    	Setup.testcase.assertAll();
		}
		@DataProvider(name="PracticeMeasureComputationSummaryNR")

	    public Object[][] getDataForPracticeMeasureComputationSummaryViewNR() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_PMCSummaryViewNR_Data");
	        return object;    
	    }
}
