package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_Config_Practice {

    @Test
    public void google_search_test(){

        Driver.getDriver().get("https://www.google.com");
        //3 Write "apple" in the search box
        WebElement googleSearchBox=Driver.getDriver().findElement(By.xpath("//input[@name='q']"));

        googleSearchBox.sendKeys(ConfigurationReader.getProperty("searchValue"));

        //4- Verify title:
        //Expected: apple - Google Search
        String expectedTitle="apple - Google Search";
        String actualTitle=Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

    }
    }
