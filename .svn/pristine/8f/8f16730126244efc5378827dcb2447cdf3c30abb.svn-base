package buisness.awadhesh.datastructures.mips;
import java.util.ArrayList;
import java.util.List;

import buisness.util.datastructures.administration.practice.PracticeGrid;
import buisness.awadhesh.datastructures.mips.*;


public class MipsNanogrid implements Comparable<MipsNanogrid>
{
	private List<MipsNanogridrow> rows;
	/**
	 * Default constructor to create objects
	 * 	
	 */
	public MipsNanogrid()
	{
		rows = new ArrayList<MipsNanogridrow>();
	}
	/**
	 * This method calls parameterized constructor of PracticeRow and store value in rows list 

	 */
	public void add(String PROVIDERNAME)
	{
		rows.add(new MipsNanogridrow(PROVIDERNAME));
	}
	@Override
	public int compareTo(MipsNanogrid target) 
	{

		if(target == null)
			return -1;
		if(this.rows.size()==target.rows.size() )
		{
			MipsNanogridrow sourceRow;
			MipsNanogridrow targetRow;
			for(int i=0;i<this.rows.size();i++)
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


