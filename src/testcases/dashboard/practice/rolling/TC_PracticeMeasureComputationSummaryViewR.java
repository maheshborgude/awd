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
 *  Verifies Measure Computation Summary grid for Dashboard>>Provider from UI and Database <p>
 *
 * @author Rakesh.kulkarni
 * Created Date: 17/03/2016
 */
public class TC_PracticeMeasureComputationSummaryViewR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="PracticeMeasureComputationSummaryR")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");

	    	Setup.log.info("TC_ProviderMeasureComputationSummary test case starts");
	    	exe.testexecute(Filelocation,"TC_PMCSummaryViewR",data);
	    	Setup.log.info("TC_ProviderMeasureComputationSummarytest  case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="PracticeMeasureComputationSummaryR")

	    public Object[][] getDataForPracticeMeasureComputationSummaryView() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_PMCSummaryViewR_Data");
	        return object;    
	    }
}
