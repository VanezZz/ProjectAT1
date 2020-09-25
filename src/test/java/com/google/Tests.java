package com.google;


import com.google.page.factory.RequestSearch;
import com.google.page.object.AfterSearch;
import com.google.page.object.BeforeSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Tests extends Base {

    @Test
    public void Gladolus() {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("гладиолус");
        driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@class='gNO89b']")).click();

        List<WebElement> resultSearch = driver.findElements(By.xpath("//h3[@class='LC20lb DKV0Md']"));

        resultSearch.stream().forEach(x -> System.out.println(x.getText()));
        Assertions.assertTrue(
                resultSearch.stream().anyMatch(x -> x.getText().contains("Шпажник — Википедия")),
                "Запрос не найден"
        );
    }
    @Test
    public void findRequestPO(){
        driver.get("https://www.google.com/");
        BeforeSearch beforeSearch = new BeforeSearch(driver);
        beforeSearch.findNews("гладиолус");
        AfterSearch afterSearch = new AfterSearch(driver);
        afterSearch.getNews().stream().forEach(x -> System.out.println(x.getText()));
        Assertions.assertTrue(
                afterSearch.getNews().stream().anyMatch(x->x.getText().contains("Шпажник — Википедия")),
                "Запрос не найден"
        );
    }

    @Test
    public void findRequestPF(){
        driver.get("https://www.google.com/");
        RequestSearch requestSearch = PageFactory.initElements(driver,RequestSearch.class);
        requestSearch.findNews("гладиолус");
        Assertions.assertTrue(
                requestSearch.getNews().stream().anyMatch(x->x.getText().contains("Шпажник — Википедия")),
                "Запрос не найден"
        );
    }

}


