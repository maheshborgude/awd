package testcases.dashboard.provider.rolling;


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
public class TC_ProviderMeasureComputationSummaryR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_ProviderMeasureComputationSummary")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");

	    	Setup.log.info("TC_ProviderMeasureComputationSummary test case starts");
	    	exe.testexecute(Filelocation,"TC_ProviderMeasureCompSum",data);
	    	Setup.log.info("TC_ProviderMeasureComputationSummarytest case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_ProviderMeasureComputationSummary")

	    public Object[][] getDataForProviderMeasureComputationSummaryView() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderMeasureCompSum_Data");
	        return object;    
	    }
}
