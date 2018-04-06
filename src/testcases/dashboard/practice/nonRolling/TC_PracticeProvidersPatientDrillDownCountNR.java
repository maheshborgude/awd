package testcases.dashboard.practice.nonRolling;

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
 * This test case validate Count of Patient Drill Down present on Providers tab >> Dashboard >> Practice For nonRolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass then return result is pass else it will fail
 * This test case validate Count of Patient Drill Down present on Providers tab >> Dashboard >> Practice For nonRolling
 * @author rakesh.kulkarni
 * Date 23/03/2016
 */
public class TC_PracticeProvidersPatientDrillDownCountNR extends Setup{

	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
	@Test(dataProvider="PracticeProvidersPatientDrillDownCountNR")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{

		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");
		log.info("\nTC To validate count of Patient Drill Down present on Providers tab for nonRolling");
		exe.testexecute(Filelocation,"TC_PProvidersPDDCountNR",data);
		log.info("\nTC To validate count of Patient Drill Down present on Providers tab for nonRolling Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PracticeProvidersPatientDrillDownCountNR")
    public Object[][] dataProvider() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PProvidersPDDCountNR_Data");
		Setup.log.info("\n TC To validate count of Patient Drill Down present on Providers tab for nonRolling for Rolling, DataFile is used from "+Filelocation);
        return object;
    }
}
