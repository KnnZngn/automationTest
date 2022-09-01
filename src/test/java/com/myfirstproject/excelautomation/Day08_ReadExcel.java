package com.myfirstproject.excelautomation;
//BAYRAM5935
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day08_ReadExcel {
    //★Workbook > Worksheet > Row > Cell.
    @Test
    public void readExcel() throws IOException {
        //String path= "C:\\Users\\DELL\\IdeaProjects\\automationTest\\src\\test\\java\\resources\\capitals.xlsx";
        String path= ".\\src\\test\\java\\resources\\capitals.xlsx";

        //file open
        FileInputStream fileInputStream = new FileInputStream(path);

        //open the workbook
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Open the first worksheet
        //Sheet sheet1 = workbook.getSheetAt(0); //getting the first sheet in the Excel
        Sheet sheet1 = workbook.getSheetAt(0); //getting the first sheet in the Excel

        //Go to first row
        //Row row1= workbook.getSheetAt(0).getRow(0);
        Row row1= sheet1.getRow(0);

        //Go to the first cell
        //Cell cell1 = workbook.getSheetAt(0).getRow(0).getCell(0);
        Cell cell1 = row1.getCell(0);
        System.out.println(cell1);

//        Go to second cell on that first row and print
        Cell r1c2 = row1.getCell(1);
        System.out.println(r1c2);

//        Go to 2nd row first cell and assert if the data equal to USA
        //!!!!!!!!  onemmmmmmmliiii  !!!!!!!!!!!!!!
        //Cell r2c1 = sheet1.getRow(1).getCell(0);
        //System.out.println(r2c1);
        //Assert.assertEquals(r2c1,"USA"); cell data type oldu stringe esitlenemz!!!!!! onun icin stringe atariz
        String r2c1 = sheet1.getRow(1).getCell(0).toString();
        Assert.assertEquals("USA",r2c1);

//        Go to 3rd row 2nd cell-chain the row and cell
        Cell r3c2 = sheet1.getRow(2).getCell(1);
        System.out.println(r3c2);

//        Find the number of row
        int numberOfRow = sheet1.getLastRowNum() + 1;  //index dan baslar +1 koymaliyiz
        System.out.println(numberOfRow);

//        Find the number of used row
         int physicalRowNumber= sheet1.getPhysicalNumberOfRows();  //ici dolu satir row  sayiyi verir. physical
        System.out.println(physicalRowNumber);

//        //map de toplama Map<String,String> Map<String,String> map de eklemek ivin put metodu var add degil
        //1. adim once map olusturduk
        //2. adim  for ile hucreleri yazip stringe attik
        //3. adim  map/put ile hepsini ekledik for icinde add yerine put
        Map<String,String> capitals = new HashMap<>();

        //loop
        for(int rowNum=1; rowNum<11; rowNum++){
            String country= sheet1.getRow(rowNum).getCell(0).toString();
            System.out.println(country);
            String capital= sheet1.getRow(rowNum).getCell(1).toString();
            System.out.println(capital);

            //map icine put metodu
            capitals.put(country,capital);

            // 2.way           We can shorten the code like this
            //capitals.put(sheet1.getRow(rowNum).getCell(0).toString(), sheet1.getRow(rowNum).getCell(1).toString());
        }
        System.out.println(capitals);





    }
}
