package buisness.core.administration.practice;

import java.sql.ResultSet;
import java.sql.SQLException;
import buisness.core.ElementMethod;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;


/**
 * This class contain method to get data from database,UI and compare it.
 * 
 * @author rakesh.kulkarni
 * Date : 1/8/2015
 */
public class PracticeCount {
	private String uname;

	public PracticeCount()
	{
		buisness.core.DashboardUI dashboardui=new buisness.core.DashboardUI();
		uname =  dashboardui.getLoggedInUser();
	}
	
	
	
	/**
	 * This Method is used for get count of practice from database
	 * 
	 * @return dbresult
	 * @author rakesh.kulkarni<p>
	 * Date : 1/8/2015<p>
	 */
	public int getPracticeCountDB()
	{
	
		DatabaseManger.SQLserverConnection(); 
		ConfigurationManager cofig=new ConfigurationManager();
		String query = cofig.getQuery("ValidateTotalPracticeLabel");	
		ResultSet resultSet =null;
		int dbresult = 0;
		try {
			query=query.replace( "@loginuser",uname);
			Setup.log.trace(query);
			resultSet = DatabaseManger.exeQuery(query);
			if (resultSet.next()) {
			  	dbresult=resultSet.getInt(1);
			}
			else
			{
				Setup.log.error("Please check query in 'Queries.properties.ValidateTotalPracticeCount'or verify the logged in UserName");
				Setup.testcase.fail();
			}
		}
		catch(Exception e)
		{
			 Setup.log.error(e);
			Setup.testcase.fail();
			
		}
		return dbresult;
	}
	
	/**
	 * This Method is used for get Count of practice from UI
	 * 
	 * @param locator
	 * @return resultofUICount
	 * @author rakesh.kulkarni<p>
	 * Date : 1/8/2015<p>
	 */	
	public int getPracticeCountUI(String locator)
	{
		ElementMethod em = new ElementMethod();
		String CountLabel = em.gettext("xpath", locator);	
	    return trimInvalidDataFromUICount(CountLabel);
	}
	
	
	
	/**
	 * This Method is used to trim all data present on practice label and return only count of Record
	 *  
	 * @return Count of Record without any extra character
	 * @author rakesh.kulkarni<p>
	 * Date : 1/8/2015<p>
	 */	
	public int trimInvalidDataFromUICount(String UIlabel)
	{
		
		 int index=0;
			char character = ' ';
			for(int i = 0; i < UIlabel.length(); i++){
			    if(UIlabel.charAt(i) == character){
			    	index=i;
			    }
			}
			int withoutspaceCount = Integer.parseInt(UIlabel.substring(index+1,UIlabel.length()));
			return withoutspaceCount;
	}
	 /**
	 * This Method is used to compare count of practice present in Database and present on UI
	 * 
	 * @param (String locator)	
	 * @return Result Pass of Fail
	 * @throws SQLException
	 * @author rakesh.kulkarni<p>
	 * Date : 1/8/2015<p>
	 * @param elementmethod 
	 */
	public boolean Verify(String elementmethod,String locator) 
	
	{
		int dbresult = getPracticeCountDB();
		int uicount = getPracticeCountUI(locator);
		
		if(dbresult==uicount)
		{
			Setup.log.trace("Count on UI match with DB");
			Setup.testcase.assertTrue(true);
			return true;	
			
		}
		else
		{
			Setup.log.trace("Count on UI not match with DB");
			Setup.testcase.fail();
			return false;			
		}
	}
}
