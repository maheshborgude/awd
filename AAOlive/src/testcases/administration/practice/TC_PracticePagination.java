package testcases.administration.practice;

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
 * This test case validate Sorting Order of listed practice
 * @author rakesh.kulkarni
 * Date 20-1-2016
 */
public class TC_PracticePagination extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
	@Test(dataProvider="PracticePagination")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Admin_practice_excel");		
		log.info("\nTC To Validate Pagination Of practice");
		exe.testexecute(Filelocation,"TC_PracticePagination",data);
		log.info("\nTC To validate Validate Pagination Of practice Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PracticePagination")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("Admin_practice_excel");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PracticePagination_Data");
		Setup.log.info("\n For TC Validate Validate Pagination Of practice, DataFile is used from "+Filelocation);
        return object;    
    } 
}
