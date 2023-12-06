package com.costco.pages;

import com.costco.util.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "navigation-dropdown")
    public WebElement shopButton;
    @FindBy(xpath = "//li[@data-parent = 0]")
    public List<WebElement> shopCategories;
    @FindBy(id = "level1")
    public WebElement shopMenu;


}