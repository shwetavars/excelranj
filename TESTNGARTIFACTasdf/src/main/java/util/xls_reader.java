package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xls_reader {

	//vars
	public String path;
	public FileInputStream fis=null;
	public FileOutputStream fos= null;
	
	private XSSFWorkbook  workbook =null;
	private XSSFSheet  sheet =null;
	private XSSFRow  row =null;
	private XSSFCell  cell =null;
	
	public xls_reader(String path) 
	{
		this.path=path;
		try {
		fis= new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet=workbook.getSheetAt(0);
		fis.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public String getcelldata(String sheetName,String colname, int rownum)
	{
		try
		{
			//get sheet info with getSheetIndex
			int index=workbook.getSheetIndex(sheetName);
			int col_num=0;
			
			sheet= workbook.getSheetAt(index);
			
			
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(colname.trim()))
					col_num=i;	
			}
			
			//for column 
			row=sheet.getRow(rownum-1);
			cell= row.getCell(col_num);
			return cell.getStringCellValue();
			
			}catch(Exception e)
		{e.printStackTrace();
		return rownum+colname;
		}
	}
	
	}
	


