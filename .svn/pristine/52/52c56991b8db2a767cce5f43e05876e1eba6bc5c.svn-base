package buisness.core.Submission;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.AdvancedStatusPopupGrid;
import configuration.Setup; 

/**
* This class to verify Sorting functionality of Advanced Status Popup grid<p>
 * from Database and UI and return a object with Grid value
 * @author Sachin.Gawade
 * Date : 29 Feb 2016
 */
public class AdvancedStatusPopupSort extends AdvancedStatusPopup {

		/**
		 * 
		 * @param querylocator Name of query in query repository<p>
		 * @param data1 measure number
		 * @param data2  order query by asc or desc
		 * @return true or false
		 */
	
	public AdvancedStatusPopupGrid getDatabaseGrid(String querylocator, String data1,String data2) {
		ConfigurationManager config = new ConfigurationManager();
	
		String query = config.getQuery(querylocator);
		query= query.replace("@measure", data1);
		if ( data2.equalsIgnoreCase("desc") || data2.equalsIgnoreCase("descending"))
		{
			query=query.replace("@sortmethod","desc");
		}
		else
		{
			query=query.replace("@sortmethod","asc");
		}
		Setup.log.error(query);
		return super.getDatabaseGrid(query);
	}
		
}

