package buisness.keywords.login;

import buisness.core.login.AfterLoginUtility;
import buisness.core.login.BeforeLoginUtility;
import buisness.keywords.Common;
import configuration.Setup;
import testcases.logout.Logout;

public class Login extends Common{

	private AfterLoginUtility al;
	
	@Override
	public String meth(String elementmethod,String action,String locator,String...data)
	{
		result=super.meth(elementmethod, action, locator, data);
		try{
		if(result != null)
		{
			return result;
		}
		else if(action.equalsIgnoreCase("BlankUser"))
          {
			  BeforeLoginUtility bl = new BeforeLoginUtility(data[0], data[1]);
              result=bl.verifyBlankUserName()? "Pass" : "Fail";
              if(bl.userLoggedIN())
              {
            	  Logout log_ot=new Logout();
				  log_ot.test();
              }
              //bl.testcase.assertAll();
          }
         else if(action.equalsIgnoreCase("BlankPassword"))
          {
        	 BeforeLoginUtility bl = new BeforeLoginUtility(data[0], data[1]);
              result=bl.verifyBlankPassword()? "Pass" : "Fail";
              if(bl.userLoggedIN())
              {
            	  Logout log_ot=new Logout();
            	  log_ot.test();
              }
              //bl.testcase.assertAll();
          }
          else if(action.equalsIgnoreCase("UserInactive"))
          {
        	  BeforeLoginUtility bl = new BeforeLoginUtility(data[0], data[1]);
              result=bl.verifyUserActive()? "Pass" : "Fail";
              //bl.testcase.assertAll();
          }
          else if(action.equalsIgnoreCase("PracticeInactive"))
          {
        	  BeforeLoginUtility bl = new BeforeLoginUtility(data[0], data[1]);
              result=bl.verifyPracticeInactive()? "Pass" : "Fail";
              //bl.testcase.assertAll();
          }
          else if(action.equalsIgnoreCase("CDRNotPresent"))
          {
        	  BeforeLoginUtility bl = new BeforeLoginUtility(data[0], data[1]);
              result=bl.verifyCDRAbsent() ?  "Pass" : "Fail";
              //bl.testcase.assertAll();
          }
          else if(action.equalsIgnoreCase("InvaildUser"))
          {
        	  BeforeLoginUtility bl = new BeforeLoginUtility(data[0], data[1]);
              result=bl.verifyVaildUser()? "Pass" : "Fail";

          }
          else if(action.equalsIgnoreCase("ForceReset"))
          {
              al = new AfterLoginUtility(data[0], data[1]);
              if(al.verifyForcedReset()==false)
            	  result="fail";
              //al.testcase.assertAll();
              
          }
          else if(action.equalsIgnoreCase("ForceResetPasswordDoesNotMatch"))
          {
              if( al.verifyForcedResetNewPassword(data[0], data[1])==false)
            	  result="fail";
             // al.testcase.assertAll();
              
          }
          else if(action.equalsIgnoreCase("ForceResetPasswordPolicy"))
          {
              if( al.verifyForcedResetPolicy(data[0], data[1])==false)
            	  result="fail";
              //al.testcase.assertAll();
          }
          else if(action.equalsIgnoreCase("LoggedInUser"))
          {
              al = new AfterLoginUtility(data[0], data[1]);
              if(al.userLoggedIN())
        	  {
            	  result = al.verifyLoggedUser()? "Pass" : "Fail";
            	  Logout log_ot=new Logout();
            	  log_ot.test();
        	  }
        	  else
        		  System.out.println("User was unable to login");
             // al.testcase.assertAll();
              
          }
          else if(action.equalsIgnoreCase("Login"))
          {
              al = new AfterLoginUtility(data[0], data[1]);
          }
          else if(action.equalsIgnoreCase("Logout"))	
          {	
              Logout log_ot=new Logout();
              log_ot.test();

          }

          else if(action.equalsIgnoreCase("StartInDefaultAuthority"))
          {
              al = new AfterLoginUtility(data[0], data[1]);
       		  if(al.userLoggedIN())
       		  {
       			  result=al.verifyStartInDefaultAuthority()? "Pass" : "Fail";
       			  Logout log_ot=new Logout();
       			  log_ot.test();
       		  }
       		  else
       			  System.out.println("User was unable to login");
        	  //al.testcase.assertAll();
              
          }
          else if(action.equalsIgnoreCase("StartInNoAuthority"))
          {
        	  if(al!=null)
        	  {
        		  if(al.userLoggedIN())
        		  {
        			  result=al.verifyStartInNoAuthority(data[0])? "Pass" : "Fail";
        			  Logout log_ot=new Logout();
        			  log_ot.test();
        		  }
        		  else
        			  System.out.println("User was unable to login");
        	  }
        	  else
        	  {
        		  System.out.println("Error: login action should be used before start in");
        		  Setup.log.fatal("login action should be used before start in");
        	  }
        	  //al.testcase.assertAll();
              
          }
          else if(action.equalsIgnoreCase("StartInPartAuthority"))
          {
        	  if(al!=null)
        	  {
        		  if(al.userLoggedIN())
        		  {
        			  result=al.verifyStartInPart(data[0])? "Pass" : "Fail";
        			  Logout log_ot=new Logout();
        			  log_ot.test();
        		  }
        		  else
        			  System.out.println("User was unable to login");
        	  }
        	  else
        	  {
        		  System.out.println("Error: login action should be used before start in");
        		  Setup.log.fatal("login action should be used before start in");
        	  }
        	  //al.testcase.assertAll();
              
          }
          else if(action.equalsIgnoreCase("StartInValidAuthority"))
          {
        	  if(al!=null)
        	  {
        		  if(al.userLoggedIN())
        		  {
        			  result=al.verifyStartInValidAuthority(data[0])? "Pass" : "Fail";
        			  Logout log_ot=new Logout();
        			  log_ot.test();
        		  }
        		  else
        			  System.out.println("User was unable to login");
        	  }
        	  else
        	  {
        		  System.out.println("Error: login action should be used before start in");
        		  Setup.log.fatal("login action should be used before start in");
        	  }
        	  //al.testcase.assertAll();
              
          }
          else if(action.equalsIgnoreCase("StartInUnderMaintainance"))
          {
        	  if(al!=null)
        	  {
        		  if(al.userLoggedIN())
        		  {
        			  result=al.verifyStartInUnderMaintainance(data[0])? "Pass" : "Fail";
        			  Logout log_ot=new Logout();
        			  log_ot.test();
        		  }
        		  else
        			  System.out.println("User was unable to login");
        	  }
        	  else
        	  {
        		  System.out.println("Error: login action should be used before start in");
        		  Setup.log.fatal("login action should be used before start in");
        	  }
        	  //al.testcase.assertAll();
              
          }
          else if(action.equalsIgnoreCase("CheckFirstSelectedInPracticeList"))
          {
              al = new AfterLoginUtility(data[0], data[1]);
              if(al.userLoggedIN())
              {
            	  result=al.verifyFirstPracticeSelected() ? "Pass" : "Fail";
              }
              else
            	  System.out.println("User was unable to login");
              //al.testcase.assertAll();
              
          }
          else if(action.equalsIgnoreCase("PracticeList"))
          {
              al = new AfterLoginUtility(data[0], data[1]);
              if(al.userLoggedIN())
              {
            	  result = al.verifyPracticeList() ? "Pass" : "Fail";
            	  Logout log_ot=new Logout();
            	  log_ot.test();
              }
              else
            	  System.out.println("User was unable to login");
              //al.testcase.assertAll();
              
          }
          else if (action.equalsIgnoreCase("AutoUILogin"))
          {
        	  element.type_element("xpath", ".//*[@id='ctl00_MainContent_txtUserName']", "registry.admin");
        	  element.type_element("xpath", ".//*[@id='ctl00_MainContent_txtPassword']", "Abcd1234#");
        	  element.click_element("xpath", ".//*[@id='ctl00_MainContent_imgOk22']");
          }
          else if (action.equalsIgnoreCase("authenticate"))
          {
        	  BeforeLoginUtility bl = new BeforeLoginUtility(data[0], data[1]);
        	  if(bl.authenticateUser()) {
        		  if(bl.userLoggedIN())
                  {
                	  Logout log_ot=new Logout();
                	  log_ot.test();
                  }
        		  result="Pass";
        	  }
        	  else
        		  result="Fail";
        	  //bl.testcase.assertAll();
          }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        	
		return result;		
	}
	
}
