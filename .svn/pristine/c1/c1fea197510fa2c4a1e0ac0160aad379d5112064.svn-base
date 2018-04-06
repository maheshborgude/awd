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
 * This test case validate total count total Reported Patient Visits >> Submission 2015 
 *      >> Report PQRS Measures Milestone >> Count total Reported For Patient Visits Qualified Clinical Data Registry view
 * This test case validate data present in Grid with data present in Database of eligible patient 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail 
 * @author rakesh.kulkarni
 * Date 02/03/2016
 */
public class TC_ReportedPatientVisitsQCDRRCount extends Setup{
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="ReportedPatientVisitsQCDRRCount")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");		
		log.info("\nTC To validate total count of QCDRR Reported Patient Visits ataracts");
		exe.testexecute(Filelocation,"TC_ReportedPatientVisitsQCDRRCount",data);
		log.info("\nTC To validate total count of QCDRR Reported Patient Visits Cataracts Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="ReportedPatientVisitsQCDRRCount")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_ReportedPatientVisitsQCDRRCount_Data");
		Setup.log.info("\n For TC Validate total count of QCDRR 0Reported Patient Visits Cataracts data from "+Filelocation);
        return object;    
    } 
}
