package com.google.page.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class GoogleSearchPF {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@title=\"Поиск\"]")
    WebElement inputField;

    @FindBy(how = How.XPATH, using = "//*[@value=\"Поиск в Google\" and @name = \"btnK\"]")
    WebElement findButton;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@class=\"r\"]//h3"))
    List<WebElement> news;

    public GoogleSearchPF(WebDriver driver) {this.driver = driver; }

    public void findNews(String key) {
        inputField.click();
        inputField.sendKeys(key);
        findButton.click();
    }

    public List<WebElement> getNews() { return news; }
}
