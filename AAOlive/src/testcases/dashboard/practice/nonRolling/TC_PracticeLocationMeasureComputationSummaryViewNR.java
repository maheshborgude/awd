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
 * This test case validate View of Practice Location Measure Computation Summary View present on Practice >>
 *              Select Measure >> Location Tab >> Select Loacation  For nonRolling<p>
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case validate  View of Practice Location Measure Computation Summary View present on Practice >>
 *              Select Measure >> Location Tab >> Select Loacation  For nonRolling<p>
 * @author rakesh.kulkarni
 * Date 24/03/2016
 */
public class TC_PracticeLocationMeasureComputationSummaryViewNR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="PracticeLocationMeasureComputationSummaryViewNR")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");

	    	Setup.log.info("TC_PracticeLocationMeasureComputationSummaryViewNR test case starts");
	    	exe.testexecute(Filelocation,"TC_PLocationMCSViewNR",data);
	    	Setup.log.info("TC_PracticeLocationMeasureComputationSummaryViewNR case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="PracticeLocationMeasureComputationSummaryViewNR")

	    public Object[][] dataProvider() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_PLocationMCSViewNR_Data");
	        return object;    
	    }
}
