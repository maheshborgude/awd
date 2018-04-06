package buisness.util.datastructures.dashboard;

import java.util.ArrayList;
import java.util.List;

import configuration.Setup;

/**
 *This class compare row of Patient Drill Down grid of Dashboard>>Provider
 *This class implements Comparable<PatientDrillDownGrid>
 * @author Sachin.Gawade
 * Update Date 3 March 2016 
 */
public class PatientDrillDownGrid implements Comparable<PatientDrillDownGrid>
{

	private List<PatientDrillDownGridRow> rows;


	private int rowcount;
/**
 * PatientDrillDownGrid constructor
 * Initializes rowcount to 0
 * Initializes rows to ArrayList<PatientDrillDownGridRow>>()
 */
	public PatientDrillDownGrid()
	{
		this.rowcount = 0;
		rows = new ArrayList<PatientDrillDownGridRow>();
	}
	/**
	 * This method is used for adding the rows
	 * @param name: Patient name
	 * @param mrn: Patient mrn
	 * @param gender: Patient gender
	 * @param dob: Patient date of birth
	 */
	public void addPatientRow(String name,String mrn,String gender,String dob)
	{
		rows.add(new PatientDrillDownGridRow	(name,mrn,gender,dob));
		this.rowcount = rowcount + 1;
	}
	
	/**
	 * This method is used to  get rowcount
	 * @return rowcount
	 */
	public int getRowcount() 
	{
		return this.rowcount;
	}
	
	/**
	 * This method is used to  get specified row in the grid.
	 * @param index Row number
	 * @return PatientDrillDownGridRow row
	 */
	public PatientDrillDownGridRow getRow(int index) 
	{
		return rows.get(index);
	}
	/**
	 * This method is used to get List<PatientDrillDownGridRow> object
	 * @return List<PatientDrillDownGridRow> object
	 */
	public List<PatientDrillDownGridRow> getRows() 
	{
		return rows;
	}
	
	
	@Override
	/**
	 * This method is used to compare two rows of PatientDrillDownGridRow data type<p>
	 * @param target Passed Grid<p>
	 * @return 0 or 1 based on comparison
	 */
	public int compareTo(PatientDrillDownGrid target) 
	{
		PatientDrillDownGridRow sourceRow;
		PatientDrillDownGridRow targetRow;
		
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