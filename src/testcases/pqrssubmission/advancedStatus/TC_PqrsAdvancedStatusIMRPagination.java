package testcases.pqrssubmission.advancedStatus;

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
 * This test case validate Data of provider present on PQRS Submission >> Submission 2015 
 *      >> Report PQRS Measures Milestone >>PQRS Advanced Status 
 * This test case validate pagination an compare data after every pagination with valid data present under the database
 * @author rakesh.kulkarni
 * Date 03/03/2016
 */
public class TC_PqrsAdvancedStatusIMRPagination extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
	@Test(dataProvider="PqrsAdvancedStatusIMRPagination")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");		
		log.info("\nTC To validate Pagination of PQRS Advanced Status IMR on Report PQRS Measures Milestone");
		exe.testexecute(Filelocation,"TC_PqrsAdvancedStatusIMRPagination",data);
		log.info("\nTC To validate pagination of PQRS Advanced Status IMR present on Report PQRS Measures Milestone Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PqrsAdvancedStatusIMRPagination")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PQRSSubmission_Submission");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PqrsAdvancedStatusIMRPagination_Data");
		Setup.log.info("\n For TC validate pagination of PQRS Advanced Status IMR present on Report PQRS Measures Milestone, DataFile is used from "+Filelocation);
        return object;    
    } 
}
