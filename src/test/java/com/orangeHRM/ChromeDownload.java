package com.orangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ChromeDownload {

    @Test
    public void testingDownloadUsingChrome() throws InterruptedException{

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://demo.automationtesting.in/FileDownload.html");

        //download text file
        driver.findElement(By.id("textbox")).sendKeys("testing text file download");//text box
        driver.findElement(By.id("createTxt")).click();//generate button
        driver.findElement(By.id("link-to-download")).click();//download button

        Thread.sleep(2000);

        isFileExist("/Users/zuura/Downloads/info.txt");

        //download pdf file
        driver.findElement(By.id("pdfbox")).sendKeys("testing pdf file download");
        driver.findElement(By.id("createPdf")).click();
        driver.findElement(By.id("pdf-link-to-download")).click();

        Thread.sleep(2000);

        isFileExist("/Users/zuura/Downloads/info.pdf");

        driver.close();

    }



    public static boolean isFileExist(String path){

        File file = new File(path);

        if(file.exists()){

            System.out.println("File exists in Downloads folder");
            return true;

        }else {

            System.out.println("File does not exist in Downloads folder");
            return false;
        }

    }
}

