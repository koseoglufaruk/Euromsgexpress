package com.euromsgexpress.pages;

import com.euromsgexpress.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ÜyeVeListeYöentimiPage extends BasePage{

    @FindBy(xpath = "//button[contains(text(),'Yeni Liste Oluştur')]")
    public WebElement yeniListeOluştur;

    @FindBy (css = "input[placeholder='Listeye isim ver']")
    public WebElement listeyeİsimVerInputBox;

    @FindBy (xpath = "//button[contains(text(),'Kaydet')]")
    public WebElement kaydetBtn;

    @FindBy (xpath = "//button[contains(text(),'Üye Ekle')]")
    public WebElement üyeEkleBtn;

    @FindBy (xpath = "//a[contains(text(),'Form ile Ekle')]")
    public WebElement formİleEkle;

    @FindBy (css = "#firstName")
    public WebElement adInputBox;

    @FindBy (css = "#lastName")
    public WebElement soyadInputBox;

    @FindBy (css = "#email")
    public WebElement emailInputBox;

    @FindBy (css = ".fa.fa-check")
    public WebElement checkBox;

    public int sizeOfList(){

        List<WebElement> lisOfNewMemberTable = Driver.get().findElements(By.xpath("//table/tbody/tr"));
        int sizeOfTable = lisOfNewMemberTable.size();
        return sizeOfTable;

    }

    public String informationOfTheTable(int row, int column){

        return Driver.get().findElement(By.xpath("//table/tbody/tr["+row+"]/td["+column+"]")).getText();

    }




}
