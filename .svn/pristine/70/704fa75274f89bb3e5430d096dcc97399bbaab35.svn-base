package buisness.util.datastructures.Submission.gprosubmission.milestonetwo;


import java.util.ArrayList;
import java.util.List;

/**
 * This Class is used in order to store a table or a grid.<p>
 * This class implements Comparable interface.<p>
 * @author Sachin Gawade<p>
 * 11 Feb 2016
 */
public class ReportingMeasureGrid implements Comparable<ReportingMeasureGrid> {
	private List<ReportingMeasureGridRow> rows;

	public ReportingMeasureGrid() {
		rows = new ArrayList<>();
	}

	//This method is used to compare two rows
	//This method throws Comparable interface NullPointerException.
	//Returns int value
	//Returns 0 if both rows are same
	//Returns -1 if both rows are not same
	@Override
	/**
	 * This method is used to compare two rows<p>
	 * This method throws Comparable interface NullPointerException.<p>
	 * Returns 0 if both rows are same<p>
	 * Returns -1 if both rows are not same
	 */
	public int compareTo(ReportingMeasureGrid target) throws NullPointerException {

		if (target == null) {
			throw new NullPointerException("Target object is null");
		}
		ReportingMeasureGridRow sourceRow;
		ReportingMeasureGridRow targetRow;

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
	 * This method is used add data in the row of the grid <p> 
	 * @author Sachin Gawade
	 * 11 Feb 2016
	 */

	public void GproMeasureGridCountRow(String pqrsno, String measuretitle, String qualitydomain, String crosscutting) {
		rows.add(new ReportingMeasureGridRow(pqrsno, measuretitle, qualitydomain , crosscutting));

	}

}