package com.qa.tests;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DemoQaScreenshot {

    private WebDriver driver;

    @Test
    public void captureScreenshot() throws Exception {
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //LAUNCH THE DEMOQA WEBSITE
        driver.get("https://demoqa.com/");


        //VERIFY NAME OF THE THIRD BOOK ITEM
        driver.findElement(By.xpath("//a[@href='/books?book=9781449337711']"));

        //VERIFY AUTHOR OF THE THIRD BOOK ITEM
        driver.findElement(By.xpath("//div[@class='rt-td' and text()='Glenn Block et al.']"));

        //VERIFY PUBLISHER OF THE THIRD BOOK ITEM
        driver.findElement(By.xpath("//div[@id='app']/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/div/div[4]"));

        //CLICK ON THE THIRD BOOK ITEM
        driver.findElement(By.xpath("//a[text()='Designing Evolvable Web APIs with ASP.NET']"));
        //VERIFY THE ISBN
        driver.findElement(By.id("ISBN-label"));

        //VERIFY THE TITLE
        driver.findElement(By.id("title-label"));

        //VERIFY THE AUTHOR
        driver.findElement(By.id("author-label"));

        //CLICK ON THE WEBSITE LINK IN BOOKSTORE PAGE
        driver.findElement(By.xpath("(//label[@id='userName-value'])[8]")).click();

        // VERIFY THE NEW TAB IS OPENED
        driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "t");
        //LAUNCHING THE OREILLY SITE
        driver.get("https://www.oreilly.com/");

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            Utility.captureScreenshot(driver, result.getName());
        }
        driver.quit();

    }

}

