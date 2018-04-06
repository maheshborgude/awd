package buisness.util.datastructures.dashboard.provider;

import java.util.ArrayList;
import java.util.List;

/**
 * This class compare row of Data grid of Dashboard>>Provider or
 * Dashboard>>Location This class implements Comparable<ProviderLocationGrid>
 * 
 * @author Sachin.Gawade Date 1 March 2016
 * @author probeer.roy Updated Date: 18 Dec 2017
 */

public class ProviderViewGrid implements Comparable<ProviderViewGrid> {
	private List<ProviderViewGridRow> rows;

	/**
	 * ProviderLocationGrid constructor It Initializes rows to type
	 * ArrayList<>()
	 */
	public ProviderViewGrid() {
		rows = new ArrayList<>();
	}

	/**
	 * This method is used for adding the rows in ProviderLocationGridRow
	 * 
	 * @param name:
	 *            Provider or Location name
	 * @param exceeding:
	 *            Exceeding count
	 * @param below:
	 *            Below count
	 */
	public void addProvider(String providername, String exceeding, String withinrange, String below) {

		rows.add(new ProviderViewGridRow(providername, exceeding, withinrange, below));
	}

	@Override
	/**
	 * This method is uset to compare two grids of same data type
	 * @param target Passed UI Grid
	 * @return 0(for match),-1(for mismatch)
	 */
	public int compareTo(ProviderViewGrid target) throws NullPointerException {
		{
			if (target == null)
				throw new NullPointerException("Target object is null");
			ProviderViewGridRow sourceRow;
			ProviderViewGridRow targetRow;
			int a = this.rows.size();
			int b = target.rows.size();
			System.out.println(+a + "==" + b);
			if (a == b) {
				for (int i = 0; i < a; i++) {
					sourceRow = this.rows.get(i);
					targetRow = target.rows.get(i);
					if (sourceRow.compareTo(targetRow) != 0) {
						return -1;
					}

				}
				return 0;

			}
			return -1;

		}
	}
}
