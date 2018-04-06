package buisness.util.datastructures.dashboard.practice.practiceProvider;

import java.util.ArrayList;
import java.util.List;


/**
 * This class contain Table Grid logic for Practice >> Provider View
 * This class is used to compare Performance Trend Table from UI and DB.
 * @author Ashwini.Gore
 * Created date : 1/12/2017
 */

public class PracticeProviderPT_TableGrid implements Comparable<PracticeProviderPT_TableGrid>{
	
	private List<PracticeProviderPT_TableGridRow> rows;

	public PracticeProviderPT_TableGrid()
	{
	rows = new ArrayList<>();
	}
	
	public void addRowToTable(String Quarter, String All, String Met, String NotMet, String Percentage )
	{
		// System.out.println("It is coming to add method");
	   rows.add(new PracticeProviderPT_TableGridRow(Quarter, All, Met, NotMet, Percentage));	
	}
	
	
	
	@Override
	public int compareTo(PracticeProviderPT_TableGrid target) throws NullPointerException {
		// TODO Auto-generated method stub
		System.out.println("Compare To method of Dashboard>>Practice Provider tab Performance Table\n");
		if(target ==null)
			throw new NullPointerException("Target object is null");
			//return -1;
		int a = this.rows.size();
		int b = target.rows.size();
		System.out.println("UI:Total Rows: "+a+ "\tDB:Total Rows: " +b);
		if(a==b)
		{
			PracticeProviderPT_TableGridRow sourceRow;
			PracticeProviderPT_TableGridRow targetRow;
			for(int i = 0;i<a;i++)
			{
				sourceRow = this.rows.get(i);
				targetRow = target.rows.get(i);
				if(sourceRow.compareTo(targetRow) != 0)
				{
					return -1;
				}
			}
			return 0;
		}
		return -1;
	}

}