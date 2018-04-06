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
 * This test case validate Data of PQRS Advanced Status Group Performance View present on PQRS Submission >> Submission 2015 
 *      >> Report PQRS Measures Milestone >>PQRS Advanced Status QCDRRView
 * This test case validate data present in Grid with data present in Database 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail 
 * @author rakesh.kulkarni
 * Date 04/03/2016
 */
public class TC_GroupPerformanceView extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="GroupPerformanceView")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");		
		log.info("\nTC To validate data of Group Performance View  preseent on Report PQRS Measures milestone ");
		exe.testexecute(Filelocation,"TC_GroupPerformanceView",data);
		log.info("\nTC to validate data of PQRS Group Performance View preseent on Report PQRS Measures milestone Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="GroupPerformanceView")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_GroupPerformanceView_Data");
		Setup.log.info("\n For TC Validate data of Group Performance View preseent on Report PQRS Measures milestone from "+Filelocation);
        return object;    
    } 
}
