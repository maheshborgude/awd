package testcases.dashboard.location.locationList.nonRolling;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class TC_LocationBubbleCountNR extends Setup {
	/*@Author Awadhesh Sengar
	 * 12/15/2017
	 * Testcase to verify if location count displayed in Dahboard side bar matches with the database count.
	 */
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="LocationBubbleCountNR")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");
		log.info("\nTC To validate bubble count for Location on dashboard non rolling");
		exe.testexecute(Filelocation,"TC_LbubbleCountNR",data);
		log.info("\nTC To validate bubble count for Location on dashboard non rolling Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="LocationBubbleCountNR")
    public Object[][] dataProvider() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Dashboard_Location");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_LbubbleCountNR_Data");
		Setup.log.info("\n For To validate bubble count for Location on dashboard non rolling, DataFile is used from "+Filelocation);
        return object;    
    } 

}
