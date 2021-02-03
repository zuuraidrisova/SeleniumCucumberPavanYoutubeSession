package com.orangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolling_JavaScriptExecutor {

    @Test
    public void scrollingByPixel_JavaScriptExecutor_test() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");

        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //scrolling using pixel
        js.executeScript("window.scrollBy(0, 1000)","");

        Thread.sleep(2000);

        //refresh the page using javascript
        js.executeScript("history.go(0)");

        //getting page title using javascript
        String title = js.executeScript("return document.title").toString();

        System.out.println("title = " + title);

        driver.close();
    }

    @Test
    public void scrollingByWebElement_JavaScriptExecutor_test() throws InterruptedException{

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");

        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //scrolling till we find web element
        WebElement KGZ_flag = driver.findElement(By.xpath("//img[@alt='Flag of Kyrgyzstan']"));

        js.executeScript("arguments[0].scrollIntoView();", KGZ_flag);

        KGZ_flag = driver.findElement(By.xpath("//img[@alt='Flag of Kyrgyzstan']"));

        if(KGZ_flag.isDisplayed()){

            System.out.println(true);
        }else{

            System.out.println(false);
        }

        Thread.sleep(2000);

        driver.close();

    }

    @Test
    public void scrollingTillBottom_JavaScriptExecutor_test() throws InterruptedException{

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");

        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //scrolling page till bottom
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");

        Thread.sleep(2000);

        driver.close();

    }
}
