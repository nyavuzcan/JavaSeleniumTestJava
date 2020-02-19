package com.openhere;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
/*      MongoClient mongoClient = new MongoClient(
          new MongoClientURI(
              "mongodb+srv://nyavuzcan:nevzat1234@cluster0-qmh6q.gcp.mongodb.net/test?authSource=admin&replicaSet=Cluster0-shard-0&w=majority&readPreference=primary&appname=MongoDB%20Compass%20Community&retryWrites=true&ssl=true"));
mongoClient.co*/

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
              ArrayList<String> linkler=new ArrayList<String>();
                for (int i =1 ; i<=webElementIlcelist.size()+1; i++){
                  JavascriptExecutor js = (JavascriptExecutor) web;
                  WebElement element =web.findElement(By.xpath("//*[@id=\"searchResultLeft-address\"]/dl/dd/ul/li[2]/div/div[3]/div/div[1]"));
                  js.executeScript("arguments[0].setAttribute('style', 'padding: 0px; top: -"+i*18+"px; left: 0px; width: 209px;')",element);

                    webElementIlcelist.get(i).click();



                    web.findElement(By.className("address-overlay")).click();
                    Thread.sleep(1000);
                    web.findElement(By.linkText("Mahalle")).click();
                    Thread.sleep(1500);
                    List<WebElement> webElementMahallelist = web.findElements(By.cssSelector("li [data-level='district']"));

                  for(int m=1; m<webElementMahallelist.size(); m++){
                   linkler.add("https://www.sahibinden.com/satilik-daire/istanbul-"+webElementIlcelist.get(i).getAttribute("data-label")+"-"+

                       webElementMahallelist.get(m).getAttribute("data-label"  ) );
                  }

                  web.findElement(By.className("address-overlay")).click();
                    Thread.sleep(1500);
                    web.findElement(By.cssSelector("dd > ul >li[data-address='town']")).click();
                    Thread.sleep(1500);
                  JavascriptExecutor jsx = (JavascriptExecutor) web;
                  WebElement elementx =web.findElement(By.xpath("//*[@id=\"searchResultLeft-address\"]/dl/dd/ul/li[2]/div/div[3]/div/div[1]"));
                  jsx.executeScript("arguments[0].setAttribute('style', 'padding: 0px; top: -"+i*18+"px; left: 0px; width: 209px;')",elementx);

                  webElementIlcelist.get(i).click();

                    Thread.sleep(3000);
                    continue;
                }
                web.findElement(By.className("address-overlay")).click();
                web.findElement(By.cssSelector("dd > ul >li[data-address='city']")).click();



            }

    }


}
