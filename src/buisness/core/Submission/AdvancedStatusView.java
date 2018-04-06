package buisness.core.Submission;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.AdvancedStatusGrid;
import configuration.Setup; 

/**
 * This class used to verify Advanced Status grid
 * @author Sachin Gawade
 * Date : 18 Feb 2016
 */
public class AdvancedStatusView extends AdvancedStatus	 {

	/**
	 * This method is used to get data from Database for PQRS Advanced Status <p>
	 * @param querylocator Name of query in query repository<p>
	 * @return AdvancedStatusGrid object(Database grid)
	 */
	@Override
	public AdvancedStatusGrid getDatabaseGrid(String querylocator) {
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery(querylocator);
		query=query.replace("@loginuser",getLoggedInUser());
		Setup.log.trace(query);
		return super.getDatabaseGrid(query);
	}
	
	
}

