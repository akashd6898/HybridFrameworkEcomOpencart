package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataProviders {
    Logger logger = LogManager.getLogger(DataProviders.class);
    ExcelUtility xlUtility;
    Object[][] login_Data;
    @DataProvider(name="LoginData")
    public Object[][] getLoginData() throws IOException {
        logger.info("$$Under Data provider method$$");
        String xlPath = "C:\\Users\\AKASH\\AquaProjects\\HybridFrameworkEcomOpencart\\testData\\Login_Test data.xlsx"/*System.getProperty("user.dir") + "\\testData\\Login_Test data.xlsx"*/;
        xlUtility= new ExcelUtility();
        xlUtility.excelReadingMode(xlPath);
        logger.info("$$Reading the excel$$");
        xlUtility.workbookOpen("reading");
        logger.info("$$Passing the Sheet name$$");
        xlUtility.readingSheet("Sheet1");
        logger.info("$$Accessing the data$$");
        logger.info("Total Rows: " + xlUtility.totalRows + ", Total Columns: " + xlUtility.totalCols);
        login_Data = new Object[xlUtility.totalRows][xlUtility.totalCols];
        for(int i=1; i<=xlUtility.totalRows; i++) {
            for(int j=0; j<xlUtility.totalCols; j++) {
                login_Data[i-1][j] = xlUtility.getCellData(i, j);
                logger.info(login_Data[i-1][j]);
            }
        }
        return login_Data;
    }
}
