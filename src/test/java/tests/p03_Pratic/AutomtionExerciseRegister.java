package tests.p03_Pratic;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomtionExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class AutomtionExerciseRegister {

    @Test
    public void aEregister() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("aEUrl"));
        AutomtionExercisePage automtionExercisePage=new AutomtionExercisePage();
        Faker faker=new Faker();
        automtionExercisePage.signUpButton.click();
        automtionExercisePage.fullName.sendKeys(faker.name().fullName());
        automtionExercisePage.email.sendKeys(faker.internet().emailAddress()+ Keys.ENTER);
        automtionExercisePage.gender.click();
        automtionExercisePage.password.sendKeys(faker.internet().password());
        automtionExercisePage.newsletter.click();
        automtionExercisePage.offers.click();
        automtionExercisePage.firstName.sendKeys(faker.name().firstName());
        automtionExercisePage.lastName.sendKeys(faker.name().lastName());
        automtionExercisePage.address1.sendKeys(faker.address().fullAddress());
        automtionExercisePage.state.sendKeys(faker.address().state());
        automtionExercisePage.city.sendKeys(faker.address().cityName());
        automtionExercisePage.zipcode.sendKeys(faker.address().zipCode());
        automtionExercisePage.mobile_number.sendKeys(faker.phoneNumber().phoneNumber());
        automtionExercisePage.createButton.click();
        automtionExercisePage.continueButton.click();
        automtionExercisePage.deleteButton.click();
        String expDeletedMessage="Account Deleted!";
        String actDeleteMessage=automtionExercisePage.deleteMessage.getText();
        Assert.assertEquals(actDeleteMessage.toUpperCase(),expDeletedMessage.toUpperCase());
        automtionExercisePage.continueButton.click();
        Thread.sleep(1000);
        Driver.quitDriver();


    }
}
