package com.cydeo.practice.nextBase_CRM;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CY7_US13 {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env2"));
        //1-User on the homepage
        CRM_Utilities.crm_login(driver, ConfigurationReader.getProperty("usernameHelp1"), ConfigurationReader.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        BrowserUtils.sleep(2);
        driver.close();

    }

    @Test
    public void text_create_appreciation(){
        //click MORE button to see appreciation option
        WebElement moreButton=driver.findElement(By.xpath("//*[@class='feed-add-post-form-link-text']"));
        moreButton.click();
        //click Appreciation option
        WebElement appreciationButton= driver.findElement(By.xpath("//*[text()='Appreciation']"));
        appreciationButton.click();
        //changing focus to iframe
       driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[1]")));
       //enter some content
        WebElement content= driver.findElement(By.xpath("//body[@contenteditable='true']"));
       content.sendKeys("Hello B25 Test 24");
       //changing focus to parent frame
       driver.switchTo().parentFrame();
       //click send button
        WebElement sendButton=driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        //verify appreciation message is displayed
        WebElement isDisplayed=driver.findElement(By.xpath("//*[id='blog_post_body_525']"));
        System.out.println("isDisplayed.isDisplayed() = " + isDisplayed.isDisplayed());
    }
    @Test
    public void test_appreciation_withNoContent(){

        //click MORE button to see appreciation option
        WebElement moreButton=driver.findElement(By.xpath("//*[@class='feed-add-post-form-link-text']"));
        moreButton.click();

        //click Appreciation option
        WebElement appreciationButton= driver.findElement(By.xpath("//*[text()='Appreciation']"));
        appreciationButton.click();

        //changing focus to iframe
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[1]")));

        //enter some content
        WebElement content= driver.findElement(By.xpath("//body[@contenteditable='true']"));

        content.sendKeys("");

        //changing focus to parent frame
        driver.switchTo().parentFrame();

        //click send button
        WebElement sendButton=driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        //verify if The message title is not specified is displayed
        WebElement errorText= driver.findElement(By.xpath("//*[text()='The message title is not specified']"));

        Assert.assertTrue(errorText.isDisplayed());

    }


}
