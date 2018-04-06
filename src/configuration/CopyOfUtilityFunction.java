package configuration;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import buisness.core.ElementMethod;
import buisness.managers.DatabaseManger;

public class CopyOfUtilityFunction extends ElementMethod  {
	
	DatabaseManger db_exe=new DatabaseManger();
	ResultSet rs1=null;
	public static String practiceuid=null;
	public static int duration=0;
	public static String duration_flag=null;
	public static int practice_tab=0;
	public static String duration_yr=null;
	public static String mq_column;

	
/**
 * @author nikita.desai
 * Function to check practice control is present or not
 * @return
 */
private String IsPracticeControlPresent()
{
	String practice_style=Setup.driver.findElement(By.xpath(".//*[@id='divMasterPracticeField']")).getAttribute("style");
	System.out.println("practice style is"+practice_style);
	if(practice_style.contains("none"))
	{
		practice_tab=1;
		return "Fail as practice not present";
	}	
	
	return "Pass";
}

/**
 * @author Nikita desai
 * Function to check pratice tab '>>' first button
 *  
 */
private void practice_firstbutton()
{
 try
 { 
	if(isElementPresent(By.xpath(".//*[@id='divMasterPagerPractice']/a[contains(text(),'<<')]")))
     {	   
        String style_first=Setup.driver.findElement(By.xpath(".//*[@id='divMasterPagerPractice']/a[contains(text(),'<<')]")).getCssValue("cursor");
	   //check first pointer is present or not If yes then Click on it	  
		  if(style_first.equals("pointer"))
			 {
				 click_element("xpath",".//*[@id='divMasterPagerPractice']/a[contains(text(),'<<')]");
				 System.out.println("Go to first page of practice");
				 Thread.sleep(1000);
			 }
     }  
 }
 catch(Exception e)
 {
	 e.printStackTrace();
	 
 }
}

/**
 * @author Nikita Desai
 * Function to Select Default (first) practice from practice Control in case  of practice is not present or practice Input is blank
 */
public String selectdefaultpractice()
{
	  String first_practice=null;
		try
		{
	       
		   click_element("xpath",".//*[@id='txtddlparentPractice']");
	       Thread.sleep(1000);
	        
	       // check practice first button
	       practice_firstbutton();
	      
		   // get first practice n UId from practice control
	       String prac_uid=null;	       
		   first_practice=gettext("xpath",".//*[@id='tblPracticeDropDownList']/tbody/tr[2]/td[2]");
		   String First_practice_query="Select practiceuid from practice where externalid like '"+first_practice+"'";
		   rs1=db_exe.SQLserverConnection(First_practice_query);
		    
		       while(rs1.next()){
		    	   prac_uid=rs1.getString(1).toLowerCase();	  
		         }
		       
		    practiceuid=prac_uid;   
		    String first_practice_xpath=".//*[@id='chkddl"+practiceuid+"']";
		    
		    // select first practice
		    if(radioselect_element("xpath",first_practice_xpath).equals("Pass"))
		     {
					 System.out.println("Default first practice is selected "+first_practice);
					 return "Pass";
					 
	         }
		   return "Pass";
		}
		catch(Exception e)
		{
			System.out.println("Excpetion for selecting default practice"+e);
			e.printStackTrace();
			Setup.log.fatal(e);
			return "Fail to select defualt practice"+first_practice;
		}
}


/************************************************************************************
 *  @author Nikita Desai
 *  Function to check  Is Menu Selected or not
 */

public String IsMenuSelected(String data)
{
	int flag_menu=0;
	try
		{
		
		   if(data.isEmpty())
	       {
	    	 System.out.println("Menu is not given");
	    	 return "Pass Not Allowed to Proceed";
	       }
		    int no_menu=Setup.driver.findElements(By.xpath(".//*[@id='ctl00_MainContent_divLeftMenu']/ul/li")).size();
			System.out.println("Total menu is"+no_menu);
			for(int i=1;i<=no_menu;i++)
			{
				     String menu_list_xpath=".//*[@id='ctl00_MainContent_divLeftMenu']/ul/li["+i+"]/a";
				     String actual_menu=Setup.driver.findElement(By.xpath(menu_list_xpath)).getText();
				     System.out.println("Actul menu is "+actual_menu);
				 //Match UI menu with given menu
				 if(actual_menu.equalsIgnoreCase(data))
				 {
				    	String style_path=".//*[@id='ctl00_MainContent_divLeftMenu']/ul/li["+i+"]";
				    	if(isElementPresent(By.xpath(style_path)))
				    	{	
				    	  String menu_style=Setup.driver.findElement(By.xpath(style_path)).getAttribute("class");
				    	  System.out.println("class is "+menu_style);
				    	  //check menu is already selected or not
				    	  if(menu_style.isEmpty())
				    	   { 
                           
				    		if(click_element("xpath",menu_list_xpath).equals("Pass"))
				    		{		
				    		    System.out.println("Menu "+actual_menu+" is selected");
				    		    flag_menu=1;
				    			return "Pass";
				    		}	
				    	  }
				    	  else if(menu_style.equals("open"))
				    	   {
				    	     System.out.println("Menu "+actual_menu+" is already selected");
				    	     flag_menu=1;
				    	     return "Pass";
				    	   }
				       }
				   //sub menu is not present for given menu 	
				     else
				     {
				    		if(click_element("xpath",menu_list_xpath).equals("Pass"))
				    		{		
				    		    System.out.println("Menu "+actual_menu+" is selected");
				    		    flag_menu=1;
				    			return "Pass";
				    		}	
				    }
				 }
				    
    		 }
		  //Menu is not present	
		  if(flag_menu==0) 
			   {
				    	 System.out.println("Menu "+data+ " is not present ");
				    	 return "Pass Not Allowed to Proceed";
			   }
			return "Pass";
		}		
	catch(Exception e)
		{
			System.out.println("Exception occurs while selecting menu"+e);
			Setup.log.fatal(e);
			return "Fail during selecting Menu"+data;
		}
		
}

/************************************************************************************
 *  @author Nikita Desai
 *  Function to check  Is SubMenu Selected or not
 */
	
public String IsSubMenuSelected(String data)
{
	int flag_smnu=0;
try
{
		
	   if(data.isEmpty())
        {
	    	      System.out.println("SubMenu is not given");
	    	      return "Pass Not Allowed to Proceed";
        }
		    int no_menu=Setup.driver.findElements(By.xpath(".//*[@id='ctl00_MainContent_divLeftMenu']/ul/li")).size();
	        System.out.println("Total menu is "+no_menu);
			for(int i=1;i<=no_menu;i++)
			{
				String style_path=".//*[@id='ctl00_MainContent_divLeftMenu']/ul/li["+i+"]/ul";
			 //check sub menu present or not 
			 if(isElementPresent(By.xpath(style_path)))
		      {
				String menu_style=Setup.driver.findElement(By.xpath(style_path)).getAttribute("style");
		    	if(menu_style.equals("display: block;"))
		    	{
				    String sub_menu_list_xpath=".//*[@id='ctl00_MainContent_divLeftMenu']/ul/li["+i+"]/ul/li";
				    int submenu=Setup.driver.findElements(By.xpath(sub_menu_list_xpath)).size();
			        for(int j=1;j<=submenu;j++)
				     { 
				        String actual_submenu_xpath=".//*[@id='ctl00_MainContent_divLeftMenu']/ul/li["+i+"]/ul/li["+j+"]/a";  
				        String actual_submenu=Setup.driver.findElement(By.xpath(actual_submenu_xpath)).getAttribute("data-module");
				        System.out.println("submenu is"+actual_submenu);
				        if(actual_submenu.equalsIgnoreCase(data))
				          {
				    	     String actual_submenu_class_xpath=".//*[@id='ctl00_MainContent_divLeftMenu']/ul/li["+i+"]/ul/li["+j+"]";
				    	     String menu_class=Setup.driver.findElement(By.xpath(actual_submenu_class_xpath)).getAttribute("class");
				    	//	  System.out.println("class is"+menu_class);
				    	      if(menu_class.equalsIgnoreCase("active"))
				    	        {	  
				    		        System.out.println("Sub menu "+data+" is already opened");
				    		        flag_smnu=1;
				    	            return "Pass";
				    	         }  
				    	      else if(menu_class.isEmpty())
				    	       {
				    		      if(click_element("xpath",actual_submenu_xpath).equals("Pass"))
					    	    	{		
					    		         System.out.println("Submenu "+data+" is selected");
					    		         flag_smnu=1;
					    			     return "Pass";
					    		     }	
				    		      else
				    		      {
				    		    	  System.out.println("Unable to click sub menu"+data);
				    		    	  flag_smnu=0;
				    		    	  return "Fail to Click Sub menu"+data;
				    		      }
					           }
				            } 
				          }
				       }
				   }
				
			  }
			  if(flag_smnu==0)
			  {
				  System.out.println("Sub menu"+data+" is not Present");
		    	  return "Pass Not Allowed to Proceed";
			  }
			
			return "Pass";
		}		
	catch(Exception e)
		{
			System.out.println("Exception occurs while selecting menu"+e);
			Setup.log.fatal(e);
			return "Fail during selecting Submenu"+data;
		}
		
}
	

/************************************************************************************
 *  @author Nikita Desai
 *  Function to Select practice
 */
	
public String selectPractice(String data)
{
   int pr_flag=0;
   String pra_uid=null;  
try	
{
		
		 if(data.isEmpty())
	     {
	    	 System.out.println("practice is not given");
	    	 return "Pass Not Allowed to Proceed";
	     }
		 
		 if(IsPracticeControlPresent().equals("Pass"))
		 {	  
		     click_element("xpath",".//*[@id='txtddlparentPractice']"); 
		     Thread.sleep(1000);
		     // check first button
		     practice_firstbutton();
		     		 
		     List<WebElement> e =null;
		     int practiceCount=Integer.parseInt(Setup.driver.findElement(By.xpath(".//*[@id='tblPracticeDropDownList']")).getAttribute("data-practicecount"));
			 do
		    {
			   		Thread.sleep(1000);
			  e = getWebElements("xpath", ".//*[@id='tblPracticeDropDownList']/tbody/tr");
			  System.out.println("Searching For practice "+data);
			 for(int j=2;j<=e.size();j++)
			 {
				 String practice_id_xpath=".//*[@id='tblPracticeDropDownList']/tbody/tr["+j+"]/td["+2+"]";
				 String practice_id=gettext("xpath",practice_id_xpath);
				
		
				 if(practice_id.equals(data))
				   {
				      String Pquery="Select practiceuid from practice where externalid like '"+practice_id+"'";
				      rs1=db_exe.SQLserverConnection(Pquery);
				     
				       while(rs1.next()){
				    	   pra_uid=rs1.getString(1).toLowerCase();	  
				          }
				       practiceuid=pra_uid;
				       String practice_xpath=".//*[@id='chkddl"+practiceuid+"']"; 
				       if(radioselect_element("xpath",practice_xpath).equals("Pass"))
					   {
						 System.out.println("practice "+practice_id+" is selected");
						 pr_flag=1;
						 return "Pass";
					   }
				       else
					   {
						 System.out.println("practice "+practice_id+" is not selected");
						 return "Fail";
					   }
				    }      
			     practiceCount--;
			 }
			 
				 
			 if(isElementPresent(By.xpath(".//*[@id='divMasterPagerPractice']/a[contains(text(),'>')]")))
			 {	 
			    String style_next=Setup.driver.findElement(By.xpath(".//*[@id='divMasterPagerPractice']/a[contains(text(),'>')]")).getCssValue("cursor");
			    if(style_next.equals("pointer"))
			      {
				       // System.out.println("> is present");
				      click_element("xpath", ".//*[@id='divMasterPagerPractice']/a[contains(text(),'>')]");
			      }
			 }
			 else 
			 {
				 if(click_element("xpath",".//*[@id='btnGridLookMasterPractice']").equals("Pass"))
					{
						System.out.println("click to 'Done'");
						
					}
					else
					{
						System.out.println("fail to click done");
						return "Fail to click Done";
					}
		     }
			 
		  Thread.sleep(2000);	 
	   }while(practiceCount!=0);
		 
		 if(pr_flag==0)
		 {
			 click_element("xpath",".//*[@id='btnGridLookMasterPractice']");
			 System.out.println("\npractice is not present in tab ");
			 return "Pass Not Allowed to Proceed";
		 }
   }
		 /// for single practice user
		 else
		 {
			 if(get_single_practiceuid().equalsIgnoreCase("pass"))
				 return "pass";
			 else
				 return "fail";
		 }
   		 return "Pass";
	   }
 catch(Exception e)
	   {

			System.out.println("Exception occurs while seleting practice"+data+" is "+e);
			e.printStackTrace();
			Setup.log.fatal(e);
			return "Fail";
	   }
/*finally
		 {
		    practice_close();
		 }*/
}
	
/**
 * @author nikita.desai
 * Function to get practiceuid of single practice user
 * 	
 * 
 */
private String get_single_practiceuid()
{
  try
  {
	 String pra_uid = null; 
	 System.out.println("practice Tab is not Present");
	 String userFromLoginPage = gettext("xpath",".//*[@id='ctl00_HeaderContent_lblLoggedeUserName']");
	 System.out.println("Login User is" + userFromLoginPage);
	 String Pquery ="Select practiceuid from Individual where IndividualUid in ( select FIGUserUid from figUser where loginname='" + userFromLoginPage + "' )";
	 rs1=db_exe.SQLserverConnection(Pquery);
    while(rs1.next()){
   	   pra_uid=rs1.getString(1).toLowerCase();	  
         }
    practiceuid=pra_uid;
	return "Pass";
}
catch(Exception e)
{
   e.printStackTrace();
   return "Fail";
}
  
}

/************************************************************************************
 * 
 *                Function to Click 'done' of practice
 */
	
/*private void practice_close() {
		if(isElementPresent(By.xpath(".//*[@id='btnGridLookMasterPractice']")))
		 {
			 if(click_element("xpath",".//*[@id='btnGridLookMasterPractice']").equals("Pass"))
				{
					System.out.println("click to 'Done'");
				}
				
		 }
		
}*/

/************************************************************************************
 *  @author Nikita Desai
 *  Function to Select Duration Monthly or Quarterly
 */

public String selectDuration(String data)
{
 try
 {
	    //duration is empty then default duration
		if(data.isEmpty())
		{
			
			 	 System.out.println("duration is not given");
		    	 return "Pass Not Allowed to Proceed";
		     
			
			
		  }
		 else
		 {	
		  //for monthly selection	
	     
		  if(data.contains("Jan") || data.contains("Feb") || data.contains("Mar") || data.contains("Apr") ||  data.contains("May") || 
		     data.contains("Jun") || data.contains("Jul") || data.contains("Aug") || data.contains("Sep") ||  data.contains("Oct") ||
		     data.contains("Nov") || data.contains("Dec"))
		   {
			  if(radioselect_element("xpath",".//*[@id='radioMonthly']").equals("Pass"))
				{
				  System.out.println("Mothly radio button is selected");  
				  if(selectDropDownByValue("xpath",".//*[@id='ddlMonth']",data).equals("Pass"))
				  {
					  System.out.println("Month "+data+" is selected");
					  String [] months=data.split(" ");
					  duration=getMonth(months[0]);
					  duration_yr=months[2];
					  duration_flag="MR";
					  mq_column="Month";
					  return "Pass";
					  
				  }
				  else
				  {
					  System.out.println("Month "+data+" is not Present");
					  return "Pass Not Allowed to Proceed";
				  }
			     }
			   else
			    {
				  System.out.println("Mothly radio button is not selected"); 
				  return "Fail to select monthly radio button";
			     }
		      }
		  //for quarterly selection
		      else if(data.contains("Q"))
		      {
			     if(radioselect_element("xpath",".//*[@id='radioQuartly']").equals("Pass"))
				  {
				       System.out.println("Quarterly radio button is selected");
				      if(selectDropDownByVisibltext("xpath",".//*[@id='ddlQuarter']",data).equals("Pass"))
				       {
					      System.out.println("quarter "+data+" is selected");
					      String [] quarters=data.split("Q");
					      duration=Integer.parseInt(quarters[1]);
					      duration_yr=quarters[0];
					      mq_column="Quarter";
					      System.out.println("Quarter "+quarters[0]);
					      duration_flag="QR";
					       return "Pass";
				        }
				      else
				         {
					        System.out.println("quarter "+data+" is not Present");
					        return "Pass Not Allowed to Proceed";
				         }
			       }
			      else
			      {
				        System.out.println("Quarterly radio button is not selected"); 
				        return "Fail to select quarterly radio button";
			       }
			     }
		  // invalid duration
		     else
		     {
			    System.out.println("Please enter proper duration");
			     return "Pass Not Allowed to Proceed";
			     
		      }
		  
		 }
		// return "Pass";
	 }
  catch(Exception e)
	{
			System.out.println("Fail to select duration"+data);
		    Setup.log.fatal(e);
			return "Fail";
	}
}

/************************************************************************************
 *  @author Nikita Desai
 *  Function to Get practice
 */
	
public String getPractice()
{
	try
	{  
			 Setup.driver.findElement(By.xpath(".//*[@id='txtddlparentPractice']")).click();
		      int practicecount=Integer.parseInt(Setup.driver.findElement(By.xpath(".//*[@id='tblPracticeDropDownList']")).getAttribute("data-practicecount"));
		      String practiceid=null;
		      do
		      {
		    	  List<WebElement> elements=Setup.driver.findElements(By.xpath(".//*[@id='tblPracticeDropDownList']/tbody/tr"));
		          for(int i=2 ; i<elements.size();i++)
		          {
		        	 String pclass=elements.get(i).getAttribute("class");
		        	 if(pclass.equalsIgnoreCase("rowselected"))
		    	      {		 
		        		String [] words=elements.get(i).getText().split(" ");
		        		practiceid=words[0];
		        	  }
		        	   practicecount=practicecount-1;
		    	   }  
		          
		           if(isElementPresent(By.xpath(".//*[@id='divMasterPagerPractice']/a[contains(text(),'>')]")))
					 {
						 click_element("xpath", ".//*[@id='divMasterPagerPractice']/a[contains(text(),'>')]");
					  }
		           else
		             {
		        	    click_element("xpath",".//*[@id='btnGridLookMasterPractice']");
		        	  }
		              
		        }while(practicecount!=0);
		      
		         
		      String Practiceuid_query="Select practiceuid from practice where externalid like '"+practiceid+"'";
		      ResultSet rs1=db_exe.SQLserverConnection(Practiceuid_query);
		      
		       while(rs1.next()){
		    	   practiceuid=rs1.getString(1).toLowerCase();	  
		          }  
		       System.out.println("selected practiceuid id is "+practiceuid);
		      
			
			return "Pass";
}
catch(Exception e)
{
			e.printStackTrace();
			System.out.println("Fail to get practice");
			Setup.log.fatal(e);
			return "Fail";
}
		
}

	
/**
 * @author nikita.desai
 * @return
 * Function to check quarter and monthly list
 */

public String checkdurationlist() {
try
{
		
		//check quarter list
		radioselect_element("xpath",".//*[@id='radioQuartly']");
		{
		  System.out.println("Quarterly radio button is selected");
		  WebElement sel = Setup.driver.findElement(By.xpath(".//*[@id='ddlQuarter']"));
		  List<WebElement> lists = sel.findElements(By.tagName("option"));
		  String []act_list=new String[lists.size()]; 
		  for(int i=0;i<lists.size();i++)  
		   {
		          String var2 = lists.get(i).getAttribute("value");
		          //System.out.println(var2);
		          act_list[i]=var2;
		        
		   }      
		  
		  String db_query="select date from Calendar where Quarter <> 0  order by date desc";
		  List<String>exp_list=db_exe.SQLserverConnection2(db_query);
		  for(int j=0;j<act_list.length;j++)
		  {
			  System.out.println("Actual list element is "+act_list[j]);
			  System.out.println("Expected list element is "+exp_list.get(j));
			  Assert.assertEquals(act_list[j],exp_list.get(j));
		  }
		  
		}
		//check monthly list
		radioselect_element("xpath",".//*[@id='radioMonthly']");
		{
			  System.out.println("Monthly radio button is selected");
			  WebElement sel = Setup.driver.findElement(By.xpath(".//*[@id='ddlMonth']"));
			  List<WebElement> lists = sel.findElements(By.tagName("option"));
			  String []act_list=new String[lists.size()]; 
			  for(int i=0;i<lists.size();i++)  
			   {
			          String var2 = lists.get(i).getAttribute("value");
			          act_list[i]=var2;
			        
			   }      
			  
			  String db_query="select date from Calendar  order by date desc";
			  List<String>exp_list=db_exe.SQLserverConnection2(db_query);
			  for(int j=0;j<act_list.length;j++)
			  {
				  System.out.println("Actual list element is "+act_list[j]);
				  System.out.println("Expected list element is "+exp_list.get(j));
				  Assert.assertEquals(act_list[j],exp_list.get(j));
			  }
			  
		}
		return "Pass";
}
catch(Exception e)
{
		e.printStackTrace();
		System.out.println("Exception occured while checking duration list");
		Setup.log.fatal(e);
		return "Fail to check duration list";
}
}	

public static int  getMonth(String month)
{
 try
 {	     int mon=0;
 	     switch(month)
 	     {
 	         case "Jan" : mon=1;
 	                      break;
 	         case "Feb" : mon=2;
                         break;    
 	         case "Mar" : mon=3;
                         break;
 	         case "Apr" : mon=4;
                         break;
 	         case "May" : mon=5;
                         break;
 	         case "Jun" : mon=6;
                         break;
 	         case "Jul" : mon=7;
                         break;
 	         case "Aug" : mon=8;
                          break;
 	         case "Sep" : mon=9;
                          break;
 	         case "Oct" : mon=10;
                          break;
 	         case "Nov" : mon=11;
                          break;
 	         case "Dec" : mon=12;
                          break;            
 	     }
 		 return mon;
}
catch(Exception e)
{
		e.printStackTrace();
		return 0;
}
}
	
	
	
}
