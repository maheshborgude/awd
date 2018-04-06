package buisness.util.datastructures.dashboard;

import java.util.ArrayList;
import java.util.List;

public class PopupProviderGrid implements Comparable<PopupProviderGrid>
{

	private List<PopupLocationGridRow> rows;


	private int rowcount;

	public PopupProviderGrid()
	{
		rowcount = 0;
		rows = new ArrayList<PopupLocationGridRow>();
	}
	
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
	public int compareTo(PopupProviderGrid target) 
	{
		PopupLocationGridRow sourceRow;
		PopupLocationGridRow targetRow;
		
		for(int i=0;i<this.getRowcount();i++)
		{
			sourceRow = this.getRow(i);
			targetRow = target.getRow(i);
			
			if(i<=rowcount && sourceRow.compareTo(targetRow) != 0)
			{
				
				System.out.print("Source: ");
				sourceRow.print();
				System.out.print("Target: ");
				targetRow.print();
				return 1;
			}
			else
			{
				/*
				System.out.println("Same---");
				System.out.print("Source: ");
				sourceRow.print();
				System.out.print("Target: ");
				targetRow.print();*/
			}
		}
		return 0;
	}

}