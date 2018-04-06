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
 * This test case verify Data present on Administration >>GroupManagement >> Associated User grid with Database
 *   1.Verify all Data present in Grid with Database
 *   2.Verify Data on basis of logged in user name
 * @author rakesh.kulkarni
 * Date 28/1/2015
 */
public class TC_AssociatedUsersSort extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="ValidateSortingOfAssociatedUser")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Admin_groupManagement_excel");		
		log.info("\nTC To validate sorting order of Associated User");
		exe.testexecute(Filelocation,"TC_ValidateSortingOfAssociatedUser",data);
		log.info("\nTC To validate sorting order of Associated User Ends");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="ValidateSortingOfAssociatedUser")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Admin_groupManagement_excel");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_ValidateSortingOfAssociatedUser_Data");
		Setup.log.info("\n For TC Validate Total GroupManagement, DataFile is used from "+Filelocation);
        return object;    
    } 

}
