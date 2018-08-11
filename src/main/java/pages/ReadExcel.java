package excelfun;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {


public static Object[][] readExcel(String fileName) throws IOException
{
	XSSFWorkbook wBook=new XSSFWorkbook("./data/"+fileName+".xlsx");
	//Go to sheet
	XSSFSheet sheet = wBook.getSheetAt(0);
	//find the row count
	int rowNum = sheet.getLastRowNum();
	//find the cell count
	short cellNum = sheet.getRow(0).getLastCellNum();
	//Read the data
	Object[][] data=new Object[rowNum][cellNum];
	for(int i=1;i<=rowNum;i++) {
		XSSFRow row = sheet.getRow(i);
		for(int j=0;j<cellNum;j++) {
			try {
				XSSFCell cell = row.getCell(j);
				data[i-1][j] = cell.getStringCellValue();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				data[i-1][j]="";
			}
			//System.out.println(data);
		}
	}
	wBook.close();
	return data;
}
}
