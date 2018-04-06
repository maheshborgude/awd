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
 * This test case verify Data present on Administration >>GroupManagement>>Associated User grid with Database
 *   1.Verify all Data present in Grid with Database
 *   2.Verify Data on basis of Group name
 * @author rakesh.kulkarni
 * Date 29/1/2015
 */
public class TC_AuthorizedUsersGroupsView extends Setup{

	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
	ExcelReader ex = new ExcelReader();


	@Test(dataProvider="ValidateTableOfAuthorizedUsersGroups")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
    		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Admin_groupManagement_excel");		
			log.info("\nTC to Validate Table Of Authorized Users Groups WebGrid");
			exe.testexecute(Filelocation,"TC_ValidateTableOfAuthorizedUsersGroups",data);
			log.info("\nTC to Validate Authorized Users Groups Ends");
			Setup.testcase.assertAll();
	}

	@DataProvider(name="ValidateTableOfAuthorizedUsersGroups")
	public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Admin_groupManagement_excel");
		Object[][] object=ex.getDataingrid(Filelocation,"TC_ValidateTableOfAuthorizedUsersGroups_Data");
		Setup.log.info("For TC Validate Authorized Users Groups WebGrid, DataFile is used from "+Filelocation);
		return object;    
	} 
}



