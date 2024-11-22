package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminDashboard {
    public AdminDashboard(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Affiliate Users alanına tıklama
    @FindBy(xpath = "(//*[@class='svg-inline--fa fa-users'])[2]")
    public WebElement ortaklikButton;

    // ortalık kullanicilarını gösterme
    @FindBy(xpath = "//select[@id='perPage']")
    public WebElement show;

    //ortaklik kullanicilari rapor sonucu    col-12 text-muted pagination-record ms-sm-3
    //
    @FindBy(xpath = "//*[@class='col-12 text-muted pagination-record ms-sm-3']")
    public WebElement raporSonucu;

    // kullanici secimi ile dogrulama islemi
    @FindBy(xpath = "(//*[@class='mb-1 text-decoration-none fs-6'])[1]")
    public WebElement kullaniciDogrulama;

    // kullanici ekranına geçtiğimi doğrulama

    @FindBy(xpath = "//h1[normalize-space()='User Details']")
    public WebElement userDetails;

    // kullanici ekranindan geri dönme
    @FindBy(xpath = "//button[@class='btn btn-outline-primary float-end']")
    public WebElement backButton;

    //Affiliate Users ekranında olduğumu doğrulama
    @FindBy(xpath = "//button[@class='btn px-0 aside-menu-container__aside-menubar d-block d-xl-none sidebar-btn']")
    public WebElement affiliateUsers;

    //üyelik islemleri ekrani giris
    @FindBy(xpath = "//span[normalize-space()='Affiliation Transactions']")
    public WebElement uyelikButton;

    // Affiliation Transactions ekraninda rapor alma
    @FindBy(xpath = "//select[@id='perPage']")
    public WebElement affiliationTransactionsRapor;

    //
    ////*[@class='text-muted ms-sm-3 pagination-record']

    @FindBy(xpath = "//*[@class='text-muted ms-sm-3 pagination-record']")
    public WebElement affiliationTransactionsRaporSonucu;

    //affiliation Transactions kullanici doğrulama islemi
    @FindBy(xpath = "(//*[@class='mb-1 text-decoration-none fs-6'])[1]")
    public WebElement kullaniciSecim;

    // kullanici ekraninda oldugumu doğrulama 
    @FindBy(xpath = "//button[@id='overview-tab']")
    public WebElement kullaniciEkrani;

    // ekrandan geri dönme islemi yapılır
    @FindBy(xpath = "//button[@class='btn btn-outline-primary float-end']")
    public WebElement geriDon;
}
