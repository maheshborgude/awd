
package buisness.core.Submission.pqrsSubmission.submission2015.milestoneThree;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.managers.ConfigurationManager;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.Submission.pqrssubmission.GroupPerformanceGrid;
import configuration.Setup;
/**
 * This is abstract class this class get data from UI and Database 
 * This class also contain trimMultiSpace() function to remove the space present between word 
 * This class get data of  Report PQRS Measures Grid
 * This class get data present in UI with condition of
 * To meet the 2015 PQRS measures group reporting criteria:
 *   The Group Numerator must be equal to 20 or more.
 *   The Group Medicare must be equal to 11 or more.
 * @author Rakesh.kulkarni	
 * date 04/03/2016
 */
abstract public class GroupPerformance extends DashboardUI {


	
	public String trimMultiSpace(String getString)
	{
		String string =getString;
		String[] parts = string.split(" ");
		String s = new String();
		for(int i=0;i<parts.length;i++)
		{   
			parts[i]=parts[i].trim();
			if(!parts[i].equals(""))	
			{
				s=s+" "+parts[i];
			}
		}
		return s;
	} 
	/**
	 * This method is used to get data from UI of 
	 * That is present for To meet the 2015 PQRS measures group reporting criteria: 
	 * PQRS Advanced Status grid
	 * @return GroupDenominator
	 * @return GroupNumerator
	 * @return GroupMedicare
	 */
	public GroupPerformanceGrid getWebGrid(String elementmethod,String locator)
	{
		if(locator!=null)
		{
			GroupPerformanceGrid groupPerformanceGrid=new GroupPerformanceGrid();
			try
			{
				List<WebElement> rows = getWebElements(elementmethod, locator);			
				Setup.log.trace(locator);
				for(WebElement table : rows)
				{

					String GroupDenominator = table.findElement(By.xpath("./td[1]")).getText();
					Setup.log.info(GroupDenominator);
					String GroupNumerator = table.findElement(By.xpath("./td[2]")).getText();
					Setup.log.info(GroupNumerator);
					String GroupMedicare = table.findElement(By.xpath("./td[3]")).getText();	
					Setup.log.info(GroupMedicare);
					groupPerformanceGrid.add(GroupDenominator, GroupNumerator, GroupMedicare);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Setup.log.error(e);
				Setup.log.error("Please check xpath in ObjectRepositary.Properties file ");
			}
			return groupPerformanceGrid;	
		}
		else
		{
			Setup.log.error("The Xpath of WebGrid is incorrect on missing please check the GroupManagement.xlsx");
			return null;
		}

	}

	/**
	 * This method is used to get data from Database and return a object with Grid value<p>
	 * For logged in user in the database<p>
	 * With criteria of 
	 * To meet the 2015 PQRS measures group reporting criteria:
	 *	The Group Numerator must be equal to 20 or more.
	 *	The Group Medicare must be equal to 11 or more.
	 * @return GroupDenominator
	 * @return GroupNumerator
	 * @return GroupMedicare
	 */
	public GroupPerformanceGrid getDatabaseGrid(String querylocater)
	{
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery(querylocater);

		DatabaseManger.SQLserverConnection(); 
		String userName =getLoggedInUser();
		String Newquery=query.replace( "@loginuser",userName);	
		ResultSet resultSet= DatabaseManger.exeQuery(Newquery);
		GroupPerformanceGrid GroupPerformanceGridDB=new GroupPerformanceGrid();
		Setup.log.trace(query);
		if(resultSet != null)
		{
			try {
				while(resultSet.next())
				{
					String GroupDenominator = resultSet.getString("GroupDenominator");	
					String GroupDenominatorT=trimMultiSpace(GroupDenominator).trim();		
					Setup.log.info(GroupDenominatorT);
					String GroupNumerator = resultSet.getString("GroupNumerator");	
					String GroupNumeratorT=trimMultiSpace(GroupNumerator).trim();	
					Setup.log.info(GroupNumeratorT);
					String GroupMedicare = resultSet.getString("GroupMedicare");	
					String GroupMedicareT=trimMultiSpace(GroupMedicare).trim();	
					Setup.log.info(GroupMedicareT);
					GroupPerformanceGridDB.add(GroupDenominatorT, GroupNumeratorT, GroupMedicareT);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Setup.log.error("Please check query in 'Queries.properties.ValidateTotalPracticeCount'or verify the logged in UserName");
				Setup.testcase.fail();
			}
			return GroupPerformanceGridDB;
		}

		else
		{
			return null;
		}
	}
}
