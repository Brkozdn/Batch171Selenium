package day07_DropDown_Alert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_TestBaseClassWork extends TestBase {

    @Test
    public void test01() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil = driver.findElement(By.xpath("(//select)[2]"));
        WebElement ay = driver.findElement(By.xpath("(//select)[3]"));
        WebElement gun = driver.findElement(By.xpath("(//select)[4]"));


        bekle(2);


        selectIndex(ay,4);


    }


}
