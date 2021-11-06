package com.euromsgexpress.step_definitions;

import com.euromsgexpress.pages.HomePage;
import com.euromsgexpress.pages.LoginPage;
import com.euromsgexpress.pages.ÜyeVeListeYöentimiPage;
import com.euromsgexpress.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class NewListStepDefs  {

    @Given("the user should already logged in with {string} email and {string} password")
    public void the_user_should_already_logged_in_with_email_and_password(String email, String password) throws InterruptedException{
        LoginPage loginPage = new LoginPage();
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

        wait.until(ExpectedConditions.visibilityOf(loginPage.languageOfPage));
        try {
            loginPage.languageOfPage.click();
        }catch (Exception e){
            JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
            executor.executeScript("arguments[0].click();", loginPage.languageOfPage);
        }

        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);

        Driver.get().switchTo().frame(loginPage.recaptchaIframe);
        loginPage.recaptcha.click();
        Driver.get().switchTo().defaultContent();
        Thread.sleep(20000);
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginBtn));
        loginPage.loginBtn.click();
    }

    @When("the user click Üyelerini Ekle")
    public void the_user_click_Üyelerini_Ekle() {
        new HomePage().üyeleriniEkle.click();
    }

    @When("the user click Yeni Liste Oluştur")
    public void the_user_click_Yeni_Liste_Oluştur() {

        ÜyeVeListeYöentimiPage üyeVeListeYöentimiPage = new ÜyeVeListeYöentimiPage();
        //new WebDriverWait(Driver.get(), 10).until(ExpectedConditions.visibilityOf(üyeVeListeYöentimiPage.yeniListeOluştur));
        üyeVeListeYöentimiPage.yeniListeOluştur.click();
    }

    @When("the user type list name as {string}")
    public void the_user_type_list_name(String listName) {
        new ÜyeVeListeYöentimiPage().listeyeİsimVerInputBox.sendKeys(listName);
    }

    @When("the user click Kaydet button")
    public void the_user_click_Kaydet_button() {
        new ÜyeVeListeYöentimiPage().kaydetBtn.click();
    }

    @When("the user click Üye Ekle button")
    public void the_user_click_Üye_Ekle_button() {
        new ÜyeVeListeYöentimiPage().üyeEkleBtn.click();
    }

    @When("the user click Form ile Ekle option")
    public void the_user_click_Form_ile_Ekle_option() {
        new ÜyeVeListeYöentimiPage().formİleEkle.click();
    }

    @When("the user enter following information click Kaydet button")
    public void the_user_enter_following_information_click_Kaydet_button(Map<String, String> informations) throws InterruptedException {
        ÜyeVeListeYöentimiPage üyeVeListeYöentimiPage = new ÜyeVeListeYöentimiPage();

        for (int i = 0; i < informations.size()/3; i++){

            new WebDriverWait(Driver.get(), 10).until(ExpectedConditions.elementToBeClickable(üyeVeListeYöentimiPage.adInputBox));

            üyeVeListeYöentimiPage.adInputBox.sendKeys(informations.get("Ad"+(i+1)));
            üyeVeListeYöentimiPage.soyadInputBox.sendKeys(informations.get("Soyad"+(i+1)));
            üyeVeListeYöentimiPage.emailInputBox.sendKeys(informations.get("E-Posta"+(i+1)));
            üyeVeListeYöentimiPage.checkBox.click();
            üyeVeListeYöentimiPage.kaydetBtn.click();


        }


    }




    @Then("the user should display following informations in Kaydedilenler")
    public void the_user_should_display_following_informations_in_Kaydedilenler(Map<String, String> informations) {

        ÜyeVeListeYöentimiPage üyeVeListeYöentimiPage = new ÜyeVeListeYöentimiPage();



        for (int i = 0 ; i < üyeVeListeYöentimiPage.sizeOfList(); i++){

            for(int j = 1; j <= 3; j++){

                if(j == 1){
                    Assert.assertEquals(informations.get("E-Posta" + (i+1)),üyeVeListeYöentimiPage.informationOfTheTable(i+1, j));
                }else if (j == 2){
                    Assert.assertEquals(üyeVeListeYöentimiPage.informationOfTheTable(i+1, j),informations.get("Ad"+(i+1)));
                }else if (j == 3){
                    Assert.assertEquals(üyeVeListeYöentimiPage.informationOfTheTable(i+1, j),informations.get("Soyad"+(i+1)));
                }


            }

        }

    }




}
