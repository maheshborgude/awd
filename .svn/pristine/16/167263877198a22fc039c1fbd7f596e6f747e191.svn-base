package testcases.patientoutreach.outreachconfiguration;


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
 * This test case is used to test Patient Outreach>>Outreach Configuration
 * 
 * @author Sachin.Gawade
 * Created Date: 11 March 2016
 */
public class TC_OutreachConfiguration extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_OutreachConfiguration")
		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("outreachconfiguration_excel");
	    	Setup.log.info("TC_OutreachConfiguration test case starts");
	    	exe.testexecute(Filelocation,"TC_OutreachConfiguration",data);
	    	Setup.log.info("TC_OutreachConfiguration test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_OutreachConfiguration")
	    public Object[][] getDataForOutreachConfiguration() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("outreachconfiguration_excel");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_OutreachConfiguration_Data");
	        return object;    
	    }
}
