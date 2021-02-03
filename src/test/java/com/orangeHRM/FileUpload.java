package com.orangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import sun.jvm.hotspot.runtime.Threads;

public class FileUpload {

    @Test
    public void testFileUpload() throws Exception{

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://demo.automationtesting.in/Register.html");

        Thread.sleep(2000);

        driver.findElement(By.id("imagesrc")).click();

        String imageFilePath = "/Users/zuura/Downloads";
        String inputFilePath = "/Users/zuura/Downloads";

        Screen screen = new Screen();

        Pattern fileInput = new Pattern(imageFilePath+"FiletextBox.jpg");
        Pattern openButton = new Pattern(imageFilePath+"OpenButton.jpg");

        screen.wait(fileInput, 20);
        screen.type(fileInput, inputFilePath+"Landscape-Color.jpg");
        screen.click(openButton);


    }


}
