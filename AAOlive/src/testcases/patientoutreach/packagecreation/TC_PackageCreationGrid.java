package testcases.patientoutreach.packagecreation;

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
 * This test case is used to test Patient Outreach>>Package Creation >>Package Creation Grid(Only UI)
 * 
 * @author Sachin.Gawade
 * Created Date: 16 March 2016
 */
public class TC_PackageCreationGrid extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_PackageCreationGrid")
		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("packagecreation_excel");
	    	Setup.log.info("TC_PackageCreationGrid test case starts");
	    	exe.testexecute(Filelocation,"TC_PackageCreationGrid",data);
	    	Setup.log.info("TC_PackageCreationGrid test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_PackageCreationGrid")
	    public Object[][] getDataForPackageCreationGrid() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("packagecreation_excel");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_PackageCreationGrid_Data");
	        return object;    
	    }
}

