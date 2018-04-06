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
 * This test case validate View of AllProvider Measure Computation Summary View present Patient Drill Down present
 *          on Dashboard >> Practice >> All tab - Providers For nonRolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case to  validate View of AllProvider Measure Computation Summary View present Patient Drill Down present
 *          on Dashboard >> Practice >> All tab - Providers For nonRolling
 * @author rakesh.kulkarni
 * Date 25/03/2016
 */
public class TC_PracticeAllProvidersMeasureComputationSummaryViewNR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="PracticeAllProvidersMeasureComputationSummaryViewNR")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");

	    	Setup.log.info("TC_PracticeAllProvidersMeasureComputationSummaryViewNR test case starts");
	    	exe.testexecute(Filelocation,"TC_PAllProvidersMCSViewNR",data);
	    	Setup.log.info("TC_PracticeAllProvidersMeasureComputationSummaryViewNR case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="PracticeAllProvidersMeasureComputationSummaryViewNR")

	    public Object[][] dataProvider() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_PAllProvidersMCSViewNR_Data");
	        return object;    
	    }
}
