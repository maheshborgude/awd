package buisness.core.dashboard.provider;

import buisness.util.datastructures.dashboard.MeasureComputationSummaryGrid;

public class MeasureComputationSummaryView extends MeasureComputationSummary {

    public String query;
	
	/**
	 * Returns MeasureComputationSummaryGrid object containing  measures details from database<p>
	 * @param query Query to run in database<p>
	 * @return dbgrid which contains all database rows 
	 * @author Sachin Gawade
	 *Created date  3 Mar 2016
	 */

	public MeasureComputationSummaryGrid getDatabaseGrid(String query) 
	{
		System.out.println(query);
	//query=query.replace("@loginuser",getLoggedInUser());
	/*	query=query.replace( "@measureID",getSelectrdMeasureUIDonMeasuePopup());*/
	//	query=query.replace( "@loginuser",getLoggedInUser());
	//	query=query.replace( "@provideruid",getSelectedProvierUID());  // Ok If Delete
	//	query=query.replace( "@measureuid",getSelectedMeasureUID());
		return super.getDatabaseGrid(query);
	}
	

}
