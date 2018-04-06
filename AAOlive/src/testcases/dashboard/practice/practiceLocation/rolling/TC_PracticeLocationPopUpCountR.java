package testcases.dashboard.practice.practiceLocation.rolling;

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
 * This test case validate Count of Location popup present on Dashboard >> Practice >> On select Measure for Rolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case validate Count of Location popup present on Dashboard >> Practice for Rolling
 * @author Awadhesh Sengar
 * Date 12/6/2017
 */
public class TC_PracticeLocationPopUpCountR extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
    String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");
    
	@Test(dataProvider="PracticeLocationPopUpCountR",groups = "CountGroup")
	public void TC_AllMeasuresPracticeLocationPopUpCountR(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
		log.info("\nTC To  validate count of Location popup present on Dashboard > practice for Rolling");
		exe.testexecute(Filelocation,"TC_PLocationPopUpCountR",data);
		log.info("\nTC To validate count of Location popup present on Dashboard > practice for Rolling Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PracticeLocationPopUpCountR")
    public Object[][] dataProvider() throws IOException, InvalidFormatException
	{
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PLocationPopUpCountR_Data");
		Setup.log.info("\n For TC To validate count of Location popup present on Dashboard > practice for Rolling, DataFile is used from "+Filelocation);
        return object;    
    } 
}
