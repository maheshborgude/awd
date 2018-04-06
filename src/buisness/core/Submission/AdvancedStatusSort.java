package buisness.core.Submission;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.AdvancedStatusGrid;
import configuration.Setup; 

/**
 * This class to verify Sorting functionality of Advanced Status grid<p>
 * from Database and UI and return a object with Grid value
 * @author Sachin.Gawade
 * Date : 16 Feb 2016
 */
public class AdvancedStatusSort extends AdvancedStatus {

/**
 * This method is used to get query from Database
 * @param querylocator Name of query in  query repository<p>
 * @param data Parameter used to sort query in asc or desc order
 * @return AdvancedStatusGrid object
 */
	public AdvancedStatusGrid getDatabaseGrid(String querylocator,String data) {
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery(querylocator);
		if ( data.equalsIgnoreCase("desc") || data.equalsIgnoreCase("descending"))
		{
			query=query.replace("@sortmethod","desc");
		}
		else
		{
			query=query.replace("@sortmethod","asc");
		}
		query=query.replace("@loginuser",getLoggedInUser());
		Setup.log.trace(query);
		return super.getDatabaseGrid(query);
	}

	
	
}

