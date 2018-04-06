package buisness.core.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.google.common.collect.LinkedListMultimap;

import buisness.core.ElementMethod;
import buisness.managers.DatabaseManger;
import configuration.Setup;

public class AfterLoginUtility extends LoginUtility {

	private ElementMethod em;
	public static String CurrentSelected;
	private LinkedListMultimap<String, String> Authorities;
	
	public AfterLoginUtility(String userName, String password) 
	{
		super(userName, password);
		em =new ElementMethod();
		setAuthorities();
	}
	

	/**
	 * Check in database whether the user has authority of a particular menu or
	 * not. Note the authority checked only for the parent menu and not the child
	 * menu items.
	 * 
	 * @author  Abhishek Gaikwad
	 * @param Authority The one which need to be verified from database
	 * @return True if the User has the authority, or false if it don't
	 */
	private boolean menuAuthority(String Authority)
	{
		if(Authorities.containsKey(Authority))
			return true;
		else
			return false;
	}

	/**
	 * Sets the authorities of user in Authorities variable as per the database
	 * Note:- Function is should be called in Constructor itself.
	 */
	private void setAuthorities()
	{
		ResultSet rs=null;
		Authorities = LinkedListMultimap.create();
		String parentMenu=null,childMenu=null;
		
		String query ="select ms.Securityuid,ms.Name,ms.ParentSecurityUid from SecurityFIGUserGroup sf" 
				+ " inner join MasterSecurity MS on Ms.SecurityUid = sf.SecurityUid" 
				+ " where ms.Inactive='0' and ms.SystemDefined=1 and IsMenu=1 and InMaintainance=0 and sf.FIGUserUid in ('" + FIGUserUID +"')"
				+ " order by Ms.ListOrder,ParentSecurityUid";

		DatabaseManger.SQLserverConnection(); 
		if(userValid())
			rs = DatabaseManger.exeQuery(query);
		
		try {
			
			while(rs.next())
			{
				rs.getString("ParentSecurityUid");
				if(rs.wasNull()) // if ParentSecurityUid is null means its a parent menu
					parentMenu = rs.getString("Name");
				else // other wise child menu
				{
					childMenu=rs.getString("Name");
					Authorities.put(parentMenu, childMenu);
				}
			}
		}
		catch(Exception e)
		{
			Authorities=null;
		}
	}
	
