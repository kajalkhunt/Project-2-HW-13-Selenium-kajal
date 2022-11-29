package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

    public void selectMyAccountOptions(String option) {

        List<WebElement> list = driver.findElements(By.xpath("//body/nav/div/div/ul/li/ul/li"));
        for (WebElement options : list) {
            System.out.println(options.getText());
            if (options.getText().equalsIgnoreCase(option)) {
                options.click();
                break;
            }
        }
    }
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        clickOnElement(By.xpath("//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]"));
        selectMyAccountOptions("Register");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        clickOnElement(By.xpath("//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]"));
        selectMyAccountOptions("Login");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {

        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]"));

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

        //  3.3 Enter First Name
        String firstName = "Jack";
        sendTextToElement(By.id("input-firstname"), firstName);

        // 3.4 Enter Last Name
        String lastName = "Wills";
        sendTextToElement(By.id("input-lastname"), lastName);
        // 3.5 Enter Email

        sendTextToElement(By.id("input-email"),"William.Smith12@gmail.com");

        // 3.6 Enter Telephone
        sendTextToElement(By.id("input-telephone"), "07478224212");

        // 3.7 Enter Password

        sendTextToElement(By.id("input-password"), "Summer20");

        // 3.8 Enter Password Confirm
        sendTextToElement(By.id("input-confirm"), "Summer20");

        // 3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("(//input[@type='radio'])[2]"));

        // 3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@type='checkbox']"));

        // 3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@type='submit']"));

        // 3.12 Verify the message “Your Account Has Been Created!”
        String expTextAccount = "Your Account Has Been Created!";
        String actTextAccount = getTextFromElement(By.xpath("//h1[contains(text(), 'Been Created')]"));
        Assert.assertEquals("Not Matching", expTextAccount, actTextAccount);

        //  3.13 Click on Continue button
        clickOnElement(By.xpath("//a[text()='Continue']"));

        // 3.14 Click on My Account Link
        clickOnElement(By.xpath("//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]"));

        // 3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        //  3.16 Verify the text “Account Logout”
        String expTextLogout = "Account Logout";
        String actTextLogout = getTextFromElement(By.xpath("//h1[text()='Account Logout']"));
        Assert.assertEquals("Not Logout", expTextLogout, actTextLogout);

        // 3.17 Click on Continue button
        clickOnElement(By.xpath("//a[text()='Continue']"));

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {

        // 4.1 Click on My Account Link.
        clickOnElement(By.xpath("//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]"));

        //  4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

        //  4.3 Enter Email address
        sendTextToElement(By.id("input-email"), "William.Smith12@gmail.com");

       // 4.4 Enter Last Name


        // 4.5 Enter Password
        sendTextToElement(By.id("input-password"), "Summer20");

        // 4.6 Click on Login button
        clickOnElement(By.xpath("//input[@type='submit']"));
Thread.sleep(5000);
        // 4.7 Verify text “My Account”
        String expTextMyAccount = "My Account";
        String actTextMyAccount = getTextFromElement(By.xpath("//h2[text()='My Account']"));
        Assert.assertEquals("Not logged in", expTextMyAccount,actTextMyAccount);


        // 4.8 Click on My Account Link.
        clickOnElement(By.xpath("//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]"));

        // 4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        // 4.10 Verify the text “Account Logout”
        String expTextLogout = "Account Logout";
        String actTextLogout = getTextFromElement(By.xpath("//h1[text()='Account Logout']"));
        Assert.assertEquals("Not Logout", expTextLogout, actTextLogout);

        // 4.11 Click on Continue button
        clickOnElement(By.xpath("//a[text()='Continue']"));
    }

}
