package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.Driver;

import java.time.Duration;

public class Hooks {

    @Before
    public void setUp() {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        if (Driver.getDriver() != null) {
            Driver.closeDriver();
        }
    }
}

