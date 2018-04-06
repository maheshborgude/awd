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
 * This test case validate Pagination of User Group 
 * @author rakesh.kulkarni
 * Date 20-1-2016
 */
public class TC_UserGroupPagination extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="PaginationOfUserGroup")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Admin_groupManagement_excel");		
		log.info("\nTC To Validate Pagination Of UserGroup");
		exe.testexecute(Filelocation,"TC_PaginationOfUserGroup",data);
		log.info("\nTC To validate Validate Pagination Of UserGroup Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PaginationOfUserGroup")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Admin_groupManagement_excel");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PaginationOfUserGroup_Data");
		Setup.log.info("\n For TC Validate Validate Pagination Of UserGroup, DataFile is used from "+Filelocation);
        return object;    
    } 
}
