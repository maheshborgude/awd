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
 *  Verifies Dashboard>>Location or Dashboard>>Provider grid as it compares the grid from UI and Database(Non Rolling) <p>
 * 
 * @author Sachin.Gawade
 * Created Date: 4 Mar 2016
 */
public class TC_DashboardProviderPaginationNR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_DashboardProviderPaginationNR")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");

	    	Setup.log.info("TC_DashboardProviderPaginationNR test case starts");
	    	exe.testexecute(Filelocation,"TC_DashboardProviderPagNR",data);
	    	Setup.log.info("TC_DashboardProviderPaginationNR test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_DashboardProviderPaginationNR")

	    public Object[][] getDataForDashboardProviderPagination() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_DashboardProviderPagNR_Data");
	        return object;    
	    }
}
