package com.euromsgexpress.step_definitions;

import com.euromsgexpress.pages.LoginPage;
import com.euromsgexpress.utilities.ConfigurationReader;
import com.euromsgexpress.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefs {

    @Given("the user should be on login page")
    public void the_user_should_be_on_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        new WebDriverWait(Driver.get(), 10).until(ExpectedConditions.visibilityOf(loginPage.languageOfPage));
        try {
            loginPage.languageOfPage.click();
        }catch (Exception e){
            JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
            executor.executeScript("arguments[0].click();", loginPage.languageOfPage);
        }

    }

    @When("the user enter valid {string} and valid {string}")
    public void the_user_enter_valid_and_valid(String email, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
        Driver.get().switchTo().frame(loginPage.recaptchaIframe);
        WebDriverWait wait = new WebDriverWait(Driver.get(), 200);
        wait.until(ExpectedConditions.visibilityOf(loginPage.recaptcha));

        try {
            loginPage.recaptcha.click();
        }catch (Exception e){
            JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
            executor.executeScript("arguments[0].click();", loginPage.recaptcha);
        }


        //wait.until(ExpectedConditions.visibilityOf(loginPage.checkedRecaptcha));
        Driver.get().switchTo().defaultContent();
        //Thread.sleep(20000);

    }


    @When("the user click Oturum Aç button")
    public void the_user_click_Oturum_Aç_button() throws InterruptedException {
        Thread.sleep(20000);
        new LoginPage().loginBtn.click();
    }

    @Then("the user should land on home page")
    public void the_user_should_land_on_home_page() {
        new WebDriverWait(Driver.get(),10).until(ExpectedConditions.urlToBe("https://console.euromsg.com/home"));
        Assert.assertEquals("https://console.euromsg.com/home",Driver.get().getCurrentUrl());
    }

    @When("the enter {string} and {string}")
    public void the_enter_and(String email, String password) throws InterruptedException{
        LoginPage loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
        Driver.get().switchTo().frame(loginPage.recaptchaIframe);
        WebDriverWait wait = new WebDriverWait(Driver.get(), 200);
        wait.until(ExpectedConditions.visibilityOf(loginPage.recaptcha));

        try {
            loginPage.recaptcha.click();
        }catch (Exception e){
            JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
            executor.executeScript("arguments[0].click();", loginPage.recaptcha);
        }

        //wait.until(ExpectedConditions.visibilityOf(loginPage.checkedRecaptcha));
        Driver.get().switchTo().defaultContent();
        //Thread.sleep(20000);
    }

    @Then("the user should not be able login")
    public void the_user_should_not_be_able_login() {
        Assert.assertEquals("https://console.euromsg.com/login", Driver.get().getCurrentUrl());
    }





}
