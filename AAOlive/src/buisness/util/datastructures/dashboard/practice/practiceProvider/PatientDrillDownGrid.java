package buisness.util.datastructures.dashboard.practice.practiceProvider;

import java.util.ArrayList;
import java.util.List;

import configuration.Setup;

/**
 *This class compare row of Patient Drill Down grid of Dashboard>>Practice>>provider
 *This class implements Comparable<PatientDrillDownGrid>
 * @author Ashwini.Gore
 * Update Date 13 Dec 2017
 */
public class PatientDrillDownGrid implements Comparable<PatientDrillDownGrid>
{

  	private List<PatientDrillDownGridRow> rows;

		public PatientDrillDownGrid()
		{
		rows = new ArrayList<>();
		}
		
		public void addPatientRow(String name, String mrn, String gender, String DOB)
		{
			// System.out.println("It is coming to add method");
		   rows.add(new PatientDrillDownGridRow(name, mrn,gender, DOB));	
		}
		
		
		
		@Override
		public int compareTo(PatientDrillDownGrid target) throws NullPointerException {
			// TODO Auto-generated method stub
			System.out.println("Compare To method of Dashboard>>Practice Provider tab View\n");
			if(target ==null)
				throw new NullPointerException("Target object is null");
				//return -1;
			int a = this.rows.size();
			int b = target.rows.size();
			System.out.println("UI:Total Rows: "+a+ "\tDB:Total Rows: " +b);
			if(a==b)
			{
				PatientDrillDownGridRow sourceRow;
				PatientDrillDownGridRow targetRow;
				for(int i = 0;i<a;i++)
				{
					sourceRow = this.rows.get(i);
					targetRow = target.rows.get(i);
					if(sourceRow.compareTo(targetRow)!= 0)
					{
						return 1;
					}
				}
				return 0;
			}
			return 1;
		}
}