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
	private Sheet firstSheet;
	private static int rowcount=0;
	private static int colCount=0;
	private ArrayList<String> arr1=new ArrayList<String>();
	
	public XlReader() throws Exception{
		inputStream = new FileInputStream(new File(excelFilePath));
		workbook = new XSSFWorkbook(inputStream);
		firstSheet = workbook.getSheet("RunManager");
	}

	public List<String> getRows() throws Exception{
	//	List<String> cellContents = new ArrayList<String>();
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
		 //			String print= cellContents.get(i);
		 //			System.out.println("Arraylist"+print);
		 			System.out.println(arr1.get(Counter));
		 			Counter++;
	
		 			}	 			
		 			}
		 	return 	arr1;
	}
	
	}

