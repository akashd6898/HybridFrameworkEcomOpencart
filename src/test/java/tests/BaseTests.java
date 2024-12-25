package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BaseTests {
    static WebDriver driver;
    Logger logger;
    Properties prop;
    @BeforeClass
    @Parameters({"os","browser"})
    public void setUp(String os, String browser) throws IOException {
     logger = LogManager.getLogger(this.getClass());
        FileReader fileReader = new FileReader("./src/test/resources/config.properties");
        prop = new Properties();
        prop.load(fileReader);
     switch(browser.toLowerCase())
        {
            case "chrome": driver = new ChromeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            default: System.out.println("Invalid Browser value"); return;
        }

     driver.manage().window().maximize();
     driver.manage().deleteAllCookies();
    }
    public void urlNavigate(String url)
    {
        driver.get(url);
    }
    public  void tearDown ()
    {
        driver.quit();
    }

    public String randomNumber()
    {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomText()
    {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomPassword()
    {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    public String captureScreenshot(String name) throws IOException
    {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        //String targetFileName = System.getProperty("user.dir")+"\\screenshots\\"+timestamp+"_st.png";
        String targetFileName = System.getProperty("user.dir")+"/reports/spark_report" +timestamp+"_st.jpeg";
        File targetFile = new File(targetFileName);
        sourceFile.renameTo(targetFile);
        return targetFileName;
    }
}
