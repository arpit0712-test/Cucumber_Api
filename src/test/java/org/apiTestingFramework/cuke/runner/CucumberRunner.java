package org.apiTestingFramework.cuke.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:features"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = "org.apiTestingFramework.cuke.stepdefinitions")
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
