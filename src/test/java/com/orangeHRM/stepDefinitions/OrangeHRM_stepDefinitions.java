package com.orangeHRM.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_stepDefinitions {

    WebDriver driver;

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @When("I open OrangeHRM home page")
    public void i_open_orange_hrm_home_page() {

        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Then("I verify logo is present on home page")
    public void i_verify_logo_is_present_on_home_page() {

        boolean logoDisplayed =  driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();

        Assert.assertTrue(logoDisplayed);

        System.out.println("Success!");

    }

    @Then("I close browser")
    public void i_close_browser() {

        driver.close();

    }

}
