package TestData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;





public class CreateExcelData {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
	  LocalDate Date = LocalDate.now();
	  String usercode;
	  String intime;
	  String outtime;
	  
	  
	  
	public void writeexceldata(String employeename,String coemployee,String intime,String outtime) throws IOException
	{
		File file= new File(System.getProperty("user.dir") +"/Excel/Attendance.xls");
		HSSFWorkbook wb= new HSSFWorkbook();
		HSSFSheet sh=wb.createSheet("Sheet1");
		 Map<String, Object[]> data = new TreeMap<String, Object[]>(); 
	FileOutputStream fos = new FileOutputStream(file);

		 
	data.put("1", new Object[]{ "Employee Details", "ECN", "Department", "Designation", "Date (MM/dd/yyyy)", "Punch_In_Time", 
			"Punch_Out_Time", "Total_Time", "Status" }); 	
	data.put("2", new Object[]{ "Paresh", employeename, "Department", "Designation", dtf.format(Date), intime, 
			outtime, "", "" }); 
	data.put("3", new Object[]{ "Paresh", coemployee, "Department", "Designation", dtf.format(Date), intime, 
			outtime, "", "" }); 
	
	 // Iterate over data and write to sheet 
    Set<String> keyset = data.keySet(); 
    int rownum = 0; 
    for (String key : keyset) { 
        // this creates a new row in the sheet 
        Row row = sh.createRow(rownum++); 
        Object[] objArr = data.get(key); 
        int cellnum = 0; 
        for (Object obj : objArr) {  
            // this line creates a cell in the next column of that row 
            Cell cell = row.createCell(cellnum++); 
            if (obj instanceof String) 
                cell.setCellValue((String)obj); 
            else if (obj instanceof Integer) 
                cell.setCellValue((Integer)obj); 
        } 
    } 
	
		wb.write(fos);
		
	}

}
