package buisness.keywords.login;

import java.io.IOException;

import buisness.keywords.Common;
import testcases.login.forgotpassword.ForgotPassword_Utility;

public class ForgotPassword extends Common{

	ForgotPassword_Utility fpu=new ForgotPassword_Utility(); 

	@Override
	public String meth(String elementmethod,String action,String locator,String...data)
	{
		result=super.meth(elementmethod, action, locator, data);
		try 
		{
			if (action.equalsIgnoreCase("validate_username"))
			{
				result=fpu.check_username_empty(data[0]);
				fpu.s_assert.assertAll();
			}
			else if (action.equalsIgnoreCase("check_email"))
			{
				result=fpu.check_email(data[0]);
				fpu.s_assert.assertAll();
			}
			else if (action.equalsIgnoreCase("validate_email"))
			{
				result=fpu.validate_email(data[0],data[1]);
				fpu.s_assert.assertAll();
			}
			else if (action.equalsIgnoreCase("validate_email_db"))
			{
				result=fpu.validate_db_email(data[0],data[1]);
				fpu.s_assert.assertAll();
			}
			else if (action.equalsIgnoreCase("validate_enter"))
			{
				result=fpu.validate_enter(data[0],data[1]);
				fpu.s_assert.assertAll();
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return result;
	} 
}
