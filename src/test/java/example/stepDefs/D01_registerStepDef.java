package example.stepDefs;

import example.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static example.stepDefs.Hooks.driver;

public class D01_registerStepDef extends P01_register {
    /*@Given("user go to register page")
    public void goRegisterPage()
    {
        System.out.println("This is a test before start coding");

        registerlink().click();
    }*/


    P01_register register = new P01_register();

    @Given("user go to register page")
    public void go_to_register()
    {
        register.register.click();
    }

    /*@Given("user go to register page")
    public void go_to_register()
    {
        register.registerlink().click();

    }*/
    P01_register selectGender = new P01_register();
    @When("user select gender type")
    public void select_gender() throws InterruptedException {
      selectGender.selectGenderFemale.click();
        Thread.sleep(1000);

        selectGender.selectGenderMale.click();
    }
    P01_register enterName = new P01_register();
    @And("user enter first name \"automation\" and last name \"tester\"")
    public void enter_name() throws InterruptedException {
        enterName.enterFirstName.sendKeys("automation100");

        Thread.sleep(1000);

        enterName.enterLastName.sendKeys("tester100");
    }

    P01_register enterBirthDate = new P01_register();
    @And("user enter date of birth")
    public void enter_birthDate()
    {
        enterBirthDate.selectDay.click();
        enterBirthDate.selectDay.findElement(By.cssSelector("option[value=\"2\"]")).click();

        enterBirthDate.selectMonth.click();
        enterBirthDate.selectMonth.findElement(By.cssSelector("option[value=\"6\"]")).click();

        enterBirthDate.selectYear.click();
        enterBirthDate.selectYear.findElement(By.cssSelector("option[value=\"1991\"]")).click();
    }
    P01_register enterEmail = new P01_register();
    @And("user enter email \"test@example.com\" field")
    public void enter_email()
    {
        enterEmail.enterEmail.sendKeys("test@example100.com");
    }
    P01_register enterPassword = new P01_register();
    @And("user fills Password fields \"P@ssw0rd\" \"P@ssw0rd\"")
    public void enter_password()
    {
        enterPassword.enterPassword.sendKeys("P@ssw0rd");

        enterPassword.ConfirmPassword.sendKeys("P@ssw0rd");

    }
    P01_register clickRegisterButton = new P01_register();
    @And("user clicks on register button")
    public void click_registerButton()
    {
        clickRegisterButton.clickRegisterButton.submit();
    }
    P01_register displaySuccessMessage = new P01_register();

    @Then("success message is displayed")
    public void display_SuccessMessage()
    {
        displaySuccessMessage.displaySuccessMessage.findElements(By.className("result"));

        //Assertion
        SoftAssert soft = new SoftAssert();

        String expectedResult = "Your registration completed";
        String actualResult = driver.findElement(By.className("result")).getText();
        soft.assertTrue(actualResult.contains(expectedResult));

        String expectedColor = "rgba(76, 177, 124, 1)";
        String actualColor = driver.findElement(By.className("result")).getCssValue("color");
        soft.assertTrue(actualColor.contains(expectedColor));

        soft.assertAll();



    }
}