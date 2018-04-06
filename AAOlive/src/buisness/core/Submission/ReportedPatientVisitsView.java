package buisness.core.Submission;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.ReportedPatientVisitsGrid;

/**
 * This class used to get Reported Patient Visits grid<p>
 * from Database and UI <p>
 * @author Sachin.Gawade
 * Date : 10 Feb 2016
 */
public class ReportedPatientVisitsView extends ReportedPatientVisits	 {
	/**
	 * This method is used to get data from Database for Reported Patient Visits grid<p>
	 * @param querylocator Name of query in query repository<p>
	 * @return ReportedPatientVisitsGrid grid(Database grid)
	 */
	public ReportedPatientVisitsGrid getDatabaseGrid(String querylocator) 
	{
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery(querylocator);	
		String replaceQuery=query.replace("@loginuser",getLoggedInUser());
		return super.getDatabaseGrid(replaceQuery);
	}	
}

