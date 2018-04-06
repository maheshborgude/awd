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
 *  Verifies Pagination for Patient Visits grid with and compares the grid from UI and Database <p>
 *  for GPRO Reporting Option in 'Report PQRS Measures' milestone
 * 
 * @author Sachin.Gawade
 * Created Date: 18 Feb 2016
 */
//TODO: java doc:done
public class TC_GPROReportedPatVisitsPagination extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_GPROReportedPatVisitsPagination")
	  //TODO: function name:done
		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("gprosubmission");
	    	//TODO: there should not be new line in log:done
	    	Setup.log.info("TC_GPROReportedPatVisitsPagination test case starts");
	    	exe.testexecute(Filelocation,"TC_RepPatVisitsPagination",data);
	    	Setup.log.info("TC_GPROReportedPatVisitsPagination test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_GPROReportedPatVisitsPagination")
		//TODO: function name:done
	    public Object[][] getDataForRepPatientVisitsPagination() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("gprosubmission");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_RepPatVisitsPagination_data");
	        return object;    
	    }
}
