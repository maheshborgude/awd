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
 * This test case validate the count of Measures with  higher score present on Dashboard >> Practice For Rolling/Non Rolling
 * This test case validate the count from UI and number of records
 * This test case validate the count present in Database.
 * Test case is pass if return result is pass else it will fail
 * @author probeer.roy Updated Date: 07/12/2017
 */

public class TC_PMCountOfHigherScore extends Setup {

	ConfigurationManager rd = new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
	ExcelReader ex = new ExcelReader();
	public String Filelocation = System.getProperty("user.dir") + rd.read_Configfile("measuregrid_excelpath");

	@Test(dataProvider = "MeasureCountWithHS",groups = "MeasureGrid")
	public void test(Hashtable<String, String> data) throws IOException, InvalidFormatException {

	
		log.info("\n Testcase: to validate the count of measures with higher scores on Dashboard: Rolling/NonRolling");
		exe.testexecute(Filelocation, "TC_MeasureHSCount", data);
		log.info("\n Ends Here");
		Setup.testcase.assertAll();
	}

	@DataProvider(name = "MeasureCountWithHS")
	public Object[][] getDataForDataProvider() throws IOException, InvalidFormatException {
		Object[][] object = ex.getDataingrid(Filelocation, "TC_MeasureHSCount_Data");
		return object;
	}
}
