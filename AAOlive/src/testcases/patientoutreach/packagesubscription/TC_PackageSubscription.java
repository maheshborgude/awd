package testcases.patientoutreach.packagesubscription;


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
 * This test case is used to test Patient Outreach>>Package Subscription>>Package Subscription Grid(Only UI)
 * 
 * @author Sachin.Gawade
 * Created Date: 21 March 2016
 */
public class TC_PackageSubscription extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_PackageSubscription")
		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("packagesubscription_excel");
	    	Setup.log.info("TC_PackageSubscription test case starts");
	    	exe.testexecute(Filelocation,"TC_PackageSubscription",data);
	    	Setup.log.info("TC_PackageSubscription test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_PackageSubscription")
	    public Object[][] getDataForPackageSubscriptionGrid() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("packagesubscription_excel");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_PackageSubscription_Data");
	        return object;    
	    }
}



