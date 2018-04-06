package testcases.dashboard.practice;


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

@Listeners({  buisness.Listeners.Screenshot.class})
public class TC_VerifyReportDuration extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_VerifyReportDuration")
		public void testBlankPassword(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice_excel");
	    	System.out.println("\nTest Case: TC_VerifyReportDuration starts");
	    	Setup.log.info("\nTC_VerifyReportDuration test case starts");
	    	exe.testexecute(Filelocation,"TC_VerifyReportDuration",data);
	    	System.out.println("Test Case: TC_VerifyReportDuration end");
	    	Setup.log.info("\nTC_VerifyReportDuration test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_VerifyReportDuration")
	    public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice_excel");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_VerifyReportDuration_Data");
	        return object;    
	    }
}

