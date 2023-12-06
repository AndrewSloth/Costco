package com.costco.pages;

import com.costco.util.Driver;
import org.openqa.selenium.support.PageFactory;

public class  MainPage extends BasePage {
    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
