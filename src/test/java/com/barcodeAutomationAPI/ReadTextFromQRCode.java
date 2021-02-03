package com.barcodeAutomationAPI;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ReadTextFromQRCode {

    @Test
    public void test_QRCode() throws IOException, NotFoundException, InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        String qrCodeUrl =  driver.findElement(By.xpath("//div[@id='HTML4']/div[1]/img")).getAttribute("src");

        System.out.println("qrCodeUrl = " + qrCodeUrl);

        URL url = new URL(qrCodeUrl);

        BufferedImage bufferedImage =  ImageIO.read(url);

        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);

        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));

        Result result = new MultiFormatReader().decode(binaryBitmap);

        //qr code text = Welcome to Selenium
        System.out.println("qr code text = " + result.getText());

        Thread.sleep(2000);

        driver.close();

    }

}
