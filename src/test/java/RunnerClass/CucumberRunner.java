package RunnerClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/FeatureFile" },
        glue = "StepDefinitions"
       ,plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class CucumberRunner {

}
