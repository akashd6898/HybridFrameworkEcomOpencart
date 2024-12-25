package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.UserRegistration;
import utilities.DataProviders;

public class TC001_UserRegistrationTest extends BaseTests{
    UserRegistration userreg;

    @Test
    public void testUserRegistration() {
        try {
            logger.info("**Test Website**");
            urlNavigate(prop.getProperty("urlHome"));
            userreg = new UserRegistration(driver);
            userreg.clickAccountMenu();
            logger.info("**Test User Registration**");
            userreg.clickRegisterMenu();
            Thread.sleep(5000);
        }
        catch(Exception e) {
            logger.error("Test User Registration Failed");
            Assert.fail("Test User Registration Failed due to " + e.getMessage());
        }
    }
    @Test(priority = 1)
    public void testFillRegistration()
    {
        try {
            String generatedPassword = randomPassword();
            String generatedFirstRandomText = randomText();
            logger.info("**Test Registration Fill**");
            userreg.userName(generatedFirstRandomText, randomText());
            userreg.enterEmail(generatedFirstRandomText + "@mail.com");
            userreg.enterPassword(generatedPassword);
            userreg.enterConfirmPassword(generatedPassword);
            userreg.enterTelephone(randomNumber());
            userreg.setNewsletter(true);
            logger.info("**Username:"+generatedFirstRandomText+"@mail.com");
            logger.info("**Password:"+generatedPassword);
        }
        catch(Exception e) {
            logger.error("Test Registration Fill Failed");
            Assert.fail("Test Registration Fill Failed due to exception:"+e.getMessage());
        }
    }
    @Test(priority = 2)
    public void passwordAssert()
    {
        logger.info("**Test Password Assert**");
        Assert.assertEquals(userreg.getPassword(), userreg.getConfirmPassword());
    }

    @Test(priority=2)
    public void checkPolicy()
    {
        logger.info("**Test Check Policy: Checked**");
        userreg.checkboxPolicy(true);
        logger.info("**Test Check Policy: True**");
        Assert.assertEquals(userreg.submitButtonStatus(), true);
    }

//    @AfterClass
//    public void closeBrowser() {
//        tearDown();
//    }
}
