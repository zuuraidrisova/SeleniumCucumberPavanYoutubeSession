package com.robotAPI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.awt.AWTAccessor;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class RobotAPI {

    @Test
    public void robotAPI_demo() throws AWTException{

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //we need windows pop up to work with Robot class
        driver.get("");

        Robot robot = new Robot();//To handle advanced keyboard and mouse actions

        robot.keyPress(KeyEvent.VK_DOWN);

        robot.keyPress(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_ENTER);


    }
}
