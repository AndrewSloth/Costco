package com.costco.step_def;

import com.costco.util.Driver;
import com.costco.util.Environment;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class Us01 {

    @Given("user on the main page")
    public void user_on_the_main_page() {
    Driver.getDriver().get(Environment.URL);

    }


    @Given("title is {string}")
    public void title_is(String string) {
        Assert.assertEquals(string, Driver.getDriver().getTitle());
    }

}
