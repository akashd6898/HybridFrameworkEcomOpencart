package tests;

import org.testng.annotations.Test;
import pageObjects.UserLogin;
import utilities.DataProviders;
import utilities.ExcelUtility;


import java.io.IOException;

public class TC002_LoginUser extends BaseTests {
    UserLogin userlogin;
    /*String username, password;
    ExcelUtility xlUtility;
    Object[][] login_Data;*/

    /*@Test
    public void beforeClass() throws IOException {
        logger.info("reading the excel file");
        String xlPath = "C:\\Users\\AKASH\\AquaProjects\\HybridFrameworkEcomOpencart\\testData\\Login_Test data.xlsx";*//*System.getProperty("user.dir") +"\\testData\\Login_Test data.xlsx";*//*
        xlUtility= new ExcelUtility();
        xlUtility.excelReadingMode(xlPath);
        xlUtility.workbookOpen("reading");
        xlUtility.readingSheet("Sheet1");
        login_Data = new Object[xlUtility.totalRows][xlUtility.totalCols];
        for(int i=1; i<xlUtility.totalRows; i++) {
            for(int j=0; j<xlUtility.totalCols; j++) {
                login_Data[i-1][j] = xlUtility.getCellData(i, j);
                logger.info(login_Data[i-1][j]);
            }
        }
    }*/

    @Test
    public void testLoginUser(){
        userlogin = new UserLogin(driver);
        logger.info("**Navigating to Login**");
        urlNavigate(prop.getProperty("urlUserLogin"));
    }
    @Test(priority = 1,dataProvider = "LoginData", dataProviderClass = utilities.DataProviders.class)
    public void enterCredential(String username, String password, String xlResult){
        try{
            logger.info(username,password,xlResult);
            userlogin.loginEmail(username);
            userlogin.loginPassword(password);
        }
        catch(Exception e){
            logger.info(e.getMessage());
        }
    }
}
