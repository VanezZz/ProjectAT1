package com.google.page.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class RequestSearch {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@class='gLFyf gsfi']")
    WebElement inputField;

    @FindBy(how = How.XPATH, using = "//div[@class='FPdoLc tfB0Bf']//input[@class='gNO89b']")
    WebElement findButton;

    @FindAll(@FindBy(how = How.XPATH, using = "//h3[@class='LC20lb DKV0Md']"))
    List<WebElement> news;

    public RequestSearch(WebDriver driver) {this.driver = driver; }

    public void findNews(String key) {
        inputField.click();
        inputField.sendKeys(key);
        findButton.click();
    }

    public List<WebElement> getNews() { return news; }
}
