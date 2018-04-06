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
 * Verifies Reported Patient Visits grid for GPRO Reporting Option in 'Report PQRS Measures' milestone
 * 
 * @author Sachin.Gawade
 * Created Date: 16 Feb 2016
 */
public class TC_GPROVerifyReportedPatientVisits extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_GPROVerifyReportedPatientVisits")
		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("gprosubmission");
	    	Setup.log.info("TC_GPROVerifyReportedPatientVisits test case starts");
	    	exe.testexecute(Filelocation,"TC_VerifyRepPatientVisits",data);
	    	Setup.log.info("TC_GPROVerifyReportedPatientVisits test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_GPROVerifyReportedPatientVisits")
	    public Object[][] getDataForVerifyRepPatientVisits() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("gprosubmission");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_VerifyRepPatientVisits_data");
	        return object;    
	    }
}
