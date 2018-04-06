package buisness.awadhesh.datastructures.mips;

import java.util.ArrayList;
import java.util.List;


//public class Mipsprovidergrid implements Comparable<Mipsprovidergrid>
public class Mipsprovidergrid  implements Comparable<Mipsprovidergrid>
{
	/**
	 * This method calls parameterized constructor of Provider and store value in rows list
	 * @param LocationName : Name of Locatiom
	 * @param Qualified : Name of Qualified
	 * @param Met : Count of Met
	 * @param NotMet :  Count of Not Met
	 * @param Performance : Count of Performance
	 * @param RegistryBenchmark : RegistryBenchmark for Location
	
	**/
	private List<Mipsprovidergridrow> rows;

	public Mipsprovidergrid() {
		rows = new ArrayList<>();
	}
	
	public void add(String PROVIDERNAME, String MIPSELIGIBILITY, String NPI, String TIN,String QUALITY,String ACI,String IA,String MIPSFINALSCORE,String SUBMISSIONSTATUS)
	{
		rows.add(new Mipsprovidergridrow(PROVIDERNAME, MIPSELIGIBILITY,NPI,TIN,QUALITY,ACI,IA,MIPSFINALSCORE,SUBMISSIONSTATUS));
		
	}

	@Override
	public int compareTo(Mipsprovidergrid target) 
	{
		if(target == null)
			return -1;
		int a = this.rows.size();
		int b = target.rows.size();
		System.out.println(+a+ "==" +b);
		if(a==b )
		{
			Mipsprovidergridrow sourceRow;
			Mipsprovidergridrow targetRow;
			for(int i=0;i<a;i++)
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