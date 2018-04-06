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
 *      >> Manage Provider Profile Milestone >>PQRS Reporting Option for Individual Measures 
 * This test case validate data present in Grid with data present in Database of eligible patient 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail 
 * @author rakesh.kulkarni
 * Date 15/02/2016
 */
public class TC_PqrsReportingOptionIMRView extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="PqrsReportingOptionView")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");		
		log.info("\nTC To validate data of PQRS Reporting Option present on Manage Provider Profile milestone");
		exe.testexecute(Filelocation,"TC_PqrsReportingOptionIMRView",data);
		log.info("\nTC To validate data of PQRS Reporting Option present on Manage Provider Profile milestone Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PqrsReportingOptionView")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PqrsReportingOptionIMRView_Data");
		Setup.log.info("\n For TC Validate data of TC To validate data of PQRS Reporting Option present on Manage Provider Profile milestone from "+Filelocation);
        return object;    
    } 
}
