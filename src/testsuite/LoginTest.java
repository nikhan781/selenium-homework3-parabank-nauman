package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    @Before
    public void openBrowser() {
        browserSetupBaseTest("https://parabank.parasoft.com/parabank/index.htm", "Chrome");
    }

    //Test 1
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        Thread.sleep(1000);
        //* Enter valid username
        sendTextToElement(By.name("username"), "Cap001");
        //* Enter valid password
        sendTextToElement(By.name("password"), "Avenger01");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //* Verify the ‘Accounts Overview’ text is display
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Accounts Overview')]"), "Accounts Overview");
    }

    //Test 2
    @Test
    public void verifyTheErrorMessage() {
        //* Enter invalid username
        sendTextToElement(By.name("username"), "Thanos001");
        //* Enter invalid password
        sendTextToElement(By.name("password"), "AntiAvenger01");
        //* Click on Login button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //* Verify the error message ‘The username and password could not be verified.’
        verifyTextFromElements(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"), "The username and password could not be verified.");
    }

    //Test 3
    @Test
    public void userShouldLogOutSuccessfully() {
        //* Enter valid username
        sendTextToElement(By.name("username"), "Cap001");
        //* Enter valid password
        sendTextToElement(By.name("password"), "Avenger01");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //* Click on ‘Log Out’ link
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
        //* Verify the text ‘Customer Login’
        verifyTextFromElements(By.xpath("//h2[contains(text(),'Customer Login')]"), "Customer Login");
    }

    @After
    public void closingBrowser() {
        closingTheBrowserBaseTest();
    }
}

