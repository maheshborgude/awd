package buisness.util.datastructures.administration.provider;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class is used in order to store a table or a grid.
 * <p>
 * This class implements Comparable interface.
 * <p>
 *
 * @author Sachin Gawade
 *         <p>
 *         12 Jan 2016
 */
public class DashboardLocationProviderGrid implements Comparable<DashboardLocationProviderGrid> {
	private List<ProviderGridRow> rows;

	public DashboardLocationProviderGrid() {
		rows = new ArrayList<>();
	}

	//This method is used to compare two rows
	 //This method throws Comparable interface NullPointerException.
	 //Returns int value
	 //Returns 0 if both rows are same
	//Returns -1 if both rows are not same
	@Override
	public int compareTo(DashboardLocationProviderGrid target) throws NullPointerException {

		if (target == null) {
			throw new NullPointerException("Target object is null");
		}
		ProviderGridRow sourceRow;
		ProviderGridRow targetRow;

		// TODO: invalid logic try using with first row in valid and rest
		// correct:done

		if (rows.size() == target.rows.size()) {
			for (int i = 0; i < rows.size(); i++) {
				sourceRow = rows.get(i);
				targetRow = target.rows.get(i);

				if (sourceRow.compareTo(targetRow) != 0) {
					return -1;
				}
			}
			return 0;
		}
		return -1;

	}

	/**
	 * This method is used add rows in the grid
	 * <p>
	 * @author Sachin Gawade
	 *         <p>
	 *         12 Jan 2016
	 */

	public void ProviderGridCountRow(String firstname, String middlename, String lastname, String emailaddress,
			String npi, String inactive) {
		rows.add(new ProviderGridRow(firstname, middlename, lastname, emailaddress, npi, inactive));

	}

}