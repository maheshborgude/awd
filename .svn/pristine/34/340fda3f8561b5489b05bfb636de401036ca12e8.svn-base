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
 *  Verifies Dashboard>>Location or Dashboard>>Provider grid as it compares the grid from UI and Database <p>
 * 
 * @author Sachin.Gawade
 * Created Date: 4 Mar 2016
 */
public class TC_DashboardProviderViewNR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	    String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");
	    
	    @Test(dataProvider="TC_DashboardProviderViewNR")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	

	    	Setup.log.info("TC_DashboardProviderViewNR test case starts");
	    	exe.testexecute(Filelocation,"TC_DashboardProviderViewNR",data);
	    	Setup.log.info("TC_DashboardProviderViewNR test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_DashboardProviderViewNR")

	    public Object[][] getDataForDashboardProviderView() throws IOException, InvalidFormatException
		{
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_DashboardProviderViewNR_Data");
	        return object;    
	    }
}
