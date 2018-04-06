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
 * This test case validate View of Measures  present on Dashboard >> Practice for Rolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case validate view of  Measure for Rolling
 * @author probeer.roy Updated Date: 07/12/2017
 */
public class TC_VerifyPracticeMeasureGridR extends Setup {
	private ConfigurationManager rd = new ConfigurationManager();
	private TestExecutor exe = new TestExecutor();
	private ExcelReader ex = new ExcelReader();
	private String FileLocation = System.getProperty("user.dir") + rd.read_Configfile("measuregrid_excelpath");

	@Test(dataProvider = "VerifyPracticeMeasureGrid", groups = "MeasureGrid")
	public void test(Hashtable<String, String> data) throws IOException, InvalidFormatException {
		System.out.println("-------------TC_VerifyPracticeMeasureGridR-------------");
		log.info(
				"\n Test Case: will verify the UI grid and DB grid of the practice measure grid when user logged in for first time.: Rolling");
		exe.testexecute(FileLocation, "TC_VerifyPMViewR", data);
		log.info("\n Ends here");
	}

	@DataProvider(name = "VerifyPracticeMeasureGrid")
	public Object[][] getDataFromDataprovider() throws IOException, InvalidFormatException {
		Object[][] object = ex.getDataingrid(FileLocation, "TC_VerifyPMViewR_Data");
		return object;
	}
}
