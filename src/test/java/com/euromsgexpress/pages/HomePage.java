package com.euromsgexpress.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy (xpath = "//h4[.='Üyelerini Ekle']")
    public WebElement üyeleriniEkle;


}
