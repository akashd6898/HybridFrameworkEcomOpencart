package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {

    FileInputStream fileInReading;
    FileOutputStream fileInWriting;

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public int totalRows;
    public int totalCols;

    String cellData;

    public void excelReadingMode(String xlpath) throws FileNotFoundException {
        fileInReading =new FileInputStream(xlpath);
        //return fileInReading;
    }

    public FileOutputStream excelWritingMode() throws FileNotFoundException {
        fileInWriting = new FileOutputStream("./testData/Login_Test data.xlsx");
        return fileInWriting;
    }

    public void workbookOpen(String openType) throws IOException {
        if(openType.equalsIgnoreCase("reading"))
        {
            workbook = new XSSFWorkbook(fileInReading);
        }
       else if(openType.equalsIgnoreCase("writing"))
        {
            workbook = new XSSFWorkbook();
        }
       else{
           System.out.println("Invalid workbook open option");
           assert false;
        }
    }

    public void readingSheet(String sheetName)
    {
        sheet = workbook.getSheet(sheetName);
        //sheet = workbook.getSheet("name");
        totalRows = sheet.getLastRowNum();
        totalCols = sheet.getRow(1).getLastCellNum();
    }
    public String getCellData(int row, int col)
    {
        cellData = sheet.getRow(row).getCell(col).getStringCellValue();
        return cellData;
    }
}
