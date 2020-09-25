package com.google.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BeforeSearch {
    protected WebDriver driver;
    private WebElement inputField;
    private WebElement findButton;

    public BeforeSearch(WebDriver driver){
        this.driver=driver;
        this.inputField = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        this.findButton = driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//*[@class='gNO89b']"));
    }

    public void findNews(String key){
        inputField.click();
        inputField.sendKeys(key);
        findButton.click();
    }
}
