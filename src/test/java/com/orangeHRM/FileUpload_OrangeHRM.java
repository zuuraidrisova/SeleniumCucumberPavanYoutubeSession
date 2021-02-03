package com.orangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FileUpload_OrangeHRM {

    @Test
    public void testUploadFile_OrangeHRM() throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123"+ Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("menu_pim_viewPimModule")).click();

        Thread.sleep(2000);

        driver.findElement(By.linkText("Add Employee")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Pavan");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Kim");

        Thread.sleep(2000);

        String filePath = "/Users/zuura/Downloads/Landscape-Color.jpg";

        WebElement chooseFile = driver.findElement(By.xpath("//input[@class='duplexBox']"));

        Thread.sleep(2000);

        chooseFile.sendKeys(filePath);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='btnSave']")).click();

        Thread.sleep(2000);

        driver.close();

        //test will pass but our file is exceeded the size

    }
}
