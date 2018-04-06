package buisness.core.Submission;

import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.gprosubmission.milestonetwo.ReportingMeasureGrid;
/**
 * GPROReportingMeasuresView class
 * Extends GPROReportingMeasures class
 * Class used to compare GPRO Reporting Measures grid from UI and database.
 * @author Sachin.Gawade
 * Created 11 Feb 2016
 */
public class ReportingMeasuresView extends ReportingMeasures{
	

		
	/**
	 * Replaces variables present in Query(obtained from object repository) 
	 * @param querylocator Name of query in query repository<p>
	 * @return query as String
	 */
	public ReportingMeasureGrid getDatabaseGrid(String querylocator)
	{
		ConfigurationManager config;
		config = new ConfigurationManager();
		String query = config.getQuery(querylocator);
		query=query.replace("@loginuser",getLoggedInUser());
		return super.getDatabaseGrid(query);
	}
	
}
