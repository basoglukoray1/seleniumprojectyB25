package com.cydeo.practice.nextBase_CRM;

import com.cydeo.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practice {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));

    }
    // Step 1
    @Test
    public void logIn(){


        WebElement userNameButton= driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userNameButton.sendKeys(ConfigurationReader.getProperty("username"));

        WebElement passwordButton= driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordButton.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement logInButton=driver.findElement(By.xpath("//input[@value='Log In']"));
        logInButton.click();

        WebElement taskButton= driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']"));
        // Step2: Click Task button
        taskButton.click();
      driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@class='bx-editor-iframe'])[2]")));




        WebElement content=driver.findElement(By.xpath("//body[@contenteditable='true']"));
      //  content.click();

        content.sendKeys("Hello");



    }
}
