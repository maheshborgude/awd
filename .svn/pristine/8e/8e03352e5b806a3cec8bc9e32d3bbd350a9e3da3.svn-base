package testcases.administration.groupmanagement;
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
 * This test case verify Data present on Administration >>GroupManagement grid with Database
 *   1.Verify all Data present in Grid with Database
 *   2.Verify Data on basis of logged in user name
 * @author rakesh.kulkarni
 * Date 13/1/2015
 */
public class TC_UserGroupSearch extends Setup{

	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
	ExcelReader ex = new ExcelReader();


	@Test(dataProvider="ValidateSearching")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
    		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Admin_groupManagement_excel");		
			log.info("\nTC to Validate GroupManagement ValidateSearching");
			exe.testexecute(Filelocation,"TC_ValidateSearchingOfUserGroup",data);
			log.info("\nTC to Validate GroupManagement ValidateSearching Ends");
			Setup.testcase.assertAll();
	}

	@DataProvider(name="ValidateSearching")
	public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Admin_groupManagement_excel");
		Object[][] object=ex.getDataingrid(Filelocation,"TC_ValidateSearchingOfUserGroup_Data");
		Setup.log.info("For TC Validate GroupManagement Searching, DataFile is used from "+Filelocation);
		return object;    
	} 
}