	/**
	 * Returns the menu items both parent menu and child displayed after successful
	 * login of user in left side panel. If the item is not displayed then it clicks
	 * the parent menu and gets the Child menu. It returns parent and child menu in 
	 * form of LinkedListMultimap with key as parent menu and Value as child menu item.
	 * 
	 * @author  Abhishek Gaikwad
	 * @return LinkedListMultimap< ParentMenu, Child Menu >
	 */
	public LinkedListMultimap<String, String> getUIMenuItems()
	{
		String ParentText,ChildText;
		List<WebElement> wholeParentMenuElements,wholeChildMenuElements;
		LinkedListMultimap<String, String> AuthoritiesAsPerUI = LinkedListMultimap.create();

		wholeParentMenuElements = em.getWebElements("xpath", ".//*[@id='ctl00_MainContent_divLeftMenu']/ul/*/a/span");
		for(WebElement currentParentElement : wholeParentMenuElements)
		{
			ParentText = currentParentElement.getText();
			Setup.log.info(ParentText);
			if(ParentText.equals("Logout") == false)
			{
				wholeChildMenuElements = currentParentElement.findElements(By.xpath("../../ul/li/a"));
				for(WebElement currentChildElement : wholeChildMenuElements)
				{
					if(currentChildElement.isDisplayed()==false)
						currentParentElement.click();
					ChildText = currentChildElement.getText();
					AuthoritiesAsPerUI.put(ParentText, ChildText);
				}
			}
		}
		return AuthoritiesAsPerUI;
	}
	/**
	 * Returns the parent menu which is selected on left side panel
	 * 
	 * @author  Abhishek Gaikwad
	 * @return String containing menu which is selected, or if no menu is selected returns null
	 */
	public String getUIParentMenuSelected()
	{
		List<WebElement> wholeParentMenuElements;
		WebElement selectedElement;
		wholeParentMenuElements = em.getWebElements("xpath", ".//*[@id='ctl00_MainContent_divLeftMenu']/ul/*/ul");
		for(WebElement currentParentElement : wholeParentMenuElements)
			if(currentParentElement.getCssValue("display").equals("block"))
			{
				selectedElement = currentParentElement.findElement(By.xpath("../a/span"));
				return selectedElement.getText();
			}
		return null;
	}/*
	public String getUIChildMenuSelected()
	{
		List<WebElement> wholeChildMenuElements;
		WebElement selectedElement;
		String currentSelectedParent;
		
		currentSelectedParent = getUIParentMenuSelected();
		
		
		return new String();
	} */
	/**
	 * Check if the user has been forced to change password on log in
	 * if the user has forced to change password the checks if the 
	 * dialog for new password appears or not
	 * 
	 * @author  Abhishek Gaikwad
	 * @return True if Password change dialog appears or returns false
	 */
	public boolean verifyForcedReset()
	{
		String query;
		List<String> result;
		DatabaseManger.SQLserverConnection();
		query = "select fs.ForcePasswordReset c from figuser fu inner join FIGUserSecureData fs "
				+ "on fu.FIGUserUid = fs.FIGUserSecureDataUid where LoginName = '"+ userName +"'";
		result = DatabaseManger.getQuery(query);
		if(result.contains("1"))
		{
			if(em.isElementPresent(By.xpath(".//*[@id='ModalResetPassword']/div/div")) )
			{
				Setup.log.info("Test-Case: Forced password reset.\tStatus: Pass");
				//em.click_element("xpath", ".//*[@id='ModalResetPassword']/div/div/div[1]/button");
				Setup.testcase.assertTrue(true);
				return true;
			}
			else
			{
				Setup.log.info("Test-Case: Forced password reset.\tStatus: Fail");
				Setup.testcase.fail();
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Check if the password entered in both the dialog matches or not
	 * if both does not match a error roaster should appear and display
	 * appropriate error
	 * 
	 * @author  Abhishek Gaikwad
	 * @param Pass1 - The password entered in 
	 * @param Pass2
	 * @return True if appropriate roaster appears or return False 
	 * 
	 */
	public boolean verifyForcedResetNewPassword(String Pass1,String Pass2)
	{
		String actual = em.gettext("xpath", ".//*[@id='divmessage']/div/table/tbody/tr/td[2]");
		String expected = "New password and Re-Entered password does not match.";
		if(Pass1.equals(Pass2)==false)
		{
			if(actual.equals(expected))
			{
				Setup.log.info("Test-Case: Forced password reset,Both password does not match.\tStatus: Pass");
				Setup.testcase.assertTrue(true);
				return true;
			}
			else
			{
				Setup.log.info("Test-Case: Forced password reset,Both password does not match.\tStatus: Fail");
				Setup.testcase.assertTrue(true);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * Check if the password  does matches the password policy the check if
	 * the roaster with appropriate error appears or not
	 * 
	 * @author  Abhishek Gaikwad
	 * @param Pass1 - The first password passed in New password dialog
	 * @param Pass2 - The second password passed in New password dialog
	 * @return True Valid error message is displayed in roaster
	 */
	public boolean verifyForcedResetPolicy(String Pass1,String Pass2)
	{
		String actual = em.gettext("xpath", ".//*[@id='divmessage']/div/table/tbody/tr/td[2]");
		
		if(Pass1.toLowerCase().contains(userName.toLowerCase()))
		{
			String expected="Password should not contain User Name.";
			if(actual.equals(expected))
			{
				Setup.log.info("Test-Case: Forced password reset,password contains username.\tStatus: Pass");
				Setup.testcase.assertTrue(true);
				return true;
			}
			else
			{
				Setup.log.info("Test-Case: Forced password reset,password contains username.\tStatus: Fail");
				Setup.testcase.assertTrue(true);
				return false;
			}
		}
		else if(Pass1.equals(Pass2)==true && Pass1.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$")==false)
		{
			String expected = "New password does not meet its requirement.";
			if(actual.equals(expected))
			{
				Setup.log.info("Test-Case: Forced password reset, password policy does not match.\tStatus: Pass");
				Setup.testcase.assertTrue(true);
				return true;
			}
			else
			{
				Setup.log.info("Test-Case: Forced password reset, password policy does not match.\tStatus: Fail");
				Setup.testcase.assertTrue(true);
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Check if the user name appear after the user has logged in (i.e Welcome SomeUser), 
	 * is as per the user name used to log in 
	 * 
	 * @author  Abhishek Gaikwad
	 * @return True if the appropriate name is appeared or else false
	 */
	public boolean verifyLoggedUser()
	{
		
		String userFromLoginPage = em.gettext("xpath",".//*[@id='ctl00_HeaderContent_lblLoggedeUserName']");
		//Setup.log.info(userFromLoginPage);
		if(userFromLoginPage.equals(userName))
		{
			Setup.log.info("Test-Case: Vaild user name on logged in page.\tStatus: Pass");
			Setup.testcase.assertTrue(true);
			return true;
		}
		
		Setup.log.info("Test-Case: Vaild user name on logged in page.\tStatus: Fail");
		Assert.assertEquals(userFromLoginPage, userName);
		return false;
		
		
	}
	
	public boolean verifyFirstPracticeSelected()
	{
		String attribute = em.getattribute("xpath", ".//*[@id='tblPracticeDropDownList']/tbody/tr[2]", "Class");
		if(attribute.equals("rowselected"))
			return true;
		else
			return false;
	}
	
	/**
	 * Check the practices appear in the practice list matches the
	 * practice in database. Please note that the practice are checked
	 * according to the list order in database
	 * 
	 * @author  Abhishek Gaikwad
	 */
	public boolean verifyPracticeList()
	{
		// TODO: Needs to be modified
		int practiceCount,flag=0;
		ResultSet rs;
		String uiValue[] = null;
		String query=null;
	    List<WebElement> e;
	    switch(userType)
	    {
	    	case SinglePractice:
	    		query = "Select p.externalID,p.ListName from FIGuser FG inner join FIGUserSecureData FSD on FG.FIGUserUid = FSD.FIGUserSecureDataUid  inner join Individual I on FG.FIGUserUid = I.IndividualUid  inner join practice P on P.PracticeUid = I.PracticeUid  where  p.Inactive=0 and p.ClinicalDataRepositoryUid is not null and fg.LoginName='"+ userName +"' order by p.ListName";
	    		break;
	    	
	    	case MultiPractice:
	    		query = "Select p.externalID,p.ListName from FIGuser FG  inner join FIGUserSecureData FSD on FG.FIGUserUid = FSD.FIGUserSecureDataUid  inner join Individual I on FG.FIGUserUid = I.IndividualUid  inner join FIGUserAuthorization FA on FA.FIGUserUid = FG.FIGUserUid  inner join practice P on P.PracticeUid = FA.ObjectUid and FA.ObjectName = 'practice'  where P.Inactive=0 and p.ClinicalDataRepositoryUid is not null and fg.LoginName='"+ userName +"' order by p.ListName";
	    		break;
	    	
	    	case Super:
	    		query= "select externalID,ListName  from practice p inner join ClinicalDataRepository cdr on cdr.ClinicalDataRepositoryUid = p.ClinicalDataRepositoryUid where p.Inactive ='0'  order by p.ListName";
	    	
	    	case Invaild:
	    	default:
	    		break;

	    }
	    
	    Setup.log.info(query);
	    DatabaseManger.SQLserverConnection();
	    rs = DatabaseManger.exeQuery(query);
	    try 
	    {	   
			 practiceCount=Integer.parseInt(	em.getattribute("xpath", ".//*[@id='tblPracticeDropDownList']", "data-practicecount"));
	    
			 for(int i=0; i<practiceCount  ; i+=(e.size()-1) )
			 {
				 e = em.getWebElements("xpath", ".//*[@id='tblPracticeDropDownList']/tbody/tr");
				 for(int j=1; j< e.size() ; j++)
				 {
					 rs.next();
					 uiValue = e.get(j).getText().split(" ",2);
					 if(!rs.getString("externalID").equals(uiValue[0]) && !rs.getString("ListName").equals(uiValue[1]))
					 	{
						 System.out.print("UI value: " +e.get(j).getText());
						 Setup.log.info("\tDbValue: " + rs.getString("externalID")+"," +  rs.getString("ListName"));
						 uiValue = e.get(j).getText().split(" ");
						 flag=1;
					 	}
				 }
				 //go to next page
				 if(em.isElementPresent(By.xpath(".//*[@id='divMasterPagerPractice']/a[last()-1]")))
				 {
					 em.click_element("xpath", ".//*[@id='divMasterPagerPractice']/a[last()-1]");
				 }
				 else
					 break;
			 }
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	    if(flag==0)
	    {
	    	Setup.log.info("Test Case: Verification of practice List/tStatus:Pass");
	    	Setup.testcase.assertTrue(true);
			return true;
	    }
	    else
	    {
	    	Setup.log.info("Test Case: Verification of practice List/tStatus:Fail");
	    	Setup.testcase.fail();
	    	return false;
	    }
	}
	
	/**
	 * Check if user has no module authority then user should be logged in
	 * and redirected to Help page
	 * 
	 * @author  Abhishek Gaikwad
	 * @param startInSelection The module of start in selected during login
	 * @return true user is on Help page or false
	 */
	public boolean verifyStartInNoAuthority(String startInSelection)
	{
		if(Authorities.isEmpty())
		{
			if(startInSelection.isEmpty())
			{
				if(getUIParentMenuSelected().equals("Help") )
				{
					Setup.log.info("Test case: No authority\tStatus:Pass");
					Setup.testcase.assertTrue(true);
					return true;
				}
				else
				{
					Setup.log.info("Test case: No authority\tStatus:Fail");
					Setup.testcase.fail();
					return false;
				}
			}
			else
			{
				if(em.isElementPresent(By.xpath(".//*[@id='ctl00_MainContent_lblErrHeaderMsg']")))
				{
					Setup.log.info("Test case: No authority\tStatus:Pass");
					Setup.testcase.assertTrue(true);
					return true;
				}
				else
				{
					Setup.log.info("Test case: No authority\tStatus:Fail");
					Setup.testcase.fail();
					return false;
				}
			}
			
		}
		return false;
	}
	/**
	 * Check if the user has partial authority then checks if start in
	 * module selected as per his authority then it should be jumped 
	 * on that page or Error message is displayed or not
	 * 
	 * @author  Abhishek Gaikwad
	 * @param startInSelection The module of start in selected during login
	 * @return True if One of above mentioned condition is successful or false
	 */
	public boolean verifyStartInPart(String startInSelection)
	{
		if(menuAuthority(startInSelection) == false && startInSelection != null)
		{
			if(em.isElementPresent(By.xpath(".//*[@id='ctl00_MainContent_lblUserDefinedError']")))
			{
				Setup.log.info("Test case: Invaild StartIn Menu selection\tStatus:Pass");
				Setup.testcase.assertTrue(true);
				return true;
			}
			else
			{
				Setup.log.info("Test case: Invaild StartIn Menu selection\tStatus:Fail");
				Setup.testcase.fail();
				return false;
			}
		}
		return false;
	}
	
	public boolean verifyStartInDefaultAuthority()
	{
		if(menuAuthority(CurrentSelected) == false )
		{
			String query;
			ResultSet rs=null;
			
			query = "select ms.Name from SecurityFIGUserGroup sf " 
					+ "inner join MasterSecurity MS on Ms.SecurityUid = sf.SecurityUid "
					+ "where ms.Inactive='0' and ms.ParentSecurityUid is null and "
					+ "sf.FIGUserUid in ('"+FIGUserUID+ "') order by Ms.ListOrder";
			
			DatabaseManger.SQLserverConnection(); 
			if(userValid())
				rs = DatabaseManger.exeQuery(query);
			try 
			{
				if(rs.next())
				{
					if(getUIParentMenuSelected().equals(rs.getString("Name")) )
					{
						Setup.log.info("Test case: Default StartIn authority\tStatus:Pass");
						Setup.testcase.assertTrue(true);
						return true;
					}
					else
					{
						Setup.log.info("Test case: Default StartIn authority\tStatus:Fail");
						Setup.testcase.fail();
						return false;
					}
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 *
	 * Check if the user with a valid authority of module, when makes a
	 * start in module selection then is jumped on that page or not
	 * 
	 * @author  Abhishek Gaikwad
	 * @param startInSelection The module of start in selected during login
	 * @return True if user is jumped on appropriate page or false
	 */
	public boolean verifyStartInValidAuthority(String startInSelection)
	{
		if(menuAuthority(startInSelection) == true )
		{
			if(getUIParentMenuSelected().equals(startInSelection))
			{
				Setup.log.info("Test case: Valid StartIn Menu selection\tStatus:Pass");
				Setup.testcase.assertTrue(true);
				return true;
			}
			else
			{
				Setup.log.info("Test case: valid StartIn Menu selection\tStatus:Fail");
				Setup.testcase.fail();
				return false;
			}
		}
		return false;
	}
	/**
	 * Check if particular module is under Maintainance by verifying InMaintainance 
	 * column in database, if the module is under Maintainance then the appropriate
	 * page should be displayed
	 * 
	 * @author  Abhishek Gaikwad
	 * @param startInSelection - The module of start in selected during login
	 * @return True if appropriate page is displayed or false
	 */
	public boolean verifyStartInUnderMaintainance(String startInSelection)
	{
		if(menuAuthority(startInSelection) == true )
		{
			
			String query;
			ResultSet rs;
			query = "select ms2.InMaintainance from MasterSecurity Ms inner join MasterSecurity MS2  "
					+ "on ms.SecurityUid = Ms2.ParentSecurityUid where ms.Inactive=0 and ms.IsMenu=1 "
					+ "and ms.Name = '"+startInSelection+ "' order by ms.ListOrder ";
			rs = DatabaseManger.exeQuery(query);			
			try {
				if(rs.next())
				{
					if(rs.getString("InMaintainance").equals("1"))
					{
						String actual = em.gettext("xpath", ".//*[@id='aspnetForm']/div[3]/div[2]/div/div/section/section/div/div/h1");
						String execepted = "We�ll be back soon!";
						if( actual.contains(execepted))
						{
							Setup.log.info("Test case: Under maintenance.\tStatus:Pass");
							Setup.testcase.assertTrue(true);
							return true;
						}
						else
						{
							Setup.log.info("Test case: Under maintenance.\tStatus:Fail");
							Setup.testcase.fail();
							return false;
						}
					}
				}
				else
					Setup.log.info("Invalid Menu specified in Startin");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static String getFIGUerUID() 
	{
		ElementMethod em = new ElementMethod();
		String userFromLoginPage = em.gettext("xpath",".//*[@id='ctl00_ctl00_HeaderContent_lblLoggedeUserName']");
		userFromLoginPage = em.gettext("xpath",".//*[@id='ctl00_ctl00_HeaderContent_lblLoggedeUserName']");
		String query ="Select Figuseruid from figUser where loginname='" + userFromLoginPage + "'";
		DatabaseManger.SQLserverConnection();
		ResultSet rs = DatabaseManger.exeQuery(query);
		try
		{
		if(rs.next())
			return rs.getString("Figuseruid");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	/*public boolean verifyStartIn(String startInSelection)
	{
		
		if(menuAuthority(startInSelection) == false && startInSelection != null)
		{
			if(em.isElementPresent(By.xpath(".//*[@id='ctl00_MainContent_lblUserDefinedError']")))
			{
				Setup.log.info("Test case: Invaild StartIn Menu selection\tStatus:Pass");
				Setup.APPLICATION_LOGS.info("Test case: Invaild StartIn Menu selection\tStatus:Pass");
				testcase.assertTrue(true);
			}
			else
			{
				Setup.log.info("Test case: Invaild StartIn Menu selection\tStatus:Fail");
				Setup.APPLICATION_LOGS.error("Test case: Invaild StartIn Menu selection\tStatus:Fail");
				testcase.fail();
			}
		}
		else if(menuAuthority(startInSelection) == true )
		{
			if(getUIMenuSelected().equals(startInSelection))
			{
				Setup.log.info("Test case: Valid StartIn Menu selection\tStatus:Pass");
				Setup.APPLICATION_LOGS.info("Test case: Valid StartIn Menu selection\tStatus:Pass");
				testcase.assertTrue(true);
			}
			else
			{
				Setup.log.info("Test case: valid StartIn Menu selection\tStatus:Fail");
				Setup.APPLICATION_LOGS.error("Test case: valid StartIn Menu selection\tStatus:Fail");
				testcase.fail();
			}
		}
		return true;
	}*/
}
