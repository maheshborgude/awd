package buisness.core.administration.provider;

import java.sql.ResultSet;

import buisness.core.ElementMethod;
import buisness.core.administration.location.Location;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import configuration.Setup;

public class ProviderCount extends Location {
	String resultofCount;
	ResultSet resultSet=null;
	String query;

	/** Gets locations  count for logged in user from database<p>
	 * Returns provider count of logged in user as String<p>
	 * Returns 0 as String if no record is found or error is faced<p>
	 */

	public String getdbcount()
	{

		DatabaseManger.SQLserverConnection();
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("ProviderCountAdmin");
		query=query.replace( "@loginuser",getLoggedInUser());


		try {
			System.out.println(query);
			resultSet = DatabaseManger.exeQuery(query);
			if (resultSet.next()) {
				return resultSet.getString(1);
			}
			else
			{
				Setup.log.error("No Provider Record found in the Database.");
			}

		}

		catch(Exception e)
		{
			Setup.log.error("\nQuery syntax incorrect.");
		}
		Setup.testcase.fail();
		return "0";
	}


	/** Gets Location  count for logged in user from the UI<p>
	 * Returns Location count of logged in user as String<p>
	 * Returns 0 as String if no record is found or error is faced<p>
	 * calls trimuicount(String rawcount) to clear redundant data<p>
	 * @param locator of Provider count in the UI is passed<p>
	 */
	public String getuicount(String locator)
	{
		ElementMethod em=new ElementMethod();
		try
		{
			return trimuicount(em.gettext("xpath", locator));
		}
		catch (Exception e)
		{
			Setup.testcase.fail();
			Setup.log.error("No Provider Record found in the UI");
			return "0";
		}
	}

	/** Trims unnecessary data for the captured data from the UI
	 * @param rawcount:  Untrimmed total record from the UI
	 * Returns actual count as String
	 */
	public String  trimuicount(String rawcount)
	{
		int index=0;
		char character = ' ';
		for(int i = 0; i < rawcount.length(); i++){
			if(rawcount.charAt(i) == character){
				index=i;
			}
		}
		return rawcount.substring(index+1,rawcount.length());

	}
	/** Compares Location Count for logged in user from UI and Database
	 * calls getdbcount(),getuicount()
	 * @param locator of element that shows record in the UI
	 * Returns result pass\false
	 */
	public boolean verify(String locator)
	{
//		String dbCount;
//		String uiCount;
//
//		dbCount=getdbcount();
//		uiCount=getuicount(locator);

		System.out.println("Ui_Count"+getuicount(locator));
		System.out.println("Db_Count"+getdbcount());

		if(getuicount(locator).equals(getdbcount()))
		{
			Setup.log.trace("\nCount from Database and UI getting matched");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else
		{
			Setup.log.trace("\nCount from Database and UI is not getting matched");
			Setup.testcase.fail();
			return false;
		}

	}

}









































