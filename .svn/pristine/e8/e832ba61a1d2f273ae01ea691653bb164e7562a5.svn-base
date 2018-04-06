package buisness.util.datastructures.dashboard.practice.practiceProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class contain Table Grid logic for Practice >> Provider View
 * This class is used to compare Performance Trend Table from UI and DB.
 * @author Ashwini.Gore
 * Created date : 4/12/2017
 */
public class PracticeProviderPopUpViewGrid implements Comparable<PracticeProviderPopUpViewGrid>
{
  	private List<PracticeProviderPopUpViewGridRow> rows;

		public PracticeProviderPopUpViewGrid()
		{
		rows = new ArrayList<>();
		}
		
		public void addRowToTable(String providerName, String All, String Met, String NotMet, String Performance,String registryAverage  )
		{
			// System.out.println("It is coming to add method");
		   rows.add(new PracticeProviderPopUpViewGridRow(providerName, All, Met, NotMet, Performance,registryAverage));	
		}
		
		@Override
		public int compareTo(PracticeProviderPopUpViewGrid target) throws NullPointerException {
			// TODO Auto-generated method stub
			System.out.println("Compare To method of Dashboard>>Practice Provider tab View\n");
			if(target ==null)
				throw new NullPointerException("Target object is null");
				//return -1;
			int a = this.rows.size();
			int b = target.rows.size();
			System.out.println("UI:Total Rows: "+a+ "\tDB:Total Rows: " +b);
			if(a==b)
			{
				PracticeProviderPopUpViewGridRow sourceRow;
				PracticeProviderPopUpViewGridRow targetRow;
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

