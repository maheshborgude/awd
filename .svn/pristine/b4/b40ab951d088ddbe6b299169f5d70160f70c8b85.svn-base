package buisness.core.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import buisness.core.ElementMethod;
import buisness.managers.DatabaseManger;
import configuration.Setup;

/**
 * 
 * @author Abhishek Gaikwad
 * @version 1.0
 *
 */
public abstract class LoginUtility {
	
	public static enum FIGUserType { SinglePractice, MultiPractice, Super, Invaild };
	protected String userName;
	protected String password;
	protected String FIGUserUID;
	protected List<String> PracticeUId;
	protected FIGUserType userType;


	/**
	 *@author  Abhishek Gaikwad
	 *@param userName - Dash-board login User name
	 *@param password - Dash-board login Password
	 */
	public LoginUtility(String userName,String password) 
	{
		this.userName = userName;
		this.password = password;
		
		PracticeUId = new  ArrayList<String>();
		//Setup.testcase  = new SoftAssert();
		
		Setup.log.info("LoginUtlity invoked with userName: " + userName +" and password: " + password );
		
		DatabaseManger.SQLserverConnection();
		setFIGUserUID();
		setUserType();
		setPracticeUID();
	}
	
	/**
	 * @author  Abhishek Gaikwad
	 * @param expected - The string to be compared with UI i.e fetched from database
	 * @return True if the data matches with the UI, or false if it does not matches
	 */
	protected boolean compareErrorWithUI(String expected)
	{
		ElementMethod element = new ElementMethod();
		if(userLoggedIN() == false)
		{
			String actual = element.gettext("xpath", ".//*[@id='login-box']/div/div[1]/fieldset/label[1]/span");
			if(actual.equals(expected))
				return true;
		}
		else
		{
			Setup.log.info("");
		}
		return false;
		
	}
	
	
	public boolean authenticateUser()
	{	
		//User Name Empty
		if( userName.isEmpty() )
		{
			if(compareErrorWithUI("Please enter username"))
			{
				Setup.log.info("Test-Case: User name absent or both absent.\tStatus: Pass");
				Setup.log.info("Test-Case: User name absent or both absent.\tStatus: Pass");
				return true;
			}
			else
				return false;
		}
		//Password Empty
		else if( password.isEmpty() )
		{
			if(compareErrorWithUI("Please enter password"))
			{
				Setup.log.info("Test-Case: Password absent.\tStatus: Pass");
				return true;
			}
			else
				return false;
		}
		//Invalid user name
		else if( userValid()==false )
		{
			if(compareErrorWithUI("Invalid User: Please verify the Username and Password"))
			{
				Setup.log.info("Test-Case: Inactive user login.\tStatus: Pass");
				return true;
			}
			else
				return false;
		}
		//User active
		else if( userActive()==false )
		{
			if(compareErrorWithUI("Invalid User: Please verify the Username and Password"))
			{
				Setup.log.info("Test-Case: Inactive user login.\tStatus: Pass");
				return true;
			}
			else
				return false;
		}
		//practice or CDR not present
		else if( practiceActive() == false || CDRPresent() == false)
		{
			if(compareErrorWithUI("Invalid User: Please verify the Username and Password")) 
			{
				Setup.log.info("Test-Case: practice inactive or CDR is not present.\tStatus: Pass");
				return true;
			}
			else
				return false;
		}
		return true;
	}
	
