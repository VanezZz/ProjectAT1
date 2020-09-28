package com.google;


import com.google.page.factory.GoogleSearchPF;
import com.google.page.object.GoogleSearchPO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class Tests extends Base {

    @Test
    public void findRequestPO() {
        driver.get("https://www.google.com/");
        GoogleSearchPO GoogleSearchPO = new GoogleSearchPO(driver);
        GoogleSearchPO.findNews("гладиолус");
        Assertions.assertTrue(
                GoogleSearchPO.getNews().stream().anyMatch(x -> x.getText().contains("Шпажник — Википедия")),
                "Запрос не найден"
        );
    }

    @Test
    public void findRequestPF() {
        driver.get("https://www.google.com/");
        GoogleSearchPF googleSearchPF = PageFactory.initElements(driver, GoogleSearchPF.class);
        googleSearchPF.findNews("гладиолус");
        Assertions.assertTrue(
                googleSearchPF.getNews().stream().anyMatch(x -> x.getText().contains("Шпажник — Википедия")),
                "Запрос не найден"
        );
    }
}


