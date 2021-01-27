package com.orangeHRM.stepDefinitions;

import com.orangeHRM.pages.AddCustomerPage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.pages.SearchCustomerPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Commerce_StepDefinitions extends TestBase{


    @Before
    public void setUp(){

        //reading from properties file
        configurationProperties = new Properties();

        try {
            //loading properties file into java memory
            FileInputStream file = new FileInputStream("configuration.properties");

            configurationProperties.load(file);

            file.close();

        }catch (IOException exception){

            logger.info("***********Properties file path is not found************");
            exception.printStackTrace();
        }

        logger = Logger.getLogger("nopCommerce");//added logger

        PropertyConfigurator.configure("log4j.properties");// provide path to log4j.properties file

        String browser = configurationProperties.getProperty("browser");

        if(browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();

        }else if(browser.equalsIgnoreCase("firefox")){

            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();

        }else if(browser.equalsIgnoreCase("ie")){

            WebDriverManager.iedriver().setup();

            driver = new InternetExplorerDriver();

        }else{

            throw new RuntimeException("Wrong Browser : : "+browser);
        }

        logger.info("*************Launching browser****************");
    }


    @Given("User Launch Chrome browser")
    public void user_Launch_Chrome_browser() {

        lp = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_URL(String url) {

        logger.info("*************Launching URL****************");

        driver.get(url);

        driver.manage().window().maximize();
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_Email_as_and_Password_as(String email, String password) {

        logger.info("*************Providing credentials****************");

        lp.setUserName(email);
        lp.setPassword(password);

    }

    @When("Click on Login")
    public void click_on_Login() {

        logger.info("*************Started login****************");

        lp.clickLogin();
    }

    @Then("Page Title should be {string}")
    public void page_Title_should_be(String exptitle) throws InterruptedException {

        if(driver.getPageSource().contains("Login was unsuccessful"))
        {
            driver.close();

            logger.info("*************Login passed****************");
        }
        else
        {
            logger.info("*************Login failed****************");

            Assert.assertEquals(exptitle, driver.getTitle());
        }

        Thread.sleep(3000);

    }

    @When("User click on Log out link")
    public void user_click_on_Log_out_link() throws InterruptedException {

        logger.info("*************Clicking on Logout link****************");

        lp.clickLogout();
        Thread.sleep(3000);
    }

    @Then("close browser")
    public void close_browser() {

        logger.info("*************Closing the session****************");

        driver.quit();
    }

    //Customer feature step definitions..........................................

    @Then("User can view Dashboad")
    public void user_can_view_Dashboad() {

        addCust=new AddCustomerPage(driver);

        Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
    }

    @When("User click on customers Menu")
    public void user_click_on_customers_Menu() throws InterruptedException {

        Thread.sleep(3000);
        addCust.clickOnCustomersMenu();
    }

    @When("click on customers Menu Item")
    public void click_on_customers_Menu_Item() throws InterruptedException {

        Thread.sleep(2000);
        addCust.clickOnCustomersMenuItem();
    }

    @When("click on Add new button")
    public void click_on_Add_new_button() throws InterruptedException {

        logger.info("*************Adding a new customer****************");

        addCust.clickOnAddnew();
        Thread.sleep(2000);
    }

    @Then("User can view Add new customer page")
    public void user_can_view_Add_new_customer_page() {

        Assert.assertEquals("Add a new customer / nopCommerce administration",
                addCust.getPageTitle());
    }

    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {

        logger.info("*************Providing customer details****************");

        String email = randomestring() + "@gmail.com";
        addCust.setEmail(email);
        addCust.setPassword("test123");
        // Registered - default
        // The customer cannot be in both 'Guests' and 'Registered' customer roles
        // Add the customer to 'Guests' or 'Registered' customer role
        addCust.setCustomerRoles("Guest");
        Thread.sleep(3000);

        addCust.setManagerOfVendor("Vendor 2");
        addCust.setGender("Male");
        addCust.setFirstName("Pavan");
        addCust.setLastName("Kumar");
        addCust.setDob("7/05/1985"); // Format: D/MM/YYY
        addCust.setCompanyName("busyQA");
        addCust.setAdminContent("This is for testing.........");
    }

    @When("click on Save button")
    public void click_on_Save_button() throws InterruptedException {

        logger.info("*************Saving a new customer****************");

        addCust.clickOnSave();
        Thread.sleep(2000);
    }


    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
                .contains("The new customer has been added successfully"));
    }


    //Searching customer by email ID.............................

    @When("Enter customer EMail")
    public void enter_customer_EMail() {

        logger.info("*************Searching customer by email****************");

        searchCust = new SearchCustomerPage(driver);
        searchCust.setEmail("victoria_victoria@nopCommerce.com");
    }

    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {

        searchCust.clickSearch();
        Thread.sleep(3000);
    }

    @Then("User should found Email in the Search table")
    public void user_should_found_Email_in_the_Search_table() {

        boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
        Assert.assertEquals(true, status);

    }

    //steps for searching a customer by Name................
    @When("Enter customer FirstName")
    public void enter_customer_FirstName() {

        logger.info("*************Searching customer by firstName****************");

        searchCust=new SearchCustomerPage(driver);
        searchCust.setFirstName("Victoria");
    }

    @When("Enter customer LastName")
    public void enter_customer_LastName() {

        searchCust.setLastName("Terces");
    }

    @Then("User should found Name in the Search table")
    public void user_should_found_Name_in_the_Search_table() {

        boolean status=searchCust.searchCustomerByName("Victoria Terces");
        Assert.assertEquals(true, status);
    }


}
