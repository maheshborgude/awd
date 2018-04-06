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
 *  Verifies Patient Drill Down in Dashboard>>Provider grid as it compares the grid from UI and Database(Non Rolling) <p>
 * @author Sachin.Gawade
 * Created Date: 9 Mar 2016
 */
public class TC_ProviderPatientDrillDownNR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_ProviderPatientDrillDownNR")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");

	    	Setup.log.info("TC_ProviderPatientDrillDownNR test case starts");
	    	exe.testexecute(Filelocation,"TC_ProviderPatientDDNR",data);
	    	Setup.log.info("TC_ProviderPatientDrillDownNR test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_ProviderPatientDrillDownNR")

	    public Object[][] getDataForProviderPatientDrillDown() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderPatientDDNR_Data");
	        return object;    
	    }
}
