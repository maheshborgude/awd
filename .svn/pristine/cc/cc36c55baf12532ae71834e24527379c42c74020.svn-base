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
 *      >> Report PQRS Measures Milestone >>PQRS Advanced Status QCDRR
 * This test case validate data present in Grid with data present in Database 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail 
 * @author rakesh.kulkarni
 * Date 03/03/2016
 */
public class TC_PqrsAdvancedStatusQCDRRSort extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="PqrsAdvancedStatusQCDRRSort")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");		
		log.info("\nTC to validate sorting of PQRS Advanced Status QCDRRSort on Report PQRS Measures Milestone");
		exe.testexecute(Filelocation,"TC_PqrsAdvancedStatusQCDRRSort",data);
		log.info("\nTC to validate sorting of PQRS Advanced Status QCDRRSort on Report PQRS Measures Milestone Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PqrsAdvancedStatusQCDRRSort")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PqrsAdvancedStatusQCDRRSort_Data");
		Setup.log.info("\n For TC validate sorting of PQRS Advanced Status QCDRRSort on Report PQRS Measures Milestone, DataFile is used from "+Filelocation);
        return object;    
    } 
}
