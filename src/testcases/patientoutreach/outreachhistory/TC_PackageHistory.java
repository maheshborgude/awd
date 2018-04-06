package testcases.patientoutreach.outreachhistory;

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
 * This test case is used to test Patient Outreach>> Package History Tab(Only UI)
 * 
 * @author Sachin.Gawade
 * Created Date: 15 March 2016
 */
public class TC_PackageHistory extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_PackageHistory")
		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("outreachhistory_excel");
	    	Setup.log.info("TC_PackageHistory test case starts");
	    	exe.testexecute(Filelocation,"TC_PackageHistory",data);
	    	Setup.log.info("TC_PackageHistory test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_PackageHistory")
	    public Object[][] getDataForOutreachForPackageHistory() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("outreachhistory_excel");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_PackageHistory_Data");
	        return object;    
	    }
}
