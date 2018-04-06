package testcases.analytics.registrydatadictionary;

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
 * This test case validate View of Registry Data Dictionary View present on > Analytics
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case validate validate View of Registry Data Dictionary View present on > Analytics
 * @author rakesh.kulkarni
 * Date 29/03/2016
 */
public class TC_RegistryDataDictionaryView extends Setup {

	ConfigurationManager rd = new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
	ExcelReader ex = new ExcelReader();

	@Test(dataProvider = "RegistryDataDictionaryView")
	public void TC_AllMeasures(Hashtable<String, String> data) throws IOException, InvalidFormatException {

		String Filelocation = System.getProperty("user.dir") + rd.read_Configfile("registrydatadictionary_excel");
		log.info("\nTC To validate view of Registry Data Dictionary");
		exe.testexecute(Filelocation, "TC_RegistryDataDictionaryView", data);
		log.info("\nTC To validate view of Registry Data Dictionary Ends");
		Setup.testcase.assertAll();
	}

	@DataProvider(name = "RegistryDataDictionaryView")
	public Object[][] dataProvider() throws IOException, InvalidFormatException {
		String Filelocation = System.getProperty("user.dir") + rd.read_Configfile("registrydatadictionary_excel");
		Object[][] object = ex.getDataingrid(Filelocation, "TC_RegistryDataDictionaryView_Data");
		Setup.log.info("\n For TC To validate view of Registry Data Dictionary, DataFile is used from :" + Filelocation);
		return object;
	}
}