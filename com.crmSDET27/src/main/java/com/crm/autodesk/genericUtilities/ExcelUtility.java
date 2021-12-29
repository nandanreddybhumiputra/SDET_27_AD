package com.crm.autodesk.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Nanda
 *
 */
public class ExcelUtility {

	
	/**
	 * it is used to read the data from excel based on below arguments
	 * @param sheetName
	 * @param rowName
	 * @param cellNum
	 * @return data
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable {
		FileInputStream fis=new FileInputStream("./docs/commondata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}	
		/**
		 * it is used to get the last used row number on specific Sheet
		 * @param sheetName
		 * @return 
		 * @throws Throwable 
		 */
     public int getRowCount(String sheetName) throws Throwable {
        FileInputStream fis=new FileInputStream("./docs/commondata.xlsx");
 		Workbook wb=WorkbookFactory.create(fis);
 		Sheet sh=wb.getSheet(sheetName);
    	wb.close(); 
    	return sh.getLastRowNum();
     }
     
     
    
     public void setDataExcel(String sheetName,int rowNum,int cellNum,String data) throws Throwable {
        FileInputStream fis=new FileInputStream("./docs/commondata.xlsx");
 		Workbook wb=WorkbookFactory.create(fis);
 		Sheet sh=wb.getSheet(sheetName);
 		Row row = sh.getRow(rowNum);
    	Cell cell=row.createCell(cellNum); 
    	cell.setCellValue(data); 
    	FileOutputStream fos=new FileOutputStream("./docs/commondata.xlsx");
    	wb.write(fos);
    	wb.close();
     }	
}
