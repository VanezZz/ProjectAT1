package com.google.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchPO {
    WebDriver driver;
    private WebElement inputField;
    private WebElement findButton;

    public GoogleSearchPO(WebDriver driver) {
        this.driver = driver;
        this.inputField = driver.findElement(By.xpath("//input[@title=\"Поиск\"]"));
        this.findButton = driver.findElement(By.xpath("//*[@value='Поиск в Google' and @name = 'btnK']"));
    }

    public void findNews(String key) {
        inputField.click();
        inputField.sendKeys(key);
        findButton.click();
    }

    public List<WebElement> getNews() {
        return driver.findElements(By.xpath("//div[@class='r']//h3"));
    }
}
