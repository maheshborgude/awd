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
 * This test case validate Pagination of provider present on PQRS Submission >> Submission 2015 
 *      >> ManageProviderProfile Milestone >>ProviderView
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail 
 * This test case validate Select Provider Option of Manage Provider Profile milestone
 * @author rakesh.kulkarni
 * Date 20-1-2016
 */
public class TC_SelectProviderPagination extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="ManageProviderProfile_ProviderSearch")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");		
		log.info("\nTC To validate Pagination of provider present on Manage provider Profile milestone");
		exe.testexecute(Filelocation,"TC_ManageProviderProfile_ProviderPagination",data);
		log.info("\nTC To validate pagination of provider present on Manage provider Profile milestone Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="ManageProviderProfile_ProviderSearch")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_ManageProviderProfile_ProviderPagination_Data");
		Setup.log.info("\n For TC validate paginnation of provider present on Manage provider Profile milestone, DataFile is used from "+Filelocation);
        return object;    
    } 
}
