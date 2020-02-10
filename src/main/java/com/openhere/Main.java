package com.openhere;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

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
        web.findElement(By.linkText("İstanbul (Tümü)")).click();

        try {
            web.findElement(By.xpath("//button[text()='Ara']")).click();
        }catch (Exception x){
            System.out.println("Couldn find");
            x.getLocalizedMessage();
        }


        System.out.println(web.getCurrentUrl());

    }
}
