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
 * This test case validate Searching of Reported Patient Visits present on Report PQRS Measures >> Submission 2015 
 *      >> Report PQRS Measures Milestone >>Reported Patient Visits Search Individual Measures  
 * This test case validate data present in Grid with data present in Database of eligible patient 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail 
 * This test case validate PQRS Reporting Option of Qualified Clinical Data Registry
 * @author rakesh.kulkarni
 * Date 01/03/2016
 */
public class TC_ReportedPatientVisitsIMRSearch extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="ReportedPatientVisitsIMRSearch")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");		
		log.info("\nTC To validate data of Reported Patient Visits IMRSearch preseent on Report PQRS Measures milestone ");
		exe.testexecute(Filelocation,"TC_ReportedPatientVisitsIMRSearch",data);
		log.info("\nTC to validate data of Reported Patient Visits IMRSearch preseent on Report PQRS Measures milestone Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="ReportedPatientVisitsIMRSearch")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_ReportedPatientVisitsIMRSearch_Data");
		Setup.log.info("\n For TC Validate data of Reported Patient Visits IMRSearch preseent on Report PQRS Measures milestone from "+Filelocation);
        return object;    
    } 
}
