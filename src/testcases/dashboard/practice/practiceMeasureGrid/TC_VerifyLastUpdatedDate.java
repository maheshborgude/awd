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
 * This test case validate the last updated date present on Dashboard. 
 * This test case validate date present in Grid with data present in Database.
 * Test case is pass if return result is pass else it will fail
 * @author probeer.roy Updated Date: 07/12/2017
 */
public class TC_VerifyLastUpdatedDate extends Setup {
	private ConfigurationManager rd = new ConfigurationManager();
	private TestExecutor exe = new TestExecutor();
	private ExcelReader ex = new ExcelReader();
	private String FileLocation = System.getProperty("user.dir") + rd.read_Configfile("measuregrid_excelpath");

	@Test(dataProvider = "MeasuresLastUpdateDate", groups = "MeasureGrid")
	public void test(Hashtable<String, String> data) throws IOException, InvalidFormatException {
		System.out.println("-------------TC_VerifyLastUpdatedDate-------------");
		log.info(
				"\nTest Case: to verify the last updated date in UI: Rolling/Non-rolling");
		exe.testexecute(FileLocation, "TC_VerifyLastUpdated", data);
		log.info("\n Ends here");
	}

	@DataProvider(name = "MeasuresLastUpdateDate")
	public Object[][] getDataFromDataprovider() throws IOException, InvalidFormatException {
		Object[][] object = ex.getDataingrid(FileLocation, "TC_VerifyLastUpdated_Data");
		return object;
	}
}