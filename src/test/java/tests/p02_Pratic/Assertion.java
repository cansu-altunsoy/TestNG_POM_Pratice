package tests.p02_Pratic;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BabayigitPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Assertion {

    @Test
    public void test01(){

        Driver.getDriver().get(ConfigReader.getProperty("babayigitUrl"));
        BabayigitPage babayigit=new BabayigitPage();

        //Sitenin title'ında Testing! kelimesini olduğunu doğrulayınız

        String expectedIcerik="Testing!";
        String actualTitle=Driver.getDriver().getTitle();

        // Assert.assertTrue(actualTitle.contains(expectedIcerik));

        String url="https://www.babayigit.net/test/";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualUrl,url);
        softAssert.assertTrue(actualTitle.contains(expectedIcerik));
        softAssert.assertAll();
        Driver.quitDriver();
    }

}
