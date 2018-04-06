package testcases.patientoutreach.outreachauthorization;

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
 * This test case is used to test Patient Outreach>>Outreach Authorization>>List Of Patients
 * 
 * @author Sachin.Gawade
 * Created Date: 14 March 2016
 */
public class TC_ListOfPatients extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_ListOfPatients")
		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("outreachauthorization_excel");
	    	Setup.log.info("TC_ListOfPatients test case starts");
	    	exe.testexecute(Filelocation,"TC_ListOfPatients",data);
	    	Setup.log.info("TC_ListOfPatients test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_ListOfPatients")
	    public Object[][] getDataForListOfPatients() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("outreachauthorization_excel");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_ListOfPatients_Data");
	        return object;    
	    }
}
