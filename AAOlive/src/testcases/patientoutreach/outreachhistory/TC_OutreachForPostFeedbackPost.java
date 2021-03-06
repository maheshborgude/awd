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
 * This test case is used to test Patient Outreach>>Outreach History >> Outreach For Post Feedback>> Post Tab(Only UI)
 * 
 * @author Sachin.Gawade
 * Created Date: 14 March 2016
 */
public class TC_OutreachForPostFeedbackPost extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_OutreachForPostFeedbackPost")
		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("outreachhistory_excel");
	    	Setup.log.info("TC_OutreachForPostFeedbackPost test case starts");
	    	exe.testexecute(Filelocation,"TC_OutreachPostFeedPost",data);
	    	Setup.log.info("TC_OutreachForPostFeedbackPost test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_OutreachForPostFeedbackPost")
	    public Object[][] getDataForOutreachForPostFeedbackPost() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("outreachhistory_excel");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_OutreachPostFeedPost_Data");
	        return object;    
	    }
}
