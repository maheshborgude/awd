package buisness.util.datastructures.dashboard;

import java.util.ArrayList;
import configuration.Setup;

/**
 *This class compare row of Measure Computation Summary Grid of Dashboard>>Provider or Dashboard Location
 * @author Sachin.Gawade
 * Update Date 3 March 2016 
 */
public class MeasureComputationSummaryGrid extends ArrayList<MeasureComputationSummaryGridRow> implements Comparable<MeasureComputationSummaryGrid>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method is used for  adding the rows in MeasureComputationSummaryRow
	 * @param monquat: Month or Quarter
	 * @param allmeasures: All measure count
	 * @param met: Met count
	 * @param notmet: Not met count
	 * @param percentage: Percentage
	 */
	public void addMeasureRow(String monquat, String allmeasures, String met, String notmet, String percentage)
	{
		this.add(new MeasureComputationSummaryGridRow(monquat, allmeasures, met, notmet, percentage));

	}
	/**
	 * This method is used to  get specified row in the grid.
	 * @param index Row number
	 * @return MeasureComputationSummaryGridRow row
	 */
	public MeasureComputationSummaryGridRow getRow(int index) 
	{
		return this.get(index);
	}
	
	
	@Override
	/**
	 * This method is used to compare two rows of MeasureComputationSummaryGridRow data type<p>
	 * @param target Passed Grid<p>
	 * @return 0 or 1 based on comparison
	 */
	public int compareTo(MeasureComputationSummaryGrid target) 
	{
		MeasureComputationSummaryGridRow sourceRow;
		MeasureComputationSummaryGridRow targetRow;
		
		for(int i=0;i<this.size();i++)
		{
			sourceRow = this.getRow(i);
			targetRow = target.getRow(i);
			
			if(i<=this.size() && sourceRow.compareTo(targetRow) != 0)
			{
				Setup.log.debug("Source: "+sourceRow);
				Setup.log.debug("Target: "+targetRow);
				return 1;
			}
			else
			{
				Setup.log.debug("Source: "+sourceRow);
				Setup.log.debug("Target: "+targetRow);
			}
		}
		return 0;
	}

}