package com.ashotAPI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OrangeHRM_captureLOGO {

    @Test
    public void testOrangeHRM_logoImage() throws IOException, InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']/img"));

        Screenshot logoScreenshot =  new AShot().takeScreenshot(driver, logo);

        ImageIO.write(logoScreenshot.getImage(), "png", new File("/Users/zuura/IdeaProjects/SeleniumCucumberYoutubeSession/screenshots"));

        File file = new File("/Users/zuura/IdeaProjects/SeleniumCucumberYoutubeSession/screenshots");

        if(file.exists()){

            System.out.println("Image exists");
        }else{

            System.out.println("Image does not exist");
        }

        Thread.sleep(2000);

        driver.close();

    }
}
