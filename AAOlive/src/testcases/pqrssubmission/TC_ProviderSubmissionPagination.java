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
 * This test case validate Data of PQRS Advanced Status  present on PQRS Submission >> Submission 2015 
 *      >> Submission Milestone >>PQRS Reporting Provider 
 * This test case validate data present in Grid with data present in Database of eligible patient 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail 
 * This test case validate PQRS Reporting Option of Qualified Clinical Data Registry
 * @author rakesh.kulkarni
 * Date 09/03/2016
 */
public class TC_ProviderSubmissionPagination extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor(); 
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="ProviderSubmissionPagination")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");		
		log.info("\nTC To validate Pagination of Submission provider present on Submission milestone");
		exe.testexecute(Filelocation,"TC_ProviderSubmissionPagination",data);
		log.info("\nTC To validate Pagination of Submission provider present on Submission milestone Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="ProviderSubmissionPagination")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderSubmissionPagination_Data");
		Setup.log.info("\n TC To validate Pagination of Submission provider present on Submission milestone from "+Filelocation);
        return object;    
    } 
}
