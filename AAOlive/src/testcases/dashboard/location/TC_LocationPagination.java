package testcases.dashboard.location;


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
 * Test case for verifying Dashbaord Location  pagination on grid and compare data of pagination with database. 
 * 
 * @author nilesh.patil
 * Created Date: 10 FEB 2016 
 */
@Listeners({ buisness.Listeners.Screenshot.class })
public class TC_LocationPagination extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_LocationPagination")
		public void testBlankPassword(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{
	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");
	    	Setup.log.info("\nTest Case: TC_LocationPagination starts");
	    	exe.testexecute(Filelocation,"TC_LocationPagination",data);
	    	Setup.log.info("Test Case: TC_LocationPagination");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_LocationPagination")
	    public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_LocationPagination_Data");
	        return object;    
	    }
}

