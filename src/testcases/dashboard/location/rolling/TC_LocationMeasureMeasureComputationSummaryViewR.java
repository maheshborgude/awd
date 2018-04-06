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
 * This test case validate View of Measure Computation Summary present on Dashboard >> Location >> Measure For Rolling
 * This test case validate data present in Grid
 * This test case validate data present in Grid with data present in Database of eligible Provider
 * This test case compare total view of data present on UI of application
 * Test case is pass if return result is pass else it will fail
 * This test case validate View of Measure Computation Summary present on Dashboard >> Location >> Measure For Rolling
 * @author rakesh.kulkarni
 * Date 30/03/2016
 */
public class TC_LocationMeasureMeasureComputationSummaryViewR extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="LocationMeasureMeasureComputationSummaryViewR")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");
		log.info("\nTC To validate View of Measure Computation Summary present on Dashboard >> Location for Rolling");
		exe.testexecute(Filelocation,"TC_LMeasureMCSViewR",data);
		log.info("\nTC To validate View of Measure Computation Summary present on Dashboard >> Location for Rolling Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="LocationMeasureMeasureComputationSummaryViewR")
    public Object[][] dataProvider() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_LMeasureMCSViewR_Data");
		Setup.log.info("\n For TC To validate View of Measure Computation Summary present on Dashboard >> Location For Rolling, DataFile is used from "+Filelocation);
        return object;    
    } 
}
