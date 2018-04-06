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
 * This test case validate View of Measures with higher scores present on Dashboard >> Practice for Rolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case validate view of Favorites Measure for Rolling
 * @author probeer.roy Updated Date: 07/12/2017
 */
public class TC_PracticeMeasuresWithHigherScore extends Setup {

	ConfigurationManager rd = new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
	ExcelReader ex = new ExcelReader();
	public String Filelocation = System.getProperty("user.dir") + rd.read_Configfile("measuregrid_excelpath");

	@Test(dataProvider = "MeasureWithHS",groups = "MeasureGrid")
	public void test(Hashtable<String, String> data) throws IOException, InvalidFormatException {
		System.out.println("-------------TC_PracticeMeasuresWithHigherScore-------------");
		log.info("\n Testcase: to validate measure with higher scores on Dashboard : Rolling/NonRolling");
		exe.testexecute(Filelocation, "TC_VerifyMeasureHS", data);
		log.info("\n Ends Here");
		Setup.testcase.assertAll();
	}

	@DataProvider(name = "MeasureWithHS")
	public Object[][] getDataFromDataProvider() throws IOException, InvalidFormatException {
		Object[][] object = ex.getDataingrid(Filelocation, "TC_VerifyMeasureHS_Data");
		//Setup.log.info("\n Measure with higher scores on Dashboard >> Practice For Rolling, DataFile is used from " + Filelocation);
		return object;
	}
}
