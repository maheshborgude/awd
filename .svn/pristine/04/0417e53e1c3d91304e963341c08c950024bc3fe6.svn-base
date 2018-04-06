package buisness.util.datastructures.gprosubmission;


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
 *         11 Feb 2016
 */
public class GproMeasureGrid implements Comparable<GproMeasureGrid> {
	private List<GproMeasureGridRow> rows;

	public GproMeasureGrid() {
		rows = new ArrayList<>();
	}

	//This method is used to compare two rows
	 //This method throws Comparable interface NullPointerException.
	 //Returns int value
	 //Returns 0 if both rows are same
	//Returns -1 if both rows are not same
	@Override
	public int compareTo(GproMeasureGrid target) throws NullPointerException {

		if (target == null) {
			throw new NullPointerException("Target object is null");
		}
		GproMeasureGridRow sourceRow;
		GproMeasureGridRow targetRow;

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
	 *         11 Feb 2016
	 */

	public void GproMeasureGridCountRow(String pqrsno, String measuretitle, String qualitydomain, String crosscutting) {
		rows.add(new GproMeasureGridRow(pqrsno, measuretitle, qualitydomain , crosscutting));

	}

}