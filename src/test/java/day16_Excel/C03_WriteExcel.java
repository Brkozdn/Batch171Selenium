package day16_Excel;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C03_WriteExcel {
    @Test
    public void test01() throws IOException {
        /*
            Bir "NÜFUS" sütunu oluşturup başkent nüfuslarını excel doyasına yazınız:
            (D.C: 712816, Paris: 2161000, London: 8982000, Ankara: 5663000 ...)
        */
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("NUFUS");
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("712816");
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue("2161000");
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue("8982000");
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue("5663000");
        FileOutputStream fos = new FileOutputStream("src/test/java/resources/Capitals.xlsx");
        workbook.write(fos);
        fos.close();
        workbook.close();

    }

    @Test
    public void test02() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        List<String> veriler = new ArrayList<>(Arrays.asList("POSTAKODU","21325","635465","654656","465466"));
        for (int i = 0; i < veriler.size(); i++) {
            workbook.getSheet("Sheet1").getRow(i).createCell(3).setCellValue(veriler.get(i));
        }
        FileOutputStream fos = new FileOutputStream("src/test/java/resources/Capitals.xlsx");
        workbook.write(fos);
        fos.close();
        workbook.close();
    }
}