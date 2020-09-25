package com.google;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tests extends Base {

    @Test
    public void Gladolus() {
        driver.get("https://www.google.com/");
        WebElement inputField = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        WebElement searchButton = driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@class='gNO89b']"));
        inputField.click();
        inputField.sendKeys("гладиолус");
        searchButton.click();
        List<WebElement> resultSearch = driver.findElements(By.xpath("//h3[@class='LC20lb DKV0Md']"));

        resultSearch.stream().forEach(x -> System.out.println(x.getText()));
        Assertions.assertTrue(
                resultSearch.stream().anyMatch(x -> x.getText().contains("Шпажник — Википедия")),
                "Запрос не найден"
        );
    }


}


