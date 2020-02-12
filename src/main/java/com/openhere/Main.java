package com.openhere;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver web =new ChromeDriver();
        String baseUrl = "https://www.sahibinden.com/satilik-daire";
        web.get(baseUrl);
        try {
            web.findElement(By.className("btn btn-block search-submit"));
        }catch (Exception e){
            System.out.println("asdasd");
        }
        web.findElement(By.linkText("İl")).click();
        Thread.sleep(2000);
        List<WebElement> webElementList = web.findElements(By.cssSelector("li [data-level='city']"));
        ArrayList<String> ilStringList = new ArrayList<String>();
            for (WebElement webElement  : webElementList){
                ilStringList.add(webElement.getAttribute("data-label"));
            }
            for(WebElement webElementİl : webElementList){

            webElementİl.click();
                Thread.sleep(2000);
               web.findElement(By.linkText("İlçe")).click();
                Thread.sleep(2000);
                List<WebElement> webElementIlcelist= web.findElements(By.cssSelector("li [data-level='town']"));
                for (int i =1 ; i<=webElementIlcelist.size(); i++){
                    webElementIlcelist.get(i).click();
                    web.findElement(By.className("address-overlay")).click();
                    web.findElement(By.linkText("Mahalle")).click();
                    Thread.sleep(2000);
                    List<WebElement> webElementMahallelist = web.findElements(By.cssSelector("li [data-level='district']"));
                    web.findElement(By.className("address-overlay")).click();
                    web.findElement(By.cssSelector("dd > ul >li[data-address='town']")).click();
                    continue;
                }
                web.findElement(By.className("address-overlay")).click();
                web.findElement(By.cssSelector("dd > ul >li[data-address='city']")).click();



            }
        try {
            web.findElement(By.xpath("//button[text()='Ara']")).click();
        }catch (Exception x){
            System.out.println("Couldn find");
            x.getLocalizedMessage();
        }


        System.out.println(web.getCurrentUrl());

    }
}
