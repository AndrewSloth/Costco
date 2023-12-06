package com.costco.step_def;

import com.costco.util.Driver;
import com.costco.util.Environment;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class Us01 {

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
    Driver.getDriver().get(Environment.URL);

    }


    @Given("title is {string}")
    public void title_is(String string) {
        Assert.assertEquals(string, Driver.getDriver().getTitle());
    }

}
