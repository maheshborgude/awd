package testcases.administration.location;


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
 * Test case add new button and Pop up window and also verifies the elements on pop up window
 * 
 * @author nilesh.patil
 * Created Date: 6 jan 2015
 */

public class TC_Add_New_Location extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_Add_New_Location")
		public void testBlankPassword(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Administration_Location");
	    	System.out.println("\nTest Case: TC_Add_New_Location starts");
	    	Setup.log.info("\nTC_Add_New_Location test case starts");
	    	exe.testexecute(Filelocation,"TC_Add_New_Location",data);
	    	System.out.println("Test Case: TC_Add_New_Location end");
	    	Setup.log.info("\nTC_Add_New_Location test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_Add_New_Location")
	    public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Administration_Location");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_Add_New_Location_Data");
	        return object;    
	    }
}

