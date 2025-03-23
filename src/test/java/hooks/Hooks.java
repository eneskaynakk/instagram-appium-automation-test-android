package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.Driver;
import utility.JiraIntegration;

import java.time.Duration;

public class Hooks {
    public String issueKey;

    @Before
    public void setUp(Scenario scenario) {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        JiraIntegration.createJiraIssue(scenario.getName(), "This test case will be tested.");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (Driver.getDriver() != null) {
            if (scenario.isFailed()) {
                System.out.println("The scenario failed: " + scenario.getName());
            } else {
                System.out.println("The scenario was successful: " + scenario.getName());
            }
            Driver.closeDriver();
        }
    }
}

