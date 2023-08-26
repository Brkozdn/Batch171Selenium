package day13_Exception_ScreenShot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    /*
    TIMEOUTEXCETION
        Eğer TimeOutException hatası alıyorsak;
            1-Explicit wait'te kullandığımız max. süreyi kontrol etmeliyiz
            2-Explicit wait ile aldığımız locate'i kontrol etmeliyiz
            3-Explicit wait ile kullandığımız method'u kontrol etmemiz gerekir
            4-Explicit wait ile locate ettiğimiz webelement iframe içinde olabilir. Dolayısıyla
            iframe'e geçiş yapmamız gerekir.
     */
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldWE = driver.findElement(By.xpath("(//h4)[2]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));//-->timeOutException almak için süreyi azalttık
        wait.until(ExpectedConditions.visibilityOf(helloWorldWE));

        Assert.assertEquals("Hello World!",helloWorldWE.getText());
    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        new WebDriverWait(driver,Duration.ofSeconds(15)).
                until(ExpectedConditions.visibilityOfElementLocated(By.id("yanlis locate")));
        //Wait içinde yanlis locate de bize TimeOutException verir

        //NOT: Eğer yanlis LOCATOR(örn:xpath yerine css gibi) kullanırsanız InvalidSelectorException alırsınız
    }
}