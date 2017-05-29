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
	
	
	private String excelFilePath = "C:\\Users\\ne321427\\workspace\\Project1\\TestCases\\TestCases.xlsx";
	private FileInputStream inputStream ;
	private Workbook workbook;
	private static Sheet firstSheet;
	private static String BrowserToSelect = "";
	private static String TestCaseName = "";
	private static int rowcount=0;
	private static int colCount=0;
	private ArrayList<String> arr1=new ArrayList<String>();
	
	public XlReader() {
		try{
		inputStream = new FileInputStream(new File(excelFilePath));
		workbook = new XSSFWorkbook(inputStream);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void switchXlWorkBook(String Sheetname)throws Exception{
		
		try{
			firstSheet = workbook.getSheet(Sheetname);
			
			if(firstSheet.equals("Runmanager")){
				System.out.println("--Inside Xl reader method --");
				
				
				List<String> ArrayList=new ArrayList<String>();
				ArrayList.addAll(getRowsData());
			    Iterator<String> iterator = ArrayList.iterator();
			     
			     while (iterator.hasNext()) {
			         String ArrayIndex = iterator.next();
			         if(ArrayIndex.equals("Y")){
			        	
			        	 TestCaseName = iterator.next();
			        	 
			        	 BrowserToSelect = iterator.next();
			        	
			         }
			     }
			}else{
			getRowsData();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<String> getRowsData() throws Exception{

		int Counter  = 0;
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
		 			System.out.println(arr1.get(Counter));
		 			Counter++;
	
		 			}	 			
		 			}
		 	return 	arr1;
	}
	
	}

