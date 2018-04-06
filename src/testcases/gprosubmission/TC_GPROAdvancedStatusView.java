package testcases.gprosubmission;


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
 *  Verifies GPRO Advanced Status grid as it compares the grid from UI and Database <p>
 *  for GPRO Reporting Option in 'Report PQRS Measures' milestone
 * 
 * @author Sachin.Gawade
 * Created Date: 19 Feb 2016
 */
public class TC_GPROAdvancedStatusView extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_GPROAdvancedStatusView")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("gprosubmission");

	    	Setup.log.info("TC_GPROAdvancedStatusView test case starts");
	    	exe.testexecute(Filelocation,"TC_GPROAdvancedStatusView",data);
	    	Setup.log.info("TC_GPROAdvancedStatusView test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_GPROAdvancedStatusView")

	    public Object[][] getDataForGPROAdvancedStatusView() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("gprosubmission");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_GPROAdvancedStatusView_data");
	        return object;    
	    }
}
