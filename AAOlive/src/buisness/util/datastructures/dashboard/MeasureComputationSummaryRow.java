package buisness.util.datastructures.dashboard;

public class MeasureComputationSummaryRow implements Comparable<MeasureComputationSummaryRow>{
	
	private String monQuat;
	private int Allpatients;
	private int Met;
	private int NotMet;
	private float percentage;
	
	
	public MeasureComputationSummaryRow(String monQuat, int Allpatients, int Met, int NotMet, float percentage)
	{
		this.monQuat = monQuat;
		this.Allpatients = Allpatients;
		this.Met = Met;
		this.NotMet = NotMet;
		this.percentage = percentage;
	} 
	

	public String getMonQuat() 
	{
		return monQuat;
	}


	public int getAllpatients() 
	{
		return Allpatients;
	}


	public int getMet() 
	{
		return Met;
	}

	public int getNotMet() 
	{
		return NotMet;
	}


	public float getPercentage() 
	{
		return percentage;
	}
	
	public void print()
	{
		System.out.println(monQuat + "\t" +   Allpatients  + "\t" +  Met  + "\t" +  NotMet  + "\t" +  percentage);
	}


	@Override
	public int compareTo(MeasureComputationSummaryRow cmp)
	{
		if (this.getPercentage() == cmp.getPercentage() )
			if ( this.getAllpatients() == cmp.getAllpatients() ) 
				if(this.getNotMet() == cmp.getNotMet()  )
					if(this.getMet() == cmp.getMet() )  
						if(this.getMonQuat() == cmp.getMonQuat() )
						{
							return 0;
						}
		return 1;
	}
	
	
}
