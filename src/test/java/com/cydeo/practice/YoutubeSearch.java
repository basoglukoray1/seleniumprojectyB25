package com.cydeo.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YoutubeSearch {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://youtube.com");
        Thread.sleep(3000);

        WebElement searchBox=driver.findElement(By.cssSelector("input[id='search']"));

        searchBox.sendKeys("unravelmysprit");

        Thread.sleep(2000);

       WebElement searchButton=driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));

       searchButton.click();

        Thread.sleep(2000);

       WebElement clickchannel=driver.findElement(By.xpath("//*[@id=\"img\"]"));

       clickchannel.click();














    }
}
