package buisness.util.datastructures.dashboard.practice.practicePerformanceTrend;

import java.util.ArrayList;
import java.util.List;

import buisness.util.datastructures.dashboard.practice.practiceMeasureGrid.DefaultMeasureGridRow;

/**
 * This class contain Table Grid logic  for Practice >> Performance View
 * This class is used to compare WHole grid on UI and DB.
 * @author Shrikant.Bhujbal
 * Created date : 1/12/2017
 */

public class PPTTableGrid implements Comparable<PPTTableGrid>{
	
	private List<PPTTableGrQuarterRow> rows;

	public PPTTableGrid()
	{
	rows = new ArrayList<>();
	}
	
	public void addRowToTable(String Quarter, String All, String Met, String NotMet, String Percentage )
	{
		// System.out.println("It is coming to add method");
	   rows.add(new PPTTableGrQuarterRow(Quarter, All, Met, NotMet, Percentage));	
	}
	
	
	
	@Override
	public int compareTo(PPTTableGrid target) throws NullPointerException {
		// TODO Auto-generated method stub
		System.out.println("Compare To method of datastructures.dashboard.practice.DefaultMeasureGrid");
		if(target ==null)
			throw new NullPointerException("Target object is null");
			//return -1;
		int a = this.rows.size();
		int b = target.rows.size();
		System.out.println(+a+ "==" +b);
		if(a==b)
		{
			PPTTableGrQuarterRow sourceRow;
			PPTTableGrQuarterRow targetRow;
			for(int i = 0;i<a;i++)
			{
				sourceRow = this.rows.get(i);
				targetRow = target.rows.get(i);
				if(sourceRow.compareTo(targetRow)!=0)
				{
					return -1;
				}
			} return 0;
		}
		return -1;
	}

}