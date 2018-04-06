package buisness.util.datastructures.dashboard.practice.practicePerformanceTrend;

import configuration.Setup;

/**
 * This class contain Table Rows logic  for Practice >> Performance View
 * This class is used to compare table rows ,UI and DB.
 * @author Shrikant.Bhujbal
 * Created date : 1/12/2017
 */

public class PPTTableGrQuarterRow implements Comparable<PPTTableGrQuarterRow> {
	private String Quarter;
	private String All;
	private String Met;
	private String NotMet;
	private String Percentage;

	PPTTableGrQuarterRow(String Quarter, String All, String Met, String NotMet,String Percentage) 
	{
		this.Quarter = Quarter;
		this.All = All;
		this.Met = Met;
		this.NotMet = NotMet;
		this.Percentage = Percentage;

	}

	public String getQuarter() {
		return Quarter;
	}

	public String getAll() {
		return All;
	}

	public String getMet() {
		return Met;
	}

	public String getNotMet() {
		return NotMet;
	}
	public String getPercentage() {
		return Percentage;
	}

	public int compareTo(PPTTableGrQuarterRow target) 
{
		System.out.println("Compare To method of 'patient visit row invoked.'");
		System.out.println(this.Quarter);
		System.out.println(target.Quarter);

		if (this.Quarter.compareToIgnoreCase(target.Quarter) == 0) 
		{
			System.out.println(this.All);
			System.out.println(target.All);
			if (this.All.compareToIgnoreCase(target.All) == 0) 
			{
				if (this.Met.compareToIgnoreCase(target.Met) == 0) 
				{
					if (this.NotMet.compareToIgnoreCase(target.NotMet) == 0)
					{
						if (this.Percentage.compareToIgnoreCase(target.Percentage) == 0)
						{

						     return 0;
					    } else 
					    {
						     Setup.log.debug("Data in  Percentage column does not match for " + this.Percentage + " " + target.Percentage);
						     return 1;
					     }
				    } else 
				    {
					Setup.log.debug(
							"Data NotMet column does not match for " + this.NotMet + " " + target.NotMet);
					return 1;
				    }
			    } else 
			    {
				  Setup.log.debug("Data in Met column does not match for " + this.Met + " " + target.Met);
				  return 1;
			     }
		} else 
		{
			Setup.log.debug("Data in All column does not match for " + this.All + " " + target.All);
			return 1;
			
		 } 
	}else
	{
		Setup.log.debug("Data in Quarter column does not match for " + this.Quarter + " " + target.Quarter);
		return 1;
	}
		
}	
	
}
