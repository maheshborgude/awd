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
 * Test case for verifying data on a Location grid and compare it with database. 
 * 
 * @author nilesh.patil
 * Created Date: 3 FEB 2016 
 */
@Listeners({ buisness.Listeners.Screenshot.class })
public class TC_Veifygridview extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_Veifygridview")
		public void testBlankPassword(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{
	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");
	    	Setup.log.info("\nTest Case: TC_Veifygridview starts");
	    	exe.testexecute(Filelocation,"TC_Veifygridview",data);
	    	Setup.log.info("Test Case: TC_Veifygridview end");
	    	Setup.log.info("\nTC_Veifygridview test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_Veifygridview")
	    public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_Veifygridview_Data");
	        return object;    
	    }
}

