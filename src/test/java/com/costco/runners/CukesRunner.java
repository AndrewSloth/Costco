package com.costco.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html", //html report
                "json:target/cucumber.json"}, // cucumber report
        features = "src/test/resources/features",
        glue = "com/costco/step_def",
        dryRun = false,
        tags = ""
)
public class CukesRunner {

}
