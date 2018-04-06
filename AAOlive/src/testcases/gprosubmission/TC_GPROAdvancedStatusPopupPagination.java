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
 *  Verifies Pagination for Pqrs advance status popup grid with and compares the grid from UI and Database <p>
 *  for GPRO Reporting Option in 'Report PQRS Measures' milestone
 * 
 * @author Sachin.Gawade
 * Created Date: 29 Feb 2016
 */

public class TC_GPROAdvancedStatusPopupPagination extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_GPROAdvancedStatusPopupPagination")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("gprosubmission");
	    	Setup.log.info("TC_GPROAdvancedStatusPopupPagination test case starts");
	    	exe.testexecute(Filelocation,"TC_GPROAdvStatusPopupPag",data);
	    	Setup.log.info("TC_GPROAdvancedStatusPopupPagination test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_GPROAdvancedStatusPopupPagination")
	    public Object[][] getDataForGPROAdvancedStatusPopupPagination() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("gprosubmission");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_GPROAdvStatusPopupPag_Data");
	        return object;    
	    }
}
