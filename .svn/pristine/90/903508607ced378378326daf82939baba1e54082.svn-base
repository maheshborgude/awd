package testcases.patientoutreach.packagecreation;

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
 * This test case is used to test Patient Outreach>>Package Creation >>Outreach Package Configuration(Outreach Details Tab)(Only UI)
 * 
 * @author Sachin.Gawade
 * Created Date: 21 March 2016
 */
public class TC_SubscriptionDetailsTab extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_SubscriptionDetailsTab")
		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("packagecreation_excel");
	    	Setup.log.info("TC_SubscriptionDetailsTab test case starts");
	    	exe.testexecute(Filelocation,"TC_SubscriptionDetailsTab",data);
	    	Setup.log.info("TC_SubscriptionDetailsTab test case ends");
	    	Setup.testcase.assertAll();
		}	

		@DataProvider(name="TC_SubscriptionDetailsTab")
	    public Object[][] getDataForSubscriptionDetailsTab() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("packagecreation_excel");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_SubscriptionDetailsTab_Data");
	        return object;    
	    }
}



