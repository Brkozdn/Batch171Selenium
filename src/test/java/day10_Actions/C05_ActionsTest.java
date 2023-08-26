package day10_Actions;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_ActionsTest extends TestBase {
    @Test
    public void test01() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).//-->Arama kutusunda shift tuşuna basılı tutar
                sendKeys("selenium").//-->Shift tuşuna basılı tutarak SELENIUM yazdıracak
                keyUp(Keys.SHIFT).//-->Shift tuşundan elini çek
                sendKeys("-java", Keys.ENTER).perform();
    }



    @Test
    public void test001() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.click(aramaKutusu).keyDown(Keys.SHIFT).//-->Arama kutusunda shift tuşuna basılı tutar
                sendKeys("selenium").//-->Shift tuşuna basılı tutarak SELENIUM yazdıracak
                keyUp(Keys.SHIFT).//-->Shift tuşundan elini çek
                sendKeys("-java", Keys.ENTER).perform();
    }






    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java",Keys.ENTER);
        /*
            Yukarıdaki örnekte action class'ı kullanmadan da istediğim metni büyük küçük harf ile yazdırabilirim.
        ilk yazdığımız Keys.Shift shift tuşuna basılı tutar dolayısıyla büyük harf ile yazar. İkinici yazdığımız
        Keys.Shift ise shift tuşunu serbest bırakır. Klavye tuşlarını pratik olarak yukarıdaki örnekteki gibi
        kullanabilirsiniz.
         */


    }


    @Test
    public void odev() {


   //https://www.google.com/ sayfasına gidelim
    driver.get("https://www.google.com/");


   //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
   WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));

   aramaKutusu.sendKeys("Selenium");
   bekle(3);
   aramaKutusu.sendKeys(Keys.ENTER);


   bekle(3);

   //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim

    Actions actions = new Actions(driver);

    aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));

    actions.doubleClick(aramaKutusu).keyDown(Keys.CONTROL).sendKeys("X").keyUp(Keys.CONTROL).perform();

    bekle(3);


   //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım

    driver.navigate().back();

    bekle(3);

    aramaKutusu = driver.findElement(By.xpath("//*[@id='APjFqb']"));

    actions.click(aramaKutusu).keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
    bekle(3);
    actions.sendKeys(Keys.ENTER).perform();




    }









}