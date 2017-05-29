package com.Training.XLReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlReader {
	
	
	public String excelFilePath = "C:\\Users\\ne321427\\workspace\\Project1\\TestCases\\TestCases.xlsx";
	public FileInputStream inputStream ;
	public Workbook workbook;
	public Sheet firstSheet;
	public static int rowcount=0;
	public static int colCount=0;
	public ArrayList<String> arr1=new ArrayList<String>();
	
	public XlReader() throws Exception{
		inputStream = new FileInputStream(new File(excelFilePath));
		workbook = new XSSFWorkbook(inputStream);
		firstSheet = workbook.getSheet("RunManager");
	}


	public void XLReader() throws FileNotFoundException{
		try{
			
      inputStream = new FileInputStream(new File(excelFilePath));
      workbook = new XSSFWorkbook(inputStream);
      firstSheet = workbook.getSheet("RunManager");
//    Header header=firstSheet.getHeader();
     int rowcount = firstSheet.getPhysicalNumberOfRows();
     System.out.println("total num of rows are"+rowcount);
     
     
     Iterator<Row> iterator = firstSheet.iterator();
     ArrayList<String> columndata = null;
     columndata=new ArrayList<>();
      
     while (iterator.hasNext()) {
         Row nextRow = iterator.next();
         Iterator<Cell> cellIterator = nextRow.cellIterator();
          
         while (cellIterator.hasNext()) {
             Cell cell = cellIterator.next();
           if(nextRow.getRowNum()>0){//to filter column headings
  
        	   if(cell.getCellTypeEnum()==CellType.STRING){
            	 System.out.println("Cell is having String Value"+cell);
            	 
            }
             else if(cell.getCellTypeEnum()== CellType.NUMERIC){
            	 System.out.println("Cell is having numeric value");
             }
             else if(cell.getCellTypeEnum()==CellType.BLANK){
            	 System.out.println("Cell is Empty");
             }
             System.out.print(" - ");
        
        
         }
         } 	
     }
      
     workbook.close();
     inputStream.close();
     }
     catch(Exception e){
    	 e.printStackTrace();
     }
	 
	 }
	
	
	public List<String> getRows() throws Exception{
		List<String> cellContents = new ArrayList<String>();
		
		rowcount = firstSheet.getLastRowNum(); // index frm 0
		rowcount++;
 		System.out.println("Rows are"+rowcount);
		 for(int i=0;i<rowcount;i++){  // num of rows needed		
		 			colCount = firstSheet.getRow(i).getLastCellNum();
		 			System.out.println("Cols are"+colCount);
		 			Row row = firstSheet.getRow(i);
		 			for(int j=0;j<colCount;j++){
		 			String cell = row.getCell(j).toString().trim();
		 			arr1.add(cell);
		 //			String print= cellContents.get(i);
		 //			System.out.println("Arraylist"+print);
		 			System.out.println(arr1.get(j));
		 			}	 			
		 			}
		 	return 	cellContents;
	}
	
	}

