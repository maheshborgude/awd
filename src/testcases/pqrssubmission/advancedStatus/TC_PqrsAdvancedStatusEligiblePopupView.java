package testcases.pqrssubmission.advancedStatus;

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
 *      >> Report PQRS Measures Milestone >>PQRS Advanced Status Eligible popup
 * This test case validate data present in Grid with data present in Database of eligible patient 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail 
 * @author rakesh.kulkarni
 * Date 11/02/2016
 */
public class TC_PqrsAdvancedStatusEligiblePopupView extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="PqrsAdvancedStatusEligiblePopupView")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");		
		log.info("\nTC To validate data of PQRS Advanced Status eligible patient popup preseent on Report PQRS Measures milestone ");
		exe.testexecute(Filelocation,"TC_PqrsAdvancedStatusEligiblePopupView",data);
		log.info("\nTC to validate data of PQRS Advanced Status preseent eligible patient popup on Report PQRS Measures milestone Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PqrsAdvancedStatusEligiblePopupView")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PqrsAdvancedStatusEligiblePopupView_Data");
		Setup.log.info("\n For TC Validate data of PQRS Advanced Status eligible patient popup preseent on Report PQRS Measures milestone from "+Filelocation);
        return object;    
    } 
}
