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
 *  Verifies Pagination for Patient Drill Down in Dashboard>>Provider grid from UI and Database(Non Rolling) <p>
 * @author Sachin.Gawade
 * Created Date: 9 Mar 2016
 */
public class TC_ProviderPatientDrillDownPaginationNR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	    String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");
	    @Test(dataProvider="TC_ProviderPatientDrillDownPaginationNR")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	

	    	Setup.log.info("TC_ProviderPatientDrillDownPaginationNR test case starts");
	    	exe.testexecute(Filelocation,"TC_ProviderPatientDDPagiNR",data);
	    	Setup.log.info("TC_ProviderPatientDrillDownPaginationNR test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_ProviderPatientDrillDownPaginationNR")

	    public Object[][] getDataForProviderPatientDrillDownPagination() throws IOException, InvalidFormatException
		{
	      
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderPatientDDPagiNR_Data");
	        return object;    
	    }
}

