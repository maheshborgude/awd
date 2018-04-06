package testcases.rpc.resetpracticekey;

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
 * This test case validate Data of map view present on Rpc >> Map
 * This test case validate data present on UI with data given in sheet 
 * This test case compare total view of data present on UI of application 
 * Test case is pass if return result is pass else it will fail 
 * @author rakesh.kulkarni
 * Date 11/03/2016
 */
public class TC_ResetPracticeKeyView extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="ResetPracticeKeyView")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("RPC_ResetPracticeKey");		
		log.info("\nTC To validate View of Reset practice Key present on RPC ");
		exe.testexecute(Filelocation,"TC_ResetPracticeKeyView",data);
		log.info("\nTC To validate View of Reset practice Key present on RPC Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="ResetPracticeKeyView")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("RPC_ResetPracticeKey");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_ResetPracticeKeyView_Data");
		Setup.log.info("\n For TC Validate View of Reset practice Key present on RPC from "+Filelocation);
        return object;    
    } 
}
