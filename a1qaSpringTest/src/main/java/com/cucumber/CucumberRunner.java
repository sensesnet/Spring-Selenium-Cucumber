package com.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@a1qa"},
        format = {"pretty", "json:target/cucumber.json","html:target/cucumber.html"},
        features = {"src/main/java/com/features/"})
public class CucumberRunner {

}
