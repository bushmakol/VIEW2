package AbstractComponents;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{
	
  public String getExcelData(int row,int column, String sheetName) throws InterruptedException, EncryptedDocumentException, IOException 
  {
	  FileInputStream fis = new FileInputStream(Constants.excelPath);
	  Workbook wb = WorkbookFactory.create(fis);
	  Sheet sh = wb.getSheet(sheetName);
	  Row row1= sh.getRow(row);
	
	  String value="";
	try {
			row1.getCell(column).setCellType(CellType.STRING);
			value = row1.getCell(column).getStringCellValue();
		} 
	catch (NullPointerException e) 
	{
		
		return value.trim();
	}
	  wb.close();
	  return value.trim();
	  
  }
  public void setExcelData(int row,int column, String data, String sheetName) throws InterruptedException, EncryptedDocumentException, IOException 
  {
	  FileInputStream fis = new FileInputStream(Constants.excelPath);
	  Workbook wb = WorkbookFactory.create(fis);
	  Sheet sh = wb.getSheet(sheetName);
	  //Row row1 = sh.createRow(row);
	  Row row1;
	  row1= sh.getRow(row);
	  Cell cel;
	try {
		cel = row1.createCell(column);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		row1= sh.createRow(row);
		cel = row1.createCell(column);
		//test
	}
	  FileOutputStream fos = new FileOutputStream(Constants.excelPath);
	  //cel.setCellType(CellType.STRING);
	  cel.setCellValue(data);
	  wb.write(fos);
	  fos.close();
	  wb.close();
  }
}
;