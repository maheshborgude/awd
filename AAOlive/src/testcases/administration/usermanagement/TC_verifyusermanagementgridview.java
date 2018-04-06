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
 * Test case for verifying data on a usermanagement  grid and compare it with database. 
 * 
 * @author nilesh.patil
 * Created Date: 29 Jan 2016 
 */
@Listeners({ buisness.Listeners.Screenshot.class })
public class TC_verifyusermanagementgridview extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_verifyusermanagementgridviewdata")
		public void testBlankPassword(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{
	    	
	    

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Administration_Usermanagement");
	    	Setup.log.info("TC_verifyusermanagementgridview test case starts");
	    	exe.testexecute(Filelocation,"TC_verifyusermanagementgridview",data);
	    	Setup.log.info("TC_verifyusermanagementgridview test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_verifyusermanagementgridviewdata")
	    public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
		{
			
			System.out.println("reached");
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Administration_Usermanagement");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_verifyusermanagementgri_Data");
	        return object;    
	    }
}

