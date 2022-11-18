package uk.socialmedia.test;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        tags = "@Test",
        plugin = {"pretty", "html:target/cucmber.html", "json:target/cucumber-report.json", "junit:target/cucumber.xml"},
        glue = {"classpath:uk/socialmedia/test/hooks","classpath:uk/socialmedia/test/stepdef"},
        features = "classpath:/uk/socialmedia/test/features"
)
public class TestRunner {


}
