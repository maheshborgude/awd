package buisness.util.datastructures.mipsutil;

import java.util.ArrayList;
import java.util.List;


public class Mipscliniciangrid implements Comparable<Mipscliniciangrid> 
{
	private List<MipscliniciangridRow> rows;
	
	
	public Mipscliniciangrid()
	{
		rows = new ArrayList<>();
		 
	}
	
	/**
	 * 	//TODO: parameter description
	 * this method is used for  adding the rows 
	 * @param locationname
	 * @param City
	 * @param State
	 * @param postalcode
	 * @param Inactive
	 */

	public void addPopupuserGridcountRow1(String PROVIDERNAME, String MIPSELIGIBILITY, String NPI, String TIN,String QUALITY,String ACI,String IA,String MIPSFINALSCORE,String SUBMISSIONSTATUS)
	{
		rows.add(new MipscliniciangridRow(PROVIDERNAME, MIPSELIGIBILITY,NPI,TIN,QUALITY,ACI,IA,MIPSFINALSCORE,SUBMISSIONSTATUS));
	}

	@Override
	public int compareTo(Mipscliniciangrid target) throws NullPointerException
	{

		{
             
			if(target == null)
				throw new NullPointerException("Target object is null");
			MipscliniciangridRow sourceRow;
			MipscliniciangridRow targetRow;
		for(int i=0;i<this.rows.size();i++)
		{
			sourceRow = this.rows.get(i);
			targetRow = target.rows.get(i);
			if(sourceRow.compareTo(targetRow) != 0)
			{
				return -1;
			}
			
			
		}	return 0;
	
		
	}
	
	
	}
	
	
}
