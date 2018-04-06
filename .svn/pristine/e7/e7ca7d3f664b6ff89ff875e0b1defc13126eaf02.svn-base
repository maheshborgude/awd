package testcases.pqrssubmission;

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
 * This test case validate total count total Reported Patient Visits for Individual Measures >> Submission 2015 
 *      >> Report PQRS Measures Milestone >> Count total Reported Patient Visits Individual Measures 
 * This test case validate data present in Grid with data present in Database of eligible patient 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail 
 * @author rakesh.kulkarni
 * Date 02/03/2016
 */
public class TC_ReportedPatientVisitsIMRCount extends Setup{
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="ReportedPatientVisitsIMRCount")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");		
		log.info("\nTC To validate total count of Reported Patient Visits IMR ataracts");
		exe.testexecute(Filelocation,"TC_ReportedPatientVisitsIMRCount",data);
		log.info("\nTC To validate total count of Reported Patient Visits IMR Cataracts Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="ReportedPatientVisitsIMRCount")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_ReportedPatientVisitsIMRCount_Data");
		Setup.log.info("\n For TC Validate total count of Reported Patient Visits IMR Cataracts data from "+Filelocation);
        return object;    
    } 
}
