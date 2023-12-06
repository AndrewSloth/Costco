package com.costco.pages;

import com.costco.util.Driver;
import com.costco.util.Environment;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Test extends BasePage {
    Driver driver;

    @org.junit.Test
    public void test() throws InterruptedException {
        System.out.println("sdasdsad");
        Driver.getDriver().get(Environment.URL);

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(shopButton).build().perform();
        Thread.sleep(3000);

        List<String> list = new ArrayList<>();

        for (WebElement element : shopCategories) {
            System.out.println(element.getText());

            list.add(element.getText());

            actions.moveToElement(element,0,0).perform();
            Thread.sleep(500);


            System.out.println("element.getCssValue(\"font-weight\") = " + element.getCssValue("font-weight"));

            System.out.println("element.getAttribute(\"Class\") = " + element.getAttribute("Class"));

        }
        System.out.println(list.size());
        Assert.assertTrue(list.size() == 27);
Driver.closeDriver();

    }


}
