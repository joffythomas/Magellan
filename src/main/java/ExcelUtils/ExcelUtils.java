package ExcelUtils;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static HSSFSheet ExcelWorksheet;
	
	private static  HSSFWorkbook Workbook;
	
	private static HSSFRow Row;
	
	private static HSSFCell Cell;
	
	private static int rowNum = 0;
	
	

	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			Workbook = new HSSFWorkbook(ExcelFile);

			ExcelWorksheet = Workbook.getSheet(SheetName);

		} catch (Exception e) {

			throw (e);

		}

	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWorksheet.getRow(RowNum).getCell(ColNum);
			String CellData="";
			System.out.println(Cell.getCellType()+"type");
			
			if(Cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
			{
				int val = (int) Cell.getNumericCellValue();
				CellData = Integer.toString(val);
			}
			else if(Cell.getCellType()==Cell.CELL_TYPE_STRING)
			{
				CellData = Cell.getStringCellValue();
			}

			System.out.println(CellData);
			return CellData;

		} catch (Exception e) {

			return "";

		}

	}
	
	public static Date getDateCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWorksheet.getRow(RowNum).getCell(ColNum);

			Date CellData = Cell.getDateCellValue();
			System.out.println(Cell.getDateCellValue());

			return CellData;
			

		} catch (Exception e) {
			System.out.println("Incatch");
		}
		return null;

	}

	public static int findRow(String cellContent) {
		int rowNum = 0;
		for ( Row row : ExcelWorksheet) {
			for (Cell cell : row) {
				if (cell.getColumnIndex() <= 2) {
					if (cell.getColumnIndex() == 2) {
						if (cell.getRichStringCellValue().getString().equalsIgnoreCase(cellContent)) {
							rowNum = row.getRowNum();

						}
					}
				} else {
					break;
				}
			}
		}
		return rowNum;
	}

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters

	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {

		try {

			Row = ExcelWorksheet.getRow(RowNum);

			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(Constants.ExcelPath + Constants.TestData);

			Workbook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		} catch (Exception e) {

			throw (e);

		}

	}

}