package TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CaptureExcelData {
	 Row row=null;
	 int rows=0;
	 int col =0;
	 Cell cell=null;
	 String data_path=null;
		public String[][] readfile(String filepath, String filename, String sheetname) throws IOException
		{
		    File file = new File(filepath+"\\"+filename);
		    FileInputStream fis = new FileInputStream(file);

		  Workbook wb = null;
		  String fileExtensionName = filename.substring(filename.indexOf("."));
			//wb = new XSSFWorkbook(Fis);
			//System.out.println("here");
			if(fileExtensionName.equals(".xlsx")){
			    //If it is xlsx file then create object of XSSFWorkbook class
			    wb = new XSSFWorkbook(fis);
			    }
			    //Check condition if the file is xls file
			    else if(fileExtensionName.equals(".xls")){
			        //If it is xls file then create object of XSSFWorkbook class
			        wb = new HSSFWorkbook(fis);
			    } 


		    Sheet sh = wb.getSheet(sheetname);
		   
		    int rows=sh.getLastRowNum()-sh.getFirstRowNum();
		   
	      // int rowcount = sh.getLastRowNum()-sh.getFirstRowNum();
		    row= sh.getRow(1);
         int col = row.getLastCellNum();
        
         System.out.println("cols"+col);
	       System.out.println("rows"+rows);
	       String data[][] = new String[rows][col];
		    for(int i=0;i<rows;i++)
		    {
		        
           
        
             row=sh.getRow(i+1);
		        

		        for (int j = 0; j < row.getLastCellNum(); j++) {
		        	
		             cell = row.getCell((j),Row.CREATE_NULL_AS_BLANK);
		            switch (cell.getCellType()) {
		            case Cell.CELL_TYPE_STRING:
		               // System.out.print(row.getCell(j).getStringCellValue() + " ");
		                data[i][j]=row.getCell(j,Row.CREATE_NULL_AS_BLANK).getStringCellValue();
		             //   System.out.println(data[i][j]);
		                break;

		            case Cell.CELL_TYPE_NUMERIC:
		              //  System.out.print((int)row.getCell(j).getNumericCellValue() + " ");
		                data[i][j]=String.valueOf((int)row.getCell(j).getNumericCellValue());
		               // System.out.println(data[i][j]);
		                break;
		           
		            }
		           

		        }
	            
		        
	          
		    }
		    return data;
		}

}
