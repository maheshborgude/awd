package buisness.core.Submission;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.ReportedPatientVisitsGrid;
import configuration.Setup; 

/**
 * This class used to verify sorting(ascending and descending) for Reported Patient Visits grid
 *  from Database and UI<p>
 * @author Sachin.Gawade
 * Date : 10 Feb 2016
 */
public class ReportedPatientVisitsSort extends ReportedPatientVisits {
	
	/**
	 * This method is used to get data from Database for Reported Patient Visits grid<p>
	 * @param querylocator Name of query in query repository<p>
	 * @param data to sort query in asc or desc order
	 * @return ReportedPatientVisitsGrid grid(Database grid)
	 */
	public ReportedPatientVisitsGrid getDatabaseGrid(String querylocator,String data) {
		ConfigurationManager config = new ConfigurationManager();
		String query;
		query = config.getQuery(querylocator);
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

