package buisness.core.dashboard.provider;

import buisness.util.datastructures.dashboard.PatientDrillDownGrid;
import configuration.Setup; 

/**
 * This class used to verify sorting(ascending and descending) for Dashboard>>Patient Drill Down grid
 *  from Database and UI<p>
 * @author Sachin.Gawade
 * Date : 3 Mar 2016
 */
public class PatientDrillDownSort extends PatientDrillDown {
	
	/**
	 * This method receives querylocator name. It then fetches the actual query from query repository and passes<p>
	 * it to getDatabaseGrid() method of PatientDrillDown class<p>
	 * @param query: Query to run on database<p>
	 * @param data: data parameter is used to sort query in asc ore desc order
	 * @return true or false
	 */
	public PatientDrillDownGrid getDatabaseGrid(String query,String data) {
		//ConfigurationManager config=new ConfigurationManager();
		//query = config.getQuery(query);
		if ( data.equalsIgnoreCase("desc") || data.equalsIgnoreCase("descending"))
		{
			query=query.replace("@sortmethod","desc");
		}
		else
		{
			query=query.replace("@sortmethod","asc");
		}
		Setup.log.trace(query);
		return super.getDatabaseGrid(query);
	}
	
}

