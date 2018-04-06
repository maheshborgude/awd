package testcases.login;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.testng.SkipException;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;




/**
 * Test case to login clinican user to pro portal. 
 * 
 * @author awadhesh sengar
 * Created Date: 10 october 2017
 */

public class TC_Proclinicianlogin extends Setup {

	private ConfigurationManager rd=new ConfigurationManager();
	private TestExecutor exe=new TestExecutor();
	private ExcelReader ex= new ExcelReader();
	private String fileLocation = System.getProperty("user.dir")+rd.read_Configfile("login_excel");


    @Test(dataProvider="TC_Pro_Clinicianlogin",groups = "LoginGroup")
	public void testBlankPassword(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
    	log.info("\nTest Case: TC_Pro_Clinicianlogin starts");
	//	SplashScreen screen = SplashScreen.getSplashScree();
	//	screen.appendText("\nTest Case: TC_AutoLogin starts");
    	exe.testexecute(fileLocation,"TC_Pro_Clinicianlogin",data);
    	log.info("\nTest Case: TC_Pro_Clinicianlogin end");
    	// To restrict password in Mail
    	data.put("login_pass", "**********");
	}

    @DataProvider(name="TC_Pro_Clinicianlogin")
    public Object[][] getDataFromDataproviderPassword() throws IOException, InvalidFormatException
	{
        Object[][] object=ex.getDataingrid(fileLocation,"TC_PRO_Clinicianlogin_data");
		return object;
    }
}