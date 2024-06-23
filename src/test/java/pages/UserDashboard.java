package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class UserDashboard {
    public UserDashboard(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Dashboard yazısı görünürlügü
    @FindBy(xpath = "//a[@class='nav-link p-0 active']")
    public WebElement yaziGoruntusu;

    // VCards alanına tıklar
    @FindBy(xpath = "//span[text()='VCards']")
    public WebElement VCardsButton;

    // New Vcard butonuna tıklar
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement newCardButton;

    // Takma adın yanindaki url'in soru isareti yazisi
    @FindBy(xpath ="//span[@data-bs-original-title='The main URL that your vcard is going to be able accessed from.']//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]")
    public WebElement questionMark;

    //Carka tıklayıp takma ad url'i alma
    @FindBy(xpath = "//*[@class='svg-inline--fa fa-arrows-rotate']")
    public WebElement arrowsRotateButton;

    //Carka bastıktan sonra sol tarafta cıkan kod

    @FindBy(xpath = "//input[@id='vcard-url-alias']")
    public WebElement uniqueCode;


    //Vcard adı girilir
    @FindBy(xpath = "//input[@placeholder='Enter VCard Name']")
    public WebElement VCardName;

    //Occupation: meslek alanı girisi
    @FindBy(xpath = "//input[@placeholder='Enter Occupation']")
    public WebElement occupationText;

    // Yeni kart kaydet butonu
    @FindBy(xpath = "//input[@class='btn btn-primary me-3']")
    public WebElement saveButton;

    // Kartın basarili sekilde kaydedildigini teyit etme
    @FindBy(xpath = "//*[text()='Edit VCard']")
    public WebElement basariliGiris;

    //Description alanına yazı yazılır.
    @FindBy(xpath = "//div[@class='ql-editor ql-blank']")
    public WebElement DescriptionText;

    // 150 karakter uyarısı
    @FindBy(xpath = "//*[@class='mt-1']")
    public WebElement karakterUyarisi;

    // geri gelme islemi
    @FindBy(xpath = "//a[@class='btn btn-outline-primary float-end']")
    public WebElement backButton;

    // Tablonun raponu alma
    @FindBy(xpath = "//select[@id='perPage']")
    public WebElement tableShow;

    //Raporun altında cıkan sonuc yazisi
    @FindBy(xpath = "//*[@class='col-12 text-muted pagination-record ms-sm-3']")
    public WebElement sonucYazisi;

    //Vcard isim secimi
    @FindBy(xpath = "//a[@class='mb-1 text-decoration-none fs-6']")
    public WebElement vcardName;

    // kullanıcı isminin aktiflik durumu
    @FindBy(xpath= "(//a[contains(text(),'Yusuf')])[1]")
    public WebElement vcardNameActive;

    // Vcard Edit ekranında yer alan "basicDetails" görünürlügü
    @FindBy(xpath = "//h1[normalize-space()='Edit VCard']")
    public WebElement editVcardEkrani;

    // url secme ve aktiflik durumu
    @FindBy(xpath = "//a[@id='vcardUrl740']")
    public WebElement urlSelect;

    // copy islemi butonu
    @FindBy(xpath = "//td//button[@title='copy']")
    public WebElement copyIcon;

    // istatistik ikonuna tıklama

    @FindBy(xpath = "//*[@class='btn px-2 text-primary fs-2 user-edit-btn copy-clipboard']")
    public WebElement statsIcon;

    //istatistik ekranı doğrulama
    @FindBy(xpath = "//*[@class='svg-inline--fa fa-chart-line fs-2']")
    public WebElement statsDogrulama;


    // checkBox secimi
    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBox;

    // kare kod alanına tıklanır.
    @FindBy(xpath = "//a[@title='QR Code']")
    public WebElement kareKod;

    // indirme butonu loceti
    @FindBy(xpath = "//*[@class='svg-inline--fa fa-download']")
    public WebElement dowloand;

    //Enquiries butonu  //a[@class='btn px-1 text-info fs-3 vcard-qr-code-btn']

    @FindBy(xpath = "(//*[@class='svg-inline--fa fa-clipboard-question'])[1]")
    public WebElement enquiriesButton;

    // Enquiries ekranına geciş
    @FindBy(xpath = "//div[@class='d-md-flex align-items-center justify-content-between mb-5']")
    public WebElement enquiriesEkrani;

    // Enquiries ekanından geri dönü yapar.
    @FindBy(xpath = "//a[@class='btn btn-outline-primary']")
    public WebElement geriDonus;

    // aynı kartan iki tane oluşturma işlemi yapar.
    @FindBy(xpath = "(//*[@class='svg-inline--fa fa-copy'])[1]")
    public WebElement copyTwo;

    //iki defa kopyaladıktan sonra çıkan ekranda yes butonuna basar
    @FindBy(xpath = "//button[@class='swal-button swal-button--confirm']")
    public WebElement yesButton;

    //sanal kart ekranına giriş ekrani
    @FindBy(xpath="//*[@id='sidebar']/div[2]/ul/li[5]/a")
    public WebElement sanalKartArkaPlan;


    //sanal arka plan kartı belirleme
    @FindBy(xpath = "(//*[@class='flip-box-h col-lg-3 m-4'])[1]")
    public WebElement sanalKartArkaYuz;

    //kayitli kullanici secme
    @FindBy(xpath = "//span[@id='select2-e-vcard-id-container']")
    public WebElement kayitliKullaniciSecme;

    // kullanici secme  //span[@class='select2-selection__placeholder']   //*[@class='select2-hidden-accessible']

    @FindBy(xpath = "//select[@id='e-vcard-id']")
    public WebElement kullaniciIsmiSecme;

    // arka yüz ekleme ekranindaki soru isareti
    @FindBy(xpath = "//*[@class='svg-inline--fa fa-circle-question ml-1 mt-1 general-question-mark']")
    public WebElement soruIsareti;

    // fotograf secme

    @FindBy(xpath = "//*[@class='svg-inline--fa fa-pen']")
    public WebElement fotoSecme;

    // name alanı
    @FindBy(name = "first_name")
    public WebElement isimText;

    // last name
    @FindBy(name = "last_name")
    public WebElement soyadiText;

    // Kart arka yüz mail adresi
    @FindBy(name = "email")
    public WebElement mailAdresi;

    // kart arka yüz meslek bilgisi
    @FindBy(name = "occupation")
    public WebElement meslek;

    // Location kullanıcı adresi
    @FindBy(name = "location")
    public WebElement adres;

    //ülke alanına tıklama
    @FindBy(xpath = "//div[@class='iti__selected-flag']")
    public WebElement ulkeTikla;

    //ülke secimi   "//select[@class='form-control form-select select2-hidden-accessible']"
    @FindBy(xpath = "//select[@id='selectLanguage']")
    public WebElement ulkeSec;


    //Telefon numarası giris
    @FindBy(xpath = "//input[@id='phoneNumber']")
    public WebElement telefonNumarasi;

    //web sitesi girisi
    @FindBy(name = "website")
    public WebElement siteGirisi;

    // kaydet butonu
    @FindBy(xpath = "//button[@class='btn btn-primary me-3']")
    public WebElement kaydetButton;

    //edit butonu
    @FindBy(xpath = "//*[@class='svg-inline--fa fa-pen-to-square']")
    public WebElement editButton;

    // edit butonu doğrualama  //*[@class='svg-inline--fa fa-circle-question p-1']
    @FindBy(xpath = "//*[@class='svg-inline--fa fa-circle-question p-1']")
    public WebElement editButtonDogrula;

    // edit ekranında back butonu
    @FindBy(xpath = "//a[@class='btn btn-outline-primary float-end']")
    public WebElement editGeriButton;

    //silme işlemi yapılır.
    @FindBy(xpath = "//*[@class='svg-inline--fa fa-trash']")
    public WebElement copKutusu;

    //silme işlemine onay verme
    @FindBy(xpath = "//button[@class='swal-button swal-button--confirm']")
    public WebElement silmeOnay;

}
