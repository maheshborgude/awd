package buisness.util.datastructures.dashboard;



public class PopupProviderGridRow implements Comparable<PopupProviderGridRow>
{
	private String	name;
	private int 	qualified;
	private int 	met;
	private int 	notmet;
	private double 	performance;

	PopupProviderGridRow(String name,int qualified,int met,int notmet,double performance)
	{
		this.name = name;
		this.qualified = qualified; 
		this.met = met;
		this.notmet = notmet;
		this.performance = performance;
	}
	
	public void print()
	{
		System.out.println( name + "\t" +qualified + "\t" + met + "\t" + notmet + "\t" + performance );
	}
	
	@Override
	public int compareTo(PopupProviderGridRow target) 
	{
		if(this.name.equals(target.name))
		{
			if(this.qualified == target.qualified && this.met == target.met && this.notmet == target.notmet)
			{
				if(this.performance == target.performance)
				{
					return 0;
				}

			}
		}
		return 1;
	}
	
}
