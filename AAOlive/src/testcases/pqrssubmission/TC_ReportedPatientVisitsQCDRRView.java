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
 * This test case validate Reported Patient Visits For Patient Visits Qualified Clinical Data Registry view
 *  Sorting present on PQRS Submission >> Submission 2015 
 *    >> Report PQRS Measures Milestone >>Reported Patient Visits For Patient Visits Qualified Clinical Data Registry sorting 
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible patient 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail
 * @author rakesh.kulkarni
 * Date 18/02/2015
 */
public class TC_ReportedPatientVisitsQCDRRView extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="ReportedPatientVisitsQCDRRView")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");		
		log.info("\nTC to validate data of Reported Patient Visits present on Report PQRS Measures milestone for  Qualified Clinical Data Registry Reporting");
		exe.testexecute(Filelocation,"TC_ReportedPatientVisitsQCDRRView",data);
		log.info("\nTC to validate searching of Reported Patient Visits present on Report PQRS Measures milestone for  Qualified Clinical Data Registry Reporting Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="ReportedPatientVisitsQCDRRView")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_ReportedPatientVisitsQCDRRView_Data");
		Setup.log.info("\n For TC validate searching of Reported Patient Visits present on Report PQRS Measures milestone for  Qualified Clinical Data Registry Reporting, DataFile is used from "+Filelocation);
        return object;    
    } 
}