	/**
	 * Check whether any of the practice assigned to user has Clinical Data Repository present
	 * 
	 * @author  Abhishek Gaikwad
	 * @return True, if any of the assigned practice has CDR, False if no assigned practice has CDR
	 */
	public boolean CDRPresent()
	{
		String query;
		ResultSet rs;
		
		if(getUserType() != FIGUserType.Invaild)
		try 
		{
			query = "select ClinicalDataRepositoryUid from practice where ClinicalDataRepositoryUid is not null and PracticeUid in (";
			
			//Second Part: addition of PracticeUID in query
			for(String practice : PracticeUId) 
				query = query+ "'" +practice+ "',";
			
			// For removal of last comma "," in the query
			query = query.substring(0, query.lastIndexOf(","));
			
			//Third Part: closing bracket
			query = query + ")";
			
			rs = DatabaseManger.exeQuery(query);
			if(rs.next())
					return true;
			
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	/**
	 * Check whether any of the assigned practice to user is active
	 * 
	 * @author  Abhishek Gaikwad
	 * @return True, if any of the assigned practice is active, False if no assigned practice is active
	 */
	public boolean practiceActive()
	{
		String query;
		ResultSet rs;
		
		if(getUserType() != FIGUserType.Invaild)
		try 
		{
			query = "select Inactive from practice where Inactive=0 and PracticeUid in (";
			
			//Second Part: addition of PracticeUID in query
			for(String practice : PracticeUId) 
				query = query+ "'" +practice+ "',";
			
			// For removal of last comma "," in the query
			query = query.substring(0, query.lastIndexOf(","));
			
			//Third Part: closing bracket
			query = query + ")";
			
			rs = DatabaseManger.exeQuery(query);
			if(rs.next())
					return true;
			
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}


	/**
	 * Check if user inactive or not in database using table FIGUser and column Inactive
	 * 
	 * @author  Abhishek Gaikwad
	 * @return true if user is Inactive; false if user false
	 */
	public boolean userActive()
	{
		if( getUserType()== FIGUserType.Invaild)
			return false;
		else
		{
			String query ;
			List<String> result;
			
			query= "select Inactive c from FIGuser where LoginName='"+ this.userName + "'";
			result = DatabaseManger.getQuery(query);
		
			if(result.contains("1"))
				return false;
		}
		
		return true;
	}
	
	
	/**
	 * Checks if user name and password present in database, tables used FIGUser and FIGUserSecureData 
	 * 
	 * @author  Abhishek Gaikwad
	 * @return true only if, both user name and password present in database; or return false
	 */
	public boolean userValid()
	{
		String tempuserName,temppassword;
		
		if(userName.contains("'"))
			tempuserName = userName.replace("'", "''");
		else
			tempuserName = userName;
		if(password.contains("'"))
			temppassword = password.replace("'", "''");
		else
			temppassword = password;
		//check if user present in database and password is correct
		String query = "select count(1) c from FIGuser FG inner join FIGUserSecureData FSD on FG.FIGUserUid = FSD.FIGUserSecureDataUid" 
				+ " where fg.LoginName='"+ tempuserName +"' and fsd.Password='"+ temppassword + "'";
		List<String> result = DatabaseManger.getQuery(query);
		
		if(result.get(0).equals("1"))
			return true;
		else
		{
			userType = FIGUserType.Invaild;
			return false;
		}
	}
	

	/**
	 * Returns a FIGUID for a valid user name. Note FIGUID is returned even if the password is invalid
	 * 
	 * @return FIGUID for a user with valid user
	 */
	public String getFIGUserUID() {
		return FIGUserUID;
	}
	
	
	/**
	 * Sets a FIGUserUid from database for user
	 * 
	 * @author  Abhishek Gaikwad
	 */
	private void setFIGUserUID()
	{
		
		String query;
		ResultSet rs=null;
		query = "select FIGuserUid from FIGuser where LoginName='"+ this.userName + "'";
		rs = DatabaseManger.exeQuery(query);
		try 
		{
			if(rs.last())
				FIGUserUID = rs.getString("FIGuserUid");
			else
			{
				FIGUserUID="";
				userType = FIGUserType.Invaild;
			}
			Setup.log.info("FIGuserUid set. FIGuserUid: " + FIGUserUID);
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			Setup.log.fatal(e.toString());
		}
	}

	/**
	 * @author  Abhishek Gaikwad
	 * @return The user type i.e single, multiple, super or invalid
	 */
	public FIGUserType getUserType() {
		return userType;
	}

	private void setUserType() 
	{	
		if( userValid()==true )
		{
			String query;
			ResultSet rs;

			try 
			{	
				//For single practice User
				query = "select PracticeUid from Individual where PracticeUid is not null and IndividualUid='"+ this.FIGUserUID + "'";
				rs = DatabaseManger.exeQuery(query);
				if( rs.first()== true)
				{
					userType = FIGUserType.SinglePractice;
					return;
				}
				
				//For Multi-practice user
				query = "select ObjectUid from FIGUserAuthorization where ObjectName='practice' and ObjectUid is not null "
						+" and FIGUserUid = '" + this.FIGUserUID + "'";
				rs = DatabaseManger.exeQuery(query);
				if( rs.first()==true)
				{
					userType = FIGUserType.MultiPractice;
					return;
				}
				
				//If its a valid user and not a single or multi practice user means a Super user
				userType = FIGUserType.Super;
				
				
			} catch (Exception e) 
			{
				Setup.log.info("Error in method TestCases.Login.TestCases.setUserType. Error: " +e);
				Setup.log.fatal(e.toString());
			}
		}
	}
	
	/**
	 * Fetch PracticeUID(s) from database as per user type. Note: Inactive practice(s) are also fetched.
	 * 
	 * @author  Abhishek Gaikwad
	 */
	private void setPracticeUID()
	{
		String query;
		ResultSet rs;
		try
		{
			switch(getUserType())
			{
				case SinglePractice:
					query = "select PracticeUid from Individual where IndividualUid='"+ this.FIGUserUID + "'";
					rs = DatabaseManger.exeQuery(query);
					if(rs.next())
					{
						PracticeUId.add( rs.getString("PracticeUid") );
					}
					else
						Setup.log.info("No practice assigned");
					break;
					
				case MultiPractice:
					query = "select ObjectUid from FIGUserAuthorization where ObjectName='practice' and FIGUserUid = '" + this.FIGUserUID + "'";
					rs = DatabaseManger.exeQuery(query);
					while(rs.next())
						PracticeUId.add( rs.getString("ObjectUid") );
					break;
					
				case Super:
					query = "select PracticeUid from practice";
					rs = DatabaseManger.exeQuery(query);
					while(rs.next())
						PracticeUId.add( rs.getString("PracticeUid") );
					break;
					
				case Invaild:
					break;
					
				default:
						Setup.log.info("Something went wrong in method setPractice.");
					break;
				
			}	
		}
		catch(Exception e)
		{
			Setup.log.info("Something went wrong in method setPractice. Error:" + e);
			Setup.log.fatal(e.toString());
		}
	}
	
	
	/**
	 * Check if the user has logged in the dash-board irrespective of any condition
	 * 
	 * @author  Abhishek Gaikwad
	 * @return TRUE if the user has logged in, or False if user was unable to login
	 */
	public boolean userLoggedIN()
	{
		String URL = Setup.driver.getCurrentUrl();
		URL = URL.toLowerCase();
		if(URL.contains("login")==false)
			return true;
		else
			return false;
	}
}
