package testcases.mips;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

@Listeners({ buisness.Listeners.Screenshot.class })
public class TC_Verfiymipsprovidergrid extends Setup {ConfigurationManager rd=new ConfigurationManager();
TestExecutor exe=new TestExecutor();
ExcelReader ex= new ExcelReader();

@Test(dataProvider="TC_VerifymipsProviderGrid")
public void testBlankPassword(Hashtable <String,String> data) throws IOException, InvalidFormatException
{
	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("MipsProviderexcell");
	Setup.log.info("\nTest Case: TC_Verifywelcomepage starts");
	exe.testexecute(Filelocation,"TC_VerifymipsProviderGrid",data);
	Setup.log.info("Test Case: TC_VerifymipsProviderGrid");
	Setup.testcase.assertAll();
}

@DataProvider(name="TC_VerifymipsProviderGrid")
public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
{
    String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("MipsProviderexcell");
    Object[][] object=ex.getDataingrid(Filelocation,"TC_VerifymipsProviderGridData");
    return object;    
}
}
