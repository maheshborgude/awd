package testcases.login.forgotpassword;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import buisness.core.ElementMethod;
import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

@Listeners({  buisness.Listeners.Screenshot.class})
public class ForgotPassword_ValidateEmail extends Setup
{
	ConfigurationManager rd=new ConfigurationManager();
	ExcelReader ex=new ExcelReader();
	TestExecutor exe=new TestExecutor();
	ElementMethod ele=new ElementMethod();
	
	// Test Case: invalid email id
	/**
	 * @author Shweta Phadnis
	 * Test Case: InValid Email ID 
	 */
	@Test(dataProvider="hybridData_ValidateEmail",priority=3)
	public void TC_ValidateEmail(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
		try
		{
			String file=System.getProperty("user.dir")+rd.read_Configfile("forgot_password_excel");
			System.out.println("Test Case: Validate Email ID Starts");
			Setup.log.info("Test Case: Validate Email ID Starts");
			exe.testexecute(file,"TC_ValidateEmail",data);
			System.out.println("Test Case: Validate Email ID Ends");
			Setup.log.info("Test Case: Validate Email ID Ends");
			Setup.testcase.assertAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Setup.log.fatal(e.toString());
		}
	}
	
	@DataProvider(name="hybridData_ValidateEmail")
	public Object[][] getDataFromUser_ValidateEmail() throws IOException, InvalidFormatException
	{
		try
		{
			String file=System.getProperty("user.dir")+rd.read_Configfile("forgot_password_excel");
			Object[][] ob=ex.getDataingrid(file,"TC_ValidateEmail_Data");
			return ob;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Setup.log.fatal(e.toString());
			return null;
		}
	}
}
