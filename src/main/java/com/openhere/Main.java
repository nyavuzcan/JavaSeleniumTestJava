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
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver web =new ChromeDriver();
        String baseUrl = "https://www.sahibinden.com/satilik-daire";
        web.get(baseUrl);
      Thread.sleep(2000);
        web.findElement(By.linkText("İl")).click();
        Thread.sleep(2000);
        List<WebElement> webElementList = web.findElements(By.cssSelector("li [data-level='city']"));
        webElementList.remove(1);
        webElementList.remove(2);
        Thread.sleep(4000);
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
              //  List<WebElement> webElements =new ArrayList<WebElement>();
                for (int i =1 ; i<=webElementIlcelist.size(); i++){
                  //  webElements.add(webElementIlcelist.get(i));
                    webElementIlcelist.get(i).click();
                 /*   webElementIlcelist.get(33).click();

                    JavascriptExecutor js = (JavascriptExecutor) web;

// Scroll inside web element vertically (e.g. 100 pixel)
                    js.executeScript("arguments[0].scrollTop = arguments[1];",web.findElement(By.className("address-pane active")), 100);*/
                    web.findElement(By.className("address-overlay")).click();
                    Thread.sleep(1000);
                    web.findElement(By.linkText("Mahalle")).click();
                    Thread.sleep(1500);
                    List<WebElement> webElementMahallelist = web.findElements(By.cssSelector("li [data-level='district']"));
                    web.findElement(By.className("address-overlay")).click();
                    Thread.sleep(1500);
                    web.findElement(By.cssSelector("dd > ul >li[data-address='town']")).click();
                    Thread.sleep(1500);
                    webElementIlcelist.get(i).click();

                    Thread.sleep(3000);
                    continue;
                }
                web.findElement(By.className("address-overlay")).click();
                web.findElement(By.cssSelector("dd > ul >li[data-address='city']")).click();



            }

    }
}
