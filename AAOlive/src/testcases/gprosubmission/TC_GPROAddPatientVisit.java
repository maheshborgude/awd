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
 * This test case is used to add patient visit
 * 
 * @author Sachin.Gawade
 * Created Date: 11 Feb 2016
 */
public class TC_GPROAddPatientVisit extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_GPROAddPatientVisit")
		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("gprosubmission");
	    	Setup.log.info("TC_GPROAddPatientVisit test case starts");
	    	exe.testexecute(Filelocation,"TC_AddPatientVisit",data);
	    	Setup.log.info("TC_GPROAddPatientVisit test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_GPROAddPatientVisit")
	    public Object[][] getDataForAddPatientVisit() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("gprosubmission");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_AddPatientVisit_data");
	        return object;    
	    }
}
