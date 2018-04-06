package buisness.util.datastructures.dashboard.practice.practiceMeasureGrid;

import java.util.ArrayList;
import java.util.List;

import buisness.util.datastructures.dashboard.practice.practiceMeasureGrid.DefaultMeasureGridRow;;

public class DefaultMeasureGrid implements Comparable<DefaultMeasureGrid>{
	
	private List<DefaultMeasureGridRow> rows;

	public DefaultMeasureGrid()
	{
	rows = new ArrayList<>();
	}
	
	public void add(String id, String measure, String performance, String reg_avg  )
	{
	rows.add(new DefaultMeasureGridRow(id, measure, performance, reg_avg));	
	}
	

	
	
	@Override
	public int compareTo(DefaultMeasureGrid target) throws NullPointerException {
		if(target ==null)
			throw new NullPointerException("Target object is null");
			//return -1;
		int a = this.rows.size();
		int b = target.rows.size();
		//System.out.println(+a+ "==" +b);
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