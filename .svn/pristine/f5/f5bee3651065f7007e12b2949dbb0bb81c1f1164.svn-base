package testcases.dashboard.practice.practiceMeasureGrid;

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
 * This test case validate View of Measures with lower scores present on Dashboard >> Practice for Rolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case validate view of Favorites Measure for Rolling
 * @author probeer.roy Updated Date: 07/12/2017
 */
public class TC_PracticeMeasuresWithLowerScore extends Setup {

	ConfigurationManager rd = new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
	ExcelReader ex = new ExcelReader();
	public String Filelocation = System.getProperty("user.dir") + rd.read_Configfile("measuregrid_excelpath");

	@Test(dataProvider = "MeasureWithLS",groups = "MeasureGrid")
	public void test(Hashtable<String, String> data) throws IOException, InvalidFormatException {	
		System.out.println("-------------TC_PracticeMeasuresWithLowerScore-------------");
		log.info("\n Testcase: to validate Measure with lower scores on Dashboard :Rolling/Nonrolling");
		exe.testexecute(Filelocation, "TC_VerifyMeasureLS", data);
		log.info("\n Ends Here");
		Setup.testcase.assertAll();
	}

	@DataProvider(name = "MeasureWithLS")
	public Object[][] getDataFromDataProvider() throws IOException, InvalidFormatException {
		Object[][] object = ex.getDataingrid(Filelocation, "TC_VerifyMeasureLS_Data");
	//	Setup.log.info("\n For TC To validate Measure with lower scores on Dashboard >> Practice For Rolling, DataFile is used from " + Filelocation);
		return object;
	}
}
