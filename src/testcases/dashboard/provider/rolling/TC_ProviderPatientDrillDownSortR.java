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
 *  Verifies Sorting for Patient Drill Down in Dashboard>>Provider grid from UI and Database <p>
 * @author Sachin.Gawade
 * Created Date: 3 Mar 2016
 */
public class TC_ProviderPatientDrillDownSortR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	public String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");
	    @Test(dataProvider="TC_ProviderPatientDrillDownSort")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{
	    	Setup.log.info("TC_ProviderPatientDrillDownSort test case starts");
	    	exe.testexecute(Filelocation,"TC_ProviderPatientDDSort",data);
	    	Setup.log.info("TC_ProviderPatientDrillDownSort test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_ProviderPatientDrillDownSort")

	    public Object[][] getDataForProviderPatientDrillDownSort() throws IOException, InvalidFormatException
		{
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderPatientDDSort_Data");
	        return object;    
	    }
}

