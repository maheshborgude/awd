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
 * This test case validate sorting of provider present on PQRS Submission >> Submission 2015 
 *      >> ManageProviderProfile Milestone >>ProviderView
 * This test case validate data present in Grid
 * @author rakesh.kulkarni
 * Date 20-1-2016
 */
public class TC_ReportedPatientVisitsCMGRSort extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="ReportedPatientVisitsSort")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");		
		log.info("\nTC to validate sorting of Reported Patient Visits present on Report PQRS Measures milestone");
		exe.testexecute(Filelocation,"TC_ReportedPatientVisitsCMGRSort",data);
		log.info("\nTC to validate sorting of Reported Patient Visits present on Report PQRS Measures milestone Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="ReportedPatientVisitsSort")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_ReportedPatientVisitsCMGRSort_Data");
		Setup.log.info("\n For TC validate sorting of Reported Patient Visits present on Report PQRS Measures milestone, DataFile is used from "+Filelocation);
        return object;    
    } 
}
