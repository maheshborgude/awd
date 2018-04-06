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
 * This test case validate View of Measure Computation Summary present on Dashboard >> Practice For Rolling
 * This test case validate data present in UI Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case validate View of Measure Computation Summary present on Dashboard >> Practice For Rolling
 * @author rakesh.kulkarni Created Date: 15/03/2016
 * @author probeer.roy Updated Date: 07/12/2017
 */
public class TC_PracticeMeasureViewR extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="PracticeMeasureViewR",groups = "LoginGroup")
	public void test(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");		
		log.info("\nTC To validate View of Measure present on Dashboard >> Practice for Rolling");
		exe.testexecute(Filelocation,"TC_PracticeMeasureViewR",data);
		log.info("\nTC To validate View of Measure present  on Dashboard >> Practice for Rolling Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PracticeMeasureViewR")
    public Object[][] getDataFromDataProvider() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PracticeMeasureViewR_Data");
		//Setup.log.info("\n For TC To validate View of Measure present on Dashboard >> Practice For Rolling, DataFile is used from "+Filelocation);
        return object;
    } 
}
