package buisness.util.datastructures.dashboard.practice;

import java.util.ArrayList;
import java.util.List;

import buisness.util.datastructures.dashboard.practice.DefaultMeasureGridRow;;

public class DefaultMeasureGrid implements Comparable<DefaultMeasureGrid>{
	
	private List<DefaultMeasureGridRow> rows;

	public DefaultMeasureGrid()
	{
	rows = new ArrayList<>();
	}
	
	public void add(String ID, String Measure, String Reg_Avg, String Reg_Bench  )
	{
		// System.out.println("It is coming to add method");
	rows.add(new DefaultMeasureGridRow(ID, Measure, Reg_Avg, Reg_Bench));	
	}
	
	
	
	@Override
	public int compareTo(DefaultMeasureGrid target) throws NullPointerException {
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
			DefaultMeasureGridRow sourceRow;
			DefaultMeasureGridRow targetRow;
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