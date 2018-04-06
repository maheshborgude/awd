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
 * This test case validate sorting of  of provider present on PQRS Submission >> Submission 2015 
 *      >> Report PQRS Measures Milestone >>PQRS Advanced Status Tab
 * This test case validate data present in Grid
 * @author rakesh.kulkarni
 * Date 11/02/2015
 */
public class TC_PqrsAdvancedStatusIMRSort extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="PqrsAdvancedStatusIMRSort")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");		
		log.info("\nTC to validate sorting of PQRS Advanced Status on Report PQRS Measures Milestone");
		exe.testexecute(Filelocation,"TC_PqrsAdvancedStatusIMRSort",data);
		log.info("\nTC to validate sorting of PQRS Advanced Status on Report PQRS Measures Milestone Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PqrsAdvancedStatusIMRSort")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PqrsAdvancedStatusIMRSort_Data");
		Setup.log.info("\n For TC validate sorting of PQRS Advanced Status on Report PQRS Measures Milestone, DataFile is used from "+Filelocation);
        return object;    
    } 
}
