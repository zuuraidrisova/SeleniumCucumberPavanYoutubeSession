package com.orangeHRM.stepDefinitions;

import com.orangeHRM.pages.AddCustomerPage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.pages.SearchCustomerPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public  class TestBase {

    public WebDriver driver;
    public LoginPage lp;
    public AddCustomerPage addCust;
    public SearchCustomerPage searchCust;
    public Properties configurationProperties;
    public static Logger logger;


    //Created for generating random string for Unique email
    public static String randomestring(){

        String generatedString1 = RandomStringUtils.randomAlphabetic(5);

        return (generatedString1);
    }


}
