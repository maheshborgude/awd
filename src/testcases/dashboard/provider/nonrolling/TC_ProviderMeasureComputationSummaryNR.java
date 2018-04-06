package testcases.dashboard.provider.nonrolling;

import java.io.IOException;
import java.util.Hashtable;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;
/**
 *  Verifies Measure Computation Summary grid for Dashboard>>Provider from UI and Database <p>
 * 
 * @author Sachin.Gawade
 * Created Date: 4 Mar 2016
 */
public class TC_ProviderMeasureComputationSummaryNR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	    String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");
	    
	    @Test(dataProvider="TC_ProviderMeasureComputationSummaryNR")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	

	    	Setup.log.info("TC_ProviderMeasureComputationSummaryNR test case starts");
	    	exe.testexecute(Filelocation,"TC_ProviderMeasureCompSumNR",data);
	    	Setup.log.info("TC_ProviderMeasureComputationSummaryNR test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_ProviderMeasureComputationSummaryNR")

	    public Object[][] getDataForProviderMeasureComputationSummaryView() throws IOException, InvalidFormatException
		{
	       
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderMeasureCompSumNRData");
	        return object;    
	    }
}
