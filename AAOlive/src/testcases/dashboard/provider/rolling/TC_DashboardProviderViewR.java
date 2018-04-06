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
 *  Verifies Dashboard>>Location or Dashboard>>Provider grid as it compares the grid from UI and Database <p>
 * 
 * @author Sachin.Gawade
 * Created Date: 1 Mar 2016
 */
public class TC_DashboardProviderViewR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_DashboardProviderView")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");

	    	Setup.log.info("TC_DashboardProviderView test case starts");
	    	exe.testexecute(Filelocation,"TC_DashboardProviderView",data);
	    	Setup.log.info("TC_DashboardProviderView test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_DashboardProviderView")

	    public Object[][] getDataForDashboardProviderView() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_DashboardProviderView_Data");
	        return object;    
	    }
}
