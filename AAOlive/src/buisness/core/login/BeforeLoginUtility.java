package buisness.core.login;

import configuration.Setup;


public class BeforeLoginUtility extends LoginUtility {

	
	public BeforeLoginUtility(String userName, String password) 
	{
		super(userName, password);
	}
	
	/**
	 * Verify the error appeared on dash board matches with expected error
	 * 
	 * @author  Abhishek Gaikwad
	 * @return true if the error matches, or if not then returns false
	 */
	public boolean verifyBlankUserName()
	{
		if( userName.isEmpty() )
			if(compareErrorWithUI("Please enter username"))
			{
				//Setup.log.info("Test-Case: User name absent or both absent.\tStatus: Pass");
				Setup.testcase.assertTrue(true);
			}
			else if (userLoggedIN() == false)
			{
				//Setup.log.info("Test-Case: User name absent or both absent.\tStatus: Fail");
				Setup.testcase.fail();
				return false;
			}
		return true;
	}
	
	
	/**
	 * Verify the error appeared on dash board matches with expected error
	 * 
	 * @author  Abhishek Gaikwad
	 * @return true if the error matches, or if not then returns false
	 */
	public boolean verifyBlankPassword()
	{
		if(password.isEmpty())
		{
			if(compareErrorWithUI("Please enter password"))
			{
			//Setup.log.info("Test-Case: Password absent.\tStatus: Pass");
				Setup.testcase.assertTrue(true);
			}
			else 
			{
				//Setup.log.info("Test-Case: Password absent.\tStatus: Fail");
				Setup.testcase.fail();
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Verify the error appeared on dash board matches with expected error
	 * 
	 * @author  Abhishek Gaikwad
	 * @return true if the error matches, or if not then returns false
	 */
	public boolean verifyUserActive()
	{
		 if( userActive()==false )
		 {
				if(compareErrorWithUI("Invalid User: Please verify the Username and Password"))
				{
					Setup.log.info("Test-Case: Inactive user login.\tStatus: Pass");
					Setup.testcase.assertTrue(true);
				}
				else
				{
					Setup.log.info("Test-Case: Inactive user login.\tStatus: Fail");
					Setup.testcase.fail();
					return false;
				}
		 }
		 return true;
	}
	
	
	/**
	 * Verify the error appeared on dash board matches with expected error
	 * 
	 * @author  Abhishek Gaikwad
	 * @return true if the error matches, or if not then returns false
	 */
	public boolean verifyCDRAbsent()
	{
		if( CDRPresent() == false)
		{
			if(compareErrorWithUI("Invalid User: Please verify the Username and Password")) 
			{
				Setup.log.info("Test-Case: CDR is not present.\tStatus: Pass");
				Setup.testcase.assertTrue(true);
			}
			else if (userLoggedIN() == false)
			{
				Setup.log.info("Test-Case: practice inactive .\tStatus: Fail");
				Setup.testcase.fail();
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Verify the error appeared on dash board matches with expected error
	 * 
	 * @author  Abhishek Gaikwad
	 * @return true if the error matches, or if not then returns false
	 */
	public boolean verifyPracticeInactive()
	{
		if( practiceActive() == false )
		{
			if(compareErrorWithUI("Invalid User: Please verify the Username and Password")) 
			{
				Setup.log.info("Test-Case: practice inactive.\tStatus: Pass");
				Setup.testcase.assertTrue(true);
				return true;
			}
			else if (userLoggedIN() == false)
			{
				Setup.log.info("Test-Case: practice inactive.\tStatus: Fail");
				Setup.testcase.fail();
				return false;
			}
		}
		return true;
	}

	/**
	 * Verify the error appeared on dash board matches with expected error
	 * 
	 * @author  Abhishek Gaikwad
	 * @return true if the error matches, or if not then returns false
	 */
	public boolean verifyVaildUser()
	{
		if(compareErrorWithUI("Invalid User: Please verify the Username and Password"))
		{
			Setup.log.info("Test-Case: Inactive user login.\tStatus: Pass");
			Setup.testcase.assertTrue(true);
		}
		else if (userLoggedIN() == false)
		{
			Setup.log.info("Test-Case: Inactive user login.\tStatus: Fail");
			Setup.testcase.fail();
			return false;
		}
		return true;
	}
}
