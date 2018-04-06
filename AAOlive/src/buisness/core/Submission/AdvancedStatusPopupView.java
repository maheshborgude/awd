package buisness.core.Submission;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.Submission.AdvancedStatusPopupGrid; 
/**
 * This class used to get  Report PQRS Measures Milestone >>PQRS Advanced status popup grid<p>
 * data from Database and UI and return a object with Grid value<p>
 * Returns Advanced Status Popup grid object
 * Schin Gawade
 * Date : 20 Feb 2016
 */
public class AdvancedStatusPopupView extends AdvancedStatusPopup	 {

	/**
	 * This method is used to fetch query from database for Advanced Status Popup grid
	 * @param querylocator Name of query in query repository<p>
	 * @param data measure number
	 * @return true or false
	 */
	public AdvancedStatusPopupGrid getDatabaseGrid(String querylocator,String data) {
		ConfigurationManager config = new ConfigurationManager();
		String query = config.getQuery(querylocator);
		String replaceQuery= query.replace("@measure", data);
		return super.getDatabaseGrid(replaceQuery);
	}

	
}

