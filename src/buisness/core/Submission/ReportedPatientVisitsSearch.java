package buisness.core.Submission;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.ReportedPatientVisitsGrid;
import configuration.Setup; 

/**
 * This class used to verify search functionality for  GPRO Submission>> Report PQRS Measures Milestone >>Reported Patient Visits Tab
 *     data from Database and UI <p>
 * @author Sachin.Gawade
 * Date : 16 Feb 2015
 */
public class ReportedPatientVisitsSearch extends ReportedPatientVisits {
	
	
	/**
	 * This method is used to get data from Database for Reported Patient Visits Grid<p>
	 * @param querylocator Name of query in query repository<p>
	 * @param data string to be searched<p>
	 * @return ReportedPatientVisitsGrid grid(Database grid)
	 */
	public ReportedPatientVisitsGrid getDatabaseGrid(String querylocator,String data) {
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery(querylocator);	
		query=query.replace("@loginuser",getLoggedInUser());
		query=query.replace("@searchkey",data);

		Setup.log.trace(query);
		return super.getDatabaseGrid(query);
	}
	
}

