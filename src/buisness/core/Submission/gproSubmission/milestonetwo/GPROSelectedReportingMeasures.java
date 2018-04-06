package buisness.core.Submission.gproSubmission.milestonetwo;

import java.sql.SQLException;
import buisness.core.Submission.ReportingMeasuresView;
import buisness.util.datastructures.Submission.gprosubmission.milestonetwo.ReportingMeasureGrid;
import configuration.Setup;


/**Verifies Selected measures from GPRO Reporting Measures Grid(GPROSubmission)<p>
 * @author Sachin.Gawade<p>
 * Created Date: 29 Feb 2016
 * 
 */
public class GPROSelectedReportingMeasures extends ReportingMeasuresView{
	
	
	/**
	 * Compares UI grid and database records
	 * @param locator Name of locator in object repository<p>
	 * @return Boolean true or false based on the comparison of ui grid and database <p>
	 * @throws SQLException
	 */

	public boolean verify(String elementmethod,String locator) throws SQLException
	{
		super.setCheckAllMeasures(false);
		ReportingMeasureGrid dbGrid =getDatabaseGrid("SelectedGproMeasures");
		ReportingMeasureGrid uiGrid =getWebGrid(elementmethod,locator);
	
		if(uiGrid==null ) 
		{
			Setup.log.error("UI grid is null");
		}
		else if(uiGrid.compareTo(dbGrid) == 0)
		{
			Setup.log.trace("Data on UI and Database matches.");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else 
		{
			Setup.log.trace("Data on UI and Database does not match.");
		}
		Setup.testcase.fail();
		return false;
	
	}

}
