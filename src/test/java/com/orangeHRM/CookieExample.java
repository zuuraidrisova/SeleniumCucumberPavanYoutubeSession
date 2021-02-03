package com.orangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CookieExample {

    @Test
    public void testCookies() throws InterruptedException{

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com");

        Set<Cookie> cookies = driver.manage().getCookies();//captures all cookies from web page

        int countCookies = cookies.size();//get the size of cookies

        System.out.println("countCookies = " + countCookies);

        System.out.println("==============================================");

        //prints cookie according to the name
        System.out.println("session-id-time= " + driver.manage().getCookieNamed("session-id-time"));

        System.out.println("==============================================");

        //to add cookie to browser
        Cookie cookieObject = new Cookie("myCookie", "3872911");
        driver.manage().addCookie(cookieObject);

        cookies = driver.manage().getCookies();//captures all cookies from web page after adding

        for (Cookie each: cookies){//read and print all cookies

            String nameOfCookie = each.getName();
            String valueOfCookie = each.getValue();

            System.out.println("nameOfCookie = " + nameOfCookie+", valueOfCookie = "+valueOfCookie);

        }

        System.out.println("==============================================");

        int countCookiesAfterAdding = cookies.size();//get the size of cookies

        System.out.println("countCookiesAfterAdding = " + countCookiesAfterAdding);

        System.out.println("==============================================");

        driver.manage().deleteCookieNamed("csm-hit");

        cookies = driver.manage().getCookies();//captures all cookies from web page after adding

        String cookieName = "";

        for (Cookie each: cookies){//read and print all cookies

            cookieName = each.getName();
        }

        if(cookieName.equals("csm-hit")){

            System.out.println("Cookie named csm-hit is not deleted!");
        }else{

            System.out.println("Cookie named csm-hit is deleted!");
        }

        System.out.println("==============================================");

        int countCookiesAfterDeleting = cookies.size();//get the size of cookies

        System.out.println("countCookiesAfterDeleting = " + countCookiesAfterDeleting);

        System.out.println("==============================================");

        driver.manage().deleteAllCookies();

        cookies = driver.manage().getCookies();//captures all cookies from web page after adding

        int countCookiesAfterDeletingAllCookies = cookies.size();

        System.out.println("countCookiesAfterDeletingAllCookies = " + countCookiesAfterDeletingAllCookies);

        Thread.sleep(2000);

        driver.close();
    }
}
