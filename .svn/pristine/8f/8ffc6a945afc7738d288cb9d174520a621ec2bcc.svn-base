package testcases.patientoutreach.packagecreation;

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
 * This test case is used to test Patient Outreach>>Package Creation >>Outreach Package Configuration(Outreach details tab)(Only UI)
 * 
 * @author Sachin.Gawade
 * Created Date: 18 March 2016
 */
public class TC_OutreachDetailsTab extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_OutreachDetailsTab")
		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("packagecreation_excel");
	    	Setup.log.info("TC_OutreachDetailsTab test case starts");
	    	exe.testexecute(Filelocation,"TC_OutreachDetailsTab",data);
	    	Setup.log.info("TC_OutreachDetailsTab test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_OutreachDetailsTab")
	    public Object[][] getDataForOutreachDetailsTab() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("packagecreation_excel");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_OutreachDetailsTab_Data");
	        return object;    
	    }
}



