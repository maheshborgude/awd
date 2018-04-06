package testcases.administration.location;


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
 * Test case for verifying Searched Location data on a Location grid and compare it with database. 
 * 
 * @author nilesh.patil
 * Created Date: 21 Jan 2016 
 */
@Listeners({ buisness.Listeners.Screenshot.class })
public class TC_SearchLocation extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_SearchLocation")
		public void testBlankPassword(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{
	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Administration_Location");
	    	Setup.log.info("\nTest Case: TC_SearchLocation starts");
	    	Setup.log.info("\nTC_SearchLocation test case starts");
	    	exe.testexecute(Filelocation,"TC_SearchLocation",data);
	    	Setup.log.info("Test Case: TC_SearchLocation end");
	    	Setup.log.info("\nTC_SearchLocation test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_SearchLocation")
	    public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Administration_Location");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_SearchLocation_Data");
	        return object;    
	    }
}

