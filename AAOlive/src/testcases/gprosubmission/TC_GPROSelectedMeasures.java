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
 * Verifies Selected GPRO Measures in 'Manage GPRO Profile' milestone of GPRO Submission
 * 
 * @author Sachin.Gawade
 * Created Date: 1 Mar 2016
 */
public class TC_GPROSelectedMeasures extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_GPROSelectedMeasures")
		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("gprosubmission");
	    	Setup.log.info("TC_GPROSelectedMeasures test case starts");
	    	exe.testexecute(Filelocation,"TC_SelectedGproMeasures",data);
	    	Setup.log.info("TC_GPROSelectedMeasures test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_GPROSelectedMeasures")

	    public Object[][] getDataForSelectedGproMeasures() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("gprosubmission");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_SelectedGproMeasures_Data");
	        return object;    
	    }
}
