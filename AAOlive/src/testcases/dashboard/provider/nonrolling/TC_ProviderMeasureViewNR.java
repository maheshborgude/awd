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
 *  Verifies Dashboard>>Location or Dashboard>>Provider count as it compares the grid from UI and Database <p>
 * 
 * @author Sachin.Gawade
 * Created Date: 4 Mar 2016
 */
public class TC_ProviderMeasureViewNR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_ProviderMeasureViewNR")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");

	    	Setup.log.info("TC_SubmissionDetailsViewR test case starts");
	    	exe.testexecute(Filelocation,"TC_ProviderMeasureViewNR",data);
	    	Setup.log.info("TC_SubmissionDetailsViewR test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_ProviderMeasureViewNR")

	    public Object[][] getDataForProviderMeasureView() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderMeasureViewNR_Data");
	        return object;    
	    }
}
