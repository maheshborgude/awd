package buisness.util.datastructures.dashboard;

import java.util.ArrayList;
import java.util.List;

import configuration.Setup;
/**
 *This class compare row of Popup Location Grid of Dashboard>>Provider or Dashboard>>Location
 *This class implements Comparable<PopupLocationGrid>
 */
public class PopupLocationGrid implements Comparable<PopupLocationGrid>
{

	private List<PopupLocationGridRow> rows;


	private int rowcount;

	/**
	 * PopupLocationGrid constructor
	 * Initializes rowcount to 0
	 * Initializes rows to ArrayList<PopupLocationGridRow>()
	 */
	public PopupLocationGrid()
	{
		rowcount = 0;
		rows = new ArrayList<PopupLocationGridRow>();
	}
	/**
	 * This method is used for adding the rows
	 * @param name: Patient name
	 * @param qualified: Patient mrn
	 * @param met: Patient gender
	 * @param notmet: Patient date of birth
	 * @param performance: Patient date of birth
	 */
	public void addMeasureRow(String name,int qualified,int met,int notmet,double performance)
	{
		rows.add(new PopupLocationGridRow(name,qualified,met,notmet,performance));
		rowcount = rowcount + 1;
	}
	
	public int getRowcount() 
	{
		return rowcount;
	}
	
	public PopupLocationGridRow getRow(int index) 
	{
		return rows.get(index);
	}
	
	public List<PopupLocationGridRow> getRows() 
	{
		return rows;
	}
	
	public void print()
	{
		for(PopupLocationGridRow current : rows)
			current.print();
	}
	
	@Override
	public int compareTo(PopupLocationGrid target) 
	{
		PopupLocationGridRow sourceRow;
		PopupLocationGridRow targetRow;
		
		for(int i=0;i<this.getRowcount();i++)
		{
			sourceRow = this.getRow(i);
			targetRow = target.getRow(i);
			
			if(i<=rowcount && sourceRow.compareTo(targetRow) != 0)
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