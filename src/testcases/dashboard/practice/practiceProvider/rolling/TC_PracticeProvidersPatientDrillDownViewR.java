package testcases.dashboard.practice.practiceProvider.rolling;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

public class TC_PracticeProvidersPatientDrillDownViewR  extends Setup 
{
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
	@Test(dataProvider="PracticeProvidersPatientDrillDownView")
	public void TC_PPPatientDrillDownView(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{

		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Practice_Provider");
		Setup.log.info("\nTC To validate patient records from Patient Drill Down present on Providers tab for Rolling starts");
		exe.testexecute(Filelocation,"TC_PProvidersPDDView",data);
		Setup.log.info("\nTC To validate patient records of Patient Drill Down present on Providers tab for Rolling ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PracticeProvidersPatientDrillDownView")
    public Object[][] dataProvider() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Practice_Provider");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PProvidersPDDView_Data");
		Setup.log.info("\n TC To validate patient records of Patient Drill Down present on Providers tab for Rolling for Rolling, DataFile is used from "+Filelocation);
        return object;
    }

}
