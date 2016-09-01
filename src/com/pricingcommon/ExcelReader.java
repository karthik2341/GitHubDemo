package com.pricingcommon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReader {
	
	public Map<String, String> getKnownGoodMap(String filePath,String sheetName,int rowNum) {
	      
        Map<String, String> knownGoodMap = new LinkedHashMap<String,String>();
        try {

            FileInputStream file = new FileInputStream(new File(filePath));

            // Get the xworkbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
            // Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheet(sheetName);
            

            // Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.rowIterator();
            int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
            for (int i = 0; i < rowNum; i++) {

                Row row = sheet.getRow(i);
                int m = i+1;
                Row row1 = sheet.getRow(m);

                

                for (int j = 0; j < row.getLastCellNum(); j++) {              	

                    
                	Cell cell = sheet.getRow(i).getCell(j);
                	cell.setCellType(Cell.CELL_TYPE_STRING);
                	
                	Cell cell1 = sheet.getRow(m).getCell(j);
                	cell1.setCellType(Cell.CELL_TYPE_STRING); 
                	         	
                     knownGoodMap.put(row.getCell(j).getStringCellValue(), row1.getCell(j).getStringCellValue());
                   
                }
              

                
                
            }
           
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return knownGoodMap;
    }
	
	// returns true if data is set successfully else false
		public boolean setCellData(String path,String sheetName,String colName,int rowNum, String data){
			try{
			FileInputStream fis = new FileInputStream(path); 
			HSSFWorkbook workbook = new HSSFWorkbook(fis);

			if(rowNum<=0)
				return false;
			
			int index = workbook.getSheetIndex(sheetName);
			int colNum=-1;
			if(index==-1)
				return false;
			
			
			HSSFSheet sheet = workbook.getSheetAt(index);
			

			HSSFRow row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				//System.out.println(row.getCell(i).getStringCellValue().trim());
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum=i;
			}
			if(colNum==-1)
				return false;

			sheet.autoSizeColumn(colNum); 
			row = sheet.getRow(rowNum-1);
			if (row == null)
				row = sheet.createRow(rowNum-1);
			
			HSSFCell cell = row.getCell(colNum);	
			if (cell == null)
		        cell = row.createCell(colNum);

		   
		    cell.setCellValue(data);

		    FileOutputStream fileOut = new FileOutputStream(path);

			workbook.write(fileOut);

		    fileOut.close();	

			}
			catch(Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		// returns the data from a cell
		public String getCellData(String path,String sheetName,String colName,int rowNum){
			try{
				FileInputStream fis = new FileInputStream(path); 
				HSSFWorkbook workbook = new HSSFWorkbook(fis);
				if(rowNum <=0)
					return "";
			
			int index = workbook.getSheetIndex(sheetName);
			int col_Num=-1;
			if(index==-1)
				return "";
			
			HSSFSheet sheet = workbook.getSheetAt(index);
			HSSFRow row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				//System.out.println(row.getCell(i).getStringCellValue().trim());
				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num=i;
			}
			if(col_Num==-1)
				return "";
			
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			HSSFCell cell = row.getCell(col_Num);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			
			if(cell==null)
				return "";
			//System.out.println(cell.getCellType());
			if(cell.getCellType()==Cell.CELL_TYPE_STRING)
				  return cell.getStringCellValue();
			else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){
				
				  String cellText  = String.valueOf(cell.getNumericCellValue());
				  if (HSSFDateUtil.isCellDateFormatted(cell)) {
			           // format in form of M/D/YY
					  double d = cell.getNumericCellValue();

					  Calendar cal =Calendar.getInstance();
					  cal.setTime(HSSFDateUtil.getJavaDate(d));
			            cellText =
			             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
			           cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
			                      cal.get(Calendar.MONTH)+1 + "/" + 
			                      cellText;
			           
			           //System.out.println(cellText);

			         }

				  
				  
				  return cellText;
			  }else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
			      return ""; 
			  else 
				  return String.valueOf(cell.getBooleanCellValue());
			
			}
			catch(Exception e){
				
				e.printStackTrace();
				return "row "+rowNum+" or column "+colName +" does not exist in xls";
			}
		}
		

}
