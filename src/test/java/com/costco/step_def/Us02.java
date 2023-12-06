package com.costco.step_def;


import com.costco.pages.MainPage;
import com.costco.util.Driver;
import com.costco.util.Environment;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Us02 {

    MainPage mainPage = new MainPage();

    @When("the user hovers over the Shop button")
    public void the_user_hovers_over_the_button_shop_button() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(mainPage.shopButton).build().perform();

    }

    @Then("the categories beneath the Shop button should be visible")
    public void the_categories_beneath_the_shop_button_should_be_visible() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(mainPage.shopMenu));
        Assert.assertTrue(mainPage.shopMenu.isDisplayed());
    }

    @Then("the user hovers over each category and categories font should change to a bold font style")
    public void the_user_hovers_over_each_category_and_categories_font_should_change_to_a_bold_font_style() {
        for (WebElement element : mainPage.shopCategories) {
            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(element, 0, -10).perform();

            Assert.assertTrue(element.getCssValue("font-weight").equals("700"));

        }

    }


    @Then("the user ensures that every hyperlink under the Shop menu works as expected")
    public void the_user_ensures_that_every_hyperlink_under_the_shop_menu_works_as_expected() {
        List<String> list = new ArrayList<>();
        List<WebElement> links = mainPage.shopMenu.findElements(By.tagName("a"));
        String homePage = Environment.URL;
        String url;
        HttpURLConnection huc = null;
        int respCode = 200;

        for (WebElement element : links) {

            url = element.getAttribute("href");
            System.out.println(url);
            if (url == null || url.isEmpty()) {
                System.out.println("URl is either not configured for anchor tag or it is Empty");
                continue;
            }
            if (!url.startsWith(homePage)) {
                continue;
            }
            try {

                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.setRequestMethod("GET");
                huc.connect();
                respCode = huc.getResponseCode();
                if (respCode != 200) {
                    System.out.println("link i broken");
                } else {
                    System.out.println("valid link");
                }
                System.out.println("respCode = " + respCode);
            } catch (IOException e) {
                e.printStackTrace();

            }

        }

    }








    @Then("Shop menu contain categories")
    public void shop_menu_contain_categories(List<String> dataTable) {


        List<String> actualCategories = new ArrayList<>();
        for (WebElement element : mainPage.shopCategories) {
            actualCategories.add(element.getText());
        }
        System.out.println("dataTable.toString() = " + dataTable.toString());
        System.out.println("actualCategories.toString() = " + actualCategories.toString());
        Assert.assertEquals(dataTable, actualCategories);
    }

}
