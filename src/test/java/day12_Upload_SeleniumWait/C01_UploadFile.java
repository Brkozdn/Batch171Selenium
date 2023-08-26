package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_UploadFile extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        //dosyaSec.click();//-->Tiklama işleminde windows penceresi açılacağından burda hata alırız
        //selenium windows pencerelerine müdehale edemez

        //Yuklemek istediginiz dosyayi secelim.
        //"C:\Users\Lenovo\OneDrive\Masaüstü\B171.txt" --> Yüklemek istediğimiz dosyanın yolu
        String dosyaYolu = "C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\B171.txt";
        dosyaSec.sendKeys(dosyaYolu);
        //uploadFilePath(dosyaYolu);
        bekle(2);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim
        WebElement text = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("File Uploaded!",text.getText());
        Assert.assertTrue(text.isDisplayed());

    }



    @Test
    public void test02() {
        // Test sayfasını aç
        driver.get("https://www.ilovepdf.com/compress_pdf");

        // Dosya seçme düğmesini bul ve tıkla
        driver.findElement(By.xpath("//*[.='Select PDF files']")).click();

        // Dosya yüklemek için Robot sınıfını kullan
        String dosyaYolu = "C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\testng.pdf";
        bekle(3);
        uploadFilePath(dosyaYolu);



    }


    @Test
    public void ErolTanitti() {

      driver.get("https://www.zillow.com/homes/for_sale/seattle/");
      bekle(30);

      List<WebElement> evler = driver.findElements(By.xpath("//li[@class='ListItem-c11n-8-84-3__sc-10e22w8-0 StyledListCardWrapper-srp__sc-wtsrtn-0 iCyebE gTOWtl']"));

        for (int i = 0; i <evler.size() ; i++) {

            evler = driver.findElements(By.xpath("//li[@class='ListItem-c11n-8-84-3__sc-10e22w8-0 StyledListCardWrapper-srp__sc-wtsrtn-0 iCyebE gTOWtl']"));

            evler.get(i).click();
            System.out.println(i + ". EV TİTLE: " + driver.getTitle());
            driver.navigate().back();

        }


    }
}












