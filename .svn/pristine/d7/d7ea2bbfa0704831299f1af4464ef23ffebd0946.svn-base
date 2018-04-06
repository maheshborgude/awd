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
public class TC_VerifyFavouriteMeasureID extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_VerifyFavouriteMeasureID")
		public void testBlankPassword(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice_excel");
	    	System.out.println("\nTest Case: TC_VerifyFavouriteMeasureID starts");
	    	Setup.log.info("\nTC_VerifyFavouriteMeasureID test case starts");
	    	exe.testexecute(Filelocation,"TC_VerifyFavouriteMeasureID",data);
	    	System.out.println("Test Case: TC_VerifyFavouriteMeasureID end");
	    	Setup.log.info("\nTC_VerifyFavouriteMeasureID test case ends");
			Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_VerifyFavouriteMeasureID")
	    public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice_excel");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_VerifyFavouriteMeasureID_D");
	        return object;    
	    }
}

