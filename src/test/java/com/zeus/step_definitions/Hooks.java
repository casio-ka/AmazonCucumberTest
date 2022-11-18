package com.zeus.step_definitions;

import com.zeus.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setupDriver(){

        // set up implicit wait or all the browser related set up
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        // maximize browser here if you wanted
        Driver.getDriver().manage().window().maximize();

    }


    @After
    public void tearDownDriver(){

        Driver.closeBrowser();

    }
}
