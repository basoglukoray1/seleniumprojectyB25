package com.cydeo.practice.nextBase_CRM;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CY7_US7 {




         WebDriver driver;

        @BeforeMethod
        public void setUp() {
            //TC #1: Radiobutton handling
            //1. Open Chrome browser and login to https://login2.nextbasecrm.com

            driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(ConfigurationReader.getProperty("env2"));


            WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
            username.sendKeys(ConfigurationReader.getProperty("username"));

            WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));

            password.sendKeys(ConfigurationReader.getProperty("password"));

            WebElement rememberMeButton = driver.findElement(By.xpath("//input[@id='USER_REMEMBER']"));
            rememberMeButton.click();

            WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
            BrowserUtils.sleep(3);
            loginButton.click();

        }
        @AfterMethod
        public void tearDown() {
            BrowserUtils.sleep(3);
            driver.close();
        }

          @Test
            public void test_poll() {


        WebElement pollBtn = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-vote']"));
        BrowserUtils.sleep(3);
        pollBtn.click();

        clickAndVerifyRadioButton(driver, "bx-vote-block-inp-substitute", "vote_radio_1138_2558");
        clickAndVerifyRadioButton(driver, "vote_radio_1138", "vote_radio_1138_2559");

             }


    //3. Locate name='vote_radio_1138' radio buttons and store them in a List of Web Element
         @Test
        public void  clickAndVerifyRadioButton(WebDriver driver, String classAttribute, String idValue) {

            List<WebElement> radioButtons = driver.findElements(By.xpath("//label[text()='Select a language']"));

            for (WebElement each : radioButtons) {
                String eachId = each.getAttribute("id");

                if (eachId.equals(idValue)) {
                    BrowserUtils.sleep(3);
                    each.click();
                    System.out.println(eachId + " is selected : " + each.isSelected());
                    break;
                }

                if (each.isSelected()) {
                    System.out.println("Verification PASSED!!");
                } else {
                    System.out.println("Verification FAILED!!");
                }

                WebElement voteBtn = driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-lg ui-btn-primary']"));
                BrowserUtils.sleep(3);
                voteBtn.click();

                if (voteBtn.isSelected()) {
                    System.out.println("Verification PASSED!!");
                } else {
                    System.out.println("Verification FAILED!!");
                }

            }

        }


    }
