package testcases.analytics.myanalytics;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

/**
 * This test case validate View of My Analytics >> Analytics
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case validate View of My Analytics >> Analytics
 * @author rakesh.kulkarni
 * Date 29/03/2016
 */
public class TC_MyAnalyticsView extends Setup {

	ConfigurationManager rd = new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
	ExcelReader ex = new ExcelReader();

	@Test(dataProvider = "PracticeFavoritesMeasureCountR")
	public void TC_AllMeasures(Hashtable<String, String> data) throws IOException, InvalidFormatException {

		String Filelocation = System.getProperty("user.dir") + rd.read_Configfile("myanalytics_excel");
		log.info("\nTC To validate View of My Analytics > Analytics");
		exe.testexecute(Filelocation, "TC_MyAnalyticsView", data);
		log.info("\nTC To validate View of My Analytics > Analytics Ends");
		Setup.testcase.assertAll();
	}

	@DataProvider(name = "PracticeFavoritesMeasureCountR")
	public Object[][] dataProvider() throws IOException, InvalidFormatException {
		String Filelocation = System.getProperty("user.dir") + rd.read_Configfile("myanalytics_excel");
		Object[][] object = ex.getDataingrid(Filelocation, "TC_MyAnalyticsView_Data");
		Setup.log.info("\n For TC To validate View of My Analytics > Analytics, DataFile is used from :" + Filelocation);
		return object;
	}
}