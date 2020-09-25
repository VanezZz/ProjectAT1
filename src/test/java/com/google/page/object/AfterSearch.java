package com.google.page.object;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AfterSearch extends BeforeSearch {
    List<WebElement> news;

    public AfterSearch(WebDriver driver){
        super(driver);
        news = driver.findElements(By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/a/h3"));
    }

    public List<WebElement> getNews() {
        return news;
    }
}
