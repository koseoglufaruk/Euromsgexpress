package com.euromsgexpress.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy (xpath = "//a[.='Türkçe']")
    public WebElement languageOfPage;

    @FindBy (css = "#exampleInputEmail1")
    public WebElement emailInput;

    @FindBy (css = "#exampleInputPassword1")
    public WebElement passwordInput;

    @FindBy (css = ".recaptcha-checkbox-border")
    public WebElement recaptcha;


    @FindBy (xpath = "//iframe[@title='reCAPTCHA']")
    public WebElement recaptchaIframe;

    @FindBy (xpath = "//button[contains(text(),'Oturum Aç')]")
    public WebElement loginBtn;



}
