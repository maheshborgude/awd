package testcases.dashboard.provider.rolling;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class TC_DetailedPPDrillDownCountR extends Setup {

	ConfigurationManager rd = new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
	ExcelReader ex = new ExcelReader();
	public String Filelocation = System.getProperty("user.dir") + rd.read_Configfile("DashboardProvider");

	@Test(dataProvider = "TC_DetailedPPDrillDownCountR")

	public void startTestCase(Hashtable<String, String> data) throws IOException, InvalidFormatException {

		Setup.log.info("TC_DetailedPPDrillDownCountR test case starts");
		exe.testexecute(Filelocation, "TC_DetailedPPDDCountR", data);
		Setup.log.info("TC_DetailedPPDrillDownCountR test case ends");
		Setup.testcase.assertAll();
	}

	@DataProvider(name = "TC_DetailedPPDrillDownCountR")

	public Object[][] getDataForProviderPatientDrillDownCount() throws IOException, InvalidFormatException {
		Object[][] object = ex.getDataingrid(Filelocation, "TC_DetailedPPDDCountR_Data");
		return object;
	}
}
