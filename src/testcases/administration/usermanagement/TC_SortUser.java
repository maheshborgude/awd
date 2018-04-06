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
 * Test case for verifying Sorting functionality for usermanagement grid and compare it with database. 
 * 
 * @author nilesh.patil
 * Created Date: 29 Jan 2016 
 */
@Listeners({ buisness.Listeners.Screenshot.class })
public class TC_SortUser extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_SortUser")
		public void testBlankPassword(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{
	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Administration_Usermanagement");
	    	Setup.log.info("\nTest Case: TC_SortUser starts");
	    	Setup.log.info("\nTC_SortUser test case starts");
	    	exe.testexecute(Filelocation,"TC_SortUser",data);
	    	Setup.log.info("Test Case: TC_SortUser end");
	    	Setup.log.info("\nTC_SortUser test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_SortUser")
	    public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Administration_Usermanagement");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_SortUser_Data");
	        return object;    
	    }
}

