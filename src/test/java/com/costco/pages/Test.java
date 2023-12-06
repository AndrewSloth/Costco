package com.costco.pages;

import com.costco.util.Driver;
import com.costco.util.Environment;
import org.jsoup.select.Evaluator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Test extends BasePage {
    Driver driver;

    @org.junit.Test
    public void test() throws InterruptedException {

        Driver.getDriver().get(Environment.URL);

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(shopButton).build().perform();
        Thread.sleep(1000);

        List<String> list = new ArrayList<>();

        for (WebElement element : shopCategories) {


            System.out.println(element.getText());

            list.add(element.getText());

            actions.moveToElement(element, 0, -10).perform();


            //System.out.println("element.getCssValue(\"font-weight\") = " + element.getCssValue("font-weight"));

            //System.out.println("element.getAttribute(\"class\") = " + element.getAttribute("class"));

            String  homePage = Environment.URL;
            String url;
            HttpURLConnection huc = null;
            int respCode =200;

            WebElement aElement = element.findElement(By.tagName("a"));

            url = aElement.getAttribute("href");

            //System.out.println("url = " + url);

            if(url == null || url.isEmpty()){
                System.out.println("URl is either not configured for anchor tag or it is Empty");
                continue;
            }
            if(!url.startsWith(homePage)){
                continue;
            }
            try{
                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                if(respCode >= 400){
                    System.out.println("link i broken");
                }else{
                    System.out.println("valid link");
                }

            }catch (MalformedURLException e){
                e.printStackTrace();

            }catch (IOException e){
                e.printStackTrace();
            }


        }
        System.out.println(list.size());
        Assert.assertTrue(list.size() == 27);
        Driver.closeDriver();

    }


}
