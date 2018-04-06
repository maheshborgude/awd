package testcases.dashboard.location.rolling;

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
 * This test case validate Pagination of Location present on Dashboard >> Location For Rolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case validate Pagination of Location present on Dashboard >> Location For Rolling
 * @author rakesh.kulkarni
 * Date 01/04/2016
 */
public class TC_LocationPaginationR extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="LocationPaginationR")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");
		log.info("\nTC To validate Pagination of Location present on Dashboard >> Location for Rolling");
		exe.testexecute(Filelocation,"TC_LPaginationR",data);
		log.info("\nTC To validate Pagination of Location present on Dashboard >> Location for Rolling Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="LocationPaginationR")
    public Object[][] dataProvider() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_LPaginationR_Data");
		Setup.log.info("\n For To validate Pagination of Location present on Dashboard >> Location for Rolling, DataFile is used from "+Filelocation);
        return object;    
    } 
}
