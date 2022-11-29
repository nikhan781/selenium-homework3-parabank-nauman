package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    @Before
    public void openBrowser() {
        browserSetupBaseTest("https://parabank.parasoft.com/parabank/index.htm", "Chrome");
    }

    //Test 1
    @Test
    public void verifyThatSigningUpPageDisplay() {
        //* click on the ‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //* Verify the text ‘Signing up is easy!’
        verifyTextFromElements(By.xpath("//h1[contains(text(),'Signing up is easy!')]"), "Signing up is easy!");
    }

    //Test 2
    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
        //* click on the ‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //* Enter First name
        sendTextToElement(By.id("customer.firstName"),"Captain");
        //* Enter Last name
        sendTextToElement(By.id("customer.lastName"),"America");
        //* Enter Address
        sendTextToElement(By.id("customer.address.street"),"1 Avengers Avenue");
        //* Enter City
        sendTextToElement(By.id("customer.address.city"),"New York");
        //* Enter State
        sendTextToElement(By.id("customer.address.state"),"New York");
        //* Enter Zip Code
        sendTextToElement(By.id("customer.address.zipCode"),"N01 2YK");
        //* Enter Phone
        sendTextToElement(By.id("customer.address.zipCode"),"0100000001");
        //* Enter SSN
        sendTextToElement(By.id("customer.ssn"),"345");
        //* Enter Username
        sendTextToElement(By.id("customer.username"),"Cap10");
        //* Enter Password
        sendTextToElement(By.id("customer.password"),"Avenger01");
        //* Enter Confirm
        sendTextToElement(By.id("repeatedPassword"),"Avenger01");
        //* Click on REGISTER button
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));

        //* Verify the text 'Your account was created successfully. You are now logged in.
        verifyTextFromElements(By.xpath("//div[@id='rightPanel']/p"),"Your account was created successfully. You are now logged in.");

    }


    @After
    public void closingBrowser() {
        closingTheBrowserBaseTest();
    }
}
