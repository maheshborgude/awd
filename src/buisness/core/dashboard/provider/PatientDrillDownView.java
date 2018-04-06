package buisness.core.dashboard.provider;

import buisness.util.datastructures.dashboard.PatientDrillDownGrid;
/**
 *This class is used to get Dashboard>>Patient Drill Down Grid from the database.<p>
 * @author Sachin.Gawade
 * 3 Mar 2016
 */
public class PatientDrillDownView extends PatientDrillDown {

    public String query;


	/**
	 * Returns PatientDrillDownGrid object containing all measures and their details available<p>
	 * for logged in user in the database<p>
	 * @param query: Query to run on database<p>
	 * @return dbgrid which contains all database rows 
	 * @author Sachin Gawade
	 * Created date  3 Mar 2016
	 */

	public PatientDrillDownGrid getDatabaseGrid(String query) 
	{

		return super.getDatabaseGrid(query);
	}
	
	

}
