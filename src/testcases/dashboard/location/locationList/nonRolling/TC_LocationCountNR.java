package testcases.dashboard.location.locationList.nonRolling;

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
 * This test case validate Count of Location present on Dashboard >> Location For Rolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case validate Count of Location present on Dashboard >> Location For Rolling
 * @author rakesh.kulkarni
 * Date 30/03/2016
 */
public class TC_LocationCountNR extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="LocationCountNR")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");
		log.info("\nTC To validate View of Measure present on Dashboard >> Location for Rolling");
		exe.testexecute(Filelocation,"TC_LCountNR",data);
		log.info("\nTC To validate View of Measure present on Dashboard >> Location for Rolling Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="LocationCountNR")
    public Object[][] dataProvider() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_LCountNR_Data");
		Setup.log.info("\n For TC To validate View of Measure present on Dashboard >> Location For Rolling, DataFile is used from "+Filelocation);
        return object;    
    } 
}
