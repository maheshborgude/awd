package testcases.login.forgotpassword;

import java.io.IOException;
import java.util.List;

//import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import buisness.core.ElementMethod;
import buisness.frameworkengine.ExcelReader;
import buisness.managers.DatabaseManger;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class ForgotPassword_Utility {
	
	ExcelReader exe=new ExcelReader();
	ConfigurationManager rd=new ConfigurationManager();
	ElementMethod ele=new ElementMethod(); 
	public SoftAssert s_assert=new SoftAssert();
	
		// Function to check: user name empty
		/**
		 * @author Shweta Phadnis
		 * Function to check: user name empty 
		 */
		public String check_username_empty(String user) throws IOException
		{
			System.out.println("User is "+user);
			try
			{
				// Check if user name is empty
				if(user.isEmpty())
				{
					System.out.println("Username Absent");
					
					if("Please enter username.".equals(ele.gettext("xpath",".//*[@id='divMessageLogin']/div/strong/table/tbody/tr/td[2]")))
					{
						Setup.testcase.assertEquals("Please enter username.", ele.gettext("xpath",".//*[@id='divMessageLogin']/div/strong/table/tbody/tr/td[2]"));
						ele.click_element("xpath", ".//*[@id='divMessageLogin']/div/button");
						return "Pass";
					}
					else
					{
						Setup.testcase.assertEquals("Please enter username.", ele.gettext("xpath",".//*[@id='divMessageLogin']/div/strong/table/tbody/tr/td[2]"));
						ele.click_element("xpath", ".//*[@id='divMessageLogin']/div/button");
						return "Fail";
					}
				}
				// check if user name is not empty
				else
				{	
					System.out.println("Username Present");
					return "Pass";
				}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				Setup.log.fatal(e.toString());
				return "Fail";
			}
		}
		
		// Function to check: email id is empty
		/**
		 * @author Shweta Phadnis
		 * Function to check: email id is empty 
		 */
		public String check_email(String email) throws IOException
		{
			System.out.println("Email ID is "+email);
			
			try
			{
				// if email id is empty
				if(email==null || email.isEmpty())
				{
					System.out.println("Email ID Absent");
					
					String msg=ele.gettext("xpath",".//*[@id='divMessageLogin']/div");
					System.out.println("Message is "+msg);
					
					//s_assert.assertEquals("pPlease provide email address.", msg.trim());
					//Setup.testcase.assertEquals("pPlease provide email address.", msg.trim());
					if(msg.trim().equals("Please provide email address."))
					{
						Setup.testcase.assertEquals("Please provide email address.", msg.trim());
						ele.click_element("xpath", ".//*[@id='divMessageLogin']/div/button");
						return "Pass";
					}
					else
					{
						Setup.testcase.assertEquals("Please provide email address.", msg.trim());
						ele.click_element("xpath", ".//*[@id='divMessageLogin']/div/button");
						return "Fail";
					}
				}
				// if email address is not empty
				else //if(!email.isEmpty())
				{
					System.out.println("Email ID Present");
					return "Pass";
				}				
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				Setup.log.fatal(e.toString());
				return "Fail";
			}			
		}
					
		
		// Function to validate: email id with regex
		/**
		 * @author Shweta Phadnis
		 * Function to validate: email id with regex 
		 */
		public String validate_email(String email, String user)
		{
			// valid email regex
			try
			{
				String valid_email_regex="^[a-zA-Z0-9/\'_.-]+@[a-zA-Z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z0-9-]{2,})$";
				System.out.println("Email ID is "+email);
				// email id does not match regex
				if(!email.matches(valid_email_regex))
				{
					String msg=ele.gettext("xpath",".//*[@id='divMessageLogin']/div");
					System.out.println("Message is "+msg);
					// check invalid email address popup
					System.out.println("Email ID pattern not matched.");
					if(msg.trim().equals("Please provide a valid email address."))
					{
						Setup.testcase.assertEquals("Please provide a valid email address.", msg.trim());
						ele.click_element("xpath",".//*[@id='divMessageLogin']/div/button");
						return "Pass";
					}
					else
					{
						Setup.testcase.assertEquals("Please provide a valid email address.", msg.trim());
						ele.click_element("xpath",".//*[@id='divMessageLogin']/div/button");
						return "Fail";
					}
				}
				// email id matches regex
				else
				{
					System.out.println("Email ID pattern matched.");
					validate_db_email(email, user);
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Setup.log.fatal(e.toString());
				return "Fail";
			}
			return "Pass";
		}
		
		// Function to validate: email id with db value
		/**
		 * @author Shweta Phadnis
		 * Function to validate: email id with db value 
		 */
		public String validate_db_email(String email, String user)
		{
			try
			{
				System.out.println("Provided Email ID "+email);
				System.out.println("Provided User Name "+user);
				// query to get email id from db
				String email_query="select i.EmailAddress as c from Individual i inner join FIGUser f on i.IndividualUid=f.FIGUserUid inner join FIGUserSecureData s on f.FIGUserUid=s.FIGUserSecureDataUid where f.LoginName='"+user+"'";
				// query to get ForcePasswordReset value from db
				String reset_query="select s.ForcePasswordReset as c from FIGUser f inner join Individual i on i.IndividualUid=f.FIGUserUid inner join FIGUserSecureData s on f.FIGUserUid=s.FIGUserSecureDataUid where f.LoginName='"+user+"'";
				// connection to db
				DatabaseManger.SQLserverConnection();
				System.out.println("Connected!!");
				// to execute query and get email id from db
				System.out.println(email_query);
				List<String> db_email_id=DatabaseManger.getQuery(email_query);
				
				System.out.println("Executed!!");
				System.out.println("Data from DB is "+db_email_id);
				// to check if size of list<String> is >0
				if(db_email_id.size()>0)
				{
					// get value of first index from list<String>
					String db_email=db_email_id.get(0);
					System.out.println("DB_mail value is "+db_email);
					// entered value and db value do not match
					if(db_email==null || !db_email.equalsIgnoreCase(email))
					{
						//validate_email(email,user);
						String msg=ele.gettext("xpath",".//*[@id='divMessageLogin']/div");
						System.out.println("Message is "+msg);
						
						System.out.println("in first block");
						
						if(msg.trim().equals("Your email id is not registered. Please contact websupport to reset your password."))
						{
							Setup.testcase.assertEquals("Your email id is not registered. Please contact websupport to reset your password.", msg.trim());
							ele.click_element("xpath",".//*[@id='divMessageLogin']/div/button");
							return "Pass";
						}
						else
						{
							Setup.testcase.assertEquals("Your email id is not registered. Please contact websupport to reset your password.", msg.trim());
							ele.click_element("xpath",".//*[@id='divMessageLogin']/div/button");
							return "Fail";
						}
						//s_assert.assertEquals("Your email id is not registered. Please contact websupport to reset your password.", msg.trim());
						
						//ele.click_element("xpath",".//*[@id='divMessageLogin']/div/button");
					}
					// check if actual value matches expected value
					else if(db_email.equalsIgnoreCase(email))
					{
						System.out.println("I am here");
						String msg=ele.gettext("xpath",".//*[@id='divMessageLogin']/div");
						System.out.println("Message is "+ msg);
						
						System.out.println("in second block");
						
						if(msg.trim().equals("A new password has been sent to your e-mail address."))
						{
							Setup.testcase.assertEquals("A new password has been sent to your e-mail address.", msg.trim());
							ele.click_element("xpath",".//*[@id='divMessageLogin']/div/button");
							
							List<String> force_reset=DatabaseManger.getQuery(reset_query);
							String force_reset_data=force_reset.get(0);
							System.out.println("force reset value is "+force_reset_data);
							if(Integer.parseInt(force_reset_data)==1)
							{
								System.out.println("ForcePasswordReset is 1");
								System.out.println("Mail Sent!!");
							}
							else
							{
								System.out.println("ForcePasswordReset is not 1");
								System.out.println("Mail not Sent!!");
								ele.click_element("xpath",".//*[@id='forgot-box']/div/div[2]/div/a");
							}
							return "Pass";
						}
						else
						{
							Setup.testcase.assertEquals("A new password has been sent to your e-mail address.", msg.trim());
							ele.click_element("xpath",".//*[@id='divMessageLogin']/div/button");
							return "Fail";
						}
						//s_assert.assertEquals("A new password has been sent to your e-mail address.", msg.trim());
					}
				}
				// to check if size of list<String> is <=0
				else
				{
					String msg=ele.gettext("xpath",".//*[@id='divMessageLogin']/div");
					System.out.println("Message is "+msg);
					
					if(msg.trim().equals("Your email id is not registered. Please contact websupport to reset your password."))
					{
						Setup.testcase.assertEquals("Your email id is not registered. Please contact websupport to reset your password.", msg.trim());
						ele.click_element("xpath",".//*[@id='divMessageLogin']/div/button");
						return "Pass";
					}
					else
					{
						Setup.testcase.assertEquals("Your email id is not registered. Please contact websupport to reset your password.", msg.trim());
						ele.click_element("xpath",".//*[@id='divMessageLogin']/div/button");
						return "Fail";
					}
					
					//s_assert.assertEquals("Your email id is not registered. Please contact websupport to reset your password.",msg.trim());
					
					//ele.click_element("xpath",".//*[@id='divMessageLogin']/div/button");
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Setup.log.fatal(e.toString());
				return "Fail";
			}
			return "Pass";
		}
		
		// validate enter key press
		/**
		 * @author Shweta Phadnis
		 * Function to validate: enter key press
		 */
		public String validate_enter(String email,String user)
		{
			try
			{
				if(email==null || email.isEmpty())
				{
					//Setup.testcase.assertEquals("Please provide email address.", ele.gettext("xpath",".//*[@id='divMessageLogin']/div/strong/table/tbody/tr/td[2]"));
					
					System.out.println("Email ID Absent");
					
					String msg=ele.gettext("xpath",".//*[@id='divMessageLogin']/div");
					System.out.println("Message is "+msg);
					
					//s_assert.assertEquals("pPlease provide email address.", msg.trim());
					//Setup.testcase.assertEquals("pPlease provide email address.", msg.trim());
					if(msg.trim().equals("Please provide email address."))
					{
						Setup.testcase.assertEquals("Please provide email address.", msg.trim());
						ele.click_element("xpath", ".//*[@id='divMessageLogin']/div/button");
						return "Pass";
					}
					else
					{
						Setup.testcase.assertEquals("Please provide email address.", msg.trim());
						ele.click_element("xpath", ".//*[@id='divMessageLogin']/div/button");
						return "Fail";
					}
				}
				else 
				{
					//Setup.testcase.assertEquals("Your email id is not registered. Please contact websupport to reset your password.", ele.gettext("xpath",".//*[@id='divMessageLogin']/div/strong/table/tbody/tr/td[2]"));
					validate_email(email,user);
				}
				
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				Setup.log.fatal(e.toString());
				s_assert.assertTrue(false, e.getMessage());
				return "Fail";
			}
			return "Pass";
		}
}
