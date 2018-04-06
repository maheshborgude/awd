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
 *  Verifies Count for Patient Drill Down in Dashboard>>Provider grid from UI and Database <p>
 * @author Sachin.Gawade
 * Created Date: 3 Mar 2016
 */
public class TC_ProviderPatientDrillDownCountR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_ProviderPatientDrillDownCount")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");

	    	Setup.log.info("TC_ProviderPatientDrillDownCount test case starts");
	    	exe.testexecute(Filelocation,"TC_ProviderPatientDDCount",data);
	    	Setup.log.info("TC_ProviderPatientDrillDownCount test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_ProviderPatientDrillDownCount")

	    public Object[][] getDataForProviderPatientDrillDownCount() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("DashboardProvider");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderPatientDDCount_Data");
	        return object;    
	    }
}

