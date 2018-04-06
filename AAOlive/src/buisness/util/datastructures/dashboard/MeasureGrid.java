package buisness.util.datastructures.dashboard;

import java.util.ArrayList;
import java.util.List;

import configuration.Setup;
/**
 *This class compare row of Measure grid of Dashboard>>Provider Measure Grid
 * @author Sachin.Gawade
 * Update Date 2 March 2016 
 */

public class MeasureGrid implements Comparable<MeasureGrid>
{

	private List<MeasureGridRow> rows;


	private int rowcount;
/**
 * MeasureGrid constructor
 * Initializes rowcount to 0
 * Initializes rows to ArrayList<MeasureGridRow>()
 */
	public MeasureGrid()
	{
		rowcount = 0;
		rows = new ArrayList<MeasureGridRow>();
	}
	
	/**
	 * This method is used for adding the rows 
	 * @param measureID: Measure ID
	 * @param measureName: Measure Name
	 * @param registryBenchmark: Registry Benchmark for the measure
	 * @param performance: Performance for the measure
	 */
	public void addMeasureGridRow(String measureID,String measureName,String registryBenchmark,String performance)
	{
		rows.add(new MeasureGridRow(measureID,measureName,registryBenchmark,performance));
		rowcount = rowcount + 1;
	}
	
	/**
	 * This method is used to get rowcount
	 * @return rowcount
	 */
	public int getRowcount() 
	{
		return rowcount;
	}
	/**
	 * This method is used to  get specified row in the grid.
	 * @param index Row number
	 * @return MeasureGridRow row
	 */
	public MeasureGridRow getRow(int index) 
	{
		return rows.get(index);
	}
	/**
	 * This method is used to get List<MeasureGridRow>object
	 * @return List<MeasureGridRow>object
	 */
	public List<MeasureGridRow> getRows() 
	{
		return rows;
	}
	
	@Override
	/**
	 * This method is used to compare two rows of MeasureComputationSummaryRow data type<p>
	 * @param target Passed Grid<p>
	 * @return 0 or 1 based on comparison
	 */
	public int compareTo(MeasureGrid target) 
	{
		MeasureGridRow sourceRow;
		MeasureGridRow targetRow;
		
		for(int i=0;i<this.getRowcount();i++)
		{
			sourceRow = this.getRow(i);
			targetRow = target.getRow(i);
			
			if(i<=rowcount && sourceRow.compareTo(targetRow) != 0)
			{
		//		Setup.log.debug("Source: "+sourceRow);
		//		Setup.log.debug("Target: "+targetRow);
				return 1;
			}
			else
			{
		//		Setup.log.debug("Source: "+sourceRow);
		//		Setup.log.debug("Target: "+targetRow);
			}
		}
		return 0;
	}
}