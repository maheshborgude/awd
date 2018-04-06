package buisness.managers;

import org.apache.xpath.SourceTree;
import org.testng.internal.Utils;
import org.testng.xml.XmlSuite;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExcelReportManager implements IReporter {
	@Override
	/**
	 *
	 * @author Rakesh.Kulkarni
	 *
	 */

	public void generateReport(List<XmlSuite> arg0, List<ISuite> suites, String arg2) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("Result");
		XSSFRow row;
		Map<Integer, Object[]> empinfo = new TreeMap<Integer, Object[]>();
		empinfo.put(1, new Object[] { "Sr.NO", "Test Cases", "Test Data", "Expected Result", "Actual Result",
				"Execution Start Time" });
		for (ISuite s : suites) {
			Integer j = 2;
			Integer k = 1;
			for (ISuiteResult r : s.getResults().values()) {
				ITestContext i = r.getTestContext();
				for (ITestResult res : i.getPassedTests().getAllResults()) {
					Date startDate = i.getStartDate();
					Date endDate = i.getEndDate();
					long diff = Math.abs(startDate.getTime() - endDate.getTime());
					double seconds = diff / 1000.0;
					int y = (int) Math.round(seconds);
					String srNo = "" + k;

					String testName = i.getName();
					List<String> elephantList3 = OtherClass(testName);
					String name = elephantList3.get(0);
					String result = elephantList3.get(1);

					empinfo.put(j, new Object[] { srNo, name, Utils.escapeHtml(Utils.toString(res.getParameters())),
							result, (res.getStatus() == 1 ? "Pass" : "Pass"), i.getStartDate().toLocaleString() });
				}

				for (ITestResult res : i.getFailedTests().getAllResults()) {
					Date startDate = i.getStartDate();
					Date endDate = i.getEndDate();
					long diff = Math.abs(startDate.getTime() - endDate.getTime());
					double seconds = diff / 1000.0;
					int y = (int) Math.round(seconds);
					String srNo = "" + k;

					String testName = i.getName();
					List<String> elephantList3 = OtherClass(testName);
					String name = elephantList3.get(0);
					String result = elephantList3.get(1);
					empinfo.put(j, new Object[] { srNo, name, Utils.escapeHtml(Utils.toString(res.getParameters())),
							result, (res.getStatus() == 1 ? "Fail" : "Fail"), i.getStartDate().toLocaleString() });
				}
				j++;
				k++;
			}
		}
		// Iterate over data and write to sheet
		Set<Integer> keyid = empinfo.keySet();
		int rowid = 0;
		for (Integer key : keyid) {
			row = spreadsheet.createRow(rowid++);
			Object[] objectArr = empinfo.get(key);
			int cellid = 0;
			for (Object obj : objectArr) {
				Cell cell = row.createCell(cellid++);
				cell.setCellValue((String) obj);
			}
		}
		// Write the workbook in file system
		FileOutputStream out = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date)); // 2014/08/06 15:59:48
			// out = new FileOutputStream(new
			// File(System.getProperty("user.dir")+"\\test-output\\AaoDemoReportExcel.xlsx"));
			out = new FileOutputStream(
					new File(System.getProperty("user.dir")
							+ "\\test-output\\TestAutomationReports\\ReportForAAO.xlsx"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Report has been written successfully");

	}

	/**
	 *
	 * @author Rakesh.Kulkarni
	 *
	 */
	private String getDurationString(int seconds) {
		int hours = seconds / 3600;
		int minutes = (seconds % 3600) / 60;
		seconds = seconds % 60;
		String h = twoDigitString(hours);
		String m = twoDigitString(minutes);
		String s = twoDigitString(seconds);
		return h + " : " + m + " : " + s;
	}

	/**
	 *
	 * @author Rakesh.Kulkarni
	 *
	 */
	private String twoDigitString(int number) {
		if (number == 0) {
			return "00";
		}
		if (number / 10 == 0) {
			return "0" + number;
		}
		return String.valueOf(number);
	}

	/**
	 *
	 * @author Rakesh.Kulkarni
	 *
	 */
	public List<String> OtherClass(String input) {

		List<String> elephantList = Arrays.asList(input.split(":"));
		try {
			String name = elephantList.get(0);
			String result = elephantList.get(1);
		} catch (Exception e) {
			String result = "Result Not Defined";
			List<String> elephantList1 = new ArrayList<String>(1);
			elephantList1.add(0, input);
			elephantList1.add(1, result);
			return elephantList1;
		}
		return elephantList;
	}
}
