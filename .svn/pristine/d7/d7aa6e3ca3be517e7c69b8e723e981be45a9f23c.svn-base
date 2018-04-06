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
 * This test case validate Pagination of Reported Patient Visits Individual Measures  Pagination present on PQRS Submission >> Submission 2015 
 *      >> Report PQRS Measures Milestone >>Reported Patient Visits
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible patient 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail 
 * @author rakesh.kulkarni
 * Date 02/03/2016
 */
public class TC_ReportedPatientVisitsIMRPagination extends Setup	{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="ReportedPatientVisitsIMRPagination")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");		
		log.info("\nTC to validate Pagination of Reported Patient IMR Visits present on Report PQRS Measures milestone");
		exe.testexecute(Filelocation,"TC_ReportedPatientVisitsIMRPagination",data);
		log.info("\nTC to validate Pagination of Reported Patient Visits IMR present on Report PQRS Measures milestone Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="ReportedPatientVisitsIMRPagination")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_ReportedPatientVisitsIMRPagination_Data");
		Setup.log.info("\n For TC validate Pagination of Reported Patient Visits IMR present on Report PQRS Measures milestone, DataFile is used from "+Filelocation);
        return object;    
    } 
}
