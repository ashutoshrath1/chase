package StepDefinitions;

import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void before()
    {
    }

    @After
    public void after()
    {
        Driver.quitDriver();
    }

}
