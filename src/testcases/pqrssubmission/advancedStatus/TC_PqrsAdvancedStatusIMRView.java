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
 *      >> Report PQRS Measures Milestone >>PQRS Advanced Status 
 * This test case validate data present in Grid with data present in Database 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail 
 * @author rakesh.kulkarni
 * Date 10/02/2016
 */
public class TC_PqrsAdvancedStatusIMRView extends Setup {

	ConfigurationManager rd = new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
	ExcelReader ex = new ExcelReader();

	@Test(dataProvider = "PqrsAdvancedStatusIMRView")
	public void TC_AllMeasures(Hashtable<String, String> data) throws IOException, InvalidFormatException {

		String Filelocation = System.getProperty("user.dir") + rd.read_Configfile("PQRSSubmission_Submission");
		log.info("\nTC To validate IMR view");
		exe.testexecute(Filelocation, "TC_PqrsAdvancedStatusIMRView", data);
		log.info("\nTC To validate IMR view Ends");
		Setup.testcase.assertAll();
	}

	@DataProvider(name = "PqrsAdvancedStatusIMRView")
	public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException {
		String Filelocation = System.getProperty("user.dir") + rd.read_Configfile("PQRSSubmission_Submission");
		Object[][] object = ex.getDataingrid(Filelocation, "TC_PqrsAdvancedStatusIMRView_Data");
		Setup.log.info("\n For TC validate IMR view, DataFile is used from " + Filelocation);
		return object;
	}
}