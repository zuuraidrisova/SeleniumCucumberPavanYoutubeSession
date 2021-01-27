package com.orangeHRM.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features",
        glue = "com/orangeHRM/stepDefinitions",
        tags = "@sanity or @regression",
        dryRun = false,
        monochrome = true,
       // dryRun = false,//when dryRun is true it will generate snippets which were not generated
        plugin = {"pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"}

)
public class CukesRunner {
}
