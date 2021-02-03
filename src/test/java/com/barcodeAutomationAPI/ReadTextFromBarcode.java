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
import java.net.MalformedURLException;
import java.net.URL;

public class ReadTextFromBarcode {

    @Test
    public void test_Barcodes() throws IOException, NotFoundException, InterruptedException{

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        //there are 2 barcodes: 1 is ABC-abc-123 ; 2 is Hi this is Pavan
        String barcodeURL = driver.findElement(By.xpath("//div[@class='widget-content']/img[1]")).getAttribute("src");

        //String barcodeURL = driver.findElement(By.xpath("//div[@class='widget-content']/img[2]")).getAttribute("src");

        System.out.println("barcodeURL = " + barcodeURL);

        URL url = new URL(barcodeURL);

        BufferedImage bufferedImage = ImageIO.read(url);

        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);

        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));

        Result result = new MultiFormatReader().decode(binaryBitmap);

        System.out.println(" barcode text = " + result.getText());

        Thread.sleep(2000);

        driver.close();
    }
}
