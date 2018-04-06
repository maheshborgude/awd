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
 * Checks whether user is able to add new location under administration>>Location   
 * 
 * @author nilesh.patil
 * Created Date: 7 jan 2015
 */

public class TC_SaveLocation extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_Save_Location")
		public void testBlankPassword(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Administration_Location");
	    	System.out.println("\nTest Case: TC_Save_Location starts");
	    	Setup.log.info("\nTC_Add_New_Location test case starts");
	    	exe.testexecute(Filelocation,"TC_Save_Location",data);
	    	System.out.println("Test Case: TC_Add_New_Location end");
	    	Setup.log.info("\nTC_Add_New_Location test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_Save_Location")
	    public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Administration_Location");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_Save_Location_Data");
	        return object;    
	    }
}

