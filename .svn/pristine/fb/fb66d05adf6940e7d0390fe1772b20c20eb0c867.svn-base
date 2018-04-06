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
 * This test case validate Pagination of Patient Drill Down present on Performance Trend >> Dashboard >> Practice For nonRolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass then if return result is pass else it will fail
 * This test case validate Pagination of Patient Drill Down present on Performance Trend >> Dashboard >> Practice For nonRolling
 * @author rakesh.kulkarni
 * Date 15/03/2016
 */
public class TC_PracticePerformancrTrendPatientDrillDownPaginationNR extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="PracticePerformancrTrendPatientDrillDownPaginationNR")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");		
		log.info("\nTC To validate Pagination of Patient Drill Down present on Performance Trend > present on Dashboard > practice for nonRolling");
		exe.testexecute(Filelocation,"TC_PPTPatientDDPaginatNR",data);
		log.info("\nTC To validate Pagination of Patient Drill Down present on Performance Trend > present on Dashboard > practice for nonRolling Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PracticePerformancrTrendPatientDrillDownPaginationNR")
    public Object[][] dataProvider() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("dashboard_practice");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PPTPatientDDPaginatNR_Data");
		Setup.log.info("\n TC To validate Pagination of Patient Drill Down present on Performance Trend > present on Dashboard > practice for nonRolling, DataFile is used from "+Filelocation);
        return object;    
    } 
}
