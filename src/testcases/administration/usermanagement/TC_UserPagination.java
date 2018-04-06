package testcases.administration.usermanagement;


import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;



/**
 * Test case for verifying pagination on grid and compare data of pagination with database. 
 * 
 * @author nilesh.patil
 * Created Date: 1 FEB 2016 
 */
@Listeners({ buisness.Listeners.Screenshot.class })
public class TC_UserPagination extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_UserPagination")
		public void testBlankPassword(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{
	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Administration_Usermanagement");
	    	Setup.log.info("\nTest Case: TC_UserPagination starts");
	    	exe.testexecute(Filelocation,"TC_UserPagination",data);
	    	Setup.log.info("Test Case: TC_UserPagination");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_UserPagination")
	    public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Administration_Usermanagement");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_UserPagination_Data");
	        return object;    
	    }
}

