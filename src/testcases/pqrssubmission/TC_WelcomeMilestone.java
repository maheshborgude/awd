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
 * This test case validate Welcome milestone
 * @author rakesh.kulkarni
 * Date 20-1-2016
 */
public class TC_WelcomeMilestone extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="WelcomeMilestone")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");		
		log.info("\nTC To Validate Welcome Milestone of PQRS Submission");
		exe.testexecute(Filelocation,"TC_WelcomeMilestone",data);
		log.info("\nTC To validate Welcome Milestone of PQRS Submission Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="WelcomeMilestone")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_WelcomeMilestone_Data");
		Setup.log.info("\n For TC Validate Welcome Milestone of PQRS Submission, DataFile is used from "+Filelocation);
        return object;    
    } 
}
